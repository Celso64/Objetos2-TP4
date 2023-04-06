package domain.model;

import java.util.Optional;
import java.util.Set;

import domain.portsin.PlanillaParticipante;
import domain.portsout.InscripcionAlmacenamiento;

public class Participante implements PlanillaParticipante {

	private Set<String> regionesDisponibles;
	private String nombre;
	private String telefono;
	private String region;
	private InscripcionAlmacenamiento almacenamiento;

	public Participante(String nombre, String telefono, String region, InscripcionAlmacenamiento almacenamiento) {

		this.regionesDisponibles = Set.of("China", "US", "Europa");

		this.almacenamiento = almacenamiento;

		this.nombre = Optional.of(nombre).orElseThrow(RuntimeException::new);
		this.telefono = Optional.of(telefono).orElseThrow(RuntimeException::new);
		this.region = Optional.of(region).orElseThrow(RuntimeException::new);

		this.validarNombre();
		this.validarTelefono();
		this.validarRegion();

	}

	private void validarNombre() {
		if (this.nombre.isBlank())
			throw new RuntimeException("Nombre Invalido");
	}

	private void validarRegion() {
		if (!this.regionesDisponibles.contains(this.region))
			throw new RuntimeException("Region no existente");
	}

	private void validarTelefono() {
		String regex = "\\d{4}-\\d{6}";
		if (this.telefono.matches(regex) || this.telefono.isBlank())
			throw new RuntimeException("Numero Invalido");
	}

	@Override
	public void inscribir() {

		this.almacenamiento.inscribir(nombre, telefono, region);

	}

}
