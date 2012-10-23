package test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.exceedvote.Client;
import com.exceedvote.DatebaseManager;
import com.exceedvote.Statement;
import com.exceedvote.StatementList;
/**
 * ClientTest tests for a Client Class
 * @author Tanachot Teachajarupan
 * @version 2012.10.23
 */

public class ClientTest {

	@Test
	public void testClient() {
		Client c = new Client();
		DatebaseManager dm = new DatebaseManager();
		StatementList list = new StatementList(dm);
		list.addStatement("The first question");
		Statement [] st = list.getAllStatement();
		
		assertTrue(c.getStatementDescription(st, 0).equals("The first question"));
	}

}
