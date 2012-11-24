package com.exceedvote.DAO;

import java.util.List;

import com.exceedvote.jpa.Ballot;

public interface IBallotDao {

	public int FLAG_USER = 1;
	public int FLAG_CHOICE = 2;
	/**
	 * findBallot from id
	 * @param id 
	 * @return Ballot
	 */
	public Ballot findBallot(int id);
	/**
	 * findBallots from userid,questionid or choiceid,questionid 
	 * @param id if FLAG = USER id is a userid else id is choiceid
	 * @param question questionid
	 * @param flag int FLAG
	 * @return List of Ballot
	 */
	public List<Ballot> findBallots(int id,int question,int flag);
	/**
	 * deleteBallot
	 * @param id id of Ballot
	 */
	public void deleteBallot(int id);
	/**
	 * saveBallot to database
	 * @param b Ballot item
	 */
	public void saveBallot(Ballot b);
}
