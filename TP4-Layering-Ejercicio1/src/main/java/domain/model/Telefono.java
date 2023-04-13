package domain.model;

import domain.portsin.DomainException;

class Telefono {

	private static String REGEX = "\\d{4}-\\d{6}";

	private String telefono;

	public Telefono(String telefono) throws DomainException {

		if (!telefono.matches(REGEX) || telefono.isBlank())
			throw new DomainException("Numero Invalido");
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return telefono;
	}

}
