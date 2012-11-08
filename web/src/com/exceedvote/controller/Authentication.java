package com.exceedvote.controller;

import com.exceedvote.jpa.Auth;

import Core.BloatDAO;


/**
 * Class that control the authentication process.
 * @author Kunat Pipatanakul
 * @version 2012.10.23
 */
public class Authentication {
	BloatDAO b;
	Auth a;
	/**
	 * Constructor
	 */
	public Authentication(BloatDAO b) {
	this.b = b;
	}
	/**
	 * login func
	 * @param user,username that user have inputed.
	 * @param pass,password that user have inputed.
	 */
	public boolean login(String user,String pass){
		try{
			this.a = b.findUser(user, pass);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	public Auth getAuth(){
		return a;
	}
	
}
