package app.com.service;

import app.com.model.Room;
import app.com.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

    public int addUser(User u){

        if(passwordvalidation(u.getPassword())) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashed = passwordEncoder.encode(u.getPassword());
            LocalDate dateNow  = LocalDate.now().plusYears(100);
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
                    User.COLUMN_LASTNAME + " = ?," +
                    "failures = ?, lastfailure = ?, lock = ?";

            try {
                temp.update(sql, u.getUsername(), u.getEmail(), hashed, u.getBirthday(), u.getSecAns(), u.getSecretquestion(), u.getUserType(), u.getIdNumber(),
                        u.getFirstname(), u.getInitial(), u.getLastname(),0,dateNow,0);
                return 1;
            } catch (Exception e) {
                return 0;
            }
        }
        else return 0;
    }

    public boolean passwordvalidation(String password) {

        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        System.out.println(password.matches(pattern));
        if(password.matches(pattern)) {
            System.out.print(password);
            return true;
        }
                else return false;
    }
    public void deleteUser(int userID){

        String sql = "DELETE FROM " + User.TABLE_NAME + " "
                + "WHERE " +  User.COLUMN_UID + " = ?";


    }
    public List<User> getUser(String username, String password){
        User user = getUserbyUN(username).get(0);



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
                u.setUserType(rs.getInt(User.COLUMN_USERTYPE));

                return u;
            }

        });
           return u;
    }

    public List<User> getUserbyUN(String username){


        String sql = "SELECT * FROM " + User.TABLE_NAME + " Where " + User.COLUMN_UN + " = ?";

        List<User> u = temp.query(sql,  new Object[] {username}, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int rowNumber) throws SQLException {
                // TODO Auto-generated method stub
                User u = new User();

                u.setUserID(rs.getInt(User.COLUMN_UID));
                u.setUsername(rs.getString(User.COLUMN_UN));
                u.setUserType(rs.getInt(User.COLUMN_USERTYPE));
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

    public void updatelog(String name){

        String sql = "SELECT * FROM " + User.TABLE_NAME + " Where " + User.COLUMN_UN + " = ?";

        List<User> u = temp.query(sql,  new Object[] {name}, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int rowNumber) throws SQLException {
                // TODO Auto-generated method stub
                User u = new User();

                u.setUserID(rs.getInt(User.COLUMN_UID));
                u.setUsername(rs.getString(User.COLUMN_UN));
                u.setUserType(rs.getInt(User.COLUMN_USERTYPE));
                u.setEmail(rs.getString(User.COLUMN_EMAIL));
                u.setIdNumber(rs.getString(User.COLUMN_IDNUM));
                u.setPassword(rs.getString(User.COLUMN_PW));
                u.setFailure(rs.getInt("failures"));
                u.setDate(rs.getDate("lastfailure").toLocalDate());
                return u;
            }

        });

         LocalDate dateNow  = LocalDate.now();
         System.out.print(u.get(0).getDate());
         System.out.print(dateNow);
         if(u.get(0).getDate().equals(dateNow) && u.get(0).getFailure() == 3) {
             System.out.print("LOCK ACOOUNT");
             sql = "Update users set lock=?,lastfailure=?,failures=? Where username = ?";
             temp.update(sql,1,dateNow.plusYears(100),0,name);
         }
else {
             sql = "Update users set failures = failures + 1,lastfailure =? Where username = ?";

             temp.update(sql, dateNow, name);
         }
    }


}
