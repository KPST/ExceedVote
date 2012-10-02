import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;


public class Client {
	//built program with statement
	StatementList sl;
	Connection dbConnection;
	Scanner sc;
	ChoiceList cl;
    int userid;
    Statement[] st;
    public Client() {
	// TODO Auto-generated constructor stub
    // TODO
    	sc = new Scanner(System.in);
    	init_database();
    	sl = new StatementList();
    	cl = new ChoiceList();
    	try {
			sl.init_Database(dbConnection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERRORS");
			e.printStackTrace();
		}
    	try {
			cl.init_Database(dbConnection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR when connect choice databases");
			e.printStackTrace();
		}
    	st = sl.getAllStatement();
    	
    }
    public void init_database(){
    	try{
    		 dbConnection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/exceedvote","root","unkink");
    		 //System.out.println("connect!");
    		}
    		catch( SQLException x ){
    			System.out.println( "Couldn’t get connection!" );
    		}
    }
    //TODO login
    public void login(String user,String pass){
    	userid = 1;
    }
    
    public String convertChoicestoString(){
    	Choice[] st = cl.getAllStatement();
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
    	Ballot b = new Ballot(userid);
		try {
			b.init_Database(dbConnection, i, g);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR when insert");
			e.printStackTrace();
		}
    }
    
} 
