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

import com.exceedvote.entity.Statement;
import com.exceedvote.entity.User;
import com.exceedvote.entity.Ballot;
import com.exceedvote.factory.IFactory;
import com.exceedvote.factory.JpaFactory;

/**
 * Servlet implementation class History
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
		HttpSession session = request.getSession();
		User usr = (User) session.getAttribute("user");
		IFactory factory = JpaFactory.getInstance();
		Statement[] statement = factory.getStatementDAO().getStatement();
		List<List<Ballot>> ballots = new ArrayList<List<Ballot>>();
		
		for(int i = 0 ; i < statement.length ; i++){
			List<Ballot> b = factory.getBallotDAO().findBallots(usr, statement[i]);
			ballots.add(b);
		}
		request.setAttribute("ballot", ballots);
		request.setAttribute("choice", ballots);
		request.setAttribute("statement", statement);
		RequestDispatcher view = request.getRequestDispatcher("history.jsp");
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
