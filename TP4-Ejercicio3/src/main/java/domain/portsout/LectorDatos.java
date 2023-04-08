package domain.portsout;

import java.util.List;

import domain.model.Concurso;
import domain.model.Participante;
import infrastructure.data.InfrastructureDataException;

public interface LectorDatos {

	List<Participante> getParticipantes() throws InfrastructureDataException;

	List<Concurso> getConcursos() throws InfrastructureDataException;

}
