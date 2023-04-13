package main;

import java.awt.EventQueue;
import java.sql.SQLException;

import domain.portsin.DefaultPlanillaParticipante;
import infrastructure.data.ConnectionManager;
import infrastructure.data.DBInscripcionAlmacenamiento;
import infrastructure.ui.AgregarParticipante;

public class Main {

	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new AgregarParticipante(new DefaultPlanillaParticipante(
							new DBInscripcionAlmacenamiento(ConnectionManager.getProperties())));
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
	}

}
