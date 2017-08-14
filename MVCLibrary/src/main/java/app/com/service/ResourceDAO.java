package app.com.service;

import app.com.model.Comment;
import app.com.model.Resource;
import app.com.model.Status;

import java.awt.print.Book;
import java.util.List;

/**
 * Created by Micoh F Alvarez on 8/9/2017.
 */
public interface ResourceDAO {
    public List<Status> getBookStatus(int bookid,int userid);
    public List<Resource> getAllBooks();
    public List<Resource> getBooks(int id);
    public List<Resource> getBooks(String keyword);
    public List<Resource> getBooksByAuthor(String author);
    public List<Resource> getBooksByTitle(String title);
    public void reserveBook(int bookID, int userID);
    public void borrowBook(int bookID , int userID);
    public void returnBook(int bookID, int userID);
    public void deleteBook(int bookID);
    public void addBook(Resource book);
    public void editBook(Resource book);
    public List<Resource> getBookByTitle(String keyword);
    public int isReviewable(int bookID,int userID);
    public List<Comment> getComments(int resourceid);
    public void addComment(String comment, int userid, int resourceid);
}


