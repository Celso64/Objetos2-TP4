package infrastructure.data;

import java.util.Properties;

public abstract class ConnectionManager {

	public static Properties getProperties() {

		Properties prop = new Properties();

		String url = "jdbc:sqlite:./src/main/resources/db_participante";

		prop.put("url", url);

		return prop;
	}

}
