package com.exceedvote.DAO;

import com.exceedvote.entity.Project;

/**
 * IChoiceDAO is a Interface the contain all method Choice DAO have to implements.
 * @author Kunat Pipatanakul
 * @version 2012.12.10
 */
public interface IProjectDao {
	/**
	 * getChoice from database
	 * @return Choice[]
	 */
	public Project[] getProject();
	/**
	 * saveChoice
	 * @param c choice object
	 */
	public void saveProject(Project c);
	/**
	 * DeleteChoice
	 * @param id id of choice
	 */
	public void deleteProject(int id);
}
