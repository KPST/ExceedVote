package com.exceedvote;
import java.util.Scanner;

public class Client {
	//built program with statement
	StatementList sl;
	Scanner sc;
	ChoiceList cl;
    int userid;
    Statement[] st;
    DatebaseManager dm;
    public Client() {
	// TODO Auto-generated constructor stub
    // TODO
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
    
    public String getStatementDescription(Statement[] st ,int num){
    	return st[num].getDescription();
    }
    /*
     * i = no.question
     * g = choice
     */
    public void vote(int i,int g){
    	Ballot b = new Ballot(userid,dm);
			b.insertBallot(i, g);
			
    }
    
} 
