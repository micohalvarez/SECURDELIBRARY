package app.com.service;

import java.awt.print.Book;
import java.util.List;

/**
 * Created by Micoh F Alvarez on 8/9/2017.
 */
public interface ResourceDAO {

    public List<Book> getBooks(String keyword);
    public List<Book> getBooksByAuthor(String author);
    public List<Book> getBooksByTitle(String title);
    public void reserveBook(int bookID, int userID);
    public void borrowBook(int bookID , int userID);
    public void returnBook(int bookID, int userID);
    public void deleteBook(int bookID);
    public void addBook(Book book);
    public void editBook(Book book);
}


