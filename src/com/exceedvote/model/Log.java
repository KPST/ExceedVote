package com.exceedvote.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
/**
 * Logging class into log4j file.
 * @author Kunat Pipatanakul
 *
 */
public class Log {
	private static final Logger logger = Logger.getLogger( Log.class );
	private static Log log = new Log();
	/**
	 * BALLOT_SAVE
	 */
	public static int BALLOT_SAVE = 3;
	/**
	 * BALLOT_DELETE
	 */
	public static int BALLOT_DELETE = 4;
	/**
	 * LOGIN_OK
	 */
	public static int LOGIN_OK = 5;
	/**
	 * LOGIN_FAIL
	 */
	public static int LOGIN_FAIL = 6;
	/**
	 * REGISTER_OK
	 */
	public static int REGIS_OK = 7;
	/**
	 * REGISTER_FAIL
	 */
	public static int REGIS_FAIL = 8;
	/**
	 * Constructor
	 */
	private Log() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.format(cal.getTime());
	}
	/**
	 * Log vote.
	 * @param user userid
	 * @param project projectid
	 * @param question questionid
	 * @param flag BALLOT_FLAG
	 */
	public void voteLog(int user,int project,int question,int flag){
		if(flag == BALLOT_SAVE){
			logger.info("user :"+user+" vote "+project+" in question "+question);
		}
	}
	/**
	 * Log for deleteVote.
	 * @param id ballotid
	 * @param flag BALLOT_DELETE
	 */
	public void deleteVoteLog(int id,int flag){
		if(flag == BALLOT_DELETE){
			logger.info("Ballot id:"+id+" have delete.");
		}
	}
	/**
	 * Login log.
	 * @param user username
	 * @param ip ip
	 * @param flag LOGIN_LOG
	 */
	public void loginLog(String user,String ip,int flag){
		if(flag == LOGIN_OK){
			logger.info("User :"+user+" login on ip:"+ip);
		}
		if(flag == LOGIN_FAIL){
			logger.info("ip :"+ip+" login fail.");
		}
	}
	/**
	 * Register log.
	 * @param user username 
	 * @param ip ip
	 * @param flag REGIS_FLAG
	 */
	public void regisLog(String user,String ip,int flag){
		if(flag == REGIS_OK){
			logger.info("User :"+user+" have register on ip:"+ip);
		}
		if(flag == REGIS_FAIL){
			logger.info("ip:"+ip+" can not register because username already in used ");
		}
	}
	/**
	 * Admin log.
	 * @param user username
	 * @param type type of action
	 * @param ip ip
	 * @param info extra information
	 */
	public void adminLog(String user,String type,String ip,String info){
		logger.info(user+" do "+type+" by "+info+" on ip:"+ip);
	}
	/**
	 * Singleton 
	 * @return Log object.
	 */
	public static Log getLog(){
		return log;
	}
}
