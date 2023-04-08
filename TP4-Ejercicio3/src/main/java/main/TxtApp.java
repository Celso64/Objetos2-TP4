package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.SwingUtilities;

import domain.model.DefaultGestionConcurso;
import infrastructure.data.TXTEscritorDatos;
import infrastructure.data.TXTLectorDatos;
import infrastrucuture.ui.RadioCompetition;

public class TxtApp {

	private static final File FILE_PARTICIPANTES = new File("./src/main/resources/participantes.txt");
	private static final File FILE_CONCURSOS = new File("./src/main/resources/concursos.txt");

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new TxtApp().start();
				} catch (Exception e) {
					// log exception...
					System.out.println(e);
				}
			}
		});
	}

	private void start() throws Exception {

		FileInputStream inputParticipantes = new FileInputStream(FILE_PARTICIPANTES);
		FileInputStream inputConcursos = new FileInputStream(FILE_CONCURSOS);

		FileOutputStream outputParticipantes = new FileOutputStream(FILE_PARTICIPANTES, true);
		FileOutputStream outputConcursos = new FileOutputStream(FILE_CONCURSOS, true);

		new RadioCompetition(new DefaultGestionConcurso(new TXTLectorDatos(inputParticipantes, inputConcursos),
				new TXTEscritorDatos(outputParticipantes, outputConcursos)));
	}

}
