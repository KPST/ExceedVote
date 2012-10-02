import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class StatementList {
	ArrayList<Statement> statement = new ArrayList<Statement>();
	Connection c;
	DatebaseManager dm;
	public StatementList() {
	// TODO Auto-generated constructor stub
	// TODO add all statement from database to List
		
	}
	public void init_Database(Connection dbcon) throws SQLException{
		//get all statement from database
		dm = new DatebaseManager();
		dm.init_Database(dbcon);
	}
	public void getStatementFromDatabase(){
		ArrayList<Object[]> o = dm.getStatementList();
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
    
}
