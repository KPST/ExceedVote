package com.exceedvote.controller;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.exceedvote.core.Log;
import com.exceedvote.factory.IFactory;
import com.exceedvote.jpa.User;
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
	private IFactory b;
	private Log log;
    public Statement[] statements;
    public Choice[] choices;
    
    /**
     * Constructor
     */
    public Client(IFactory b) {
     this.log = Log.getLog();
     this.b = b;
     statements = b.getStatementDAO().getStatement();
     choices = b.getChoiceDAO().getChoice();
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
		this.b.getBallotDAO().saveBallot(b);
	}
    /**
     * findBallot from userid and number of question
     * @param userid
     * @param question
     * @return Ballot[] that contain every ballot in the database
     */
    public Ballot[] findBallot(int userid , int question){
    	List<Ballot> ab = b.getBallotDAO().findBallots(userid, question,b.getBallotDAO().FLAG_USER);
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
    	return b.getBallotDAO().findBallot(id);	
    }
    /**
     * DeleteBallot from id
     * @param id
     */
    public void DeleteBallot(int id){
    	b.getBallotDAO().deleteBallot(id);
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
    			temp[i][j] = b.getBallotDAO().findBallots(statements[i].getId(), choices[i].getId() , b.getBallotDAO().FLAG_CHOICE).size();
    		}
    	}
    	return temp;
    }
    
    /**
     * Delete that user
     * @param id id of user
     */
    public void deleteUser(int id){
    	b.getUserDAO().deleteUser(id);
    }
    /**
     * add to Statement
     * @param des description of statement
     */
    public void addStatement(String des){
    	Statement temp = new Statement();
    	temp.setDescription(des);
    	b.getStatementDAO().saveStatement(temp);
    	statements = b.getStatementDAO().getStatement();
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
    	b.getChoiceDAO().saveChoice(temp);
    	choices = b.getChoiceDAO().getChoice();
    }
    /**
     * Delete Statement
     * @param id id of statement
     */
    public void deleteStatement(int id){
    	b.getStatementDAO().deleteStatement(id);
    	statements = b.getStatementDAO().getStatement();
    }
    /**
     * Delete Choice
     * @param id id of choice
     */
    public void deleteChoice(int id){
    	b.getChoiceDAO().deleteChoice(id);
    	choices = b.getChoiceDAO().getChoice();
    }
    /**
     * GetAllUser
     * @return Auth[] that contain all user
     */
    public User[] getUser(){
    	return b.getUserDAO().getAllUser();
    }
    public void getDiffTime(){
    	Date ss = new Date(112, 12, 6);
    	ss.setHours(13);
    	ss.setMinutes(56);
    	ss.setSeconds(0);
    	Calendar n =new GregorianCalendar();
    	n.set(Calendar.YEAR,2012);
    	n.set(Calendar.MONTH,12-1);
    	n.set(Calendar.DAY_OF_MONTH, 6);
    	n.set(Calendar.HOUR_OF_DAY, 6);
    	n.set(Calendar.MINUTE, 42);
    	n.set(Calendar.SECOND, 0);
    	n.set(Calendar.MILLISECOND,0);
    	Calendar now = new GregorianCalendar();
    	Calendar out = new GregorianCalendar();
    	System.out.println(now);
    	System.out.println(n);
    	System.out.println(n.getTimeInMillis()-now.getTimeInMillis());
    	//now.setTimeInMillis(System.currentTimeMillis());
    	out.setTimeInMillis(n.getTimeInMillis()-now.getTimeInMillis());
    	System.out.println(out.get(Calendar.DAY_OF_MONTH)+" "+out.get(Calendar.HOUR_OF_DAY)+" "+out.get(Calendar.MINUTE)+" "+out.get(Calendar.SECOND));
    }
} 
