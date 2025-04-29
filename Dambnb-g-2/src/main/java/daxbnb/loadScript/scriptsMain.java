package daxbnb.loadScript;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;

import daxbnb.DAO.DBConnection;

/**
 * Clase principal para ejecutar el script de creación de tablas en la base de
 * datos.
 * 
 * @author Alfredo, Jonathan, Diana
 */
public class scriptsMain {
	/**
	 * Ejecuta el script SQL ubicado en scripts/CreateTableBBDD.sql
	 * 
	 * 
	 * @param args Argumentos de la línea de comandos (en este caso no se utilizan)
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
