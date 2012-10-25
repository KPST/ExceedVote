package com.exceedvote.core;

import com.mysql.jdbc.Connection;

/**
 * Ballot is a ballot that insert into database
 * @author Kunat Pipatanakul
 * @version 2012.10.23
 */
public class Ballot {
	 Connection c;
	 DatebaseManager dm;
	 /**
	  * Constructor
	  * @param dm {@link DatebaseManager} that want this class to connect
	  */
		public Ballot(DatebaseManager dm) {
	     this.dm = dm;
		}
		/**
		 * Put Ballot into database
		 * @param userid userid,int
		 * @param question no.of this ballot question
		 * @param choice no.of choice the user select
		 */
		public void insertBallot(int userid,int question,int choice) {
			//get all statement from database
			try{
	        dm.putBallotToDatabase(userid, question, choice);
			}catch(Exception e){
				System.err.println("ERROR when Insert ballot");
			}
		}
		
}
