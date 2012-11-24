package com.exceedvote.DAO;

import com.exceedvote.jpa.Statement;

public interface IStatementDao {
	/**
	 * getStatement from database
	 * @return Statement[]
	 */
	public Statement[] getStatement();
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
