package com.exceedvote.controller;

import com.exceedvote.core.Admin;
import com.exceedvote.core.Authentication;
import com.exceedvote.core.Client;
import com.exceedvote.ui.UI;



public class ClientController {
	Authentication a;
	UI ui;
	public ClientController(Authentication a, UI ui) {
	this.a = a;
	this.ui = ui;
	}
	
	public void run(){
		//input login username
		ui.update("LOGIN");
		ui.update("Username");
		String user = ui.getString();
		ui.update("Password");
		String pass = ui.getString();
		if(a.login(user,pass)){
		if(a.isAdmin){
			ui.update("Admin System");
			Admin admin = new Admin();
			ui.update(admin.k.getResult());
		}
		else{
			Client c = new Client();
		for (int i = 0 ; i < c.st.length ; i++){
			
			ui.update(c.getStatementDescription(c.st, i));
			ui.update(c.convertChoicestoString());
			int g = ui.getInput();
			//a.getUserId();
			c.vote(a.getUserId(),i + 1, g);
	    }
		}
		}
		else
			ui.update("Please Restart Program");
	}
}
