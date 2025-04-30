package daxbnb.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
<<<<<<< HEAD
 * Esta clase proporciona métodos para establecer y cerrar conexiones con la
 * base de datos utilizando JDBC (Java Database Connectivity).
 * 
 * @author Alfredo, Jonathan, Diana
=======
 * Clase encargada de manejar la conexión con la base de datos
 * 
 * @author Jonahtan, Alfredo, Diana
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
 */
public class DBConnection {
	public static final String URL_DB = "jdbc:mysql://localhost:3307/mydb?allowMultiQueries=true";
	public static final String USER = "user";
	public static final String PASSWORD = "userpass";
	public static final String CLASS_NAME = "com.mysql.cj.jdbc.Driver";

	/**
<<<<<<< HEAD
	 * Establece una conexión con la base de datos.
	 * 
	 * @return un objeto {@link Connection} que representa la conexión activa
	 * @throws ClassNotFoundException si no se encuentra el driver JDBC
	 * @throws SQLException           si ocurre un error al intentar conectarse a la
	 *                                base de datos
=======
	 * Establece la conexión con la base de datos.
	 * 
	 * @return Conexión activa a la base de datos
	 * @throws ClassNotFoundException Si el driver no se encuentra
	 * @throws SQLException           si ocurre un error de SQL
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public Connection connect() throws ClassNotFoundException, SQLException {
		System.out.println("Intentando conectar");
		Class.forName(CLASS_NAME);
		Connection connection = DriverManager.getConnection(URL_DB, USER, PASSWORD);
		return connection;
	}

	/**
<<<<<<< HEAD
	 * Cierra la conexión proporcionada con la base de datos.
	 * 
	 * @param connection el objeto {@link Connection} que se desea cerrar
	 * @throws SQLException si ocurre un error al cerrar la conexión
=======
	 * 
	 * @param connection La conexión a cerrar
	 * @throws SQLException Si ocurre un error al cerrar la conexión
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public void closeConnection(Connection connection) throws SQLException {
		System.out.println("CERRANDO CONEXIÓN");
		connection.close();
	}
}