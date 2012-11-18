package com.exceedvote.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.exceedvote.core.ExceedDAO;
import com.exceedvote.core.ExceedJpaFactory;
import com.exceedvote.core.JpaDAO;
/**
 * DAOTEST
 * @author Kunat Pipatanakul
 *
 */
public class UnitTest {
	
	@Test
	public void findUserTest() {
		ExceedDAO ed = ExceedJpaFactory.getInstance().getDAO();
		assertNotNull(ed);
		assertNotNull(ed.findUser("admin", "admin"));
		assertNull(ed.findUser("KK","GG"));
		
		assertSame(ed.getChoice(),ed.getChoice());
	}
	@SuppressWarnings("deprecation")
	@Test
	public void getChoiceTest(){
		ExceedDAO ed = ExceedJpaFactory.getInstance().getDAO();
		assertEquals(ed.getChoice(),ed.getChoice());
	}
	@Test
	public void getBallotTest(){
		ExceedDAO ed = ExceedJpaFactory.getInstance().getDAO();
		assertArrayEquals(ed.findBallots(1, 1,JpaDAO.FLAG_USER).toArray(), ed.findBallots(1,1,JpaDAO.FLAG_USER).toArray());
		assertNotSame(ed.findBallots(1,1,JpaDAO.FLAG_USER),ed.findBallots(1, 2,JpaDAO.FLAG_USER));
		assertSame(ed.findBallot(91),ed.findBallot(91));
		assertNull(ed.findBallot(-1));
	}
	@SuppressWarnings("deprecation")
	@Test
	public void getStatementTest(){
		ExceedDAO ed = ExceedJpaFactory.getInstance().getDAO();
		assertEquals(ed.getStatement(),ed.getStatement());
		assertEquals(ed.getStatement()[0], ed.getStatement()[0]);
		assertTrue(!ed.getStatement()[1].equals(ed.getStatement()[0]));
	}
}
