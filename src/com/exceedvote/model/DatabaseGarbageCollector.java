package com.exceedvote.model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.exceedvote.DAO.IBallotDao;
import com.exceedvote.DAO.ITimeDAO;
import com.exceedvote.entity.Ballot;
import com.exceedvote.entity.Project;
import com.exceedvote.entity.Role;
import com.exceedvote.entity.Criteria;
import com.exceedvote.entity.Time;
import com.exceedvote.entity.User;
import com.exceedvote.factory.IFactory;
import com.exceedvote.factory.JpaFactory;
/**
 * DatabaseGarbageCollector is a class that contain database cleanup algorithm. 
 * @author Kunat Pipatanakul
 *
 */
public class DatabaseGarbageCollector {
	private static DatabaseGarbageCollector dgc;
	private IFactory factory;
	private DatabaseGarbageCollector(){
		factory = JpaFactory.getInstance();
	}
	/**
	 * cleanUp user database.
	 * by Clear all user.
	 * and add new User "admin"
	 */
	public void cleanUpUser(){
		factory.getUserDAO().deleteAll();
		cleanUpBallot();
		User admin = new User();
		admin.setUser("admin");
		admin.setPass("admin");
		List<Role> roles = new ArrayList<Role>();
		Role radmin = factory.getRoleDAO().findRole("Admin");
		if(radmin == null){
			radmin = new Role();
			radmin.setName("Admin");
			factory.getRoleDAO().save(radmin);
		}
		roles.add(radmin);
		admin.setRoles(roles);
		factory.getUserDAO().saveUser(admin);
	}
	/**
	 * cleanUp ballot database.
	 * by check all ballot have to have own criteria project and user that are in database.
	 * if not delete it.
	 */
	public void cleanUpBallot(){
		System.out.println("Clean ballot");
		List<Criteria> lists = Arrays.asList(factory.getCriteriaDAO().getCriteria());
		List<Project> listc = Arrays.asList(factory.getProjectDAO().getProject());
		List<User> listu = Arrays.asList(factory.getUserDAO().getAllUser());
		
		List<Ballot> ballots = factory.getBallotDAO().findAllBallot();
		for(int i = 0 ; i < ballots.size() ;i++){
			Ballot temp = ballots.get(i);
			if(!listu.contains(temp.getUser())||!listc.contains(temp.getProject())||!lists.contains(temp.getQuestionid())){
				factory.getBallotDAO().deleteBallot(temp.getId());
			}
		}
	}
	/**
	 * cleanUp Time database.
	 * clear all time in database but not latest one.
	 */
	public void cleanUpTime(){
		ITimeDAO tdao = factory.getTimeDAO();
		List<Time> times = tdao.getTimer();
		for(int i = 1 ; i < times.size() ; i++){
			tdao.delete(times.get(i).getId());
		}
	}
	/**
	 * clearAllballot in the database.
	 */
	public void clearAllBallot(){
		IBallotDao bdao = factory.getBallotDAO();
		List<Ballot> ballots = bdao.findAllBallot();
		for(int i = 0 ; i < ballots.size(); i++){
			bdao.deleteBallot(ballots.get(i).getId());
		}
	}
	/**
	 * Singleton
	 * @return DatabaseGarbageCollector object.
	 */
	public static DatabaseGarbageCollector getInstance(){
		if(dgc==null)
			dgc = new DatabaseGarbageCollector();
		return dgc;
	}
}
