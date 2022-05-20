package repositories;

import models.User;
import services.AuthenticationService;
import utils.ApplicationProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
	
	private static UserRepository instance = null;
	
	public static UserRepository getInstance() {

        if (UserRepository.instance == null) {
        	UserRepository.instance = new UserRepository();
		}

        return UserRepository.instance;
    }

	public List<User> getAllUsers() {
        List<User> listOfUsers = new ArrayList<>();
        String query = "SELECT * FROM users;";
        try (Connection conn = DriverManager.getConnection(ApplicationProperties.JDBC_URL);
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
	
	public List<User> getRegisteredUser(String username, String password) {
        List<User> listOfUsers = new ArrayList<>();
        String query = "SELECT * FROM users WHERE Username = ? AND Password = ?;";
        try (Connection conn = DriverManager.getConnection(ApplicationProperties.JDBC_URL);
            PreparedStatement ps = conn.prepareStatement(query)) {

            ResultSet resultSet = ps.executeQuery();
            
            ps.setString(1, username);
            ps.setString(2, password);
            
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
        String firstName = resultSet.getString("FirstName");
        String lastName = resultSet.getString("LastName");
        String username = resultSet.getString("Username");
        String email = resultSet.getString("Email");
        String password = resultSet.getString("Password");
        String salt = resultSet.getString("salt");
        int admin = resultSet.getInt("admin");
        User user = new User(firstName, lastName, username, email, password, salt, admin);
        return user;
    }
}
