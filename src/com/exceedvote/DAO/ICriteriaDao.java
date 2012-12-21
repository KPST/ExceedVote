package com.exceedvote.DAO;

import com.exceedvote.entity.Criteria;
/**
 * IStatementDAO is a Interface the contain all method Statement DAO have to implements.
 * @author Kunat Pipatanakul
 * @version 2012.12.10
 */
public interface ICriteriaDao {
	/**
	 * getStatement from database
	 * @return Statement[]
	 */
	public Criteria[] getCriteria();
	/**
	 * getStatement by id of that Statement
	 * @param id id of statement
	 * @return Statement object.
	 */
	public Criteria getCriteriaById(int id);
	/**
	 * saveStatement
	 * @param s Statement that want to save
	 */
	public void saveCriteria(Criteria s);
	/**
	 * DeleteStatement
	 * @param id id of statement
	 */
	public void deleteCriteria(int id);
}
