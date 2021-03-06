package com.exceedvote.controller;
import java.util.List;

import com.exceedvote.core.ExceedDAO;
import com.exceedvote.core.JpaDAO;
import com.exceedvote.core.Log;
import com.exceedvote.jpa.Auth;
import com.exceedvote.jpa.Ballot;
import com.exceedvote.jpa.Choice;
import com.exceedvote.jpa.Statement;


/**
 * Client is Controller that control statement or choice
 * @author Kunat Pipatanakul
 * @version 2012.10.23
 *
 */
public class Client {
	private ExceedDAO b;
	private Log log;
    public Statement[] statements;
    public Choice[] choices;
    
    /**
     * Constructor
     */
    public Client(ExceedDAO b) {
     this.log = Log.getLog();
     this.b = b;
     statements = b.getStatement();
     choices = b.getChoice();
    }

    /**
     * getDescription of statement
     * @param st {@link Statement}[]
     * @param num no.of question
     * @return Description of statement
     */
    public Statement getStatement(int num){
    	for (Statement s : statements) {
			if(s.getId()==num)
				return s;
		}
    	return null;
    }
    /**
     * vote this Ballot
     * @param userid = id of user
     * @param i = no.question
     * @param g = choice
     */
    public void vote(int userid,int question,int choice){
    	Ballot b = new Ballot(userid,question,choice);
    	log.voteLog(userid, choice, question, Log.BALLOT_SAVE);
		this.b.saveBallot(b);
			
    }
    /**
     * findBallot from userid and number of question
     * @param userid
     * @param question
     * @return Ballot[] that contain every ballot in the database
     */
    public Ballot[] findBallot(int userid , int question){
    	List<Ballot> ab = b.findBallots(userid, question,JpaDAO.FLAG_USER);
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
    	log.deleteVoteLog(id, Log.BALLOT_DELETE);
    }
    /**
     * getResult use for count the vote
     * @return
     */
    public int[][] getResult(){
    	int[][] temp = new int[statements.length][choices.length];
    	for(int i = 0 ; i < statements.length ;i++){
    		for(int j = 0 ; j < choices.length ; i++){
    			temp[i][j] = b.findBallots(statements[i].getId(), choices[i].getId() , JpaDAO.FLAG_CHOICE).size();
    		}
    	}
    	return temp;
    }
    
    /**
     * Delete that user
     * @param id id of user
     */
    public void deleteUser(int id){
    	b.deleteUser(id);
    }
    /**
     * add to Statement
     * @param des description of statement
     */
    public void addStatement(String des){
    	Statement temp = new Statement();
    	temp.setDescription(des);
    	b.saveStatement(temp);
    	statements = b.getStatement();
    }
    /**
     * add to Choice
     * @param name String name of choice
     * @param des String description of choice
     * @param img String url to image
     */
    public void addChoice(String name,String des,String img){
    	Choice temp = new Choice();
    	temp.setName(name);
    	temp.setDescription(des);
    	temp.setImg(img);
    	b.saveChoice(temp);
    	choices = b.getChoice();
    }
    /**
     * Delete Statement
     * @param id id of statement
     */
    public void deleteStatement(int id){
    	b.deleteStatement(id);
    	statements = b.getStatement();
    }
    /**
     * Delete Choice
     * @param id id of choice
     */
    public void deleteChoice(int id){
    	b.deleteChoice(id);
    	choices = b.getChoice();
    }
    /**
     * GetAllUser
     * @return Auth[] that contain all user
     */
    public Auth[] getUser(){
    	return b.getAllUser();
    }
} 
