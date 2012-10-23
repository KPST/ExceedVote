package test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.exceedvote.DatebaseManager;
import com.mysql.jdbc.AssertionFailedException;


public class DatebaseManagerTest {

	@Test (expected=NullPointerException.class)
	public void test() {
		DatebaseManager dm = new DatebaseManager();
		ArrayList<Object[]> list = new ArrayList<Object[]>();
		list = dm.getListFromDatabase(1);
		//System.out.println(list.get(0));
		
	}

}
