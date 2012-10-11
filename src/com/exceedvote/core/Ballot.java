package com.exceedvote.core;

import com.mysql.jdbc.Connection;


public class Ballot {
	 Connection c;
	 DatebaseManager dm;
		public Ballot(DatebaseManager dm) {
	     this.dm = dm;
		}
		public void insertBallot(int userid,int question,int choice) {
			//get all statement from database
			try{
	        dm.putBallotToDatabase(userid, question, choice);
			}catch(Exception e){
				System.err.println("ERROR when Insert ballot");
			}
		}
		
}
