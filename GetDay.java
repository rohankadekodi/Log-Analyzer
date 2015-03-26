

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class GetDay {
	
	public static String gettheday(String timestamp)
	{
		int num;
		String day = new String();
		Date date = null;
		
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			date = format.parse(timestamp);
		} catch(ParseException e) {
			e.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		cal.setTime(date);
		
		num = cal.get(Calendar.DAY_OF_WEEK);
		//System.out.println(num);
		
		if(num == Calendar.SATURDAY) 
			day = "Saturday";
		
		else if(num == Calendar.SUNDAY)
			day = "Sunday";
		
		else if(num == Calendar.MONDAY)
			day = "Monday";

		else if(num == Calendar.TUESDAY)
			day = "Tuesday";
		
		else if(num == Calendar.WEDNESDAY)
			day = "Wednesday";
		
		else if(num == Calendar.THURSDAY)
			day = "Thursday";
		
		else if(num == Calendar.FRIDAY)
			day = "Friday";
		
		//System.out.println(day);
	
		return day;
	}
	
	public static String getthemonth(String timestamp)
	{
		int num;
		String month = new String();
		Date date = null;
		
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			date = format.parse(timestamp);
		} catch(ParseException e) {
			e.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		cal.setTime(date);
		
		num = cal.get(Calendar.MONTH);
		//System.out.println(num);
		
		if(num == Calendar.JANUARY) 
			month = "January";
		
		else if(num == Calendar.FEBRUARY)
			month = "February";
		
		else if(num == Calendar.MARCH)
			month = "March";

		else if(num == Calendar.APRIL)
			month = "April";
		
		else if(num == Calendar.JUNE)
			month = "June";
		
		else if(num == Calendar.JULY)
			month = "July";
		
		else if(num == Calendar.AUGUST)
			month = "August";
				
		else if(num == Calendar.SEPTEMBER)
			month = "September";
		
		else if(num == Calendar.OCTOBER)
			month = "October";
		
		else if(num == Calendar.NOVEMBER)
			month = "November";
		
		else if(num == Calendar.DECEMBER)
			month = "December";

		//System.out.println(day);
	
		return month;
	}
	
	public static String getthetime(String timestamp)
	{
		String time = new String();
		long timeConvert = 0;
		
		String timeOfDay = timestamp.substring(8);
		
		timeConvert = Long.parseLong(timeOfDay);
		
		if(timeConvert >= 000001.0000 && timeConvert <= 120000.0000) {
			time = "Morning";
		}
		
		else if(timeConvert >= 120001.0000 && timeConvert <= 170000.0000) {
			time = "Afternoon";
		}
		
		else if(timeConvert >= 170001.0000 && timeConvert <= 200000.0000) {
			time = "Evening";
		}
		
		else if(timeConvert >= 200001.0000 && timeConvert <= 235959.0000) {
			time = "Night";
		}
		
		return time;
	}
	
}
