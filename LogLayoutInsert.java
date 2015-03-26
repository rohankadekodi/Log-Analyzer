import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;


public class LogLayoutInsert {

	static void insertion(String layout, String log) {
		try {
			
			MongoClient mongoclient = new MongoClient();
			DB db = mongoclient.getDB("log_demo1");
			DBCollection coll = db.getCollection("log_demo");
			coll.remove(new BasicDBObject());
			
			String[] key = new String[10];
			String[] values = new String[10];
			
			BufferedReader brLayout = new BufferedReader(new FileReader(layout));
			//StringBuilder sb = new StringBuilder();
			String layoutLine = brLayout.readLine();
			
			String pattern = "\\[(.*?)\\]";
			Pattern pLayout = Pattern.compile(pattern);
			Matcher m = pLayout.matcher(layoutLine);
			
			int i=0,k=0;
			while(m.find()) {
				//k++;
				
				key[i] = m.group(1);
				i++;
				//System.out.println(m.group(1));
				//System.out.println("Rohan1");
			}
			
			int removeThis = 0;
			for(int counter = 0;counter <i;counter++) {
				//System.out.println(key[i]);
				//System.out.println(key[counter]);
				if(key[counter].equalsIgnoreCase("timestamp")) {
					//System.out.println("Rohan");
					removeThis = counter;
				}
			}
			
			int counter = 0;
			while(counter < removeThis) {
				dataWrapping.keys[counter] = key[counter];
				counter ++;
			}
			
			while(counter < i-1) {
				dataWrapping.keys[counter] = key[counter + 1];
				counter ++;
			}
			
			dataWrapping.numOfKeys = i-1;
			//System.out.println("Rohan1");
			
			//System.out.println(keys[0]);
			/*BufferedReader brLog = new BufferedReader(new FileReader(log));
			String logLine = new String();
			
			while((logLine = brLog.readLine()) != null) {
				Pattern pLog = Pattern.compile(pattern);
				Matcher m2 = pLog.matcher(logLine);
				
				i=0;
				k=0;
				while(m2.find()) {
					//k++;
					values[i] = m2.group(1);
					i++;
					//System.out.println(m2.group(1));
					//System.out.println("Rohan");
				}
				
				//System.out.println(values[0]);
				BasicDBObject doc = new BasicDBObject();
				for(int cnt=0;cnt < i;cnt++)
					doc.append(keys[cnt], values[cnt]);
				
				coll.insert(doc);
			}*/
			
//-----------------------------------------------------------------------------------------			
		//FileReader separator = new FileReader(new File(layout));
			Scanner separator = new Scanner(new File(layout));
			String theString = "";
			theString = separator.nextLine();
			char[] chars = theString.toCharArray();
			//separator.read(chars);
			int length = chars.length;
		//	System.out.println(length);
			
			int cnt = 0;
			int sep = 0;
			while(cnt < length) {
				//System.out.println(cnt);
				if(chars[cnt] == ']' && (cnt+1) != length) {
					dataWrapping.separators[sep++] = chars[cnt+1];
				}
				cnt++;
			}
			//System.out.println(dataWrapping.separators[0]);
			BufferedReader brLog = new BufferedReader(new FileReader(log));
			String logLine = new String();
			
			while((logLine = brLog.readLine()) != null) {
				//Pattern pLog = Pattern.compile(pattern);
				//Matcher m2 = pLog.matcher(logLine);
				//separateValue = logLine.toCharArray();
				char[] separateValue = logLine.toCharArray();
				length = separateValue.length;
				//System.out.println(separateValue[10]);
				
				//System.out.println(length);
				
				i=0;
				k=0;
				int locator1=0,locator2=0;
				sep = 0;
				//System.out.println("Tohan");
				//System.out.println(dataWrapping.separators[0]);
				//System.out.println(separateValue[5]);
	
				while(k < length) {
					//k++;
					//System.out.println("rohan");
					if(k == 0)
						locator1 = 0;
					
					if(k+1 == length) {
						locator2 = k;
						values[i++] = logLine.substring(locator1, locator2+1);
					}
					
					if(separateValue[k] == dataWrapping.separators[sep]) {
						sep++;
						locator2 = k-1;
						values[i++] = logLine.substring(locator1, locator2+1);
						//System.out.println(logLine.substring(locator1, locator2+1));
						locator1 = k+1;
						//System.out.println("rohank");
					}
					//values[i] = ;
					//i++;
					//System.out.println(m2.group(1));
				//	System.out.println(k);
					k++;
				}
				
				//System.out.println(values[0]);
				//System.out.println(values[0]);
//-------------------------------------------------------------------------------------------
				
				key[i] = "day";
				values[i] = GetDay.gettheday(values[removeThis]);
				
				i++;
				key[i] = "time";
				values[i] = GetDay.getthetime(values[removeThis]);
				
				//System.out.println(values[removeThis]);
//------------------------------------------------------------------------------------------				
				Long valueTimeStamp;
				BasicDBObject doc = new BasicDBObject();
				for(cnt=0;cnt <= i;cnt++) {
					if(cnt != removeThis)
						doc.append(key[cnt], values[cnt]);
					if(cnt == removeThis) {
						valueTimeStamp = Long.parseLong(values[removeThis]);
						doc.append(key[removeThis], valueTimeStamp);
					}
				}
				
				coll.insert(doc);
			}
			//System.out.println(keys[0]);
			//System.out.println(values[1]);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
