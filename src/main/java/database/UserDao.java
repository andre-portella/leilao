package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDao {

    public User selectUsername (String username) {

        String SELECT_USERS_SQL = "SELECT * FROM users WHERE username = ?;";

        try {
            // recebendo conexão
            Connection conn = ConnectionFactory.getConnection();

            // realizando consulta
            PreparedStatement stmt = conn.prepareStatement(SELECT_USERS_SQL);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) { // se username encontrado
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public String getUsername(int userID) {

        String GET_USERNAME_SQL = "SELECT * FROM users WHERE user_id = ?;";

        try {
            
            Connection conn = ConnectionFactory.getConnection();

            // executa query
            PreparedStatement stmt = conn.prepareStatement(GET_USERNAME_SQL);

            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));

                return user.getUsername();
            }
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
} 