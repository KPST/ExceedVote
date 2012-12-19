package com.exceedvote.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exceedvote.entity.Choice;
import com.exceedvote.entity.Role;
import com.exceedvote.entity.Statement;
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
		User usr = (User)session .getAttribute("user");
		Log log = Log.getLog();
		if(usr.hasRoles("Admin")){
		String type = request.getParameter("type");
		IFactory factory = JpaFactory.getInstance();
		if(type.equals("choice")){
			String name = request.getParameter("name");
			String des = request.getParameter("des");
			String img = request.getParameter("img");
			Choice c = new Choice();
			log.adminLog(usr.getUser(), "Choice" , request.getRemoteAddr() , "add Name:"+name+" Description:"+des+" img:"+img);
			c.setName(name);
			c.setDescription(des);
			c.setImg(img);
			factory.getChoiceDAO().saveChoice(c);
			response.sendRedirect("Admin.do?type=choice");
			return;
		}
		else if(type.equals("statement")){
			String des = request.getParameter("des");
			int multiply = Integer.parseInt(request.getParameter("multiply"));
			Statement s = new Statement();
			log.adminLog(usr.getUser(), "Statement" , request.getRemoteAddr() , "add Description:"+des+" BallotMultiply:"+multiply);
			s.setDescription(des);
			s.setBallotMultiply(multiply);
			factory.getStatementDAO().saveStatement(s);
			response.sendRedirect("Admin.do?type=statement");
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
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String day = request.getParameter("day");
			String hour = request.getParameter("hour");
			String min = request.getParameter("min");
			String tz = request.getParameter("timezone");
			log.adminLog(usr.getUser(), "Time" , request.getRemoteAddr(), "Change Time to "+year+"/"+month+"/"+day+" "+hour+":"+min+" Timezone:"+tz);
			Time time = new Time();
			time.setYear(Integer.parseInt(year));
			time.setMonth(Integer.parseInt(month));
			time.setDay(Integer.parseInt(day));
			time.setHour(Integer.parseInt(hour));
			time.setMin(Integer.parseInt(min));
			time.setTimezone(Integer.parseInt(tz));
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
