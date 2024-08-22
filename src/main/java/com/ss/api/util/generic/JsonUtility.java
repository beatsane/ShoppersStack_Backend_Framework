package com.ss.api.util.generic;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author CHIDUSD
 */
public class JsonUtility {
	
	/**
	 * Get data from json file using key
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public String getDataFromJsonFile(String key) throws IOException, ParseException {
		FileReader fileReader = new FileReader("./app_config_files/appConfigData.json");
		JSONParser jsonParser = new JSONParser();
		Object object = jsonParser.parse(fileReader);
		JSONObject jsonObject = (JSONObject) object;
		String data = (String) jsonObject.get(key);
		return data;
	}
}
