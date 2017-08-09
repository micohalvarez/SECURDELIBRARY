package app.com.model;

import java.util.Date;

/**
 * Created by Micoh F Alvarez on 8/9/2017.
 */
public class User {

    public final static String TABLE_NAME = "users";
    public final static String COLUMN_UID = "usersID";
    public final static String COLUMN_UN = "username";
    public final static String COLUMN_EMAIL = "email";
    public final static String COLUMN_PW = "password";
    public final static String COLUMN_BDAY ="birthday";
    public final static String COLUMN_SEQID ="secretquestion";
    public final static String COLUMN_SEQANS = "secretanswer";
    public final static String COLUMN_USERTYPE = "usertype";
    public final static String COLUMN_IDNUM = "idnumber";
    public final static String COLUMN_FIRSTNAME = "firstname";
    public final static String COLUMN_LASTNAME = "lastname";
    public final static String COLUMN_INITIAL = "initial";

    private int userID;
    private String username,secretquestion;
    private String email;
    private String password;
    private String birthday;
    private String secAns;
    private String idNumber;
    private String userType;
    private String firstname;
    private String lastname;
    private String initial;

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
    public String getInitial() {
        return initial;
    }
    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getSecretquestion() {
        return secretquestion;
    }
    public void setSecretquestion(String secretquestion) {
        this.secretquestion = secretquestion;
    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getSecAns() {
        return secAns;
    }
    public void setSecAns(String secAns) {
        this.secAns = secAns;
    }
    public String getIdNumber() {
        return idNumber;
    }
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }


}
