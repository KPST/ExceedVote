package com.exceedvote.DAO;

import com.exceedvote.entity.Statement;

public interface IStatementDao {
	/**
	 * getStatement from database
	 * @return Statement[]
	 */
	public Statement[] getStatement();
	public Statement getStatementById(int id);
	/**
	 * saveStatement
	 * @param s Statement that want to save
	 */
	public void saveStatement(Statement s);
	/**
	 * DeleteStatement
	 * @param id id of statement
	 */
	public void deleteStatement(int id);
}
