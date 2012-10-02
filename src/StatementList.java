import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class StatementList {
	ArrayList<Statement> statement = new ArrayList<Statement>();
	Connection c;
	PreparedStatement preparedStatement = null;
	public StatementList() {
	// TODO Auto-generated constructor stub
	// TODO add all statement from database to List
	}
	public void init_Database(Connection dbcon) throws SQLException{
		//get all statement from database
         c = dbcon;
         c.setAutoCommit(false);
         preparedStatement = (PreparedStatement) c.prepareStatement("SELECT id, description from statement");
             ResultSet resultSet = preparedStatement.executeQuery();
             try {
            	 while(true)
            	 if(resultSet.next()){
				// System.out.println(resultSet.getString("description"));
            	 addStatement(resultSet.getString("description"));
            	 }
            	 else
            		 break;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error when ");
				e.printStackTrace();
			}

			c.commit();
	}
	public void  addStatement(String des){
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
