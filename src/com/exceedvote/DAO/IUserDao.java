package com.exceedvote.DAO;

import com.exceedvote.jpa.Auth;

public interface IUserDao {
	/**
	 * getAllUser
	 * @return Auth[] object that contain all user in database.
	 */
	public Auth[] getAllUser();
	/**
	 * findUser
	 * @param user username:String
	 * @param pass password:String
	 * @return Auth object
	 */
	public Auth findUser(String user,String pass);
	/**
	 * saveUser
	 * @param a Auth Object contain userinfo
	 */
	public void saveUser(Auth a);
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
	public Auth findUser(String user);
}
