package com.exceedvote.model;

public class TestGC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DatabaseGarbageCollector dgc = DatabaseGarbageCollector.getInstance();
		dgc.cleanUpBallot();
	}

}
