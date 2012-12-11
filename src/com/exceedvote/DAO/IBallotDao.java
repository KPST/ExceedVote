package com.exceedvote.DAO;

import java.util.List;

import com.exceedvote.entity.Ballot;
import com.exceedvote.entity.Choice;
import com.exceedvote.entity.Statement;
import com.exceedvote.entity.User;

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
	 * saveBallot to database
	 * @param b Ballot item
	 */
	public List<Ballot> findBallots(User user,Statement question);
	public List<Ballot> findBallots(Choice choice,Statement question);
	public void saveBallot(Ballot b);
	public List<Ballot> findBallotsByStatement(Statement question);
	public List<Ballot> findAllBallot();
}
