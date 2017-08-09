package app.com.service;

import app.com.model.Room;
import app.com.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Micoh F Alvarez on 8/9/2017.
 */



public class UserDAOImpl implements UserDAO {


    private JdbcTemplate temp;

    public UserDAOImpl(DataSource dataSource) {
        temp = new JdbcTemplate(dataSource);
    }

    public void addUser(User u){
        //add given person to db
        System.out.print(u.getFirstname());
        String sql = "INSERT INTO " + User.TABLE_NAME + " Set " +
                User.COLUMN_UN + " = ? ," +
                User.COLUMN_EMAIL + " = ?," +
                User.COLUMN_PW + " =?, " +
                User.COLUMN_BDAY + " =?, " +
                User.COLUMN_SEQANS + " =?, " +
                User.COLUMN_SEQID + " =?, " +
                User.COLUMN_USERTYPE + " =?," +
                User.COLUMN_IDNUM + " =?," +
                User.COLUMN_FIRSTNAME + " = ?," +
                User.COLUMN_INITIAL + " = ?," +
                User.COLUMN_LASTNAME + " = ?";


        temp.update(sql, u.getUsername(),u.getEmail(),u.getPassword(),u.getBirthday(),u.getSecAns(),u.getSecretquestion(),"Micoh",u.getIdNumber(),
                u.getFirstname(),u.getInitial(),u.getLastname());


    }
    public void deleteUser(int userID){

        String sql = "DELETE FROM " + User.TABLE_NAME + " "
                + "WHERE " +  User.COLUMN_UID + " = ?";


    }
    public List<User> getUser(String username, String password){

        String sql = "SELECT * FROM " + User.TABLE_NAME + " Where " + User.COLUMN_PW + " = ? " + " AND " + User.COLUMN_UN + " = ?";

        List<User> u = temp.query(sql,  new Object[] {password,username}, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int rowNumber) throws SQLException {
                // TODO Auto-generated method stub
                User u = new User();

                u.setUserID(rs.getInt(User.COLUMN_UID));
                u.setUsername(rs.getString(User.COLUMN_UN));
                u.setEmail(rs.getString(User.COLUMN_EMAIL));
                u.setIdNumber(rs.getString(User.COLUMN_IDNUM));
                u.setPassword(rs.getString(User.COLUMN_PW));

                return u;
            }

        });
           return u;
    }

    public List<User> getAllUsers(){
        ArrayList<User> users = new ArrayList<User>();

        String sql = "SELECT * FROM " + User.TABLE_NAME;

//        Connection conn = null;
//        conn = DBPool.getInstance().getConnection();
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
//        try {
//            pstmt = conn.prepareStatement(sql);
//            rs = pstmt.executeQuery();
//
//            while(rs.next()){
//                User u = new User();
//                u.setUserID(rs.getInt(User.COLUMN_UID));
//                u.setUsername(rs.getString(User.COLUMN_UN));
//                u.setEmail(rs.getString(User.COLUMN_EMAIL));
//                u.setIdNumber(rs.getString(User.COLUMN_IDNUM));
//                u.setPassword(rs.getString(User.COLUMN_PW));
//                users.add(u);
//            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } finally{
//            try {
//                rs.close();
//                pstmt.close();
//                conn.close();
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//
       return users;
    }

}
