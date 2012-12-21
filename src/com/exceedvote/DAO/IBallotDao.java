package com.exceedvote.DAO;

import java.util.List;

import com.exceedvote.entity.Ballot;
import com.exceedvote.entity.Project;
import com.exceedvote.entity.Criteria;
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
	 * findBallots that belong to User user criteria question
	 * @param user user that vote on ballot.
	 * @param question criteria of the ballot. 
	 * @return List<Ballot> that are in specific case.
	 */
	public List<Ballot> findBallots(User user,Criteria question);
	/**
	 * findBallots that belong to Choice choice criteria question
	 * @param choice choice of that ballot.
	 * @param question criteria of that ballot.
	 * @return List<Ballot> that are in specific case.
	 */
	public List<Ballot> findBallots(Project choice,Criteria question);
	/**
	 * saveBallot
	 * @param b ballot
	 */
	public void saveBallot(Ballot b);
	/**
	 * findBallotsBycriteria
	 * @param question criteria the ballot belong to.
	 * @return List<Ballot> that are in specific case.
	 */
	public List<Ballot> findBallotsByCriteria(Criteria question);
	/**
	 * findAllBallot
	 * @return List<Ballot> all of ballot in database.
	 */
	public List<Ballot> findAllBallot();
}
