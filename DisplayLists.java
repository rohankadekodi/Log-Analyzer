

import java.io.IOException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class DisplayLists {
	public static String[] ip_droplist()
	{
		String[] ip = new String[15];
		try
		{
			MongoClient mongoclient = new MongoClient();
			DB db = mongoclient.getDB("log_analyzer");
			
			DBCollection coll = db.getCollection("users");
			
		//	BasicDBObject query = new BasicDBObject();
			DBCursor cursor = coll.find();
			
			int i=0;
			while(cursor.hasNext())
			{
				DBObject theObj = cursor.next();
				
				/*BasicDBList userList = (BasicDBList) theObj.get("username");
				
				for(int i = 0; i<userList.size();i++)
				{
					BasicDBObject userName = (BasicDBObject) userList.get(i);
					user[i] = userName.getString("username");
				}*/
				
				BasicDBObject ipNum = (BasicDBObject) theObj;
				ip[i] = ipNum.getString("ip_address");
				i++;
			}
			
			/*for(int j=0;j<i;j++)
				System.out.println(user[j]);*/
			
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		
		return ip;
	}
	
	public static String[] user_droplist()
	{
		String[] user = new String[15];
		try
		{
			MongoClient mongoclient = new MongoClient();
			DB db = mongoclient.getDB("log_analyzer");
			
			DBCollection coll = db.getCollection("users");
			
		//	BasicDBObject query = new BasicDBObject();
			DBCursor cursor = coll.find();
			
			int i=0;
			while(cursor.hasNext())
			{
				DBObject theObj = cursor.next();
				
				/*BasicDBList userList = (BasicDBList) theObj.get("username");
				
				for(int i = 0; i<userList.size();i++)
				{
					BasicDBObject userName = (BasicDBObject) userList.get(i);
					user[i] = userName.getString("username");
				}*/
				
				BasicDBObject userName = (BasicDBObject) theObj;
				user[i] = userName.getString("username");
				i++;
			}
			
			/*for(int j=0;j<i;j++)
				System.out.println(user[j]);*/
			
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		
		return user;
		
		
	}
}
