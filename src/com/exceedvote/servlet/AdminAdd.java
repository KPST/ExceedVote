package com.exceedvote.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exceedvote.entity.Project;
import com.exceedvote.entity.Role;
import com.exceedvote.entity.Criteria;
import com.exceedvote.entity.Time;
import com.exceedvote.entity.User;
import com.exceedvote.factory.IFactory;
import com.exceedvote.factory.JpaFactory;
import com.exceedvote.model.DatabaseGarbageCollector;
import com.exceedvote.model.Log;
import com.exceedvote.model.Timer;

/**
 * Servlet implementation class AdminAdd
 * @author Kunat Pipatanakul
 */
@WebServlet("/admin/Add.do")
public class AdminAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User usr = (User)session.getAttribute("user");
		Log log = Log.getLog();
		if(usr.hasRoles("Admin")){
		String type = request.getParameter("type");
		IFactory factory = JpaFactory.getInstance();
		if(type.equals("project")){
			String name = request.getParameter("name");
			String des = request.getParameter("des");
			String img = request.getParameter("img");
			Project c = new Project();
			log.adminLog(usr.getUser(), "Project" , request.getRemoteAddr() , "add Name:"+name+" Description:"+des+" img:"+img);
			c.setName(name);
			c.setDescription(des);
			c.setImg(img);
			factory.getProjectDAO().saveProject(c);
			response.sendRedirect("Admin.do?type=project");
			return;
		}
		else if(type.equals("criteria")){
			String des = request.getParameter("des");
			int multiply = Integer.parseInt(request.getParameter("multiply"));
			Criteria s = new Criteria();
			log.adminLog(usr.getUser(), "Criteria" , request.getRemoteAddr() , "add Description:"+des+" BallotMultiply:"+multiply);
			s.setDescription(des);
			s.setBallotMultiply(multiply);
			factory.getCriteriaDAO().saveCriteria(s);
			response.sendRedirect("Admin.do?type=criteria");
			return;
		}
		else if(type.equals("role")){
			String ballot = request.getParameter("ballot");
			String name = request.getParameter("name");
			log.adminLog(usr.getUser(), "Role" , request.getRemoteAddr() , "add Name:"+name+" BallotMultiply:"+ballot);
			Role r = new Role();
			r.setName(name);
			r.setBallotMultiply(Float.parseFloat(ballot));
			factory.getRoleDAO().save(r);
			response.sendRedirect("Admin.do?type=role");
			return;
		}
		else if(type.equals("time")){
			String[] date = request.getParameter("date").split("-");
			String[] timei = request.getParameter("time").split(":");
			for(int i = 0 ; i < date.length ;i++){
				System.out.println(date[i]);
			}
			log.adminLog(usr.getUser(), "Time" , request.getRemoteAddr(), "Change Time to "+date[0]+"/"+date[1]+"/"+date[2]+" "+timei[0]+":"+timei[1]+" Timezone:"+7);
			Time time = new Time();
			time.setYear(Integer.parseInt(date[0]));
			time.setMonth(Integer.parseInt(date[1]));
			time.setDay(Integer.parseInt(date[2]));
			time.setHour(Integer.parseInt(timei[0]));
			time.setMin(Integer.parseInt(timei[1]));
			time.setTimezone(Integer.parseInt("7"));
			factory.getTimeDAO().setTimer(time);
			DatabaseGarbageCollector.getInstance().cleanUpTime();
			DatabaseGarbageCollector.getInstance().clearAllBallot();
			Timer.resetTimer();
			response.sendRedirect("Admin.do?type=time");
			return;
		}
		else{
			System.out.println("type fail");
		}
		}
		else{
			log.adminLog(usr.getUser(), "Fail" , request.getRemoteAddr() , "have login to admin section.");
			System.out.println("GG");
			response.sendRedirect("fail.jsp");
			return;
		}
	}

}
