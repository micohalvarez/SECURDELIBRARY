package app.com.service;

import app.com.model.Resource;
import app.com.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Micoh F Alvarez on 8/9/2017.
 */
public class ResourceDAOImpl implements ResourceDAO {

    private JdbcTemplate temp;

    public ResourceDAOImpl(DataSource dataSource) {
        temp = new JdbcTemplate(dataSource);
    }

    public List<Resource> getBooks(String keyword){
//        String sql = "SELECT * FROM " + Resource.TABLE_NAME;
//        List<Resource> r = temp.query(sql,  new Object[] {keyword}, new RowMapper<User>() {
//
//            @Override
//            public User mapRow(ResultSet rs, int rowNumber) throws SQLException {
//                // TODO Auto-generated method stub
//                Resource r = new Resource();
//
//                u.setUserID(rs.getInt(User.COLUMN_UID));
//                u.setUsername(rs.getString(User.COLUMN_UN));
//                u.setEmail(rs.getString(User.COLUMN_EMAIL));
//                u.setIdNumber(rs.getString(User.COLUMN_IDNUM));
//                u.setPassword(rs.getString(User.COLUMN_PW));
//
//                return r;
//            }
//
//        });
//        return u;
        return null;

    }
    public List<Resource> getBooksByAuthor(String keyword){
        String sql = "SELECT * FROM " + Resource.TABLE_NAME + " Where " + Resource.COLUMN_AUTHOR + " like ? ";

        List<Resource> r = temp.query(sql,  new Object[] {"%"+keyword+"%"}, new RowMapper<Resource>() {

            @Override
            public Resource mapRow(ResultSet rs, int rowNumber) throws SQLException {
                // TODO Auto-generated method stub
                Resource r = new Resource();

               r.setAuthor(rs.getString(Resource.COLUMN_AUTHOR));
               r.setTitle(rs.getString(Resource.COLUMN_TITLE));
               r.setLocation(rs.getString(Resource.COLUMN_LOCATION));
               r.setPublisher(rs.getString(Resource.COLUMN_PUBLISHER));
               r.setResourceID(rs.getInt(Resource.COLUMN_RESOURCEID));
                return r;
            }

        });
        return r;

    }
    public List<Resource> getBooksByTitle(String keyword){
        String sql = "SELECT * FROM " + Resource.TABLE_NAME + " Where " + Resource.COLUMN_TITLE + " like ? ";

        List<Resource> r = temp.query(sql,  new Object[] {"%"+keyword+"%"}, new RowMapper<Resource>() {

            @Override
            public Resource mapRow(ResultSet rs, int rowNumber) throws SQLException {
                // TODO Auto-generated method stub
                Resource r = new Resource();

                r.setAuthor(rs.getString(Resource.COLUMN_AUTHOR));
                r.setTitle(rs.getString(Resource.COLUMN_TITLE));
                r.setLocation(rs.getString(Resource.COLUMN_LOCATION));
                r.setPublisher(rs.getString(Resource.COLUMN_PUBLISHER));
                r.setResourceID(rs.getInt(Resource.COLUMN_RESOURCEID));
                return r;
            }

        });
        return r;
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
    public void addBook(Resource book) {

    }

    @Override
    public void editBook(Resource book) {

    }
}
