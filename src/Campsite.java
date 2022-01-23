package src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Campsite {
	Map<Date, String> availabilities = new HashMap<>();
	int campsite_id;
	String campsite_reserve_type;
	String campsite_type;
	String capacity_rating;
	String loop;
	int max_num_people;
	int min_num_people;
	JsonElement quantities;
	String site;
	String type_of_use; 
	
	public Campsite() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Convert a string in json format to a class
	 * @param jsonString
	 */
	public Campsite(String jsonString) {
		// TODO Auto-generated constructor stub
		JsonElement element = JsonParser.parseString(jsonString);
		JsonObject obj = element.getAsJsonObject(); // since you know it's a JsonObject
		Set<Map.Entry<String, JsonElement>> entries = obj.entrySet();// will return members of your object

		for (Map.Entry<String, JsonElement> entry : entries) {

			JsonElement element2 = entry.getValue();
			constructorFromJsonElement(element2);
		} // END of first Loop
	}
	
	public Campsite(JsonElement jsonString) {
		constructorFromJsonElement(jsonString);
	}
	
	private void constructorFromJsonElement(JsonElement Jelement){
		JsonObject obj2 = Jelement.getAsJsonObject();
		Set<Map.Entry<String, JsonElement>> entries2 = obj2.entrySet();// will return members of
		// Get first availabilities			
		for (Map.Entry<String, JsonElement> value : entries2) {
			// Loop through availabilities dates				
			switch(value.getKey()) {
			case "availabilities":
				JsonElement availabilitiesJson = value.getValue();
				JsonObject availabilitiesAtributes = availabilitiesJson.getAsJsonObject();
				Set<Map.Entry<String, JsonElement>> availabilitiesSet = availabilitiesAtributes.entrySet();
				for (Map.Entry<String, JsonElement> dates : availabilitiesSet) {
					
					String str = dates.getKey();
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
					Date date;
					try {
						date = formatter.parse(str);
						availabilities.put(date, dates.getValue().getAsString());

					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} // End of availabilities dates					

				break;
			case "campsite_id":
				campsite_id = Integer.parseInt(value.getValue().getAsString());
				break;
			case "campsite_reserve_type":
				campsite_reserve_type = value.getValue().getAsString();
				break;
			case "campsite_type":
				campsite_type = value.getValue().getAsString();
				break;
			case "capacity_rating":
				capacity_rating = value.getValue().getAsString();
				break;
			case "loop":
				loop = value.getValue().getAsString();
				break;
			case "max_num_people":
				max_num_people = Integer.parseInt(value.getValue().getAsString());
				break;
			case "min_num_people":
				min_num_people = Integer.parseInt(value.getValue().getAsString());
				break;
			case "quantities":
				// TODO: figure out what quantities is
					quantities = value.getValue();
				break;
			case "site":
				site = value.getValue().getAsString();
				break;
			case "type_of_use":
				type_of_use = value.getValue().getAsString();
				break;
			}
		} // End of second Loop
	}
	
    public String toString() {
    	
    	String text = "----------------------------------------------------------------\n";
    	text += "availabilities : " + availabilities + "\n";
    	text +=  "campsite_id : " + campsite_id + "\n";
    	text +=  "campsite_reserve_type : " + campsite_reserve_type + "\n";
    	text +=  "campsite_type : " + campsite_type + "\n";
    	text +=  "capacity_rating : " + capacity_rating + "\n";
    	text +=  "loop : " + loop + "\n";
    	text += "max_num_people : " + max_num_people + "\n";
    	text +=  "min_num_people : " + min_num_people + "\n";
    	text +=  "quantities : " + quantities + "\n";
    	text +=  "site : " + site + "\n";
    	text +=  "type_of_use : " + type_of_use  + "\n";
    	text += "----------------------------------------------------------------\n";

        return text;
    }

	public Map<Date, String> getAvailabilities() {
		return availabilities;
	}

	public void setAvailabilities(Map<Date, String> availabilities) {
		this.availabilities = availabilities;
	}

	public int getCampsite_id() {
		return campsite_id;
	}

	public void setCampsite_id(int campsite_id) {
		this.campsite_id = campsite_id;
	}

	public String getCampsite_reserve_type() {
		return campsite_reserve_type;
	}

	public void setCampsite_reserve_type(String campsite_reserve_type) {
		this.campsite_reserve_type = campsite_reserve_type;
	}

	public String getCampsite_type() {
		return campsite_type;
	}

	public void setCampsite_type(String campsite_type) {
		this.campsite_type = campsite_type;
	}

	public String getCapacity_rating() {
		return capacity_rating;
	}

	public void setCapacity_rating(String capacity_rating) {
		this.capacity_rating = capacity_rating;
	}

	public String getLoop() {
		return loop;
	}

	public void setLoop(String loop) {
		this.loop = loop;
	}

	public int getMax_num_people() {
		return max_num_people;
	}

	public void setMax_num_people(int max_num_people) {
		this.max_num_people = max_num_people;
	}

	public int getMin_num_people() {
		return min_num_people;
	}

	public void setMin_num_people(int min_num_people) {
		this.min_num_people = min_num_people;
	}

	public JsonElement getQuantities() {
		return quantities;
	}

	public void setQuantities(JsonElement quantities) {
		this.quantities = quantities;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getType_of_use() {
		return type_of_use;
	}

	public void setType_of_use(String type_of_use) {
		this.type_of_use = type_of_use;
	}
}
