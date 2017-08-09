package app.com.service;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.awt.print.Book;
import java.util.List;

/**
 * Created by Micoh F Alvarez on 8/9/2017.
 */
public class ResourceDAOImpl implements ResourceDAO {

    private JdbcTemplate temp;

    public ResourceDAOImpl(DataSource dataSource) {
        temp = new JdbcTemplate(dataSource);
    }

    public List<Book> getBooks(String keyword){

        return null;

    }
    public List<Book> getBooksByAuthor(String author){

        return null;

    }
    public List<Book> getBooksByTitle(String title){


        return null;
    }
    public void reserveBook(int bookID, int userID){


    }

    public void borrowBook(int bookId, int userID){


    }

    @Override
    public void returnBook(int bookID, int userID) {

    }

    @Override
    public void deleteBook(int bookID) {

    }

    @Override
    public void addBook(Book book) {

    }

    @Override
    public void editBook(Book book) {

    }
}
