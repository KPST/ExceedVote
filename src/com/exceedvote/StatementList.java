package com.exceedvote;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;

import com.mysql.jdbc.Connection;


public class StatementList {
	ArrayList<Statement> statement = new ArrayList<Statement>();
	Connection c;
	DatebaseManager dm;
	public StatementList(DatebaseManager dm) {
	// TODO Auto-generated constructor stub
	// TODO add all statement from database to List
		this.dm = dm;
	}
	
	public void getStatementFromDatabase(){
		clearStatement();
		ArrayList<Object[]> o = dm.getListFromDatabase(DatebaseManager.STATEMENT);
		for(int i = 0 ; i < o.size() ; i++){
		addStatement((String) o.get(i)[0]);
		}
	}
	public void addStatement(String des){
		Statement st = new Statement();
		st.setDescription(des);
		statement.add(st); 
	}
	//return all statement
	public Statement[] getAllStatement(){
		Statement[] state = new Statement[statement.size()];
		for(int i = 0 ; i < statement.size() ; i ++){
			state[i] = statement.get(i);
		}
		return state;
	}
	public boolean clearStatement(){
		statement.clear();
		return true;
	}
    
}
