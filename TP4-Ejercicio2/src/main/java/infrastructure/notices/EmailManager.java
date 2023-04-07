package infrastructure.notices;

import java.util.Properties;
import java.util.ResourceBundle;

public abstract class EmailManager {

	public static Properties getProperties(String nombreProperties) {
		Properties prop = new Properties();

		try {
			ResourceBundle infoDataBase = ResourceBundle.getBundle(nombreProperties);
			prop.setProperty("mail.smtp.host", infoDataBase.getString("mail.smtp.host"));
			prop.setProperty("mail.smtp.port", infoDataBase.getString("mail.smtp.port"));
			prop.setProperty("username", infoDataBase.getString("email.user"));
			prop.setProperty("password", infoDataBase.getString("email.password"));
			prop.setProperty("mail.smtp.auth", infoDataBase.getString("mail.smtp.auth"));
			prop.setProperty("mail.smtp.starttls.enable", infoDataBase.getString("mail.smtp.starttls.enable"));

		} catch (Exception e1) {
			System.out.println(e1);
			throw new RuntimeException("Ocurrio un error al leer la configuraci�n desde el archivo");
		}
		return prop;

	}

}
