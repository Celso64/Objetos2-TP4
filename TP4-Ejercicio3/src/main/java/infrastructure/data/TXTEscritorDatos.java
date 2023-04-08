package infrastructure.data;

import java.io.OutputStream;
import java.time.LocalDate;
import java.util.Objects;

import domain.model.Participante;
import domain.portsout.EscritorDatos;

public class TXTEscritorDatos implements EscritorDatos {

	private OutputStream escritorParticipantes;
	private OutputStream escritorConcursos;

	public TXTEscritorDatos(OutputStream escritorParticipantes, OutputStream escritorConcursos) {
		this.escritorParticipantes = Objects.requireNonNull(escritorParticipantes);
		this.escritorConcursos = Objects.requireNonNull(escritorConcursos);
	}

	@Override
	public void salvarParticipante(String nombre, String apellido, String telefono, String email, Long idConcurso)
			throws InfrastructureDataException {

		try {
			Participante participante = new Participante(nombre, apellido, telefono, email, idConcurso);

			StringBuffer linea = new StringBuffer(256);

			linea.append(participante.getApellido()).append(", ").append(participante.getNombre()).append(", ")
					.append(participante.getTelefono()).append(", ").append(participante.getEmail()).append(", ")
					.append(idConcurso.toString()).append("\n");

			this.escritorParticipantes.write(linea.toString().getBytes());
		} catch (Exception e) {
			throw new InfrastructureDataException(e.getMessage() + " || No se pudo guardar al Participante");
		}

	}

	@Override
	public void salvarConcurso(Long id, String nombre, LocalDate fechaInicio, LocalDate fechaFin)
			throws InfrastructureDataException {

		StringBuffer linea = new StringBuffer(256);

		linea.append(id).append(", ").append(nombre).append(", ").append(fechaInicio.toString()).append(", ")
				.append(fechaFin.toString()).append("\n");

		try {
			this.escritorConcursos.write(linea.toString().getBytes());
		} catch (Exception e) {
			throw new InfrastructureDataException(e.getMessage() + " || No se pudo guardar Concurso");
		}
	}

}
