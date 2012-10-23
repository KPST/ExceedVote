package com.exceedvote.core;


/**
 * Class that control the authentication process.
 * @author Kunat Pipatanakul
 * @version 2012.10.23
 */
public class Authentication {
	DatebaseManager dm;
	int userid;
	public boolean isAdmin = false;
	/**
	 * Constructor
	 */
	public Authentication() {
		dm = new DatebaseManager();
		dm.init_Database();
	
	// TODO Auto-generated constructor stub
	}
	/**
	 *get who have login
	 *@return userid
	 */
	public int getUserId(){
		return userid;
	}
	/**
	 * login func
	 * @param user,username that user have inputed.
	 * @param pass,password that user have inputed.
	 */
	public boolean login(String user,String pass){
		int[] priority = dm.findUser(user, pass);
		if(priority == null)
			return false;
		if(priority[1] == 0){
			userid = priority[0];
			isAdmin = true;
			return true;
		}
		else{
			userid = priority[0];
			return true;
		}
	}
}
