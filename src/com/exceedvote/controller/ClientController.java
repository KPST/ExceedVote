package com.exceedvote.controller;

import com.exceedvote.core.Admin;
import com.exceedvote.core.Authentication;
import com.exceedvote.core.Client;
import com.exceedvote.ui.UI;
/**
 * Controller of exceedvote
 * @author Kunat Pipatanakul
 * @version 2012.10.23
 */
public class ClientController {
	Authentication a;
	UI ui;
	/**
	 * Constructor
	 * @param a {@link Authentication} process of this Controller
	 * @param ui {@link UI} of this Controller
	 */
	public ClientController(Authentication a, UI ui) {
		this.a = a;
		this.ui = ui;
	}
	/**
	 * start the controller
	 */
	public void run() {
		// input login username
		ui.update("LOGIN");
		ui.update("Username");
		String user = ui.getString();
		ui.update("Password");
		String pass = ui.getString();
		if (a.login(user, pass)) {
			if (a.isAdmin) {
				ui.update("Admin System");
				Admin admin = new Admin();
				ui.update(admin.k.getResult());
			} else {
				Client c = new Client();
				for (int i = 0; i < c.st.length; i++) {

					ui.update(c.getStatementDescription(c.st, i));
					ui.update(c.convertChoicestoString());
					int g = ui.getInput();
					// a.getUserId();
					c.vote(a.getUserId(), i + 1, g);
				}
			}
		} else
			ui.update("Please Restart Program");
	}
}
