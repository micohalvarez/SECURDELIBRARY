package app.com.service;

import app.com.model.User;

import java.util.List;

/**
 * Created by Micoh F Alvarez on 8/9/2017.
 */
public interface UserDAO {

    public int addUser(User user);
    public List<User> getUser(String username, String password);
    public void deleteUser(int userID);
    public List<User> getUserbyUN(String username);
    public void updatelog(String name);
    public List<User> getUsers();
    public void unlock(int userid);


}
