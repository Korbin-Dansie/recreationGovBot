package src;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Set;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import src.Campsite;

public class helloWorld {
	public static void main(String[] args) {
		String[] campSites = { "98", "102" };	
		
		// The web site takes int year, int month, int date, int hrs, int min, int sec
	    int year = 2009;
	    int month = 0; // January
	    int date = 1;

	    Calendar cal = Calendar.getInstance();
	    cal.clear();

	    cal.set(Calendar.YEAR, year);
	    cal.set(Calendar.MONTH, month);
	    cal.set(Calendar.DATE, date);
	    
	    Date utilDate = cal.getTime();
	    // start_date=2022-02-01T00%3A00%3A00.000Z
	    
	    String pattern = "yyyy-MM-dd_HH_mm_ss.mmm_";
	    SimpleDateFormat formateDate = new SimpleDateFormat(pattern);
		String strDate = formateDate.format(utilDate);
		String[] arrayString = strDate.split("_");
		
		// Insert specific element into the date 
		String[] additionalElement = {"T", "%3", "%3", "Z"};
		for(int i = 0; i < additionalElement.length; i++) {
			arrayString[i] = arrayString[i].concat(additionalElement[i]);
		}
		
		// Combing the new element into the str
		strDate = "";
		for(int i = 0; i < arrayString.length; i++) {
			strDate = strDate.concat(arrayString[i]);
		}
		
		System.out.println(strDate);


		
		// [T, %3A, %3A, Z]
		
		
//		try {
//			String oneCampsite = new String(getOneCampsite(campSites));
//			System.out.println(oneCampsite.toString());
//			Campsite trueCampsite = new Campsite(oneCampsite);
//			
//			System.out.println(trueCampsite);
//			
//			// ALL campsites
//			String stringOfCampsites = new String(getAllCampsite(campSites));	
//			CampsiteList campsiteList = new CampsiteList(stringOfCampsites);
//			System.out.print(campsiteList.toString());
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println(e);
//
//		}
		
		System.out.println("\nend");
	}

	public static void printSubString(String str, int number) {
		for (int i = 0; i < str.length();) {
			int end = Math.min(str.length(), i + number);
			System.out.println(str.substring(i, end));
			i = end;
		}

	}
	
	public static void printingAllCampsites() throws Exception {
		String[] campSites = { "98", "102" };
		
	}

//    Link to all campsites
//    https://www.recreation.gov/api/camps/availability/campground/232447/month?start_date=2022-02-01T00%3A00%3A00.000Z
	public static String getAllCampsite(String[] args) throws Exception {
		// Initialize a new array of empty strings
		String returnString = new String();
		String text = "https://www.recreation.gov/api/camps/availability/campground/232447/month?start_date=2022-02-01T00%3A00%3A00.000Z";
		URL website = new URL(text);
		URLConnection connection = website.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			returnString += inputLine;
			in.readLine();
		}
		in.close();
		return returnString;
	}

//	  Link to one campsite
//  https://www.recreation.gov/api/camps/availability/campsite/276/all
	public static String getOneCampsite(String[] args) throws Exception {
		// Initialize a new array of empty strings
		String returnString = new String();
		String text = "https://www.recreation.gov/api/camps/availability/campsite/276/all";
		URL website = new URL(text);
		URLConnection connection = website.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			returnString += inputLine;
			in.readLine();
		}
		in.close();
		return returnString;
	}

}
