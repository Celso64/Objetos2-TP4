package fakeObjects;

import domain.portsout.InscripcionAlmacenamiento;

public class FakeInscripcionAlmacenamiento implements InscripcionAlmacenamiento {

	private String resultadoInscripcion;

	public FakeInscripcionAlmacenamiento() {
		this.resultadoInscripcion = "";
	}

	@Override
	public void inscribir(String nombre, String telefono, String region) {

		StringBuffer inscripcion = new StringBuffer(64);

		inscripcion.append(nombre).append(", ").append(telefono).append(", ").append(region);

		this.resultadoInscripcion = inscripcion.toString();

	}

	public String getResultadoInscripcion() {
		return resultadoInscripcion;
	}

}
