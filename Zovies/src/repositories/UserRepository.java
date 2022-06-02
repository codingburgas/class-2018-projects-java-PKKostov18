package repositories;

import models.User;

import utils.DBConnection;
import java.sql.Connection;
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
		String query = "SELECT * FROM users WHERE Admin = '0';";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {

			while (resultSet.next()) {
				User user = mapToUser(resultSet);
				listOfUsers.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfUsers;
	}

	public List<User> getAllAdmins() {
		List<User> listOfUsers = new ArrayList<>();
		String query = "SELECT * FROM users WHERE Admin = '1';";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {

			while (resultSet.next()) {
				User user = mapToUser(resultSet);
				listOfUsers.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfUsers;
	}
	
	public User getRegisteredUser(String username) {
		User user = null;
		String query = "SELECT * FROM users WHERE Username = ?";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = getPSWithUsername(conn, query, username);
				ResultSet resultSet = ps.executeQuery()) {
			
			while (resultSet.next()) {
				user = mapToUser(resultSet);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	public boolean insertUser(String firstName, String lastName, String email, String username, String password,
			String salt, boolean admin) {
		String query1 = "INSERT INTO users (FirstName, LastName, Email, Username, Password, Salt, Admin) VALUES (?, ?, ?, ?, ?, ?, ?)";
		String query2 = "SELECT * FROM users WHERE Username = ?";
		try (Connection conn = DBConnection.getConnection(); 
				PreparedStatement pst1 = conn.prepareStatement(query1);
				PreparedStatement pst2 = conn.prepareStatement(query2)) {
			
			pst2.setString(1, username);
			
			ResultSet resultSet = pst2.executeQuery();
					
			if(resultSet.next() == true) {
				return false;
			}
			else {
				pst1.setString(1, firstName);
				pst1.setString(2, lastName);
				pst1.setString(3, email);
				pst1.setString(4, username);
				pst1.setString(5, password);
				pst1.setString(6, salt);
				pst1.setBoolean(7, admin);
				
				int rs = pst1.executeUpdate();
				return true;
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
		boolean admin = resultSet.getBoolean("Admin");
		User user = new User(userId, firstName, lastName, username, email, password, salt, admin);
		return user;
	}
	
	private PreparedStatement getPSWithUsername(Connection conn, String query, String username) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, username);
		return ps;
	}
}
