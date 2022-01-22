package src;

import java.util.Map;
import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Campsite {
	Map.Entry<String, String> availabilities;
	int campsite_id;
	String campsite_reserve_type;
	String campsite_type;
	String capacity_rating;
	String loop;
	int max_num_people;
	int min_num_people;
	String quantities;
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

	}
	
    public String toString() {
        return "Key: " + getMax_num_people();
    }

	public Map.Entry<String, String> getAvailabilities() {
		return availabilities;
	}

	public void setAvailabilities(Map.Entry<String, String> availabilities) {
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

	public String getQuantities() {
		return quantities;
	}

	public void setQuantities(String quantities) {
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
