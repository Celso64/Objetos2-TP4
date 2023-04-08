package infrastructure.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConnectionManager {

	public static Connection getConexion() throws SQLException {

		Connection conn = null;

		String url = "jdbc:sqlite:./src/main/resources/db_concursos";

		conn = DriverManager.getConnection(url);

		return conn;
	}
}
