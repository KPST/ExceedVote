package com.exceedvote;

public class Authentication {
	DatebaseManager dm;
	boolean isAdmin = false;
	public Authentication() {
		dm = new DatebaseManager();
		dm.init_Database();
	
	// TODO Auto-generated constructor stub
	}
	public boolean login(String user,String pass){
		int priority = dm.findUser(user, pass);
		if(priority == -1)
			return true;
		else if(priority == 0){
			isAdmin = true;
			return true;
		}
		else{
			return true;
		}
	}
}
