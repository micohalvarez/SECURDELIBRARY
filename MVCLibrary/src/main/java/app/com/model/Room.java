package app.com.model;

public class Room {
	public final static String TABLE_NAME = "rooms";
	public final static String COLUMN_RID = "roomID";
	public final static String COLUMN_FLOOR = "floor";
	
	
	private int userID,floor;


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public int getFloor() {
		return floor;
	}


	public void setFloor(int floor) {
		this.floor = floor;
	}

	
	
}
