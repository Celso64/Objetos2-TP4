package domain.portsin;

import domain.portsout.InfrastructureDataException;

public interface PlanillaParticipante {

	void inscribir(ParticipanteDTO participante) throws InfrastructureDataException, DomainException;

}
