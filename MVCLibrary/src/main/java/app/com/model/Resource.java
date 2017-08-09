package app.com.model;

public class Resource {

	public final static String TABLE_NAME = "resources";
	public final static String COLUMN_RESOURCEID = "resourceID";
	public final static String COLUMN_LOCATION = "location";
	public final static String COLUMN_TITLE = "title";
	public final static String COLUMN_TAGS = "tags";
	public final static String COLUMN_AUTHOR = "author";
	public final static String COLUMN_PUBLISHER = "publisher";
	public final static String COLUMN_TYPE = "type";
	
	
	private int resourceID;
	private String location,title,tags,author,publisher,type;
	public int getResourceID() {
		return resourceID;
	}
	public void setResourceID(int resourceID) {
		this.resourceID = resourceID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisherID() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
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
