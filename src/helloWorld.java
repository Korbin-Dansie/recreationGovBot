package src;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.Set;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Map;

import src.Campsite;

public class helloWorld {
	public static void main(String[] args) {
//      System.out.println("Hello, World!"); 
		String[] campSites = { "98", "102" };
		// New comment

		try {
			String campsiteList = new String(getOneCampsite(campSites));
			
			Gson campsiteOne = new Gson();
			System.out.println(campsiteOne.toJson(campsiteList));

			JsonElement element = JsonParser.parseString(campsiteList);
			JsonObject obj = element.getAsJsonObject(); // since you know it's a JsonObject
			Set<Map.Entry<String, JsonElement>> entries = obj.entrySet();// will return members of your object

			for (Map.Entry<String, JsonElement> entry : entries) {
				System.out.println("First Loop: ");
				System.out.println(entry.getKey() + " : ");
				System.out.println(entry.getValue());

				JsonElement member = entry.getValue();
				JsonObject memberAtributes = member.getAsJsonObject();
				Set<Map.Entry<String, JsonElement>> memberSet = memberAtributes.entrySet();// will return members of
																							// your object

				// Get first availabilities
				System.out.println("Second Loop: ");
				
				for (Map.Entry<String, JsonElement> member2 : memberSet) {
					// Get availabilities info
					// Loop through availabilities dates
					if (member2.getKey().equals("availabilities")) {
						JsonElement availabilities = member2.getValue();
						JsonObject availabilitiesAtributes = availabilities.getAsJsonObject();
						Set<Map.Entry<String, JsonElement>> availabilitiesSet = availabilitiesAtributes.entrySet();
						System.out.println("Third Loop: ");
						for (Map.Entry<String, JsonElement> dates : availabilitiesSet) {
							System.out.println("\t\t" + dates.getKey() + " : " + dates.getValue());
						} // End of third loop
					}
					System.out.println("\t" + member2.getKey() + " : " + member2.getValue() + " : "
							+ member2.getValue().getClass());
				} // End of second Loop
				System.out.println();
			} // END of first Loop
			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);

		}
		
		Campsite hello = new Campsite(5);
		System.out.println(hello);

		System.out.println("end");
	}

	// Try to print out all vales
	private class CampsiteList {
		Campsite[] campsites;
		int count;
	}

	public static void printSubString(String str, int number) {
		for (int i = 0; i < str.length();) {
			int end = Math.min(str.length(), i + number);
			System.out.println(str.substring(i, end));
			i = end;
		}

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
