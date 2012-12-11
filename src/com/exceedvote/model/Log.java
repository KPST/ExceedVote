package com.exceedvote.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;

public class Log {
	private static final Logger logger = Logger.getLogger( Log.class );
	private static Log log = new Log();
	public static int BALLOT_SAVE = 3;
	public static int BALLOT_DELETE = 4;
	public static int LOGIN_OK = 5;
	public static int LOGIN_FAIL = 6;
	public static int REGIS_OK = 7;
	public static int REGIS_FAIL = 8;
	private Log() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.format(cal.getTime());
	}
	
	public void voteLog(int user,int choice,int question,int flag){
		if(flag == BALLOT_SAVE){
			logger.info("user :"+user+" vote "+choice+" in question "+question);
		}
	}
	public void deleteVoteLog(int id,int flag){
		if(flag == BALLOT_DELETE){
			logger.info("Ballot id:"+id+" have delete.");
		}
	}
	public void loginLog(String user,String ip,int flag){
		if(flag == LOGIN_OK){
			logger.info("User :"+user+" login on ip:"+ip);
		}
		if(flag == LOGIN_FAIL){
			logger.info("ip :"+ip+" login fail.");
		}
	}
	public void regisLog(String user,String ip,int flag){
		if(flag == REGIS_OK){
			logger.info("User :"+user+" have register on ip:"+ip);
		}
		if(flag == REGIS_FAIL){
			logger.info("ip:"+ip+" can not register because username already in used ");
		}
	}
	public void adminLog(String user,String type,String ip,String info){
		logger.info("Admin :"+user+" have edit "+type+" by "+info+" on ip:"+ip);
	}
	public static Log getLog(){
		return log;
	}
}
