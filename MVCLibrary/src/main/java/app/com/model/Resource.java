package app.com.model;

public class Resource {

	public final static String TABLE_NAME = "resources";
	public final static String COLUMN_RESOURCEID = "resourceID";
	public final static String COLUMN_LOCATION = "location";
	public final static String COLUMN_TITLE = "title";
	public final static String COLUMN_TAGS = "tags";
	public final static String COLUMN_AUTHORID = "authorID";
	public final static String COLUMN_PUBLISHERID = "publisherID";
	public final static String COLUMN_TYPE = "type";
	
	
	private int resourceID,type,authorID,publisherID;
	private String location,title,tags;
	public int getResourceID() {
		return resourceID;
	}
	public void setResourceID(int resourceID) {
		this.resourceID = resourceID;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	public int getPublisherID() {
		return publisherID;
	}
	public void setPublisherID(int publisherID) {
		this.publisherID = publisherID;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	
	
}
