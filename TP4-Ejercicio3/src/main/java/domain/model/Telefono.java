package domain.model;

import java.util.Objects;

import domain.portsin.DomainException;

class Telefono {

	private static String REGEX = "\\d{4}-\\d{6}";

	private String telefono;

	public Telefono(String telefono) throws DomainException {

		Objects.requireNonNull(telefono, "Telefono Nulo");

		if (!telefono.matches(REGEX) || telefono.isBlank())
			throw new DomainException("Telefono Invalido");

		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return telefono;
	}

}
