package main;

import javax.swing.SwingUtilities;

import domain.model.DefaultGestionConcurso;
import infrastructure.data.ConnectionManager;
import infrastructure.data.DBEscritorDatos;
import infrastructure.data.DBLectorDatos;
import infrastrucuture.ui.RadioCompetition;

public class App {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new App().start();
				} catch (Exception e) {
					// log exception...
					System.out.println(e);
				}
			}
		});
	}

	private void start() throws Exception {

		new RadioCompetition(new DefaultGestionConcurso(new DBLectorDatos(ConnectionManager.getConexion()),
				new DBEscritorDatos(ConnectionManager.getConexion())));
	}

}
