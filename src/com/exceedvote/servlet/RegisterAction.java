package com.exceedvote.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exceedvote.entity.Role;
import com.exceedvote.factory.IFactory;
import com.exceedvote.factory.JpaFactory;
import com.exceedvote.model.Authentication;

/**
 * Servlet implementation class RegisterAction
 */
@WebServlet("/RegisterAction.do")
public class RegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAction() {
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
		if(session!=null)
			session.invalidate();
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		IFactory factory = JpaFactory.getInstance();
		String[] rolesid = request.getParameterValues("role");
		List<Role> roles = new ArrayList<Role>();
		for(int i = 0 ; i < rolesid.length ;i++){
			Role role = factory.getRoleDAO().findRole(Integer.parseInt(rolesid[i]));
			roles.add(role);
		}
		Authentication c = new Authentication(JpaFactory.getInstance());
		String ip = request.getRemoteAddr();
		//check and add username in DB
		if (c.addUser(user, pass, 1, ip,roles)) {
			response.sendRedirect("Login.do");
		}
		else{
			response.sendRedirect("Register.do");
			return;
		}
	}

}
