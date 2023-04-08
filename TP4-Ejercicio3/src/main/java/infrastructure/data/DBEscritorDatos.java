package infrastructure.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import domain.model.Concurso;
import domain.model.Participante;
import domain.portsout.EscritorDatos;

public class DBEscritorDatos implements EscritorDatos {

	private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private Connection conexion;

	public DBEscritorDatos(Connection conexion) {
		this.conexion = Objects.requireNonNull(conexion);
	}

	@Override
	public void salvarParticipante(String nombre, String apellido, String telefono, String email, Long idConcurso)
			throws InfrastructureDataException {

		try {
			Participante participante = new Participante(nombre, apellido, telefono, email, idConcurso);

			PreparedStatement st = conexion.prepareStatement(
					"INSERT INTO participante (nombre, apellido, telefono, email, id_concurso) VALUES(?,?,?,?,?)");

			st.setString(1, participante.getNombre());
			st.setString(2, participante.getApellido());
			st.setString(3, participante.getTelefono());
			st.setString(4, participante.getEmail());
			st.setLong(5, participante.getIdConcurso());

			st.executeUpdate();

		} catch (Exception e) {
			throw new InfrastructureDataException(e.getMessage());
		}

	}

	@Override
	public void salvarConcurso(Long id, String nombre, LocalDate fechaInicio, LocalDate fechaFin)
			throws InfrastructureDataException {

		try {
			Concurso concurso = new Concurso(id, nombre, fechaInicio, fechaFin);

			PreparedStatement st = conexion.prepareStatement(
					"INSERT INTO concurso (nombre, inicio_inscripcion, fin_inscripcion) VALUES(?,?,?)");

			st.setString(1, concurso.getNombre());
			st.setString(1, concurso.getFechaInicioInscripcion().format(FORMATO));
			st.setString(1, concurso.getFechaFinInscripcion().format(FORMATO));

			st.executeUpdate();

		} catch (Exception e) {
			throw new InfrastructureDataException(e.getMessage());
		}

	}

}
