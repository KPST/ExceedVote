package com.exceedvote.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exceedvote.entity.Ballot;
import com.exceedvote.entity.Choice;
import com.exceedvote.entity.Role;
import com.exceedvote.entity.Statement;
import com.exceedvote.entity.User;
import com.exceedvote.factory.IFactory;
import com.exceedvote.factory.JpaFactory;
import com.exceedvote.model.Log;
import com.exceedvote.model.Rank;
import com.exceedvote.model.RankStategy;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/admin/Admin.do")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User usr = (User) session.getAttribute("user");
		Log log = Log.getLog();
		if(usr.hasRoles("Admin")){
			IFactory b = JpaFactory.getInstance();
			String type = request.getParameter("type");
			if(type.equals("statement")){
				Statement[] statements = b.getStatementDAO().getStatement();
				request.setAttribute("statement", statements);
				RequestDispatcher view = request.getRequestDispatcher("statement.jsp");
				view.forward(request, response);
				return;
			}
			else if(type.equals("choice")){
				Choice[] choices = b.getChoiceDAO().getChoice();
				request.setAttribute("choice", choices);
				RequestDispatcher view = request.getRequestDispatcher("choice.jsp");
				view.forward(request, response);
				return;
			}
			else if(type.equals("user")){
				User[] user = b.getUserDAO().getAllUser();
				request.setAttribute("usr", user);
				RequestDispatcher view = request.getRequestDispatcher("user.jsp");
				view.forward(request, response);
				return;
			}
			else if(type.equals("role")){
				Role[] roles = b.getRoleDAO().findAll();
				request.setAttribute("role", roles);
				RequestDispatcher view = request.getRequestDispatcher("role.jsp");
				view.forward(request, response);
				return;
			}
			else if(type.equals("rank")){
				response.setHeader("Refresh", "5; URL=Admin.do?type=rank");
				Statement[] st = b.getStatementDAO().getStatement();
				List<Map<Choice,Integer>> maps = new ArrayList<Map<Choice,Integer>>();
				for(int i = 0 ; i < st.length ; i++){
				List<Ballot> ballots = b.getBallotDAO().findBallotsByStatement(st[i]);
				RankStategy rank = new Rank();
				Choice[] choices = b.getChoiceDAO().getChoice();
				Map<Choice,Integer> map = rank.computeRank(ballots, choices);
				maps.add(map);
				}
				request.setAttribute("map", maps);
				request.setAttribute("st", st);
				RequestDispatcher view = request.getRequestDispatcher("rank.jsp");
				view.forward(request, response);
				return;
			}
			else{
				
			}
		}
		else{
			log.adminLog(usr.getUser(), "Fail" , request.getRemoteAddr() , "have login to admin section.");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
