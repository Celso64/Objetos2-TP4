package main;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.opencsv.CSVReader;

import domain.model.EmpleadosTabla;
import domain.portsin.Tabla;
import infrastructure.data.CSVLeerTabla;
import infrastructure.notices.EmailManager;
import infrastructure.notices.EmailNotificador;

public class App {

	private static final String DIRECCION_ARCHIVOS = "./src/main/resources";

	public static void main(String[] args) {

		try {
			CSVReader reader = new CSVReader(new FileReader(DIRECCION_ARCHIVOS + "/datos.csv"));

			Tabla tab = new EmpleadosTabla(new CSVLeerTabla(reader),
					new EmailNotificador("mailtrap@celsotest.com", EmailManager.getProperties("email")));

			tab.felicitarCumpleanieros();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
