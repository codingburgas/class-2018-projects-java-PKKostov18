package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ApplicationProperties.JDBC_URL);
		return conn;
	}
}
