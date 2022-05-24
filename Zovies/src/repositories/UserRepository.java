package repositories;

import models.User;
import utils.ApplicationProperties;
import utils.PasswordManager;

import java.security.Key;
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
		String query = "SELECT * FROM users WHERE Username = ?";
		try (Connection conn = DriverManager.getConnection(ApplicationProperties.JDBC_URL);
				PreparedStatement ps = conn.prepareStatement(query)) {
			
			ps.setString(1, username);
			
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
	
	public boolean getAdminUser(String username) {
		String query = "SELECT * FROM users WHERE Username = ?";
		try (Connection conn = DriverManager.getConnection(ApplicationProperties.JDBC_URL);
				PreparedStatement ps = conn.prepareStatement(query)) {
			
			ps.setString(1, username);
			
			ResultSet resultSet = ps.executeQuery();
			
			while (resultSet.next()) {
				if(resultSet.getInt("Admin") == 0) {
					return false;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	public void insertUser(String firstName, String lastName, String email, String username, String password,
			String salt, int admin) {
		String query1 = "INSERT INTO users (FirstName, LastName, Email, Username, Password, Salt, Admin) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(ApplicationProperties.JDBC_URL); 
				PreparedStatement pst = conn.prepareStatement(query1)) {
			
			pst.setString(1, firstName);
			pst.setString(2, lastName);
			pst.setString(3, email);
			pst.setString(4, username);
			pst.setString(5, password);
			pst.setString(6, salt);
			pst.setInt(7, admin);
			
			int rs = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean checkHashPassword(String username, String password) {
		String query1 = "SELECT * FROM users WHERE Username = ?";
		try (Connection conn = DriverManager.getConnection(ApplicationProperties.JDBC_URL);
				PreparedStatement ps = conn.prepareStatement(query1)) {
			
			ps.setString(1, username);
			
			ResultSet resultSet = ps.executeQuery();
			
			while (resultSet.next()) {
				if(PasswordManager.isExpectedPassword(password.toCharArray(), resultSet.getString("Salt"), resultSet.getString("Password").toCharArray()) == false) {
					return false;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	private User mapToUser(ResultSet resultSet) throws SQLException {
		int userId = resultSet.getInt("UserId");
		String firstName = resultSet.getString("FirstName");
		String lastName = resultSet.getString("LastName");
		String username = resultSet.getString("Username");
		String email = resultSet.getString("Email");
		String password = resultSet.getString("Password");
		String salt = resultSet.getString("Salt");
		int admin = resultSet.getInt("Admin");
		User user = new User(userId, firstName, lastName, username, email, password, salt, admin);
		return user;
	}
}
