package daxbnb.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada de manejar la conexión con la base de datos
 * 
 * @author Jonahtan, Alfredo, Diana
 */
public class DBConnection {
	public static final String URL_DB = "jdbc:mysql://localhost:3307/mydb?allowMultiQueries=true";
	public static final String USER = "user";
	public static final String PASSWORD = "userpass";
	public static final String CLASS_NAME = "com.mysql.cj.jdbc.Driver";

	/**
	 * Establece la conexión con la base de datos.
	 * 
	 * @return Conexión activa a la base de datos
	 * @throws ClassNotFoundException Si el driver no se encuentra
	 * @throws SQLException           si ocurre un error de SQL
	 */
	public Connection connect() throws ClassNotFoundException, SQLException {
		System.out.println("Try to connect");
		Class.forName(CLASS_NAME);
		Connection connection = DriverManager.getConnection(URL_DB, USER, PASSWORD);
		return connection;
	}

	/**
	 * 
	 * @param connection La conexión a cerrar
	 * @throws SQLException Si ocurre un error al cerrar la conexión
	 */
	public void closeConnection(Connection connection) throws SQLException {
		System.out.println("CLOSE CONNECTION");
		connection.close();
	}
}
