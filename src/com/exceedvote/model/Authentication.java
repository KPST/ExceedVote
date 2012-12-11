package com.exceedvote.model;

import java.util.List;

import com.exceedvote.entity.Role;
import com.exceedvote.entity.User;
import com.exceedvote.factory.IFactory;


/**
 * Class that control the authentication process.
 * @author Kunat Pipatanakul
 * @version 2012.10.23
 */
public class Authentication {
	private IFactory b;
	private Log log;
	/**
	 * Constructor
	 */
	public Authentication(IFactory b) {
	this.b = b;
	this.log = Log.getLog();
	}
	/**
	 * login func
	 * @param user,username that user have inputed.
	 * @param pass,password that user have inputed.
	 */
	public User login(String user,String pass,String ip){
		User out = b.getUserDAO().findUser(user, pass);
		if(out != null){
			log.loginLog(out.getUser(), ip, Log.LOGIN_OK);
		}
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
    public boolean addUser(String user,String pass,int ballot,String ip,List<Role> roles){
    	if(b.getUserDAO().findUser(user)==null){
    	User temp = new User();
    	temp.setUser(user);
    	temp.setPass(pass);
    	temp.setRoles(roles);
    	b.getUserDAO().saveUser(temp);
    	log.regisLog(user, ip, Log.REGIS_OK);
    	return true;
    	}
    	else{
    		log.regisLog("", ip, Log.REGIS_FAIL);
    		System.out.println("User already regis");
    		return false;
    	}
    }
	
}
