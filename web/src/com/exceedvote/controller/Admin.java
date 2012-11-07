package com.exceedvote.controller;

import com.exceedvote.core.Counter;
import com.exceedvote.core.DatebaseManager;

/**
 * Admin Controller
 * @author Kunat Pipatanakul
 * @version 2012.11.1
 */
public class Admin {
	public Counter k;

	public Admin() {
		DatebaseManager dm = DatebaseManager.getDatabaseManager();
		k = new Counter(dm);
	}

}
