package test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.exceedvote.Choice;
import com.exceedvote.ChoiceList;
import com.exceedvote.DatebaseManager;


public class ChoiceTest {

	@Test
	public void testChoice() {
		//Create state a Statement
		Choice c = new Choice();
		c.setDescription("Good man!");
		c.setName("Mr.Wang");
		c.setId(10);
		
		assertEquals(c.getDescription(),"Good man!");
		assertEquals(c.getName(),"Mr.Wang");
		assertEquals(c.getId(),10);
		
	}
	
	@Test
	public void testChoiceList(){
		//Create dm a DatabaseManager
		DatebaseManager dm = new DatebaseManager();
		
		ChoiceList list = new ChoiceList(dm);
		
		list.addChoice("Hello",1,"Mr.Wang");
		Choice [] choices = list.getAllChoices();
		
		
		assertTrue(choices[0].getDescription() == "Hello" && choices[0].getId() == 1 && choices[0].getName() == "Mr.Wang");
		
		list.addChoice("Goodbye",2,"Ms.Susan");
		
		choices = list.getAllChoices();
		
		
		
		assertFalse(choices[0].getDescription() == "Goodbye" && choices[0].getId() == 2 && choices[0].getName() == "Ms.Susan");
		assertTrue(choices[1].getDescription() == "Goodbye" && choices[1].getId() == 2 && choices[1].getName() == "Ms.Susan");
		
	}

}
