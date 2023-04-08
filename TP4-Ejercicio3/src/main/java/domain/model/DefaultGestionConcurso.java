package domain.model;

import java.util.List;
import java.util.Objects;

import domain.portsin.DomainException;
import domain.portsin.GestionConcurso;
import domain.portsout.EscritorDatos;
import domain.portsout.LectorDatos;
import infrastructure.data.InfrastructureDataException;

public class DefaultGestionConcurso implements GestionConcurso {

	private LectorDatos lector;
	private EscritorDatos escritor;

	public DefaultGestionConcurso(LectorDatos lector, EscritorDatos escritor) {
		this.lector = Objects.requireNonNull(lector);
		this.escritor = Objects.requireNonNull(escritor);
	}

	@Override
	public List<Concurso> todosLosConcursos() throws DomainException {

		try {

			return lector.getConcursos().stream().filter(Concurso::estaVigente).toList();

		} catch (InfrastructureDataException e) {
			throw new DomainException(e.getMessage());
		}
	}

	@Override
	public void saveInscription(String nombre, String apellido, String telefono, String email, Long idConcurso)
			throws DomainException {

		try {
			escritor.salvarParticipante(nombre, apellido, telefono, email, idConcurso);
		} catch (InfrastructureDataException e) {
			throw new DomainException(e.getMessage());
		}

	}

}
