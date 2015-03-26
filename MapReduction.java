

import java.io.IOException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MapReduceCommand;
import com.mongodb.MapReduceOutput;
import com.mongodb.MongoClient;

public class MapReduction {

	public static String[] mapreductionday(String startDay, String endDay, String key, String value)
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
			//System.out.println("Rohan");
			database = "log_demo1";
			table = "log_demo";
		}
		String[] timeString = new String[4];
		long start = 0;
		long end = 0;
		
		
		if(startDay != null) {
			//System.out.println(startDay);
			start = Long.parseLong(startDay);
		}
		
		if(endDay != null) {
			//System.out.println(endDay);
			end = Long.parseLong(endDay);
		}
			
		long[] dayFreq = new long[7];
		String[] dayAvg = new String[7];
		try {
			MongoClient mongoclient = new MongoClient();
			DB db = mongoclient.getDB(database);
			DBCollection coll = db.getCollection(table);
			
			String map = "function() {"
					+ "var key = this.day;"
					+ "var value = 1;"
					//+ "qty : this.user };"
					+"emit(key,value);}";
			//String reduce = "function(key,values) {return Array.length }";
			String reduce = "function(keyDay,countObjVals) {"
					+ "var resultVal = 0;"
					+ "for(var idx = 0; idx < countObjVals.length; idx ++) {"
					+ "resultVal = resultVal + countObjVals[idx];"
					+ "}"
					+ "return resultVal; "
					+ "}";
			BasicDBObject query = new BasicDBObject();
			query.append(key,java.util.regex.Pattern.compile(value));
			if(startDay != null && endDay != null)
				query.append("timestamp", new BasicDBObject("$gte",start).append("$lte",end));
			
			
			MapReduceCommand cmd = new MapReduceCommand(coll, map, reduce, null, MapReduceCommand.OutputType.INLINE, query);
			
			MapReduceOutput out = coll.mapReduce(cmd);
			
			
			int i = 0;
			//System.out.println(out.getEmitCount());
			for(DBObject o : out.results()) {
				 String num = o.get("value").toString();
				 String numInString = "";
				 int j=0;
				 char[] numArr = num.toCharArray();
				 while(numArr[j] != '.') {
					 numInString = numInString + numArr[j];
					 j++;
				 }
				 
				 dayFreq[i++] = Long.parseLong(numInString);
				 //System.out.println(numInString);
				//System.out.println(o.get("user").toString());
				//System.out.println(Integer.parseInt(numInString));
				//System.out.println("Rohan");
				//System.out.println(o);
			}
			
			int[] dayDiv = AverageDivision.forDay(startDay,endDay);
			for(i=0;i<7;i++) {
				if(dayDiv[i] == 0)
					dayDiv[i] = 1;
			}
			
			//System.out.println((long) dayFreq[0] / dayDiv[5]);
			dayAvg[0] = Long.toString(dayFreq[0] / dayDiv[5]);
			dayAvg[1] = Long.toString(dayFreq[1] / dayDiv[1]);
			dayAvg[2] = Long.toString(dayFreq[2] / dayDiv[6]);
			dayAvg[3] = Long.toString(dayFreq[3] / dayDiv[0]);
			dayAvg[4] = Long.toString(dayFreq[4] / dayDiv[4]);
			dayAvg[5] = Long.toString(dayFreq[5] / dayDiv[2]);
			dayAvg[6] = Long.toString(dayFreq[6] / dayDiv[3]);
			
			/*for(i=0;i<7;i++) {
				System.out.println(dayDiv[i]);
			}*/
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return dayAvg;
	}
		
	
	
	public static String[] mapreductiontime(String startDay,String endDay,String key, String value)
	{
		String[] timeString = new String[4];
		long start = 0;
		long end = 0;
		
		//System.out.println(startDay);
		//System.out.println(endDay);
			if(startDay != null)
				start = Long.parseLong(startDay);
			
			if(endDay != null)
				end = Long.parseLong(endDay);
		try {
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
			
			MongoClient mongoclient = new MongoClient();
			DB db = mongoclient.getDB(database);
			DBCollection coll = db.getCollection(table);
				
			String map = "function() {"
					+ "var key = this.time;"
					+ "var value = 1;"
					//+ "qty : this.user };"
					+"emit(key,value);}";
			//String reduce = "function(key,values) {return Array.length }";
			String reduce = "function(keyDay,countObjVals) {"
					+ "var resultVal = 0;"
					+ "for(var idx = 0; idx < countObjVals.length; idx ++) {"
					+ "resultVal = resultVal + countObjVals[idx];"
					+ "}"
					+ "return resultVal; "
					+ "}";
				
			BasicDBObject query = new BasicDBObject();
			query.append(key,java.util.regex.Pattern.compile(value));
			if(startDay != null && endDay != null)
			query.append("timestamp", new BasicDBObject("$gte",start).append("$lte",end));
				
			MapReduceCommand cmd = new MapReduceCommand(coll, map, reduce, null, MapReduceCommand.OutputType.INLINE, query);
				
			MapReduceOutput out = coll.mapReduce(cmd);
			int i=0;
			//String[] timeString = new String[4];
			//System.out.println(out.getEmitCount());
			for(DBObject o : out.results()) {
				if(o.get("value").toString() != null)
					timeString[i++] = o.get("value").toString();
			//System.out.println(o.get("user").toString());
			//System.out.println(o.get("value").toString());
			//System.out.println(o.toString());
				//System.out.println("Rohan");
			}
			
			for(int cnt=0;cnt<4;cnt++) {
				if(timeString[cnt] == null)
					timeString[cnt] = "0.0";
			}
		
			//System.out.println(timeString[3]);
			} catch(IOException e) {
				e.printStackTrace();
			}
			//System.out.println(timeString[0]);
			return timeString;
	}
	
	
	
}
