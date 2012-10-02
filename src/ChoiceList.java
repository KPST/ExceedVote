import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class ChoiceList {
	ArrayList<Choice> choices = new ArrayList<Choice>();
	Connection c;
	PreparedStatement preparedStatement = null;
	public void init_Database(Connection dbcon) throws SQLException{
		//get all statement from database
         c = dbcon;
         c.setAutoCommit(false);
         preparedStatement = (PreparedStatement) c.prepareStatement("SELECT * from choice");
             ResultSet resultSet = preparedStatement.executeQuery();
             try {
            	 while(true)
            	 if(resultSet.next()){
				// System.out.println(resultSet.getString("description"));
            	 addChoice(resultSet.getString("description"),resultSet.getInt("id"),resultSet.getString("name"));
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
	public void  addChoice(String des,int id,String name){
		Choice st = new Choice();
		st.setDescription(des);
		st.setId(id);
		st.setName(name);
		choices.add(st); 
	}
	//return all statement
	public Choice[] getAllStatement(){
		Choice[] state = new Choice[choices.size()];
		for(int i = 0 ; i < choices.size() ; i ++){
			state[i] = choices.get(i);
		}
		return state;
	}
}
