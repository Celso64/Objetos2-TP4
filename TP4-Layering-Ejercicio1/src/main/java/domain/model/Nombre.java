package domain.model;

import domain.portsin.DomainException;

class Nombre {

	private String nombre;

	public Nombre(String nombre) throws DomainException {

		if (nombre.isBlank())
			throw new DomainException("Nombre Invalido");

		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}

}
