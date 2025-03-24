package dacd.cabeza.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseManager {
	public static String dbUrl;

	static {
		try {
			Properties prop = new Properties();
			prop.load(DatabaseManager.class.getClassLoader().getResourceAsStream("application.properties"));
			dbUrl = prop.getProperty("database.url");
		} catch (Exception e) {
			throw new RuntimeException("Error loading database configuration", e);
		}
	}

	public static void initializeDB() throws SQLException {
		try (Connection conn = DriverManager.getConnection(dbUrl);
			 Statement stmt = conn.createStatement()) {

			String sql = "CREATE TABLE IF NOT EXISTS hotel_rates ("
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "provider_code TEXT NOT NULL,"
					+ "provider_name TEXT NOT NULL,"
					+ "rate REAL NOT NULL,"
					+ "timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,"
					+ "check_in DATE,"
					+ "check_out DATE)";

			stmt.execute(sql);
		}
	}
}
