package domain.model;

import java.util.Objects;

import domain.portsin.DomainException;

public class Nombre {

	private String nombre;

	public Nombre(String nombre) throws DomainException {

		Objects.requireNonNull(nombre, "Nombre Nulo");

		if (nombre.isBlank())
			throw new DomainException("No debe estar vacio");

		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}

}
