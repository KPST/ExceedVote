package com.exceedvote.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
import com.exceedvote.model.Rank;
import com.exceedvote.model.RankStategy;
import com.exceedvote.model.Timer;

/**
 * Servlet implementation class TimeOut
 * @author Kunat Pipatanakul
 */
@WebServlet("/Timeout.do")
public class TimeOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TimeOut() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IFactory b = JpaFactory.getInstance();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Timer timer = Timer.getTimer();
		if(timer.getDiffTime()==0){
			Criteria[] st = b.getCriteriaDAO().getCriteria();
			List<Collection<Object[]>> lists = new ArrayList<Collection<Object[]>>();
			for(int i = 0 ; i < st.length ; i++){
				List<Ballot> ballots = b.getBallotDAO().findBallotsByCriteria(st[i]);
				RankStategy rank = new Rank();
				Project[] projects = b.getProjectDAO().getProject();
				Collection<Object[]> list = rank.computeRank(ballots, projects);
				lists.add(list);
			}
			request.setAttribute("rank", lists);
			request.setAttribute("st", st);
			if(user.hasRoles("Admin")){
				RequestDispatcher view = request.getRequestDispatcher("ranka.jsp");
				view.forward(request, response);
				return;
			}
			else{
				RequestDispatcher view = request.getRequestDispatcher("rank.jsp");
				view.forward(request, response);
				return;
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
