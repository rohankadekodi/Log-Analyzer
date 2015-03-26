

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.*;
import javax.swing.*;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class TriggerData {
	
	public static void triggering(String myUser, String myIp) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String curtime = formatter.format(new Date()).toString();
		
		long end = Long.parseLong(curtime);
		long start = end - 500;
		
		try {
			//System.out.println("rohan");
			
			MongoClient mongoclient = new MongoClient();
			DB db = mongoclient.getDB("log_analyzer");
			
			DBCollection coll = db.getCollection("log_data");
			
			BasicDBObject query = new BasicDBObject();
			query.append("user", myUser);
			query.append("timestamp", new BasicDBObject("$gte",start).append("$lte", end));
			query.append("action", "login unsuccessful");
			
			DBCursor cursor = coll.find(query);
			
			//BasicDBObject cur = new BasicDBObject();
			/*while(cursor.hasNext())
			{
				//cur = cursor.next();
				System.out.println(cursor.next().toString());
			}*/
			int cntDoc = coll.find(query).count();
			//int cntDoc = cursor.size();
			//int i=5;
			//System.out.println(myUser);
			//System.out.println(start);
			//System.out.println(end);
			//System.out.println(cntDoc);
			
			if(cntDoc >= 4) {
				//System.out.println("rohan1");
				JOptionPane.showMessageDialog(null,"LOG IN NOT ALLOWED");
				InsertingLog.java_to_mongo(myUser, "login unsuccessful", myIp);
			}
			
			else {
				
				InsertingLog.java_to_mongo(myUser, "login unsuccessful", myIp);
			}
			
		} catch(IOException e) {
			
			e.printStackTrace();
		}
		
	}
		

}
