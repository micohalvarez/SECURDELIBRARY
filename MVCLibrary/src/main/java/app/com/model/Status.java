package app.com.model;

import java.util.Date;

public class Status {
	public final static String TABLE_NAME = "status";
	public final static String COLUMN_STATUSID = "statusID";
	public final static String COLUMN_BOOKID = "resourceID";
	public final static String COLUMN_USERID = "userID";
	public final static String COLUMN_ENDDATE = "enddate";
	public final static String COLUMN_STATUS_TYPE = "statustype";
	
	private int statusID,bookID,userID,statustype;
	private String startDate,endDate;
	
	public int getStatusID() {
		return statusID;
	}
	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getStatustype() {
		return statustype;
	}
	public void setStatustype(int statustype) {
		this.statustype = statustype;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
}
