package com.ss.api.util.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author CHIDUSD
 */
public class FileUtility {
	
	/**
	 * Returns data from properties file using key
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fileInputStream = new FileInputStream("./app_config_files/appConfigData.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		String data = properties.getProperty(key);
		return data;
	}
}
