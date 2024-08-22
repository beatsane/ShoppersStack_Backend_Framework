package com.ss.api.util.generic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.parser.ParseException;

import com.mysql.cj.jdbc.Driver;

/**
 * @author CHIDUSD
 */
public class DatabaseUtility {

	static Connection connection = null;
	static ResultSet resultSet = null;
	static JsonUtility jsonUtility = new JsonUtility();

	/**
	 * Connects to database using URL,username,password
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void connectToDatabase() throws SQLException, IOException, ParseException {
		String db_URL = jsonUtility.getDataFromJsonFile("db_URL");
		String db_userName = jsonUtility.getDataFromJsonFile("db_username");
		String db_password = jsonUtility.getDataFromJsonFile("db_password");
		Driver driver;

		try {
			driver = new Driver();
			DriverManager.registerDriver(driver);
			connection = DriverManager.getConnection(db_URL, db_userName, db_password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves data from database as key value pairs
	 * 
	 * @param query
	 * @return
	 */
	public static ResultSet getResultFromDatabase(String query) {
		try {
			resultSet = connection.createStatement().executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	/**
	 * Closes the database connection
	 * 
	 * @throws SQLException
	 */
	public static void closeDatabaseConnection() throws SQLException {
		connection.close();
	}
}
