package main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

import org.junit.jupiter.api.Test;

import com.opencsv.CSVReader;

import domain.model.EmpleadosTabla;
import domain.portsin.Tabla;
import infrastructure.data.CSVLeerTabla;
import infrastructure.notices.EmailManager;
import infrastructure.notices.FakeNotificador;

class TestUnitario {

	private static final String DIRECCION_ARCHIVOS = "./src/test/resources";

	@Test
	void unEmpleadoCumpleAños() {

		FakeNotificador notificador = new FakeNotificador();
		Tabla tab;
		try {
			tab = new EmpleadosTabla(
					new CSVLeerTabla(new CSVReader(new FileReader(DIRECCION_ARCHIVOS + "/datosDePrueba.csv"))),
					notificador);

			tab.felicitarCumpleanieros();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Integer felicitados = notificador.getAvisos();

		assertEquals(1, felicitados);

	}

	@Test
	void archivoMalHecho() {

		FakeNotificador notificador = new FakeNotificador();
		String error_mensaje = "";
		Exception ex = null;
		try {
			CSVLeerTabla reader = new CSVLeerTabla(
					new CSVReader(new FileReader(DIRECCION_ARCHIVOS + "/datosDePruebaMalos.csv")));
			ex = assertThrows(Exception.class, () -> {

				@SuppressWarnings("unused")
				Tabla tab = new EmpleadosTabla(reader, notificador);
			});

			error_mensaje = 1 + " filas incompletas";

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		assertEquals(error_mensaje, ex.getMessage());
	}

	@Test
	void elEmailManagerAnda() {

		Properties prop = EmailManager.getProperties("emailTest");

		assertEquals("test", prop.get("username"));
		assertEquals("1234", prop.get("password"));
		assertEquals("1234", prop.get("mail.smtp.port"));
		assertEquals("localhost", prop.get("mail.smtp.host"));

	}

}
