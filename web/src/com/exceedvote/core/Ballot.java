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
	 int id;
	 int userid;
	 int question;
	 int choice;
		/**
		 * 
		 * @param user
		 * @param question
		 * @param choice
		 */
	 	public Ballot(int user,int question,int choice) {
			this.userid = user;
			this.question = question;
			this.choice = choice;
		}
		public Ballot(int id ,int user,int question,int choice){
			this.id = id;
			this.userid = user;
			this.question = question;
			this.choice = choice;
		}
		/**
		 * Put Ballot into database
		 */
		public void setDatabaseManager(DatebaseManager dm){
			this.dm = dm;
		}
		public int getId(){
			return id;
		}
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		public int getQuestion() {
			return question;
		}
		public void setQuestion(int question) {
			this.question = question;
		}
		public int getChoice() {
			return choice;
		}
		public void setChoice(int choice) {
			this.choice = choice;
		}
		public void insertBallot() {
			//get all statement from database
			try{
	        dm.putBallotToDatabase(userid, question, choice);
			}catch(Exception e){
				System.err.println("ERROR when Insert ballot");
			}
		}
		
}
