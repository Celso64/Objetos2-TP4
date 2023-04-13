package domain.portsin;

import java.util.List;

import domain.model.Concurso;

public interface GestionConcurso {

	List<Concurso> todosLosConcursos() throws DomainException;

	void saveInscription(ParticipanteDTO participanteDTO) throws DomainException;

}
