package dacd.cabeza.db;

import dacd.cabeza.model.HotelRate;
import java.sql.*;
import java.util.List;

public class RateRepository {
	public void saveRates(List<HotelRate> rates, String checkIn, String checkOut) throws SQLException {
		String sql = "INSERT INTO hotel_rates (provider_code, provider_name, rate, check_in, check_out) "
				+ "VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = DriverManager.getConnection(DatabaseManager.dbUrl);
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {

			for (HotelRate rate : rates) {
				pstmt.setString(1, rate.getCode());
				pstmt.setString(2, rate.getName());
				pstmt.setDouble(3, rate.getRate());
				pstmt.setString(4, checkIn);
				pstmt.setString(5, checkOut);
				pstmt.addBatch();
			}

			pstmt.executeBatch();
		}
	}
}
