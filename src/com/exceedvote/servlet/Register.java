package com.exceedvote.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exceedvote.entity.Role;
import com.exceedvote.factory.IFactory;
import com.exceedvote.factory.JpaFactory;

/**
 * Servlet implementation class Register
 * @author Kunat Pipatanakul
 */
@WebServlet("/Register.do")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		HttpSession session = request.getSession();
      	IFactory factory = JpaFactory.getInstance();
		if(session != null)
    	  session.invalidate();
      	Role[] role = factory.getRoleDAO().findNormalRole();
      	request.setAttribute("role", role);
      	RequestDispatcher view = request.getRequestDispatcher("register.jsp");
		view.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
