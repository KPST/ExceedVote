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
import com.exceedvote.model.Authentication;

/**
 * Servlet implementation class Login
 */
@WebServlet("/goLogin.do")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
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
			String name = request.getParameter("username");
	      	String pass = request.getParameter("password");
	      	HttpSession session = request.getSession();
	      	if(session != null)
	    	  session.invalidate();
	        IFactory b = JpaFactory.getInstance();
	        Authentication a = new Authentication(b);
	        String ip = request.getRemoteAddr();
	      	User usr = a.login(name, pass, ip);
	        if(usr!=null){
	      		session = request.getSession(true);
	      		session.setAttribute("user", usr);
	      		response.sendRedirect("Main.do");
	      	}
	      	//login not ok
	      	else response.sendRedirect("loginf.jsp");
	}

}
