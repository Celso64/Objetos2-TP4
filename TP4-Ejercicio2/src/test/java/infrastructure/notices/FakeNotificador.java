package infrastructure.notices;

import domain.portsuot.Notificador;

public class FakeNotificador implements Notificador {

	private Integer avisos;

	public FakeNotificador() {
		this.avisos = 0;
	}

	@Override
	public void notificar(String asunto, String cuerpoMensaje, String emailDestino) {
		this.avisos++;
	}

	public Integer getAvisos() {
		return avisos;
	}

}
