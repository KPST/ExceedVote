package com.exceedvote.factory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.exceedvote.DAO.IBallotDao;
import com.exceedvote.DAO.IProjectDao;
import com.exceedvote.DAO.IRoleDao;
import com.exceedvote.DAO.ICriteriaDao;
import com.exceedvote.DAO.ITimeDAO;
import com.exceedvote.DAO.IUserDao;
import com.exceedvote.DAO.JPA.JpaBallotDAO;
import com.exceedvote.DAO.JPA.JpaProjectDao;
import com.exceedvote.DAO.JPA.JpaRoleDao;
import com.exceedvote.DAO.JPA.JpaCriteriaDao;
import com.exceedvote.DAO.JPA.JpaTimeDAO;
import com.exceedvote.DAO.JPA.JpaUserDao;

/**
 * JpaFactory is create JPA DAO.
 * @author Kunat Pipatanakul
 * @version 2012.11.14
 */

public class JpaFactory implements IFactory{
	
	private static JpaFactory ef = new JpaFactory();
	private JpaBallotDAO bdao;
	private JpaProjectDao cdao;
	private JpaCriteriaDao sdao;
	private JpaUserDao udao;
	private JpaRoleDao rdao;
	private JpaTimeDAO tdao;
	/**
	 * Constructor
	 */
	private JpaFactory(){
		EntityManager em = Persistence.createEntityManagerFactory("ExceedVote").createEntityManager();
		bdao = new JpaBallotDAO(em);
		cdao = new JpaProjectDao(em);
		sdao = new JpaCriteriaDao(em);
		udao = new JpaUserDao(em);
		rdao = new JpaRoleDao(em);
		tdao = new JpaTimeDAO(em);
	}
	/**
	 * Singleton
	 * @return this object
	 */
	public static JpaFactory getInstance(){
		return ef;
	}
	@Override
	public IProjectDao getProjectDAO() {
		return cdao;
	}
	@Override
	public ICriteriaDao getCriteriaDAO() {
		return sdao;
	}
	@Override
	public IUserDao getUserDAO() {
		return udao;
	}
	@Override
	public IBallotDao getBallotDAO() {
		return bdao;
	}
	@Override
	public IRoleDao getRoleDAO() {
		return rdao;
	}
	@Override
	public ITimeDAO getTimeDAO() {
		return tdao;
	}


}
