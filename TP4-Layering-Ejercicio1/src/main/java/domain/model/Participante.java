package domain.model;

import java.util.Optional;
import java.util.Set;

import domain.portsin.DomainException;
import domain.portsin.PlanillaParticipante;
import domain.portsout.InscripcionAlmacenamiento;
import infrastructure.data.InfrastructureDataException;

public class Participante implements PlanillaParticipante {

	private Set<String> regionesDisponibles;
	private String nombre;
	private String telefono;
	private String region;
	private InscripcionAlmacenamiento almacenamiento;

	public Participante(String nombre, String telefono, String region, InscripcionAlmacenamiento almacenamiento)
			throws DomainException {

		this.regionesDisponibles = Set.of("China", "US", "Europa");

		this.almacenamiento = almacenamiento;

		this.nombre = Optional.of(nombre).orElseThrow();
		this.telefono = Optional.of(telefono).orElseThrow();
		this.region = Optional.of(region).orElseThrow();

		this.validarNombre();
		this.validarTelefono();
		this.validarRegion();

	}

	private void validarNombre() throws DomainException {
		if (this.nombre.isBlank())
			throw new DomainException("Nombre Invalido");
	}

	private void validarRegion() throws DomainException {
		if (!this.regionesDisponibles.contains(this.region))
			throw new DomainException("Region no existente");
	}

	private void validarTelefono() throws DomainException {
		String regex = "\\d{4}-\\d{6}";
		if (!this.telefono.matches(regex) || this.telefono.isBlank())
			throw new DomainException("Numero Invalido");
	}

	@Override
	public void inscribir() throws InfrastructureDataException {

		this.almacenamiento.inscribir(nombre, telefono, region);

	}

}
