package com.exceedvote.core;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * DatabaseManager is the class connect to Database.
 * @author Kunat Pipatanakul
 * @version 2012.10.23
 */
public class DatebaseManager {
	Connection c;
	PreparedStatement preparedStatement = null;
	public static final int STATEMENT = 1;
	public static final int CHOICE = 2;
	public static final int BALLOT = 3;
	/**
	 * Constructor
	 * 
	 */
	public DatebaseManager() {
		// TODO Auto-generated constructor stub
		init_Database();
	
	}
	/**
	 * Connect to Database.
	 * @return {@link DatebaseManager} this.
	 */
	public DatebaseManager init_Database(){
		//get all statement from database
		try {
			  Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error when load driver"+e.getMessage());
			e.printStackTrace();
		}
		try{
   		 c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/exceedvote","root","unkink");
   		 //System.out.println("connect!");
   		 c.setAutoCommit(false);
   		}
   		catch( SQLException x ){
   			System.out.println( "Couldn’t get connection!"+x.getMessage() );
   		}
         return this;
        
     }
	/**
	 * getrawInformation from database
	 * @param flag static int STATEMENT CHOICE OR BALLOT
	 * @return List of raw information from database.
	 */
	public ArrayList<Object[]> getListFromDatabase(int flag){
		ArrayList<Object[]> arrayout = new ArrayList<Object[]>();
		try{
			if(flag == STATEMENT){
				preparedStatement = (PreparedStatement) c.prepareStatement("SELECT id, description from statement");
			}
			else if(flag == CHOICE){
				preparedStatement = (PreparedStatement) c.prepareStatement("SELECT * from choice");	
			}
			else if(flag == BALLOT){
				preparedStatement = (PreparedStatement) c.prepareStatement("SELECT * from ballot");	
			}
			else{
				return null;
			}
		
        ResultSet resultSet = preparedStatement.executeQuery();
        
       	 while(true)
       	 if(resultSet.next()){
       		 if(flag == STATEMENT){
       		 Object[] temp = {resultSet.getString("description")};
       		 arrayout.add(temp);
       		 }
       		 else if(flag == CHOICE){
       	     Object[] temp = {resultSet.getString("description"),resultSet.getInt("id"),resultSet.getString("name")};
       	     arrayout.add(temp);
       		 }
       		 else if(flag == BALLOT){
       		 Object[] temp = {resultSet.getInt("questionid"),resultSet.getInt("choice")};
       		 arrayout.add(temp);
       		 }
       		 else{
       			 System.err.println("FLAG not found");
       			 return null;
       		 }
			
       	 }
       	 else
       		 break;
       	 c.commit();
		} catch (SQLException e) {
			System.out.println("Error when get Result");
			e.printStackTrace();
			return null;
		}

	return arrayout;	
	}
	/**
	 * findUser from Database 
	 * @param user username that user inputed.
	 * @param pass password that user inputed.
	 * @return null if user not found || array of int contain [0] = id [1] = priority
	 */
	public int[] findUser(String user,String pass){
		try{
				preparedStatement = (PreparedStatement) c.prepareStatement("SELECT * from auth where user='"+user+"'and pass='"+pass+"'");
			
		
        ResultSet resultSet = preparedStatement.executeQuery();
        c.commit();
        if(resultSet.next()){
        	System.out.println("OK");
        	int[] userid = new int[3];
        	userid[0] = resultSet.getInt("id");
        	userid[1] = resultSet.getInt("priority");
        	userid[2] = resultSet.getInt("no_ballot");
        	return userid;
        }
        else{
        	System.out.println("USER NOT FOUND");
        	return null;
        }
       	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR WHEN GET RESULT");
			e.printStackTrace();
			return null;
		}

		
	}
	/**
	 * put Ballot to Database
	 * @param user userid
	 * @param question int no.of question
	 * @param choice int no.of choice
	 */
	public void putBallotToDatabase(int user ,int question , int choice){
	
        try {
        	java.sql.Statement statement = c.createStatement();
			((java.sql.Statement) statement).executeUpdate("INSERT INTO  ballot ( id , user ,questionid ,choice) VALUES (NULL ,' "+user+" ' , '"+question+"',  '"+choice+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Ballot> findmyBallot(int user,int question){
		ArrayList<Ballot> ab = new ArrayList<Ballot>();
		try{
		preparedStatement = (PreparedStatement) c.prepareStatement("SELECT * from ballot where user='"+user+"'and questionid='"+question+"'");
		ResultSet resultSet = preparedStatement.executeQuery();
		c.commit();
		while(resultSet.next()){
			Ballot temp = new Ballot(user, question, resultSet.getInt("choice"));
			ab.add(temp);
		}
		}catch(Exception e){
			System.out.println("Error when add find ballot "+e.getMessage());
		}
		return ab;
	}
}
