package com.exceedvote.model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.exceedvote.entity.Ballot;
import com.exceedvote.entity.Choice;
import com.exceedvote.entity.Role;
import com.exceedvote.entity.Statement;
import com.exceedvote.entity.User;
import com.exceedvote.factory.IFactory;
import com.exceedvote.factory.JpaFactory;

public class DatabaseGarbageCollector {
	private static DatabaseGarbageCollector dgc;
	private IFactory factory;
	private DatabaseGarbageCollector(){
		factory = JpaFactory.getInstance();
	}
	public void cleanUpUser(){
		System.out.println("Clean up");
		factory.getUserDAO().deleteAll();
		cleanUpBallot();
		User admin = new User();
		admin.setUser("admin");
		admin.setPass("admin");
		List<Role> roles = new ArrayList<Role>();
		roles.add(factory.getRoleDAO().findRole("Admin"));
		admin.setRoles(roles);
		factory.getUserDAO().saveUser(admin);
	}
	public void cleanUpBallot(){
		System.out.println("Clean ballot");
		List<Statement> lists = Arrays.asList(factory.getStatementDAO().getStatement());
		List<Choice> listc = Arrays.asList(factory.getChoiceDAO().getChoice());
		List<User> listu = Arrays.asList(factory.getUserDAO().getAllUser());
		List<Ballot> ballots = factory.getBallotDAO().findAllBallot();
		for(int i = 0 ; i < ballots.size() ;i++){
			Ballot temp = ballots.get(i);
			if(!listu.contains(temp.getUser())||!listc.contains(temp.getChoice())||!lists.contains(temp.getQuestionid())){
				factory.getBallotDAO().deleteBallot(temp.getId());
			}
		}
	}
	public static DatabaseGarbageCollector getInstance(){
		if(dgc==null)
			dgc = new DatabaseGarbageCollector();
		return dgc;
	}
}
