package daxbnb.loadScript;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;

import daxbnb.DAO.DBConnection;

/**
 * Ejecuta un script SQL para crear la base de datos.
 * 
 * Lee el archivo SQL, se conecta a la base de datos, ejecuta el script y cierra
 * la conexión. El script debe estar en: scripts/CreateTableBBDD.sql
 * 
 * @author Alfredo, Jonathan, Diana
 * 
 */
public class ScriptsMain {

	public static void main(String[] args) {
		try {
			String sql = new String(Files.readAllBytes(Paths.get("scripts/CreateTableBBDD.sql")));

			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.connect();

			Statement stmt = connection.createStatement();
			stmt.execute(sql);

			System.out.println("Base de datos creada correctamente.");

			dbConnection.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}