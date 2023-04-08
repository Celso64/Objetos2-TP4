package main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.model.Participante;
import fakeObjects.FakeInscripcionAlmacenamiento;

class TestUnitario {

	private Participante participante;
	private FakeInscripcionAlmacenamiento almacenamiento;

	@BeforeEach
	void inicializacion() {
		this.almacenamiento = new FakeInscripcionAlmacenamiento();
		this.participante = null;
	}

	@Test
	void agregarParticipante() {

		try {
			this.participante = new Participante("Charles", "2920457841", "US", almacenamiento);
			this.participante.inscribir();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String textoEsperado = "Charles, 2920457841, US";

		assertEquals(textoEsperado, almacenamiento.getResultadoInscripcion());

	}

}
