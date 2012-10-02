import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class DatebaseManager {
	Connection c;
	PreparedStatement preparedStatement = null;
	static final int STATEMENT = 1;
	static final int CHOICE = 2;
	public DatebaseManager() {
		// TODO Auto-generated constructor stub
	}
	public void init_Database(Connection dbcon) throws SQLException{
		//get all statement from database
         c = dbcon;
         c.setAutoCommit(false);
     }
	public ArrayList<Object[]> getListFromDatabase(int flag){
		ArrayList<Object[]> arrayout = new ArrayList<Object[]>();
		try{
			if(flag == STATEMENT){
				preparedStatement = (PreparedStatement) c.prepareStatement("SELECT id, description from statement");
			}
			if(flag == CHOICE){
				preparedStatement = (PreparedStatement) c.prepareStatement("SELECT * from choice");	
			}
		
        ResultSet resultSet = preparedStatement.executeQuery();
        
       	 while(true)
       	 if(resultSet.next()){
			// System.out.println(resultSet.getString("description"));
       		 if(flag == STATEMENT){
       		 Object[] temp = {resultSet.getString("description")};
       		 arrayout.add(temp);
       		 }
       		 else if(flag == CHOICE){
       	     Object[] temp = {resultSet.getString("description"),resultSet.getInt("id"),resultSet.getString("name")};
       	     arrayout.add(temp);
       		 }
       		 else{
       			 System.err.println("FLAG not found");
       			 return null;
       		 }
			
       	 }
       	 else
       		 break;
       	 c.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error when ");
			e.printStackTrace();
			return null;
		}

	return arrayout;	
	}
	public void putBallotToDatabase(int user ,int question , int choice){
	
        try {
        	java.sql.Statement statement = c.createStatement();
			((java.sql.Statement) statement).executeUpdate("INSERT INTO  ballot ( id , user ,questionid ,choice) VALUES (NULL ,' "+user+" ' , '"+question+"',  '"+choice+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
