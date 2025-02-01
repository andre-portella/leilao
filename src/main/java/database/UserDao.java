package database;


import database.ConnectionFactory;
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
} 