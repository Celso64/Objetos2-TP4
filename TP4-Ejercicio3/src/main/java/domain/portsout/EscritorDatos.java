package domain.portsout;

import java.time.LocalDate;

import infrastructure.data.InfrastructureDataException;

public interface EscritorDatos {

	void salvarParticipante(String nombre, String apellido, String telefono, String email, Long idConcurso)
			throws InfrastructureDataException;

	void salvarConcurso(Long id, String nombre, LocalDate fechaInicio, LocalDate fechaFin)
			throws InfrastructureDataException;

}
