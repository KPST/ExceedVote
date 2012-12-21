package com.exceedvote.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exceedvote.entity.Criteria;
import com.exceedvote.entity.User;
import com.exceedvote.entity.Ballot;
import com.exceedvote.factory.IFactory;
import com.exceedvote.factory.JpaFactory;
import com.exceedvote.model.Timer;

/**
 * Servlet implementation class History
 * @author Kunat Pipatanakul
 */
@WebServlet("/History.do")
public class History extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public History() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Timer timer = Timer.getTimer();
		if(timer.getDiffTime()>0){
			HttpSession session = request.getSession();
			User usr = (User) session.getAttribute("user");
			IFactory factory = JpaFactory.getInstance();
			Criteria[] criteria = factory.getCriteriaDAO().getCriteria();
			List<List<Ballot>> ballots = new ArrayList<List<Ballot>>();
		    for(int i = 0 ; i < criteria.length ; i++){
				List<Ballot> b = factory.getBallotDAO().findBallots(usr, criteria[i]);
				ballots.add(b);
			}
		    request.setAttribute("timer", timer.getDiffTime());
			request.setAttribute("ballot", ballots);
			request.setAttribute("project", ballots);
			request.setAttribute("criteria", criteria);
			RequestDispatcher view = request.getRequestDispatcher("history.jsp");
			view.forward(request, response);
			return;
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
