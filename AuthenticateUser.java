

import java.io.IOException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class AuthenticateUser {

	public static boolean authenticate_user(String myUser, String myPass, String myIp)
	{
		boolean auth = false;
		
		try
		{
			MongoClient mongoclient = new MongoClient();
			DB db = mongoclient.getDB("log_analyzer");
			
			//System.out.println("Successfull !");
			
			DBCollection coll = db.getCollection("users");
			
			/*DBCursor cursor = coll.find();
			
			while(cursor.hasNext())
			{
				System.out.println(cursor.next());
			}
			
			System.out.println(myUser);
			*/
			BasicDBObject query = new BasicDBObject("username",myUser).append("password", myPass).append("ip_address",myIp);
			
			DBCursor cursor = coll.find(query);
			
			//DBCollection coll2 = db.getCollection("log_data");
			
				if(!cursor.hasNext())
				{
					auth = false;
					/*String curTime = new Date().toString();
					BasicDBObject doc = new BasicDBObject("timestamp",curTime)
										.append("user",myUser)
										.append("ip",myIp)
										.append("action", "login unsuccessful");
					coll2.insert(doc);
					*/
					//InsertingLog.java_to_mongo(myUser,"login unsuccessful",myIp);
					TriggerData.triggering(myUser, myIp);
					InsertingLog.java_to_text(myUser, "login unsuccessful", myIp);
				}
				else
				{	
					auth = true;
					/*String curTime = new Date().toString();
					BasicDBObject doc = new BasicDBObject("timestamp",curTime)
										.append("user",myUser)
										.append("ip",myIp)
										.append("action", "login successful");
					coll2.insert(doc);
					*/
					InsertingLog.java_to_mongo(myUser,"login successful",myIp);
					InsertingLog.java_to_text(myUser, "login successful", myIp);
				}	//System.out.println(cursor.next());
		
			cursor.close();
		
		} catch(IOException e) {
			e.printStackTrace();
		}
			
	
		return auth;
		
	}
}
