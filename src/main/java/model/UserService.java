package model;

import model.User;
import database.UserDao;

public class UserService {
    private UserDao userDAO = new UserDao();

    public User authenticate (String username, String password) {
        try {
            User user = userDAO.selectUsername(username);
            if(user != null && user.getPassword().equals(password)){
                return user;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
