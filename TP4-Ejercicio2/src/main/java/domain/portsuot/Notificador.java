package domain.portsuot;

public interface Notificador {

	void notificar(String asunto, String cuerpoMensaje, String emailDestino);

}
