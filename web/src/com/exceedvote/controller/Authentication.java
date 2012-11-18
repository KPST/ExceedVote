package com.exceedvote.controller;

import com.exceedvote.core.ExceedDAO;
import com.exceedvote.core.Log;
import com.exceedvote.jpa.Auth;


/**
 * Class that control the authentication process.
 * @author Kunat Pipatanakul
 * @version 2012.10.23
 */
public class Authentication {
	private ExceedDAO b;
	private Log log;
	/**
	 * Constructor
	 */
	public Authentication(ExceedDAO b) {
	this.b = b;
	this.log = Log.getLog();
	}
	/**
	 * login func
	 * @param user,username that user have inputed.
	 * @param pass,password that user have inputed.
	 */
	public Auth login(String user,String pass,String ip){
		Auth out = b.findUser(user, pass);
		if(out != null)
			log.loginLog(out.getUser(), ip, Log.LOGIN_OK);
		else
			log.loginLog("", ip, Log.LOGIN_FAIL);
		return out;
	}
	/**
     * addUser is register
     * @param user username
     * @param pass password
     * @param ballot numberofballot
     */
    public void addUser(String user,String pass,int ballot,String ip){
    	if(b.findUser(user)==null){
    	Auth temp = new Auth();
    	temp.setBallot(ballot);
    	temp.setUser(user);
    	temp.setPass(pass);
    	temp.setPriority(0);
    	b.saveUser(temp);
    	log.regisLog(user, ip, Log.REGIS_OK);
    	}
    	else{
    		log.regisLog("", ip, Log.REGIS_FAIL);
    		System.out.println("User already regis");
    	}
    }
	
}
