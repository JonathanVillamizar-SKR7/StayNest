package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import daxbnb.DAO.DBConnection;

public class Main {
	public static void main(String[] args) {
		DBConnection db = new DBConnection();
		Connection connection = null;

		// Connect
		try {
			connection = db.connect();
			System.out.println("Connection established.");
		} catch (ClassNotFoundException e) {
			System.err.println("Error: Driver not found.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Error connecting to Data Base.");
			e.printStackTrace();
		}

		// Disconnect
		try {
			db.closeConnection(connection);
			System.out.println("Connection closed.");
		} catch (SQLException e) {
			System.err.println("Error closing connection.");
			e.printStackTrace();
		}
	}
}
