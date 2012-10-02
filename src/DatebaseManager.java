import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class DatebaseManager {
	Connection c;
	PreparedStatement preparedStatement = null;
	public DatebaseManager() {
		// TODO Auto-generated constructor stub
	}
	public void init_Database(Connection dbcon) throws SQLException{
		//get all statement from database
         c = dbcon;
         c.setAutoCommit(false);
     }
	public ArrayList<Object[]> getChoiceList(){
		ArrayList<Object[]> arrayout = new ArrayList<Object[]>(); 
		try{
		
		preparedStatement = (PreparedStatement) c.prepareStatement("SELECT * from choice");
        ResultSet resultSet = preparedStatement.executeQuery();
        
       	 while(true)
       	 if(resultSet.next()){
			// System.out.println(resultSet.getString("description"));
       	  Object[] temp = {resultSet.getString("description"),resultSet.getInt("id"),resultSet.getString("name")};
       	  arrayout.add(temp);
       	 }
       	 
       	 else{
       		 break;
       	 }
       	c.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error when find choice");
			e.printStackTrace();
			return null;
		}

		return arrayout;
	}
	public ArrayList<Object[]> getStatementList(){
		ArrayList<Object[]> arrayout = new ArrayList<Object[]>();
		try{
		preparedStatement = (PreparedStatement) c.prepareStatement("SELECT id, description from statement");
        ResultSet resultSet = preparedStatement.executeQuery();
        
       	 while(true)
       	 if(resultSet.next()){
			// System.out.println(resultSet.getString("description"));
       		 Object[] temp = {resultSet.getString("description")};
       		 arrayout.add(temp);
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
