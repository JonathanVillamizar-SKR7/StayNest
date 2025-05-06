package daxbnb.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * Esta clase proporciona métodos para establecer y cerrar conexiones con la
 * base de datos utilizando JDBC (Java Database Connectivity).
 * 
 * @author Alfredo, Jonathan, Diana
 * 
 * 
 * @author Alfredo, Jonathan, Diana
 * 
 */
public class DBConnection {
	/** URL de la base de datos. */
	public static final String URL_DB = "jdbc:mysql://localhost:3307/mydb?allowMultiQueries=true";
	/** Usuario de la base de datos. */
	public static final String USER = "user";

	/** Contraseña del usuario. */
	public static final String PASSWORD = "userpass";
	/** Clase del driver JDBC. */
	public static final String CLASS_NAME = "com.mysql.cj.jdbc.Driver";

	/**
	 * 
	 * Establece una conexión con la base de datos.
	 * 
	 * @return un objeto {@link Connection} que representa la conexión activa
	 * @throws ClassNotFoundException si no se encuentra el driver JDBC
	 * @throws SQLException           si ocurre un error al intentar conectarse a la
	 *                                base de datos
	 * 
	 */
	/**
	 * Establece conexión con la base de datos
	 * 
	 * @return conexión a la BD
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public Connection connect() throws ClassNotFoundException, SQLException {
		System.out.println("Intentando conectar");
		Class.forName(CLASS_NAME);
		Connection connection = DriverManager.getConnection(URL_DB, USER, PASSWORD);
		return connection;
	}

	/**
	 * 
	 * Cierra la conexión proporcionada con la base de datos.
	 * 
	 * @param connection el objeto {@link Connection} que se desea cerrar
	 * @throws SQLException si ocurre un error al cerrar la conexión
	 * 
	 * 
	 */
	public void closeConnection(Connection connection) throws SQLException {
		System.out.println("CERRANDO CONEXIÓN");
		connection.close();
	}
}