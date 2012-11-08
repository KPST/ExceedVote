package com.exceedvote.controller;
import java.util.List;

import com.exceedvote.jpa.Ballot;
import com.exceedvote.jpa.Choice;
import com.exceedvote.jpa.Statement;

import Core.BloatDAO;

/**
 * Client is Controller that control statement or choice
 * @author Kunat Pipatanakul
 * @version 2012.10.23
 *
 */
public class Client {
	BloatDAO b;
    public Statement[] statements;
    public Choice[] choices;
    /**
     * Constructor
     */
    public Client(BloatDAO b) {
     this.b = b;
     statements = b.getStatement();
     choices = b.getChoice();
    }
    /**
     * Get Choice and Convert to String
     * @return String that contain 
     */
    public String getChoice(int num){
    	Choice[] choice = b.getChoice();
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0 ; i < choice.length ;i++){
    		sb.append(" ID : ");
    		sb.append(choice[i].getId());
    		sb.append(" Name : ");
    		sb.append(choice[i].getName());
    		sb.append(" Des : ");
    		sb.append(choice[i].getDescription());
    	}
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
    	return statements[num];
    }
    /**
     * vote this Ballot
     * @param userid = id of user
     * @param i = no.question
     * @param g = choice
     */
    public void vote(int userid,int i,int g){
    	Ballot b = new Ballot(userid,i,g);
		this.b.saveBallot(b);
			
    }
    /**
     * findBallot from userid and number of question
     * @param userid
     * @param question
     * @return Ballot[] that contain every ballot in the database
     */
    public Ballot[] findBallot(int userid , int question){
    	List<Ballot> ab = b.findBallots(userid, question);
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
    	return b.findBallot(id);	
    }
    /**
     * DeleteBallot from id
     * @param id
     */
    public void DeleteBallot(int id){
    	b.deleteBallot(id);
    }
} 
