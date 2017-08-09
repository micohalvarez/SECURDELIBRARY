package app.com.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Appointment {

	public final static String TABLE_NAME = "appointments";
	public final static String COLUMN_APPOINTMENTID = "appointmentID";
	public final static String COLUMN_STARTTIME = "startTime";
	public final static String COLUMN_ENDTIME = "endTime";
	public final static String COLUMN_ROOMID = "roomID";
	public final static String COLUMN_USERID = "userID";
	public final static String COLUMN_DATE = "date";	
	
	private int appointmentID,roomID,userID;
	private Timestamp startTime,endTime;
	private Date date;
	
	
	public int getAppointmentID() {
		return appointmentID;
	}
	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
}
