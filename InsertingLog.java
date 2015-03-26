

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class InsertingLog {
	
	public static void java_to_mongo(String myUser, String myAction, String myIp)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String curtime = formatter.format(new Date()).toString();
		String day = GetDay.gettheday(curtime);
		String month = GetDay.getthemonth(curtime);
		String time = GetDay.getthetime(curtime);
		long curTime = Long.parseLong(curtime);
		
		try
		{
			MongoClient mongoclient = new MongoClient();
			DB db = mongoclient.getDB("log_analyzer");
			
			DBCollection coll = db.getCollection("log_data");
			
			BasicDBObject doc = new BasicDBObject("timestamp",curTime)
								.append("user",myUser)
								.append("ip",myIp)
								.append("action",myAction)
								.append("day", day)
								.append("month", month)
								.append("time",time);
			coll.insert(doc);
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public static void java_to_text(String user, String action, String ip)
	{
		String log;
		String cur_time;
		Date date = new Date();
		cur_time = date.toString();
		
		log = cur_time + "," + user + "," + ip + "," + action;
		
		
		try
		{
			File file = new File("/home/rohan/workspace/java_to_text/logfile.txt");
			
			if(!file.exists())
			{
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
		
			bw.append(log);
			bw.newLine();
			bw.close();
		//System.out.println(a);
	
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
