import java.sql.*;
import model.WeatherData;

public class DBExample {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:weather.db");
             Statement statement = connection.createStatement()) {

            statement.setQueryTimeout(30);  // Tiempo de espera de 30 segundos

            // Eliminar la tabla si existe
            statement.executeUpdate("DROP TABLE IF EXISTS weather");

            // Crear la tabla para almacenar los datos del clima
            statement.executeUpdate("CREATE TABLE weather ("
                    + "city TEXT, "
                    + "temp_min REAL, "
                    + "temp_max REAL, "
                    + "pressure INTEGER, "
                    + "humidity INTEGER, "
                    + "sea_level INTEGER)");

            // Insertar datos simulados de ejemplo
            WeatherData weather = new WeatherData(288.59, 288.59, 1022, 67, 1022);
            statement.executeUpdate("INSERT INTO weather (city, temp_min, temp_max, pressure, humidity, sea_level) VALUES "
                    + "('Las Palmas', " + weather.getTempMin() + ", " + weather.getTempMax() + ", "
                    + weather.getPressure() + ", " + weather.getHumidity() + ", " + weather.getSeaLevel() + ")");

            // Consultar los datos almacenados
            ResultSet rs = statement.executeQuery("SELECT * FROM weather");
            while (rs.next()) {
                System.out.println("Ciudad: " + rs.getString("city"));
                System.out.println("Temp Mínima: " + rs.getDouble("temp_min"));
                System.out.println("Temp Máxima: " + rs.getDouble("temp_max"));
                System.out.println("Presión: " + rs.getInt("pressure"));
                System.out.println("Humedad: " + rs.getInt("humidity"));
                System.out.println("Nivel del mar: " + rs.getInt("sea_level"));
                System.out.println("-------------------------");
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }
}
