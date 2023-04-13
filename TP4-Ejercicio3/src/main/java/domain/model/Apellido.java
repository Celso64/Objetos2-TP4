package domain.model;

import java.util.Objects;

import domain.portsin.DomainException;

class Apellido {

	private String apellido;

	public Apellido(String apellido) throws DomainException {

		Objects.requireNonNull(apellido, "Apellido Nulo");

		if (apellido.isBlank())
			throw new DomainException("No debe estar vacio");

		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return apellido;
	}

}
