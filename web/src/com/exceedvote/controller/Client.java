package com.exceedvote.controller;
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
	Scanner sc;
	public Choice[] choice;
	ChoiceList cl;
    //int userid;
    public Statement[] st;
    DatebaseManager dm;
    /**
     * Constructor
     */
    public Client() {
    	dm = new DatebaseManager();
    	sc = new Scanner(System.in);
    	//init_database();
    	dm.init_Database();
    	//
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
    		
    	//}
    	sb.append(" ");
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
    	Ballot b = new Ballot(dm);
			b.insertBallot(userid,i, g);
			
    }
    
} 
