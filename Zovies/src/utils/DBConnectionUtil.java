package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ApplicationProperties.JDBC_URL);
		return conn;
	}
}
