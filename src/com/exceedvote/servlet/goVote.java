package com.exceedvote.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exceedvote.entity.Statement;
import com.exceedvote.entity.User;
import com.exceedvote.factory.IFactory;
import com.exceedvote.factory.JpaFactory;

/**
 * Servlet implementation class goVote
 */
@WebServlet("/goVote.do")
public class goVote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goVote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		IFactory factory = JpaFactory.getInstance();
		Statement st  = factory.getStatementDAO().getStatementById(id);
		User useri = (User) session.getAttribute("user");
		if(factory.getBallotDAO().findBallots(useri, st).size() >= Math.floor(useri.getBallot())*st.getBallotMultiply()){
			RequestDispatcher view = request.getRequestDispatcher("votef.jsp");
			view.forward(request, response);
			return;
		}
		request.setAttribute("choices", factory.getChoiceDAO().getChoice());
		session.setAttribute("Statement", st);
		RequestDispatcher view = request.getRequestDispatcher("vote.jsp");
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
