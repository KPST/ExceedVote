import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;


public class ChoiceList {
	ArrayList<Choice> choices = new ArrayList<Choice>();
	DatebaseManager dm;
	public void init_Database(Connection dbcon) throws SQLException{
		dm = new DatebaseManager();
		dm.init_Database(dbcon);
		}
	public void getChoiceFromDatabase(){
		ArrayList<Object[]> o = dm.getChoiceList();
		for(int i = 0 ; i < o.size(); i++){
			addChoice((String)o.get(i)[0], (Integer)o.get(i)[1] , (String) o.get(i)[2]);
		}
	}
	public void addChoice(String des,int id,String name){
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
