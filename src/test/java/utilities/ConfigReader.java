package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties property;
	
	static {
		try {
			String path="./src/test/resources/test_data/"
					+ "configuration.properties";
			FileInputStream input=new FileInputStream(path);
			property=new Properties();
			property.load(input);
			input.close();
		}catch(Exception e) {
			System.out.println("Error in ConfigReader class");
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		return property.getProperty(key);
	}
}
