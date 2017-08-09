package app.com.model;

public class Comment {

	public final static String TABLE_NAME = "comment";
	public final static String COLUMN_COMMENTID = "commentID";
	public final static String COLUMN_COMMENT = "comment";
	public final static String COLUMN_USERID = "userID";
	public final static String COLUMN_RESOURCEID = "resourceID";
	
	private int userID,resourceID,commentID;
	private String comment;
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getResourceID() {
		return resourceID;
	}
	public void setResourceID(int resourceID) {
		this.resourceID = resourceID;
	}
	public int getCommentID() {
		return commentID;
	}
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
