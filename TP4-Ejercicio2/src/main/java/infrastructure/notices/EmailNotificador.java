package infrastructure.notices;

import java.util.Objects;
import java.util.Properties;

import domain.portsuot.Notificador;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailNotificador implements Notificador {

	private String correoOrigen;
	private Properties propiedades;
	private Session session;

	public EmailNotificador(String correoOrigen, Properties propiedades) {
		this.correoOrigen = Objects.requireNonNull(correoOrigen);
		this.propiedades = Objects.requireNonNull(propiedades);
	}

	@Override
	public void notificar(String asunto, String cuerpoMensaje, String emailDestino) {
		session = Session.getInstance(propiedades, new jakarta.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(propiedades.getProperty("username"),
						propiedades.getProperty("password"));
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(this.correoOrigen));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(emailDestino));
			message.setSubject(asunto);
			message.setText(cuerpoMensaje);
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
