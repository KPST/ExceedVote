package com.exceedvote.DAO;

import com.exceedvote.entity.Statement;
/**
 * IStatementDAO is a Interface the contain all method Statement DAO have to implements.
 * @author Kunat Pipatanakul
 * @version 2012.12.10
 */
public interface IStatementDao {
	/**
	 * getStatement from database
	 * @return Statement[]
	 */
	public Statement[] getStatement();
	/**
	 * getStatement by id of that Statement
	 * @param id id of statement
	 * @return Statement object.
	 */
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
