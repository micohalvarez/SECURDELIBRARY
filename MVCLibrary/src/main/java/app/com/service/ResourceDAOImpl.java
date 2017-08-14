package app.com.service;

import app.com.model.Resource;
import app.com.model.Status;
import app.com.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
        String sql = "SELECT * FROM " + Resource.TABLE_NAME;
        List<Resource> r = temp.query(sql, new RowMapper<Resource>() {

            @Override
            public Resource mapRow(ResultSet rs, int rowNumber) throws SQLException {
                // TODO Auto-generated method stub
                Resource r = new Resource();

                r.setAuthor(rs.getString(Resource.COLUMN_AUTHOR));
                r.setTitle(rs.getString(Resource.COLUMN_TITLE));
                r.setLocation(rs.getString(Resource.COLUMN_LOCATION));
                r.setPublisher(rs.getString(Resource.COLUMN_PUBLISHER));
                r.setResourceID(rs.getInt(Resource.COLUMN_RESOURCEID));
                r.setTags(rs.getString(Resource.COLUMN_TAGS));
                r.setStatus(rs.getString(Resource.COLUMN_STATUS));
                return r;
            }

        });

        ArrayList<Resource> fin = new ArrayList<Resource>();

        for(int i = 0 ; i < r.size(); i++){
            if(r.get(i).getAuthor().toLowerCase().contains(keyword.toLowerCase()) || r.get(i).getPublisher().toLowerCase().contains(keyword.toLowerCase()) || r.get(i).getTitle().toLowerCase().contains(keyword.toLowerCase())
                        || r.get(i).getLocation().contains(keyword.toLowerCase()) || r.get(i).getTags().toLowerCase().contains(keyword.toLowerCase()))
                    fin.add(r.get(i));
        }

        return fin;


    }
    public List<Resource> getAllBooks(){
        String sql = "SELECT * FROM " + Resource.TABLE_NAME;
        List<Resource> r = temp.query(sql, new RowMapper<Resource>() {

            @Override
            public Resource mapRow(ResultSet rs, int rowNumber) throws SQLException {
                // TODO Auto-generated method stub
                Resource r = new Resource();

                r.setAuthor(rs.getString(Resource.COLUMN_AUTHOR));
                r.setTitle(rs.getString(Resource.COLUMN_TITLE));
                r.setLocation(rs.getString(Resource.COLUMN_LOCATION));
                r.setPublisher(rs.getString(Resource.COLUMN_PUBLISHER));
                r.setResourceID(rs.getInt(Resource.COLUMN_RESOURCEID));
                r.setTags(rs.getString(Resource.COLUMN_TAGS));
                r.setStatus(rs.getString(Resource.COLUMN_STATUS));
                return r;
            }

        });



     return r;


    }
    public List<Resource> getBooks(int id){
        String sql = "SELECT * FROM " + Resource.TABLE_NAME + " WHERE " + Resource.COLUMN_RESOURCEID + " = ?";
        List<Resource> r = temp.query(sql,new Object[] {id}, new RowMapper<Resource>() {

            @Override
            public Resource mapRow(ResultSet rs, int rowNumber) throws SQLException {
                // TODO Auto-generated method stub
                Resource r = new Resource();

                r.setAuthor(rs.getString(Resource.COLUMN_AUTHOR));
                r.setTitle(rs.getString(Resource.COLUMN_TITLE));
                r.setLocation(rs.getString(Resource.COLUMN_LOCATION));
                r.setPublisher(rs.getString(Resource.COLUMN_PUBLISHER));
                r.setResourceID(rs.getInt(Resource.COLUMN_RESOURCEID));
                r.setTags(rs.getString(Resource.COLUMN_TAGS));
                r.setStatus(rs.getString(Resource.COLUMN_STATUS));
                return r;
            }

        });





        return r;


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
                r.setTags(rs.getString(Resource.COLUMN_TAGS));
                r.setType(rs.getString(Resource.COLUMN_TYPE));
                r.setStatus(rs.getString(Resource.COLUMN_STATUS));
                return r;
            }

        });
        return r;

    }
    public List<Resource> getBookByTitle(String keyword){
        String sql = "SELECT * FROM " + Resource.TABLE_NAME + " Where " + Resource.COLUMN_TITLE + " like ? ";

        List<Resource> r = temp.query(sql,  new Object[] {"%"+keyword+"%"}, new RowMapper<Resource>() {

            @Override
            public Resource mapRow(ResultSet rs, int rowNumber) throws SQLException {
                // TODO Auto-generated method stub
                Resource r = new Resource();

                r.setAuthor(rs.getString(Resource.COLUMN_AUTHOR));
                r.setTitle(rs.getString(Resource.COLUMN_TITLE));
                r.setLocation(rs.getString(Resource.COLUMN_LOCATION));
                r.setTags(rs.getString(Resource.COLUMN_TAGS));
                r.setType(rs.getString(Resource.COLUMN_TYPE));
                r.setPublisher(rs.getString(Resource.COLUMN_PUBLISHER));
                r.setResourceID(rs.getInt(Resource.COLUMN_RESOURCEID));
                r.setStatus(rs.getString(Resource.COLUMN_STATUS));
                return r;
            }

        });
        return r;
    }
    public List<Resource> getBooksByTitle(String keyword) {
        String sql = "SELECT * FROM " + Resource.TABLE_NAME + " Where " + Resource.COLUMN_TITLE + " like ? ";

        List<Resource> r = temp.query(sql, new Object[]{"%" + keyword + "%"}, new RowMapper<Resource>() {

            @Override
            public Resource mapRow(ResultSet rs, int rowNumber) throws SQLException {
                // TODO Auto-generated method stub
                Resource r = new Resource();

                r.setAuthor(rs.getString(Resource.COLUMN_AUTHOR));
                r.setTitle(rs.getString(Resource.COLUMN_TITLE));
                r.setType(rs.getString(Resource.COLUMN_TYPE));
                r.setLocation(rs.getString(Resource.COLUMN_LOCATION));
                r.setPublisher(rs.getString(Resource.COLUMN_PUBLISHER));
                r.setResourceID(rs.getInt(Resource.COLUMN_RESOURCEID));
                r.setTags(rs.getString(Resource.COLUMN_TAGS));
                return r;
            }

        });
        return r;
    }

    public List<Status> getBookStatus(int bookid,int userid){

        String sql = "SELECT * FROM " + Status.TABLE_NAME +" WHERE " + Status.COLUMN_BOOKID +  "=  ? AND " + Status.COLUMN_USERID + " = ?";
        List<Status> s = temp.query(sql,new Object[]{bookid,userid}, new RowMapper<Status>() {

            @Override
            public Status mapRow(ResultSet rs, int rowNumber) throws SQLException {
                // TODO Auto-generated method stub
                Status s = new Status();
                s.setBookID(rs.getInt(Status.COLUMN_BOOKID));
                s.setEndDate(rs.getString(Status.COLUMN_ENDDATE));
                s.setUserID(rs.getInt(Status.COLUMN_USERID));
                s.setStatustype(rs.getInt(Status.COLUMN_STATUS_TYPE));

                return s;
            }

        });


        return s;

    }
    public void reserveBook(int bookId, int userID){
        LocalDate deadlineDate;

        deadlineDate = LocalDate.now().plusDays(7);

        String sql = "INSERT INTO status SET resourceID=?, userID=?, enddate=?,"
                + " statustype=?";
        temp.update(sql, bookId, userID , deadlineDate, 2); // 1 = available, 2 = reserved, 3 = taken

        String sql2 = "UPDATE resources SET status = 2 WHERE resourceID = ?";
        temp.update(sql2, bookId);


    }
    @Override
    public void borrowBook(int bookid, int userID){
        LocalDate deadlineDate;

            deadlineDate = LocalDate.now().plusDays(7);

        String sql = "INSERT INTO status SET resourceID=?, userID=?, enddate=?,"
                + " statustype=?";
        temp.update(sql, bookid, userID , deadlineDate, 1); // 1 = available, 2 = reserved, 3 = taken

        String sql2 = "UPDATE resources SET status = 1 WHERE resourceID = ?";
        temp.update(sql2, bookid);


    }

    @Override
    public void returnBook(int bookid, int userID) {
        LocalDate deadlineDate;

        deadlineDate = LocalDate.now().plusDays(7);

        String sql = "INSERT INTO status SET resourceID=?, userID=?, enddate=?,"
                + " statustype=?";
        temp.update(sql, bookid, userID , deadlineDate, 3); // 1 = borrowed, 2 = reserved, 3 = available

        String sql2 = "UPDATE resources SET status = 0 WHERE resourceID = ?";
        temp.update(sql2, bookid);

    }

    @Override
    public void deleteBook(int bookID) {
        String sql = "DELETE FROM resources WHERE" + " resourceID=?";
        temp.update(sql, bookID);
    }

    @Override
    public void addBook(Resource book) {
        String sql = "INSERT INTO resources SET title=?, location=?, tags=?, author=?, publisher=?, type=?,"
                + " status=?";
        temp.update(sql, book.getTitle(), book.getLocation(), book.getAuthor(),
                book.getPublisher(), book.getType(), book.getTags(), 0);


    }

    @Override
    public void editBook(Resource book) {
        String sql = "UPDATE resources SET title=?, location=?,tags=?, author=?, publisher=?, type=? WHERE"
                + " resourceID=?";
        temp.update(sql, book.getTitle(), book.getLocation(),book.getTags(), book.getAuthor(), book.getPublisher(), book.getType()
                , book.getResourceID());
    }
}
