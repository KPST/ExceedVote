package com.exceedvote.factory;

import com.exceedvote.DAO.IBallotDao;
import com.exceedvote.DAO.IChoiceDao;
import com.exceedvote.DAO.IRoleDao;
import com.exceedvote.DAO.IStatementDao;
import com.exceedvote.DAO.IUserDao;

/**
 * Interface for factory
 * @author Kunat Pipatanakul
 * @version 2012.11.14
 */
public interface IFactory {
	/**
	 * getDAO
	 * @return ExceedDAO
	 */
	//public ExceedDAO getDAO();
	public IChoiceDao getChoiceDAO();
	public IStatementDao getStatementDAO();
	public IUserDao getUserDAO();
	public IBallotDao getBallotDAO();
	public IRoleDao getRoleDAO();
}
