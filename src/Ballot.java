
import com.mysql.jdbc.Connection;


public class Ballot {
	 Connection c;
	 int questionid;
	 int choice;
	 int user;
	 DatebaseManager dm;
		public Ballot(int user,DatebaseManager dm) {
	     this.user = user;
	     this.dm = dm;
		}
		public void insertBallot(int question,int choice) {
			//get all statement from database
			try{
	        dm.putBallotToDatabase(this.user, question, choice);
			}catch(Exception e){
				System.err.println("ERROR when Insert ballot");
			}
		}
		
}
