package app.com.model;

public class Author {
	public final static String TABLE_NAME = "authors";
	public final static String COLUMN_AUTHORID = "authorID";
	public final static String COLUMN_FIRSTNAME = "firstname";
	public final static String COLUMN_LASTNAME = "lastname";
	
	
	private int authorID;
	private String firstname,lastname;
	public int getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}
