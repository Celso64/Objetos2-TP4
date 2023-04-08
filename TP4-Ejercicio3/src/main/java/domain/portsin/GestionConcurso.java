package domain.portsin;

import java.util.List;

import domain.model.Concurso;

public interface GestionConcurso {

	List<Concurso> todosLosConcursos() throws DomainException;

	void saveInscription(String nombre, String apellido, String telefono, String email, Long idConcurso)
			throws DomainException;

}
