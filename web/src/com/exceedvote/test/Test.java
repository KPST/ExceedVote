package com.exceedvote.test;

import com.exceedvote.controller.Client;
import com.exceedvote.core.ExceedDAO;
import com.exceedvote.core.ExceedJpaFactory;
import com.exceedvote.jpa.Auth;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExceedDAO ed = ExceedJpaFactory.getInstance().getDAO();
		//Auth a = new Auth();
		//a.setUser("name");
		//a.setPass("pass");
		//ed.saveUser(a);
		//ed.deleteUser(3);
		Client c = new Client(ed);
		Auth a = new Auth();
		a.setUser("name");
		a.setPass("pass");
		c.addUser("asdas", "pas",2);
	}

}
