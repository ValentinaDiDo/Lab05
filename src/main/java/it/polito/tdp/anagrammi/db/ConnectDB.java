package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	// String url = "jdbc:mysql://localhost/dizionario?user=root&password=kikkalove01";
	 
	public static Connection getConnection() {
		try {
			String url = "jdbc:mysql://localhost/dizionario?user=root&password=kikkalove01";
			return DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.err.println("Errore di connessione!");
			e.printStackTrace();
			return null;
		}
	}
}
