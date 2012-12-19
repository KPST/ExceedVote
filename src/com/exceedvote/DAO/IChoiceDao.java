package com.exceedvote.DAO;

import com.exceedvote.entity.Choice;

/**
 * IChoiceDAO is a Interface the contain all method Choice DAO have to implements.
 * @author Kunat Pipatanakul
 * @version 2012.12.10
 */
public interface IChoiceDao {
	/**
	 * getChoice from database
	 * @return Choice[]
	 */
	public Choice[] getChoice();
	/**
	 * saveChoice
	 * @param c choice object
	 */
	public void saveChoice(Choice c);
	/**
	 * DeleteChoice
	 * @param id id of choice
	 */
	public void deleteChoice(int id);
}
