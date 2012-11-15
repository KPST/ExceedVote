package com.exceedvote.core;
import java.util.List;

import com.exceedvote.jpa.Auth;
import com.exceedvote.jpa.Ballot;
import com.exceedvote.jpa.Choice;
import com.exceedvote.jpa.Statement;
/**
 * ExceedDAO contain Data Access Object to Databases
 * @author Kunat Pipatanakul
 * @version 2012.11.14
 */
public interface ExceedDAO {
	/**
	 * getStatement from database
	 * @return Statement[]
	 */
	public Statement[] getStatement();
	/**
	 * getChoice from database
	 * @return Choice[]
	 */
	public Choice[] getChoice();
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
	/**
	 * findUser
	 * @param user username:String
	 * @param pass password:String
	 * @return Auth object
	 */
	public Auth findUser(String user,String pass);
	/**
	 * saveUser
	 * @param a Auth Object contain userinfo
	 */
	public void saveUser(Auth a);
	/**
	 * DeleteUser
	 * @param id id of user
	 */
	public void deleteUser(int id);
	/**
	 * saveStatement
	 * @param s Statement that want to save
	 */
	public void saveStatement(Statement s);
	/**
	 * DeleteStatement
	 * @param id id of statement
	 */
	public void deleteStatement(int id);
	/**
	 * saveChoice
	 * @param c choice object
	 */
	public void saveChoice(Choice c);
	/**
	 * DeleteChoice
	 * @param id id of choice
	 */
	public void deleteChoice(int id);
	/**
	 * getAllUser
	 * @return Auth[] object that contain all user in database.
	 */
	public Auth[] getAllUser();
}
