package infrastructure.data;

import java.util.Properties;

public abstract class ConnectionManager {

	public static Properties getProperties() {

		Properties prop = new Properties();

		String url = "jdbc:derby://localhost:1527/participantes";
		String user = "app";
		String password = "app";

		prop.put("url", url);
		prop.put("user", user);
		prop.put("password", password);

		return prop;
	}

}
