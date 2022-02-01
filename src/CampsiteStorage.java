package src;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

// Make a json file to store alerts
public class CampsiteStorage {
	
	private ArrayList<Trip> campsiteID = new ArrayList<Trip>();

	public CampsiteStorage() {
		
	}
	
	public ArrayList<Trip> getCampsiteID() {
		return campsiteID;
	}

	public void setCampsiteID(ArrayList<Trip> campsiteID) {
		this.campsiteID = campsiteID;
	}
	
	/**
	 * Add a new trip to the list
	 * @param trip
	 */
	public void addTrip(Trip trip) {
		campsiteID.add(trip);
	}


	public void generateStorageFile() {
		try {
			File myObj = new File("database/filename.txt");
			if (myObj.createNewFile()) {

				generateLocalData();

				System.out.println("File created: " + myObj.getName());
			}

			// File already exists
			else {
				generateLocalData();

			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private void generateLocalData() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		try (Writer writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("database/filename.txt"), "utf-8"))) {
			// Write stuff
			
			Gson gson = new Gson();
			gson.toJson(campsiteID);
			
			writer.write(gson.toString());


		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}
	
}
