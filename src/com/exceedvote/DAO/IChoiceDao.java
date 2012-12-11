package com.exceedvote.DAO;

import com.exceedvote.entity.Choice;

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
