package testcase;
import com.exceedvote.*;
import static org.junit.Assert.*;

import org.junit.Test;


public class StatementTest {

@Test
public void testStatement() {
//Create state a Statement
Statement state = new Statement();
//Set the description of state
state.setDescription("Question1");
//Testcase1, Check after setting the description.
assertEquals(state.getDescription(),"Question1");
}

//@SuppressWarnings("deprecation")
@Test
public void testStatementList(){
//Create db a DatabaseManager
DatebaseManager dm = new DatebaseManager();
//Create list a StatementList
StatementList list = new StatementList(dm);
dm.init_Database();
//Add the first statement in list
list.addStatement("The first question");
//Instance statements an array of Statement
Statement [] statements = list.getAllStatement();

//Testcase1, The first statement should be the same one which was added firstly.
assertTrue(statements[0].getDescription().equals("The first question"));
//Add another statement in list 
list.addStatement("The second question");
//Rechange the value of statement after adding
statements = list.getAllStatement();

//Testcase2, The first statement should not be the same one which was added secondly.
assertFalse(statements[0].getDescription().equals("The second question"));
//Testcase3, The second statement should be the same on which was added secondly. 
assertTrue(statements[1].getDescription().equals("The second question"));
//change list into database list
list.getStatementFromDatabase();
//Testcase4, as we didn't call getstatement so statement should be the old one.
assertTrue(statements[0].getDescription().equals("The first question"));
assertTrue(statements[1].getDescription().equals("The second question"));
//now get new statementlist
statements = list.getAllStatement();
//Testcase5, the statements should not be the old one as statementlist now is link to database
assertFalse(statements[1].getDescription().equals("The second question"));
//now clear statementlist
list.clearStatement();
//Testcase6 clear method
assertEquals(list.getAllStatement().length, 0);
//end of statementlist test
//start of database manager test
//testcase1, test unusable flag
assertNull(dm.getListFromDatabase(3));
//testcase2, test usable flag
assertNotNull(dm.getListFromDatabase(DatebaseManager.STATEMENT));
//testcase3, test the same flag should return same data
for(int i = 0 ; i < dm.getListFromDatabase(DatebaseManager.STATEMENT).size();i++)
assertEquals(dm.getListFromDatabase(DatebaseManager.STATEMENT).get(i), dm.getListFromDatabase(DatebaseManager.STATEMENT).get(i));
//testcase4,create new databasemanager object then its should return same item
DatebaseManager testdm = new DatebaseManager();
testdm.init_Database();
for(int i = 0 ; i < dm.getListFromDatabase(DatebaseManager.CHOICE).size();i++)
	assertEquals(dm.getListFromDatabase(DatebaseManager.CHOICE).get(i),testdm.getListFromDatabase(DatebaseManager.CHOICE).get(i));
//end of database manager

}

}