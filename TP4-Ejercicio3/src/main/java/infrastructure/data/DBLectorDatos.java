package infrastructure.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import domain.model.Concurso;
import domain.model.Participante;
import domain.portsout.LectorDatos;

public class DBLectorDatos implements LectorDatos {

	private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private Connection conexion;

	public DBLectorDatos(Connection conexion) {
		this.conexion = Objects.requireNonNull(conexion);
	}

	@Override
	public List<Participante> getParticipantes() throws InfrastructureDataException {

		List<Participante> participantes = new LinkedList<>();

		try {
			String consulta = "SELECT * FROM participante";
			Statement st = conexion.createStatement();

			ResultSet rs = st.executeQuery(consulta);

			while (rs.next())
				participantes.add(new Participante(rs.getString("nombre"), rs.getString("apellido"),
						rs.getString("telefono"), rs.getString("email"), rs.getLong("id_concurso")));

		} catch (Exception e) {
			throw new InfrastructureDataException(e.getMessage() + " || No se pudo leer datos");
		}

		return participantes;

	}

	@Override
	public List<Concurso> getConcursos() throws InfrastructureDataException {
		List<Concurso> concursos = new LinkedList<>();

		try {
			String consulta = "SELECT * FROM concurso";
			Statement st = conexion.createStatement();

			ResultSet rs = st.executeQuery(consulta);

			while (rs.next()) {
				LocalDate inicio = LocalDate.parse(rs.getString("inicio_inscripcion"), FORMATO);
				LocalDate fin = LocalDate.parse(rs.getString("fin_inscripcion"), FORMATO);
				concursos.add(new Concurso(rs.getLong("id_concurso"), rs.getString("nombre"), inicio, fin));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new InfrastructureDataException(e.getMessage() + " || No se pudo leer datos");
		}

		return concursos;
	}

}
