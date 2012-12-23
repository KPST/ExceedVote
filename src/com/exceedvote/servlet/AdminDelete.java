package com.exceedvote.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.exceedvote.entity.User;
import com.exceedvote.factory.IFactory;
import com.exceedvote.factory.JpaFactory;
import com.exceedvote.model.DatabaseGarbageCollector;
import com.exceedvote.model.Log;

/**
 * Servlet implementation class AdminDelete
 * @author Kunat Pipatanakul
 */
@WebServlet("/admin/Delete.do")
public class AdminDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDelete() {
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
		IFactory factory = JpaFactory.getInstance();
		HttpSession session = request.getSession();
		Log log = Log.getLog();
		User usr = (User)session.getAttribute("user");
		if(usr.hasRoles("Admin")){
		int id = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type");
		if(type.equals("project")){
			log.adminLog(usr.getUser(), "Project" , request.getRemoteAddr() , "Delete Project id:"+id);
			factory.getProjectDAO().deleteProject(id);
			DatabaseGarbageCollector.getInstance().cleanUpBallot();
			response.sendRedirect("Admin.do?type=project");
			return;
		}
		else if(type.equals("criteria")){
			log.adminLog(usr.getUser(), "Criteria" , request.getRemoteAddr() , "Delete Criteria id:"+id);
			factory.getCriteriaDAO().deleteCriteria(id);
			DatabaseGarbageCollector.getInstance().cleanUpBallot();
			response.sendRedirect("Admin.do?type=criteria");
			return;
		}
		else if(type.equals("user")){
			log.adminLog(usr.getUser(), "User" , request.getRemoteAddr() , "Delete User id:"+id);
			factory.getUserDAO().deleteUser(id);
			DatabaseGarbageCollector.getInstance().cleanUpBallot();
			response.sendRedirect("Admin.do?type=user");
			return;
		}
		else if(type.equals("role")){
			log.adminLog(usr.getUser(), "Role" , request.getRemoteAddr() , "Delete Role id:"+id);
			factory.getRoleDAO().delete(id);
			DatabaseGarbageCollector.getInstance().cleanUpUser();
			DatabaseGarbageCollector.getInstance().clearAllBallot();
			response.sendRedirect("Admin.do?type=role");
			return;
		}
		else{
			System.out.println("type fail");
			return;
		}
		}
		else{
			System.out.println("GG");
			response.sendRedirect("fail.jsp");
			return;
		}
	}

}
