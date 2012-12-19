package com.exceedvote.model;

import java.util.Date;

import com.exceedvote.DAO.ITimeDAO;
import com.exceedvote.entity.Time;
import com.exceedvote.factory.JpaFactory;

/**
 * Timer is a class for check time vote end and now.
 * @author Kunat Pipatanakul
 * @version 2012.12.19
 */
public class Timer {
	 private static Timer timer = new Timer();
	 /**
	  * Default time.
	  */
	 private int yr = 2012;
	 private int m = 12;
	 private int d = 21;
	 private int hr = 10;
	 private int min = 0;
	 private int tz = 7;
	 /**
	 * montharray.
	 */
	public final String [] montharray= {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	/**
	 * Constructor
	 */
	public Timer() {
		loadDate();
	}
	 /**
	  * loadDatefrom Properties.
	  */
	 public void loadDate(){
	 ITimeDAO dao = JpaFactory.getInstance().getTimeDAO();
	 Time time = dao.getTimer().get(0);
	 yr = time.getYear();
	 m = time.getMonth();
	 d = time.getDay();
	 hr = time.getHour();
	 min = time.getMin();
	 tz = time.getTimezone();
	 }
	 /**
	  * getDiffTime from now to end of the vote in second.
	  * @return Different value of time in second.
	  */
	@SuppressWarnings("deprecation")
	 public long getDiffTime(){
	        Date Dtoday = new Date();
	        long todayy = Dtoday.getYear();
	        if (todayy < 1000) { todayy+=1900; }
	        long todaym = Dtoday.getMonth();
	        long todayd = Dtoday.getDate();
	        long todayh = Dtoday.getHours();
	        long todaymin = Dtoday.getMinutes();
	        long todaysec = Dtoday.getSeconds();
	        String todayS = montharray[(int) todaym]+" "+todayd+", "+todayy+" "+todayh+":"+todaymin+":"+todaysec;
	        long today = Date.parse(todayS)+(tz*1000*60*60);
	        String futureS = (montharray[(int) (m-1)]+" "+d+", "+yr+" "+hr+":"+min);
	        long future = Date.parse(futureS)-(Dtoday.getTimezoneOffset()*(1000*60));
	        long diff = future - today;
	        if(diff <= 0){
	        	return 0;
	        }else
	        	return diff/1000;
	 }
	 /**
	  * getTimer object.
	  * @return Timer object
	  */
	 public static Timer getTimer(){
		 return timer;
	 }
	 /**
	 * resetTimer object.
	 */
	public static void resetTimer(){
		 timer = new Timer();
	 }
}
