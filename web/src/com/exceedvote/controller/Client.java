package com.exceedvote.controller;
import java.util.ArrayList;
import java.util.Scanner;

import com.exceedvote.core.Ballot;
import com.exceedvote.core.Choice;
import com.exceedvote.core.ChoiceList;
import com.exceedvote.core.DatebaseManager;
import com.exceedvote.core.Statement;
import com.exceedvote.core.StatementList;
/**
 * Client is Controller that control statement or choice
 * @author Kunat Pipatanakul
 * @version 2012.10.23
 *
 */
public class Client {
	//built program with statement
	StatementList sl;
	public Choice[] choice;
	ChoiceList cl;
    //int userid;
    public Statement[] st;
    DatebaseManager dm;
    /**
     * Constructor
     */
    public Client() {
    	dm = DatebaseManager.getDatabaseManager();
    	sl = new StatementList(dm);
    	cl = new ChoiceList(dm);
    	sl.getStatementFromDatabase();
    	cl.getChoiceFromDatabase();
    	st = sl.getAllStatement();
    	choice = cl.getAllChoices();
    }
    /**
     * Get Choice and Convert to String
     * @return String that contain 
     */
    public String getChoice(int num){
    	
    	StringBuilder sb = new StringBuilder();
    	
    		sb.append(" ID : ");
    		sb.append(choice[num].getId());
    		sb.append(" Name : ");
    		sb.append(choice[num].getName());
    		sb.append(" Des : ");
    		sb.append(choice[num].getDescription());
    		
    	sb.append(" ");
    	System.out.println(sb.toString());
    	return sb.toString();
    }
    /**
     * getDescription of statement
     * @param st {@link Statement}[]
     * @param num no.of question
     * @return Description of statement
     */
    public Statement getStatement(int num){
    	return st[num];
    }
    /**
     * vote this Ballot
     * @param userid = id of user
     * @param i = no.question
     * @param g = choice
     */
    public void vote(int userid,int i,int g){
    	Ballot b = new Ballot(userid,i,g);
		b.setDatabaseManager(dm);	
    	b.insertBallot();
			
    }
    /**
     * findBallot from userid and number of question
     * @param userid
     * @param question
     * @return Ballot[] that contain every ballot in the database
     */
    public Ballot[] findBallot(int userid , int question){
    	ArrayList<Ballot> ab = dm.findmyBallot(userid, question);
    	Ballot[] g = new Ballot[ab.size()];
    	ab.toArray(g);
    	return g;
    }
    /**
     * findBallot form id
     * @param id
     * @return Ballot
     */
    public Ballot findBallot(int id){
    	return dm.findBallotById(id);	
    }
    /**
     * DeleteBallot from id
     * @param id
     */
    public void DeleteBallot(int id){
    	dm.deleteBallotById(id);
    }
} 
