package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
		int year = 2022;
		// January is defined as month 0, not month 1
		int month = 3 - 1;
		int day = 1; // Start day need to be 1.
		
	    
		try {
//			String oneCampsite = new String(getOneCampsite(campSites));
//			System.out.println(oneCampsite.toString());
//			Campsite trueCampsite = new Campsite(oneCampsite);
//			
//			System.out.println(trueCampsite);
			
			// ALL campsites
//			String stringOfCampsites = new String(getAllCampsite(campSites, year, month, day));	
			
			// Debug test.
//			String stringOfCampsites = new String(readFromCamplistJsonFile());	
//
//			CampsiteList campsiteList = new CampsiteList(stringOfCampsites);
////			System.out.print(campsiteList.toString());
//			
//			// campsite_id : 149 is avaiable  
//			for(Campsite camp : campsiteList.getPossibleCampsites()) {
//				if(camp.getCampsite_id() == 149) {
//					System.out.print(camp);
//					// Loop through dates
//					for(Map.Entry<LocalDate, String> date : camp.getAvailabilities().entrySet()) {
//						System.out.println("\nKey :" + date.getKey());
//						System.out.println("\nValue : " + date.getValue() );
//						if(date.getValue().equals("Available")) {
//							System.out.println("FOUND");
//						}
//					}
//
//				}
//			}
			
			// Temparary Start and end dates
			LocalDate startDate = LocalDate.of(2022, 2, 1);
			LocalDate endDate = LocalDate.of(2022, 2, 28);
			int facilityID = 232447;
			ArrayList<String> campsiteList2 = new ArrayList<String>();
			
			CampsiteStorage dbStorage = new CampsiteStorage(startDate, endDate,facilityID, campsiteList2);
			dbStorage.generateStorageFile();
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);

		}
		
		System.out.println("\nend");
	}
	
	public static String readFromCamplistJsonFile() {
		String returnString = new String();

	    try {
	        File myObj = new File("campsiteList-02.json");
	        Scanner myReader = new Scanner(myObj);
	        while (myReader.hasNextLine()) {
	          String data = myReader.nextLine();
	          returnString += data;
	        }
	        myReader.close();
	      } catch (FileNotFoundException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
		return returnString;
	}
	
	public static String converttoDateFormat(int year, int month, int day) {
	    Calendar cal = Calendar.getInstance();
	    cal.clear();

	    cal.set(Calendar.YEAR, year);
	    cal.set(Calendar.MONTH, month);
	    cal.set(Calendar.DATE, day);
	    
	    Date utilDate = cal.getTime();
	    // start_date=2022-02-01T00%3A00%3A00.000Z

	    String pattern = "yyyy-MM-dd_HH_mm_ss.mmm_";
	    SimpleDateFormat formateDate = new SimpleDateFormat(pattern);
		String strDate = formateDate.format(utilDate);
		String[] arrayString = strDate.split("_");
		
		// Insert specific element into the date 
		String[] additionalElement = {"T", "%3A", "%3A", "Z"};
		for(int i = 0; i < additionalElement.length; i++) {
			arrayString[i] = arrayString[i].concat(additionalElement[i]);
		}
		
		// Combing the new element into the str
		strDate = "";
		for(int i = 0; i < arrayString.length; i++) {
			strDate = strDate.concat(arrayString[i]);
		}
		
		return strDate;
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
	/**
	 * 
	 * @param args
	 * @param year which year are you looking at
	 * @param month which month are you looking at
	 * @param day which day should be 1.
	 * @return a very big string in json format of all the campsites
	 * @throws Exception
	 */
	public static String getAllCampsite(String[] args, int year, int month, int day) throws Exception {
		
		String startDate = converttoDateFormat(year, month, day);
		// Initialize a new array of empty strings
		String returnString = new String();
		String text = "https://www.recreation.gov/api/camps/availability/campground/232447/month?start_date=" + startDate;
		
		System.out.print(text);
		
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
