package model;

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

    public String getUsernameById(int userID) {

        try {
            String username = userDAO.getUsername(userID);
            return username;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
