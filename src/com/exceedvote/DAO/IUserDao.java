package com.exceedvote.DAO;

import com.exceedvote.entity.User;
/**
 * IUserDAO is a Interface the contain all method DAO have to implements.
 * @author Kunat Pipatanakul
 * @version 2012.12.10
 */
public interface IUserDao {
	/**
	 * getAllUser
	 * @return Auth[] object that contain all user in database.
	 */
	public User[] getAllUser();
	/**
	 * findUser
	 * @param user username:String
	 * @param pass password:String
	 * @return Auth object
	 */
	public User findUser(String user,String pass);
	/**
	 * saveUser
	 * @param a Auth Object contain userinfo
	 */
	public void saveUser(User a);
	/**
	 * DeleteUser
	 * @param id id of user
	 */
	public void deleteUser(int id);
	/**
	 * find user by user
	 * @param user
	 * @return Auth Object
	 */
	public User findUser(String user);
	/**
	 * deleteAll User in database.
	 */
	public void deleteAll();
	
}
