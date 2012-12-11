package com.exceedvote.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.exceedvote.entity.Ballot;
import com.exceedvote.entity.User;
import com.exceedvote.factory.IFactory;
import com.exceedvote.factory.JpaFactory;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/DeleteVote")
public class DeleteVote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteVote() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		IFactory factory = JpaFactory.getInstance();
		HttpSession session = request.getSession();
		User userinfo = (User)session.getAttribute("user");
		Ballot b = factory.getBallotDAO().findBallot(id);
		if(b.getUser()==userinfo){
			int qid = b.getQuestionid().getId();
			factory.getBallotDAO().deleteBallot(id);
			response.sendRedirect("goVote.do?id="+qid);
			return;
		}
	}

}
