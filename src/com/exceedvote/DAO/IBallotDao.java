package com.exceedvote.DAO;

import java.util.List;

import com.exceedvote.entity.Ballot;
import com.exceedvote.entity.Choice;
import com.exceedvote.entity.Statement;
import com.exceedvote.entity.User;

/**
 * IBallotDAO is a Interface the contain all method Ballot DAO have to implements.
 * @author Kunat Pipatanakul
 * @version 2012.12.10
 */
public interface IBallotDao {
	/**
	 * findBallot from id
	 * @param id 
	 * @return Ballot
	 */
	public Ballot findBallot(int id);
	/**
	 * deleteBallot
	 * @param id id of Ballot
	 */
	public void deleteBallot(int id);
	/**
	 * findBallots that belong to User user Statement question
	 * @param user user that vote on ballot.
	 * @param question Statement of the ballot. 
	 * @return List<Ballot> that are in specific case.
	 */
	public List<Ballot> findBallots(User user,Statement question);
	/**
	 * findBallots that belong to Choice choice Statement question
	 * @param choice choice of that ballot.
	 * @param question Statement of that ballot.
	 * @return List<Ballot> that are in specific case.
	 */
	public List<Ballot> findBallots(Choice choice,Statement question);
	/**
	 * saveBallot
	 * @param b ballot
	 */
	public void saveBallot(Ballot b);
	/**
	 * findBallotsByStatement
	 * @param question Statement the ballot belong to.
	 * @return List<Ballot> that are in specific case.
	 */
	public List<Ballot> findBallotsByStatement(Statement question);
	/**
	 * findAllBallot
	 * @return List<Ballot> all of ballot in database.
	 */
	public List<Ballot> findAllBallot();
}
