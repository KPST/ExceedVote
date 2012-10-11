package com.exceedvote.core;

public class Authentication {
	DatebaseManager dm;
	int userid;
	public boolean isAdmin = false;
	public Authentication() {
		dm = new DatebaseManager();
		dm.init_Database();
	
	// TODO Auto-generated constructor stub
	}
	public int getUserId(){
		return userid;
	}
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
