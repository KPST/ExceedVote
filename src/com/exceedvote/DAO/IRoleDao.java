package com.exceedvote.DAO;

import com.exceedvote.entity.Role;

/**
 * IRoleDAO is a Interface the contain all method Role DAO have to implements.
 * @author Kunat Pipatanakul
 * @version 2012.12.10
 * 
 */
public interface IRoleDao {
	/**
	 * saveRole in to database.
	 * @param role Role
	 */
	public void save(Role role);
	/**
	 * findAll Role
	 * @return Role[] all Role.
	 */
	public Role[] findAll();
	/**
	 * findRole by id
	 * @param id id of the role.
	 * @return Role
	 */
	public Role findRole(int id);
	/**
	 * findRole by name
	 * @param name name of the role.
	 * @return Role
	 */
	public Role findRole(String name);
	/**
	 * delete Role by id
	 * @param id id of the role.
	 */
	public void delete(int id);
	/**
	 * findNormalRole NormalRole is a Role that have > 0 on multiply_ballot row.
	 * @return Role[] role that are in specific case.
	 */
	public Role[] findNormalRole();
}
