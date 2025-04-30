package daxbnb.loadScript;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;

import daxbnb.DAO.DBConnection;

/**
 * Clase principal que se encarga de ejecutar un script SQL para crear la base
 * de datos.
 * 
 * Esta clase lee un archivo SQL ubicado en el sistema de archivos, establece
 * una conexión con la base de datos, ejecuta el script contenido en el archivo
 * y luego cierra la conexión.
 * 
 * @author Alfredo, Jonathan, Diana
 */
public class scriptsMain {
	/**
	 * Método principal que se ejecuta al iniciar el programa.
	 * 
	 * @param args Argumentos de la línea de comandos (no se utilizan).
	 */
	public static void main(String[] args) {
		try {
			String sql = new String(Files.readAllBytes(Paths.get("scripts/CreateTableBBDD.sql")));
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.connect(); // Abrimos la conexion
			Statement stmt = connection.createStatement(); // Creamos el statement que se crea a partir de la conexion y
															// sirve para enviar instruciones SQL
			stmt.execute(sql);// Aqui ejecutamos el sql con el statement
			System.out.println("Base de datos creada correctamente.");

			dbConnection.closeConnection(connection); // cerramos la conexion

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}