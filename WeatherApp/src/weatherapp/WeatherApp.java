package weatherapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL; 
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
//import org.json.simpleJSONObject;
public class WeatherApp {
	public static void main(String[] args) {
     try {
         WeatherApp.call_me();
        } catch (Exception e) {
         e.printStackTrace();
       }
     }
	   
public static void call_me() throws Exception {
     String url = "https://openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
     URL obj = new URL(url);
     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
     // optional default is GET
     con.setRequestMethod("GET");
     //add request header
     con.setRequestProperty("User-Agent", "Mozilla/5.0");
     int responseCode = con.getResponseCode();
     System.out.println("\nSending 'GET' request to URL : " + url);
     System.out.println("Response Code : " + responseCode);
     BufferedReader in = new BufferedReader(
             new InputStreamReader(con.getInputStream()));
     String inputLine;
     StringBuffer response = new StringBuffer();
     while ((inputLine = in.readLine()) != null) {
     	response.append(inputLine);
     }
     in.close();
     //print in String
     System.out.println(response.toString());
     
     //Read JSON response and print 
     Object myResponse = new JSONParser().parse(response.toString());
     // typecasting obj to JSONObject 
     JSONObject jo = (JSONObject) myResponse; 
     
     Map coord = ((Map)jo.get("coord"));          
     // iterating coordinate Map 
     Iterator<Map.Entry> itr1 = coord.entrySet().iterator();
     while (itr1.hasNext()) { 
     Map.Entry pair = itr1.next(); 
     System.out.println(pair.getKey() + " : " + pair.getValue()); 
     }
     
     Map wind = ((Map)jo.get("wind"));          
     // iterating wind Map 
     Iterator<Map.Entry> itr3 = wind.entrySet().iterator();
     while (itr3.hasNext()) { 
     Map.Entry pair = itr3.next(); 
     System.out.println(pair.getKey() + " : " + pair.getValue()); 
     }
     
     Map clouds = ((Map)jo.get("clouds"));          
     // iterating coordinate Map 
     Iterator<Map.Entry> itr4 = clouds.entrySet().iterator();
     while (itr4.hasNext()) { 
     Map.Entry pair = itr4.next(); 
     System.out.println(pair.getKey() + " : " + pair.getValue()); 
     }
     
     Map sys = ((Map)jo.get("sys"));          
     // iterating coordinate Map 
     Iterator<Map.Entry> itr5 = sys.entrySet().iterator();
     while (itr5.hasNext()) {
     Map.Entry pair = itr5.next(); 
     System.out.println(pair.getKey() + " : " + pair.getValue()); 
     }
     
     // getting weather 
     JSONArray ja = (JSONArray) jo.get("weather");         
     // iterating weather array
     Iterator itr2 = ja.iterator();          
     while (itr2.hasNext())  
     { 
     itr1 = ((Map) itr2.next()).entrySet().iterator(); 
     while (itr1.hasNext()) { 
     Map.Entry pair = itr1.next(); 
     System.out.println(pair.getKey() + " : " + pair.getValue()); 
        } 
    }
     
     System.out.println((String) jo.get("base"));
     System.out.println((long) jo.get("visibility"));
     System.out.println((long) jo.get("dt"));
     System.out.println((long) jo.get("id"));
     System.out.println((String) jo.get("name"));
     System.out.println((long) jo.get("cod"));
  }
}
