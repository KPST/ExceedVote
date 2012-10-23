package test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.exceedvote.DatebaseManager;
import com.exceedvote.Statement;
import com.exceedvote.StatementList;
/**
 * StatementSeparateTest tests for a Statment class and a StatementList class.
 * @author Tanachot Teachajarupan
 * @version 2012.10.23
 */

public class StatementSeparateTest {

	@Test
	public void testStatement() {
		//Create state a Statement
		Statement state = new Statement();
		//Set the description of state
		state.setDescription("Question1");
		//Testcase1, Check after setting the description.
		assertEquals(state.getDescription(),"Question1");
	}
	
	@Test
	public void testStatementList(){
		//Create db a DatabaseManager
		DatebaseManager dm = new DatebaseManager();
		//Create list a StatementList
		StatementList list = new StatementList(dm);
		//Add the first statement in list
		list.addStatement("The first question");
		//Instance statements an array of Statement
		Statement [] statements = list.getAllStatement();
		
		//Testcase1, The first statement should be the same one which was added firstly.
		assertTrue(statements[0].getDescription() == "The first question");
		//Add another statement in list 
		list.addStatement("The second question");
		//Rechange the value of statement after adding
		statements = list.getAllStatement();
		
		//Testcase2, The first statement should not be the same one which was added secondly.
		assertFalse(statements[0].getDescription() == "The second question");
		//Testcase3, The second statement should be the same on which was added secondly. 
		assertTrue(statements[1].getDescription() == "The second question");
		
	}

}
