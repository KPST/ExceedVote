package com.exceedvote.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exceedvote.entity.Ballot;
import com.exceedvote.entity.Choice;
import com.exceedvote.entity.Statement;
import com.exceedvote.entity.User;
import com.exceedvote.factory.IFactory;
import com.exceedvote.factory.JpaFactory;
import com.exceedvote.model.Log;

/**
 * Servlet implementation class vote
 */
@WebServlet(
		urlPatterns = { "/Vote.do" })
public class VoteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			IFactory i = JpaFactory.getInstance();
			Log log = Log.getLog();
			HttpSession session = request.getSession();
			Choice[] choices = i.getChoiceDAO().getChoice();
			//get information about vote
		    User useri = (User) session.getAttribute("user");
		   	Statement s = (Statement) session.getAttribute("Statement");
		   	if(i.getBallotDAO().findBallots(useri,s).size()>=Math.floor(useri.getBallot())*s.getBallotMultiply()){
		   		RequestDispatcher view = request.getRequestDispatcher("votef.jsp");
				view.forward(request, response);
				return;
			}
		   	else{
		   		int id = Integer.parseInt(request.getParameter("id"));
		   		int question = Integer.parseInt(request.getParameter("question"));
		   		int choice = Integer.parseInt(request.getParameter("choice"));
		   		//vote
		   		Ballot b = new Ballot(useri, s, choices[choice-1]);
		   		log.voteLog(id, choice, question, Log.BALLOT_SAVE);
		   		i.getBallotDAO().saveBallot(b);
		   }
		   	RequestDispatcher view = request.getRequestDispatcher("voted.jsp");
			view.forward(request, response);
		   return;
	}

}
