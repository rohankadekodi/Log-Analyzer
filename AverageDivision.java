import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class AverageDivision {
	public static int[] forDay(String startTimeStamp, String endTimeStamp) {
		
		int[] day = new int[7];
		for(int i=0;i<7;i++) {
			day[i] = 0;
		}
		long startDays, endDays,diffDays;
		
		String startYear = startTimeStamp.substring(0, 4);
		String endYear = endTimeStamp.substring(0, 4);
		String startMonth = startTimeStamp.substring(4, 6);
		String endMonth = endTimeStamp.substring(4, 6);
		String startDate = startTimeStamp.substring(6, 8);
		String endDate = endTimeStamp.substring(6, 8);
		
		long startY = Long.parseLong(startYear);
		long endY = Long.parseLong(endYear);
		long startM = Long.parseLong(startMonth);
		long endM = Long.parseLong(endMonth);
		long startD = Long.parseLong(startDate);
		long endD = Long.parseLong(endDate);
				
		startDays = (startY*365) + (startM*30) + startD;
		endDays = (endY*365) + (endM*30) + endD;
		
		diffDays = endDays - startDays;
		
		
		int num;
		Date date = null;
		
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			date = format.parse(startTimeStamp);
		} catch(ParseException e) {
			e.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		cal.setTime(date);
		
		num = cal.get(Calendar.DAY_OF_WEEK);
		//System.out.println(Calendar.DAY_OF_WEEK);
		day[num-1]++;
		
		int weeks = (int)diffDays / 7;
		for(int i=0;i<7;i++) {
			day[i] = day[i] + weeks;
		}
		
		int ctr = (int) startDays + weeks*7 + 1;
		for(int i = (num)%7; ctr <= endDays; ctr++) {
			day[i]++;
			i = (i + 1) % 7;
		}
		
		//System.out.println(day[6]);
		return day;
		
	}
}
