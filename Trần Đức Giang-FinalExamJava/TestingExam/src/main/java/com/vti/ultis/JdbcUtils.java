package com.vti.ultis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.vti.ultis.properties.DatabaseProperties;

public class JdbcUtils {

	private static Connection connection;

	private static DatabaseProperties databaseproperties;

	
	public static void connectForTesting()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException, SQLException {

		databaseproperties = new DatabaseProperties();
		String url = databaseproperties.getProperty("url");
		String username = databaseproperties.getProperty("username");
		String password = databaseproperties.getProperty("password");

		// Step 1: register the driver class with DriverManager
		Class.forName(databaseproperties.getProperty("driver"));

		// Step 2: get a Database Connection
		connection = DriverManager.getConnection(url, username, password);

		System.out.println("Connect success!");
	}

	
	public static Connection connect()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException, SQLException {

		databaseproperties = new DatabaseProperties();
		String url = databaseproperties.getProperty("url");
		String username = databaseproperties.getProperty("username");
		String password = databaseproperties.getProperty("password");

		// Step 1: register the driver class with DriverManager
		Class.forName(databaseproperties.getProperty("driver"));

		// Step 2: get a Database Connection
		connection = DriverManager.getConnection(url, username, password);

		return connection;
	}

	public static void disconnect() throws SQLException {
		connection.close();
	}
}
