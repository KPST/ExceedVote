import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class Ballot {
	 Connection c;
	 int questionid;
	 int choice;
	 int user;
	private PreparedStatement preparedStatement = null;
		public Ballot(int user) {
	     this.user = user;
		}
		public void init_Database(Connection dbcon,int question,int choice) throws SQLException{
			//get all statement from database
	         c = dbcon;
	         
	         java.sql.Statement statement = c.createStatement();
	         ((java.sql.Statement) statement).executeUpdate("INSERT INTO  ballot ( id , user ,questionid ,choice) VALUES (NULL ,' "+this.user+" ' , '"+question+"',  '"+choice+"')");
		}
		
}
