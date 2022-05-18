package repositories;

import models.User;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

	public List<User> getUsers() {
        List<User> listOfUsers = new ArrayList<>();
        String query = "SELECT * FROM users;";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlserver://SD2361\\sqlexpress;databaseName=JavaProject;integratedSecurity=true");
             PreparedStatement ps = conn.prepareStatement(query)) {

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                User user = mapToUser(resultSet);
                listOfUsers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listOfUsers;
    }

    private User mapToUser(ResultSet resultSet) throws SQLException {
        Long userId = resultSet.getLong("userId_column");
        String username = resultSet.getString("username_column");
        String password = resultSet.getString("password_column");
        User user = new User(userId, username, password);
        return user;
    }

}
