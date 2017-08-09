package app.com.service;

import app.com.model.User;

import java.util.List;

/**
 * Created by Micoh F Alvarez on 8/9/2017.
 */
public interface UserDAO {

    public void addUser(User user);
    public List<User> getUser(String username, String password);
    public void deleteUser(int userID);
}
