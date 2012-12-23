package com.exceedvote.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exceedvote.entity.Criteria;
import com.exceedvote.entity.User;
import com.exceedvote.factory.IFactory;
import com.exceedvote.factory.JpaFactory;
import com.exceedvote.model.Timer;

/**
 * Servlet implementation class Main
 * @author Kunat Pipatanakul
 */
@WebServlet("/Main.do")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Main() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Timer timer = Timer.getTimer();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(timer.getDiffTime()>0){
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Pragma", "no-cache");
			IFactory b = JpaFactory.getInstance();
			Criteria[] criterias = b.getCriteriaDAO().getCriteria();
			int[][] ballotcount = new int[criterias.length][2];
			for(int i = 0 ; i < criterias.length ; i++){
				ballotcount[i][0] = b.getBallotDAO().findBallots(user,criterias[i]).size();
				ballotcount[i][1] = (int) Math.floor(user.getBallot()*criterias[i].getBallotMultiply());
			}
			request.setAttribute("timer", timer.getDiffTime());
			request.setAttribute("ballotinfo", ballotcount);
			request.setAttribute("criteria", criterias);
			if(user.hasRoles("Admin")){
				RequestDispatcher view = request.getRequestDispatcher("maina.jsp");
				view.forward(request, response);
				return;
			}
			else{
				RequestDispatcher view = request.getRequestDispatcher("main.jsp");
				view.forward(request, response);
				return;
			}
		}
		else{
			RequestDispatcher view = request.getRequestDispatcher("Timeout.do");
			view.forward(request, response);
			return;
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
