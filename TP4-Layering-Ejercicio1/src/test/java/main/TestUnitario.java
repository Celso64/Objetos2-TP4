package main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.portsin.DefaultPlanillaParticipante;
import domain.portsin.ParticipanteDTO;
import fakeObjects.FakeInscripcionAlmacenamiento;

class TestUnitario {

	private DefaultPlanillaParticipante planilla;
	private FakeInscripcionAlmacenamiento almacenamiento;

	@BeforeEach
	void inicializacion() {
		this.almacenamiento = new FakeInscripcionAlmacenamiento();
		this.planilla = null;
	}

	@Test
	void agregarParticipante() {

		try {
			this.planilla = new DefaultPlanillaParticipante(almacenamiento);

			this.planilla.inscribir(new ParticipanteDTO("Charles", "2920-457841", "US"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		String textoEsperado = "Charles, 2920-457841, US";

		assertEquals(textoEsperado, almacenamiento.getResultadoInscripcion());

	}

}
