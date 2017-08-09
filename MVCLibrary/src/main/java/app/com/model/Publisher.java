package app.com.model;

import java.util.Date;

public class Publisher {
	public final static String TABLE_NAME = "publisher";
	public final static String COLUMN_PUBLISHERID = "publisherID";
	public final static String COLUMN_NAME = "name";
	public final static String COLUMN_YEAR = "year";
	
	private int publisherID;
	private String name;
	private Date year;
	
	public int getPublisherID() {
		return publisherID;
	}
	public void setPublisherID(int publisherID) {
		this.publisherID = publisherID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = year;
	}
	

}
