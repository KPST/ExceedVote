package com.exceedvote.factory;

import com.exceedvote.DAO.IBallotDao;
import com.exceedvote.DAO.IChoiceDao;
import com.exceedvote.DAO.IRoleDao;
import com.exceedvote.DAO.IStatementDao;
import com.exceedvote.DAO.ITimeDAO;
import com.exceedvote.DAO.IUserDao;

/**
 * Interface for factory
 * @author Kunat Pipatanakul
 * @version 2012.11.14
 */
public interface IFactory {
	/**
	 * getChoiceDAO
	 * @return IChoiceDao
	 */
	public IChoiceDao getChoiceDAO();
	/**
	 * getStatementDAO
	 * @return IStatementDAO
	 */
	public IStatementDao getStatementDAO();
	/**
	 * getUserDAO
	 * @return IUserDAO
	 */
	public IUserDao getUserDAO();
	/**
	 * getBallotDAO
	 * @return IBallotDAO
	 */
	public IBallotDao getBallotDAO();
	/**
	 * getRoleDAO
	 * @return IRoleDAO
	 */
	public IRoleDao getRoleDAO();
	/**
	 * getTimeDAO
	 * @return ITimeDAO
	 */
	public ITimeDAO getTimeDAO();
}
