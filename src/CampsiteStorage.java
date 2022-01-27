package src;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Make a json file to store alerts
public class CampsiteStorage {
	
	private LocalDate startDate;
	private LocalDate endDate;
	private int facilityID;
	private ArrayList<String> campsiteID;

	public CampsiteStorage(LocalDate startDate, LocalDate endDate, int facilityID, ArrayList<String> campsiteID ) {
		// TODO Auto-generated constructor stub
		this.startDate = startDate;
		this.endDate = endDate;

		this.facilityID = facilityID;
		
		this.campsiteID = campsiteID;	
	}
	
	public void generateStorageFile() {
	    try {
	        File myObj = new File("database/filename.txt");
	        if (myObj.createNewFile()) {

	        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
	                    new FileOutputStream("database/filename.txt"), "utf-8"))) {
	        //Write stuff
	         writer.write("something");
	        }


	        
	          System.out.println("File created: " + myObj.getName());
	        } else {
	          System.out.println("File already exists.");
	        }
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(int facilityID) {
		this.facilityID = facilityID;
	}

	public ArrayList<String> getCampsiteID() {
		return campsiteID;
	}

	public void setCampsiteID(ArrayList<String> campsiteID) {
		this.campsiteID = campsiteID;
	}
	
	

}
