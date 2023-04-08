package infrastructure.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import domain.portsout.InscripcionAlmacenamiento;

public class DBInscripcionAlmacenamiento implements InscripcionAlmacenamiento {

	private Connection conn;

	public DBInscripcionAlmacenamiento(Properties propiedades) throws SQLException {

		this.conn = DriverManager.getConnection(propiedades.getProperty("url"));
	}

	@Override
	public void inscribir(String nombre, String telefono, String region) throws InfrastructureDataException {

		String insert = "insert into participante(nombre, telefono, region)	values(?,?,?)";
		try (PreparedStatement st = conn.prepareStatement(insert);) {

			st.setString(1, nombre);
			st.setString(2, telefono);
			st.setString(3, region);
			st.executeUpdate();

		} catch (SQLException e) {
			throw new InfrastructureDataException(e.getMessage() + " || No se pudo insribir Participante");
		}

	}

}
