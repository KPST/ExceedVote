package com.exceedvote.factory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.exceedvote.DAO.BallotJpaDAO;
import com.exceedvote.DAO.ChoiceJpaDao;
import com.exceedvote.DAO.IBallotDao;
import com.exceedvote.DAO.IChoiceDao;
import com.exceedvote.DAO.IRoleDao;
import com.exceedvote.DAO.IStatementDao;
import com.exceedvote.DAO.IUserDao;
import com.exceedvote.DAO.RoleJpaDao;
import com.exceedvote.DAO.StatementJpaDao;
import com.exceedvote.DAO.UserJpaDao;

/**
 * JpaFactory is create JPA DAO.
 * @author Kunat Pipatanakul
 * @version 2012.11.14
 */

public class JpaFactory implements IFactory{
	
	private static JpaFactory ef = new JpaFactory();
	private BallotJpaDAO bdao;
	private ChoiceJpaDao cdao;
	private StatementJpaDao sdao;
	private UserJpaDao udao;
	private RoleJpaDao rdao;
	private JpaFactory(){
		EntityManager em = Persistence.createEntityManagerFactory("ExceedVote").createEntityManager();
		bdao = new BallotJpaDAO(em);
		cdao = new ChoiceJpaDao(em);
		sdao = new StatementJpaDao(em);
		udao = new UserJpaDao(em);
		rdao = new RoleJpaDao(em);
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
