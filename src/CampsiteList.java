package src;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CampsiteList {
	private ArrayList<Campsite> possibleCampsites = new ArrayList<Campsite>();
	private int count = 0;

	/**
	 * Takes the api from 
	 * https://www.recreation.gov/api/camps/availability/campground/232447/month?start_date=2022-02-01T00%3A00%3A00.000Z
	 * @param jsonString
	 */
	public CampsiteList(String jsonString) {
		// TODO Auto-generated constructor stub
		JsonElement element = JsonParser.parseString(jsonString);
		JsonObject obj = element.getAsJsonObject(); // since you know it's a JsonObject
		Set<Map.Entry<String, JsonElement>> entries = obj.entrySet();// will return members of your object

		for (Map.Entry<String, JsonElement> entry : entries) {
			if(entry.getKey().equals("campsites")) {
				JsonElement element2 = entry.getValue();
				JsonObject obj2 = element2.getAsJsonObject(); // since you know it's a JsonObject
				Set<Map.Entry<String, JsonElement>> entries2 = obj2.entrySet();// will return members of your object
				for(Map.Entry<String, JsonElement> entry2 : entries2) {
					possibleCampsites.add(new Campsite(entry2.getValue()));
				}
			}
			else {
				count = Integer.parseInt(entry.getValue().toString());
			}
		}
	}
	
	@Override
	public String toString() {
		String text = "\nTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT\n";
		for(Campsite entry : possibleCampsites) {
			text += entry;
		}
		text += "TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT\n";
		return text;
	}

	public ArrayList<Campsite> getPossibleCampsites() {
		return possibleCampsites;
	}

	public void setPossibleCampsites(ArrayList<Campsite> possibleCampsites) {
		this.possibleCampsites = possibleCampsites;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
