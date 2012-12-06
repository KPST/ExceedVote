package com.exceedvote.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.exceedvote.core.Log;
import com.exceedvote.factory.IFactory;
import com.exceedvote.factory.JpaFactory;
import com.exceedvote.jpa.Role;
import com.exceedvote.jpa.User;


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
			List<Role> rs = out.getRoles();
			System.out.println(rs.size());
			for(int i = 0 ; i < rs.size() ;i++)
				System.out.println(rs.get(i));
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
    public boolean addUser(String user,String pass,int ballot,String ip){
    	if(b.getUserDAO().findUser(user)==null){
    	User temp = new User();
    	temp.setUser(user);
    	List<Role> roles = new ArrayList<Role>();
    	//Role r = b.getRoleDAO().findRole("Admin");
    	Role r2 = b.getRoleDAO().findRole("Student");
    	//roles.add(r);
    	roles.add(r2);
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
