package com.exceedvote.core;

public class Admin {
	public Counter k;

	public Admin() {
		// TODO Auto-generated constructor stub
		DatebaseManager dm = new DatebaseManager();
		dm.init_Database();
		k = new Counter(dm);
	}

}
