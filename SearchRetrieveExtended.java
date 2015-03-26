
import java.io.IOException;
import java.util.ArrayList;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class SearchRetrieveExtended {

	public static String[][] retrieval(String select1, String value1, String select2, String value2, String operator, String timeFrom, String timeTo)
	{	
		
		
		String database = new String();
		String table = new String();
		
		if(dataWrapping.importing == 0)
		{
			database = "log_analyzer";
			table = "log_data";
		}
		
		if(dataWrapping.importing == 1)
		{
			database = "log_demo1";
			table = "log_demo";
		}
		
		String[][] cursorArray = new String[500][dataWrapping.numOfKeys+3];
		
		try {
		//ArrayList<String> cursorArray = new ArrayList<>();
		
		int i, flag;// flag[] = new int[3];
		flag=0;
		
	/*	for(i=0;i<3;i++)
			flag[i] = 1;
	*/	
		long start = 0;
		long end = 0;
		
		
			if(timeFrom != null)
				start = Long.parseLong(timeFrom);
			
			if(timeTo != null)
				end = Long.parseLong(timeTo);
			
			
				MongoClient mongoclient = new MongoClient();
				DB db = mongoclient.getDB(database);
				DBCollection coll = db.getCollection(table);
			
			
			//BasicDBObject query = new BasicDBObject("user",myUser).append("timestamp", new BasicDBObject("$gte",start).append("$lte",end)).append("action", myAction);
			BasicDBObject query = new BasicDBObject();
			
			if(operator == "AND" || operator == null) {
				if(!value1.equalsIgnoreCase("ALL"))
				{
					query.append(select1, java.util.regex.Pattern.compile(value1));
					flag = 1;
				}
			
				if(!value2.equalsIgnoreCase("ALL")) 
				{
					query.append(select2, java.util.regex.Pattern.compile(value2));
					flag = 1;
				}
					
			}
			
			if(operator == "OR") {
				if(!(value1.equalsIgnoreCase("ALL")) && !(value2.equalsIgnoreCase("ALL")))
				{
					DBObject clause1 = new BasicDBObject(select1,java.util.regex.Pattern.compile(value1));
					DBObject clause2 = new BasicDBObject(select2, java.util.regex.Pattern.compile(value2));
					
					BasicDBList or = new BasicDBList();
					
					or.add(clause1);
					or.add(clause2);
					
					query.append("$or", or);
					flag = 1;
				}
				
				if(!(value1.equalsIgnoreCase("ALL")) && value2.equalsIgnoreCase("ALL"))
				{
					query.append(select1, java.util.regex.Pattern.compile(value1));
					flag = 1;
				}
				
				if(value1.equalsIgnoreCase("ALL") && (!value2.equalsIgnoreCase("ALL"))) 
				{
					query.append(select2, java.util.regex.Pattern.compile(value2));
					flag = 1;
				}
			}
			
			if(timeFrom != null && timeTo == null)
			{
				query.append("timestamp", new BasicDBObject("$gte",start));
				flag = 1;
			}
				
			if((timeTo != null) && (timeFrom == null))
			{
				query.append("timestamp", new BasicDBObject("$lte",end));
				flag = 1;
			}
			
			if((timeTo != null) && (timeFrom != null))
			{
				query.append("timestamp", new BasicDBObject("$gte",start).append("$lte",end));
				flag = 1;
			}
			
			
			//System.out.println(query.toString());
			
			
			DBCursor cursor; 
			if (flag == 0)
			{
				//System.out.println("Rohan");
				cursor = coll.find();
			}
			
			else
			{
				//System.out.println("Rohan");
				cursor = coll.find(query);
			}
				
			i = 0;
			//String cursorArray[] = new String[50];
			String ts = new String();
			//String tsString = new String();
			//String tsString2 = new String();
			//String tsString3 = new String();
			//cursorArray = new String[cursor.count()][dataWrapping.numOfKeys+3];
			
			try {
				
				while(cursor.hasNext()) {
					
					cursor.next();
					//System.out.println("inside cursor");
					//System.out.println(cursor.next());
					
					ts = "";
					//tsString = "";
					//tsString2 = "";
					//tsString3="";
					//tsString2ing String cursorArray[] = new String[50];
					//System.out.println(cursor.next());
					
					ts = cursor.curr().get("timestamp").toString();
					
					cursorArray[i][0] = ts.substring(0, 4).concat("-").concat(ts.substring(4,6)).concat("-").concat(ts.substring(6, 8));
					cursorArray[i][1] = GetDay.gettheday(ts);
					cursorArray[i][2] = ts.substring(8, 10).concat(":").concat(ts.substring(10, 12)).concat(":").concat(ts.substring(12));
					for(int cnt = 0;cnt < dataWrapping.numOfKeys; cnt++)
						cursorArray[i][cnt+3] = cursor.curr().get(dataWrapping.keys[cnt]).toString();
					//cursorArray[i][4] = cursor.curr().get(select2).toString();
					//System.out.println(ts);
					//tsString = ts.substring(0, 4).concat("-").concat(ts.substring(4, 6)).concat("-").concat(ts.substring(6, 8)).concat(" ");
					//System.out.println(tsString);
					
					//tsString2=ts.substring(8);
					//tsString3=tsString.concat(tsString2.substring(0, 2)).concat(":").concat(tsString2.substring(2,4)).concat(":").concat(tsString2.substring(4, 6));
					//System.out.println(tsString2);
					
					
					//cursorArray.add("timestamp = ".concat(tsString).concat(tsString2).concat(" , ").concat("user = ").concat(cursor.curr().get("user").toString()).concat(" , ").concat("action = ").concat(cursor.curr().get("action").toString()));
					//System.out.println(cursorArray[i]);
					
					i++;
					//System.out.println(i);
					
				}
				
				/*
				for(int j=0;j<i;j++)
					System.out.println(cursorArray[j]);
				*/
			dataWrapping.numOfSearchRows = i;
				
			} finally {
				cursor.close();
			}
			
			//return cursorArray;
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return cursorArray;
		
	}

	
}


