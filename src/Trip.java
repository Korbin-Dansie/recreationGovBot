package src;

import java.time.LocalDate;
import java.util.ArrayList;

public class Trip {
	private LocalDate startDate;
	private LocalDate endDate;
	private int facilityID;
	private ArrayList<String> campsiteID;

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

	public Trip(LocalDate startDate, LocalDate endDate, int facilityID, ArrayList<String> campsiteID) {
		// TODO Auto-generated constructor stub
		// TODO Auto-generated constructor stub
		this.startDate = startDate;
		this.endDate = endDate;

		this.facilityID = facilityID;

		this.campsiteID = campsiteID;
	}

}
