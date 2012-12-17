package com.exceedvote.model;

import java.util.Date;

public class Timer {
	 private static Timer timer = new Timer();
	 public static long yr = 2012;
	 public static long m = 12;
	 public static long d =  20;
	 public static long hr = 17;
	 public static long min = 4;
	 public static long tz = +7;
	 public static String [] montharray= {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	 public void loadDate(){
		 //TODO
	 }
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
	 public static Timer getTimer(){
		 return timer;
	 }
}
