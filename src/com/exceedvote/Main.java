package com.exceedvote;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Authentication a = new Authentication();
		UI ui = new UI();
		ClientController c = new ClientController(a,ui);
		c.run();
	}

}
