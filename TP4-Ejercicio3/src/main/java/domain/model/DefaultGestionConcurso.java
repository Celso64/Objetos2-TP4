package domain.model;

import java.util.List;
import java.util.Objects;

import domain.portsin.DomainException;
import domain.portsin.GestionConcurso;
import domain.portsin.ParticipanteDTO;
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
			// Aclaracion: Filtro aca y no con SQL porque el motor SQLite no soporta tipo
			// Date
			return lector.getConcursos().stream().filter(Concurso::estaVigente).toList();

		} catch (InfrastructureDataException e) {
			throw new DomainException(e.getMessage());
		}
	}

	@Override
	public void saveInscription(ParticipanteDTO participanteDTO) throws DomainException {

		try {

			Participante p = new Participante(participanteDTO.nombre(), participanteDTO.apellido(),
					participanteDTO.telefono(), participanteDTO.email(), participanteDTO.idConcurso());

			escritor.salvarParticipante(p.getNombre(), p.getApellido(), p.getTelefono(), p.getEmail(),
					p.getIdConcurso());
		} catch (InfrastructureDataException e) {
			throw new DomainException(e.getMessage());
		}

	}

}
