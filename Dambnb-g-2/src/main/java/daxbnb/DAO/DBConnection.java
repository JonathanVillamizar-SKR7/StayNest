package daxbnb.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
<<<<<<< HEAD
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
=======
 * Proporciona conexión y cierre a la base de datos.
 * 
 * @author Alfredo, Jonathan, Diana
>>>>>>> 89d4511 (JavaDoc 5.02)
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
<<<<<<< HEAD
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
=======
	 * Establece conexión con la base de datos
	 * 
	 * @return conexión a la BD
	 * @throws ClassNotFoundException 
	 * @throws SQLException           
	 */

>>>>>>> 89d4511 (JavaDoc 5.02)
	public Connection connect() throws ClassNotFoundException, SQLException {
		System.out.println("Intentando conectar");
		Class.forName(CLASS_NAME);
		Connection connection = DriverManager.getConnection(URL_DB, USER, PASSWORD);
		return connection;
	}

	/**
<<<<<<< HEAD
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
=======
	 * Cierra la conexión
	 * 
	 * @param connection conexión a cerrar
	 * @throws SQLException 
>>>>>>> 89d4511 (JavaDoc 5.02)
	 */
	public void closeConnection(Connection connection) throws SQLException {
		System.out.println("CERRANDO CONEXIÓN");
		connection.close();
	}
}