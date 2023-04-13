package domain.portsin;

import domain.model.Participante;
import domain.portsout.InfrastructureDataException;
import domain.portsout.InscripcionAlmacenamiento;

public class DefaultPlanillaParticipante implements PlanillaParticipante {

	private InscripcionAlmacenamiento almacenamiento;

	public DefaultPlanillaParticipante(InscripcionAlmacenamiento almacenamiento) {
		this.almacenamiento = almacenamiento;
	}

	@Override
	public void inscribir(ParticipanteDTO participanteDTO) throws InfrastructureDataException, DomainException {

		Participante participante = new Participante(participanteDTO.nombre(), participanteDTO.telefono(),
				participanteDTO.region());

		this.almacenamiento.inscribir(participante.getNombre(), participante.getTelefono(), participante.getRegion());

	}

}
