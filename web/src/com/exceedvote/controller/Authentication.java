package com.exceedvote.controller;

import com.exceedvote.core.ExceedDAO;
import com.exceedvote.core.JpaDAO;
import com.exceedvote.jpa.Auth;


/**
 * Class that control the authentication process.
 * @author Kunat Pipatanakul
 * @version 2012.10.23
 */
public class Authentication {
	ExceedDAO b;
	/**
	 * Constructor
	 */
	public Authentication(ExceedDAO b) {
	this.b = b;
	}
	/**
	 * login func
	 * @param user,username that user have inputed.
	 * @param pass,password that user have inputed.
	 */
	public Auth login(String user,String pass){
		try{
		return b.findUser(user, pass);
		}catch(Exception e){
			return null;
		}
	}
	
	
}
