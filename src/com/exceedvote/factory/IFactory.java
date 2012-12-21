package com.exceedvote.factory;

import com.exceedvote.DAO.IBallotDao;
import com.exceedvote.DAO.IProjectDao;
import com.exceedvote.DAO.IRoleDao;
import com.exceedvote.DAO.ICriteriaDao;
import com.exceedvote.DAO.ITimeDAO;
import com.exceedvote.DAO.IUserDao;

/**
 * Interface for factory
 * @author Kunat Pipatanakul
 * @version 2012.11.14
 */
public interface IFactory {
	/**
	 * getprojectDAO
	 * @return IprojectDao
	 */
	public IProjectDao getProjectDAO();
	/**
	 * getcriteriaDAO
	 * @return IcriteriaDAO
	 */
	public ICriteriaDao getCriteriaDAO();
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
