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
import com.exceedvote.entity.Project;
import com.exceedvote.entity.Criteria;
import com.exceedvote.entity.User;
import com.exceedvote.factory.IFactory;
import com.exceedvote.factory.JpaFactory;
import com.exceedvote.model.Log;
import com.exceedvote.model.Timer;

/**
 * Servlet implementation class vote
 * @author Kunat Pipatanakul
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
			Timer timer = Timer.getTimer();
			IFactory i = JpaFactory.getInstance();
			Log log = Log.getLog();
			if(timer.getDiffTime()>0){
			HttpSession session = request.getSession();
			Project[] projects = i.getProjectDAO().getProject();
			//get information about vote
		    User useri = (User) session.getAttribute("user");
		   	Criteria s = (Criteria) session.getAttribute("criteria");
		   	if(i.getBallotDAO().findBallots(useri,s).size()>=Math.floor(useri.getBallot())*s.getBallotMultiply()){
		   		RequestDispatcher view = request.getRequestDispatcher("votef.jsp");
				view.forward(request, response);
				return;
			}
		   	else{
		   		int id = Integer.parseInt(request.getParameter("id"));
		   		int question = Integer.parseInt(request.getParameter("question"));
		   		int project = Integer.parseInt(request.getParameter("project"));
		   		//vote
		   		Ballot b = new Ballot(useri, s, projects[project-1]);
		   		log.voteLog(id, project, question, Log.BALLOT_SAVE);
		   		i.getBallotDAO().saveBallot(b);
		   }
		   	RequestDispatcher view = request.getRequestDispatcher("voted.jsp");
			view.forward(request, response);
		    return;
			}
			else{
				RequestDispatcher view = request.getRequestDispatcher("Timeout.do");
				view.forward(request, response);
				return;
			}
	}

}
