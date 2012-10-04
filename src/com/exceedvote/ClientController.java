package com.exceedvote;



public class ClientController {
	Client c;
	UI ui;
	public ClientController(Client c, UI ui) {
	this.c = c;
	this.ui = ui;
	}
	
	public void run(){
		//TODO login parse
		//input login username
		c.login("KK","GG");
		
		for (int i = 0 ; i < c.st.length ; i++){
			ui.update(c.getStatementDescription(c.st, i));
			ui.update(c.convertChoicestoString());
			int g = ui.getInput();
			c.vote(i + 1, g);
	    }
	}
}
