package com.exceedvote.core;
import java.util.Scanner;
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
    	
    }
    /**
     * Get Choice and Convert to String
     * @return String that contain 
     */
    public String convertChoicestoString(){
    	Choice[] st = cl.getAllChoices();
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0 ; i < st.length ; i++){
    		sb.append(" ID : ");
    		sb.append(st[i].getId());
    		sb.append(" Name : ");
    		sb.append(st[i].getName());
    		sb.append(" Des : ");
    		sb.append(st[i].getDescription());
    		if(i != st.length-1)
    		sb.append("\n");
    	}
    	sb.append(" ");
    	return sb.toString();
    }
    /**
     * getDescription of statement
     * @param st {@link Statement}[]
     * @param num no.of question
     * @return Description of statement
     */
    public String getStatementDescription(Statement[] st ,int num){
    	return st[num].getDescription();
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
