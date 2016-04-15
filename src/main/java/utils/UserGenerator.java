package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.io.FilenameUtils;

import businessobjects.User;

public class UserGenerator {

	private static final String password = "password";
	private static final String user = "user";
	private static String path;
	private static Properties prop = new Properties();
	private static HashMap<String, User> users = new HashMap<String, User>();

	private static String generatePath(String str) {
		path = FilenameUtils.separatorsToSystem(
				new File("").getAbsolutePath() + "\\src\\main\\resources\\config\\" + str + ".properties");
		return path;
	}

	private static void loadProperties(String str) {
		File localFile = new File(generatePath(str));
		if (!localFile.isDirectory()) {
			try {
				FileInputStream fis = new FileInputStream(localFile.getAbsolutePath());
				prop.load(fis);
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static String getProperty(String propertyName) {
		String propertyValue = "";
		if ((System.getProperty(propertyName) != null)) {
			propertyValue = System.getProperty(propertyName);
		} else
			propertyValue = UserGenerator.prop.getProperty(propertyName);
		return propertyValue;
	}

	public static String userGenerate(String userName) {
		loadProperties(userName);
		User userForLogin = new User();
		userForLogin.setEmail(UserGenerator.getProperty(user));
		userForLogin.setPassword(UserGenerator.getProperty(password));
		users.put(userName, userForLogin);
		return userName;
	}

	public static User getUserFromMap(String userName) {
		return users.get(userName);
	}

}
