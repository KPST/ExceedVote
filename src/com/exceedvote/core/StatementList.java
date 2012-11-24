package com.exceedvote.core;

import java.util.ArrayList;
import com.mysql.jdbc.Connection;

/**
 * StatementList is a List of Statement
 * @author Kunat Pipatanakul
 * @version 2012.10.23
 *
 */
public class StatementList {
	ArrayList<Statement> statement = new ArrayList<Statement>();
	Connection c;
	DatebaseManager dm;
	/**
	 * Constructor
	 * @param dm {@link DatebaseManager} object
	 */
	public StatementList(DatebaseManager dm) {
	// TODO Auto-generated constructor stub
	// TODO add all statement from database to List
		this.dm = dm;
	}
	/**
	 * get all statement from database and do add to List<Statement>
	 */
	public void getStatementFromDatabase(){
		clearStatement();
		ArrayList<Object[]> o = dm.getListFromDatabase(DatebaseManager.STATEMENT);
		for(int i = 0 ; i < o.size() ; i++){
		addStatement((String) o.get(i)[0]);
		}
	}
	/**
	 * add Statement into List
	 * @param des
	 */
	public void addStatement(String des){
		Statement st = new Statement();
		st.setDescription(des);
		statement.add(st); 
	}
	/**
	 * getAllStatement that in the List
	 * @return Statement[] 
	 */
	public Statement[] getAllStatement(){
		Statement[] state = new Statement[statement.size()];
		for(int i = 0 ; i < statement.size() ; i ++){
			state[i] = statement.get(i);
		}
		return state;
	}
	/**
	 * Clear all statement. 
	 */
	public void clearStatement(){
		statement.clear();
	}
    
}
