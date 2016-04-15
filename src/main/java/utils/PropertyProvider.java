package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FilenameUtils;

public class PropertyProvider {

	private static PropertyProvider instance = null;
	private static Properties prop = new Properties();
	private static String path = "src\\main\\resources\\config\\config.properties";

	private PropertyProvider() {
		path=FilenameUtils.separatorsToSystem(new File("").getAbsolutePath()+"\\"+path);
		loadProperties(path);
	}

	private static void loadProperties(String fullFileName) {
		File localFile = new File(fullFileName);
		if (!localFile.isDirectory()) {
			try {
				FileInputStream fis = new FileInputStream(localFile.getAbsolutePath());
				prop.load(fis);
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Exception's happend trying to load props from: " + fullFileName.toString());
			}
		}
	}

	public static String getProperty(String propertyName) {
		if (instance == null)
			instance = new PropertyProvider();

		String propertyValue = "";
		if ((System.getProperty(propertyName) != null)) {
			propertyValue = System.getProperty(propertyName);
		} else
			propertyValue = PropertyProvider.prop.getProperty(propertyName);
		return propertyValue;
	}
}
