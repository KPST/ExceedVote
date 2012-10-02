import java.sql.SQLException;
import com.mysql.jdbc.Connection;


public class Ballot {
	 Connection c;
	 int questionid;
	 int choice;
	 int user;
	 DatebaseManager dm;
		public Ballot(int user) {
	     this.user = user;
	     dm = new DatebaseManager();
		}
		public void insertBallot(Connection dbcon,int question,int choice) throws SQLException{
			//get all statement from database
			dm.init_Database(dbcon);
	        dm.putBallotToDatabase(this.user, question, choice);
		}
		
}
