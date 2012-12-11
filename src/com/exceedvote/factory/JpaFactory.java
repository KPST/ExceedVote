package com.exceedvote.factory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.exceedvote.DAO.IBallotDao;
import com.exceedvote.DAO.IChoiceDao;
import com.exceedvote.DAO.IRoleDao;
import com.exceedvote.DAO.IStatementDao;
import com.exceedvote.DAO.IUserDao;
import com.exceedvote.DAO.JPA.JpaBallotDAO;
import com.exceedvote.DAO.JPA.JpaChoiceDao;
import com.exceedvote.DAO.JPA.JpaRoleDao;
import com.exceedvote.DAO.JPA.JpaStatementDao;
import com.exceedvote.DAO.JPA.JpaUserDao;

/**
 * JpaFactory is create JPA DAO.
 * @author Kunat Pipatanakul
 * @version 2012.11.14
 */

public class JpaFactory implements IFactory{
	
	private static JpaFactory ef = new JpaFactory();
	private JpaBallotDAO bdao;
	private JpaChoiceDao cdao;
	private JpaStatementDao sdao;
	private JpaUserDao udao;
	private JpaRoleDao rdao;
	private JpaFactory(){
		EntityManager em = Persistence.createEntityManagerFactory("ExceedVote").createEntityManager();
		bdao = new JpaBallotDAO(em);
		cdao = new JpaChoiceDao(em);
		sdao = new JpaStatementDao(em);
		udao = new JpaUserDao(em);
		rdao = new JpaRoleDao(em);
	}
	/**
	 * Singleton
	 * @return this object
	 */
	public static JpaFactory getInstance(){
		return ef;
	}
	@Override
	public IChoiceDao getChoiceDAO() {
		return cdao;
	}
	@Override
	public IStatementDao getStatementDAO() {
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


}
