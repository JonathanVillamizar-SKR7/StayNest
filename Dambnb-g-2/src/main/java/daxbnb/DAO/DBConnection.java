package daxbnb.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static final String URL_DB = "jdbc:mysql://localhost:3307/mydb?allowMultiQueries=true";
	public static final String USER = "user";
	public static final String PASSWORD = "userpass";
	public static final String CLASS_NAME = "com.mysql.cj.jdbc.Driver";

	public Connection connect() throws ClassNotFoundException, SQLException {
		System.out.println("Try to connect");
		Class.forName(CLASS_NAME);
		Connection connection = DriverManager.getConnection(URL_DB, USER, PASSWORD);
		return connection;
	}

	public void closeConnection(Connection connection) throws SQLException {
		System.out.println("CLOSE CONNECTION");
		connection.close();
	}
}
