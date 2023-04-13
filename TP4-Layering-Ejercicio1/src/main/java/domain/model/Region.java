package domain.model;

import java.util.Set;

import domain.portsin.DomainException;

class Region {

	private static Set<String> REGIONES_DISPONIBLES = Set.of("China", "US", "Europa");

	private String region;

	public Region(String region) throws DomainException {

		if (!REGIONES_DISPONIBLES.contains(region))
			throw new DomainException("Region no existente");

		this.region = region;
	}

	@Override
	public String toString() {
		return region;
	}

}
