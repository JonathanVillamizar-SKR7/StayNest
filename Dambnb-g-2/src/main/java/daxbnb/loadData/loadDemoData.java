package daxbnb.loadData;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;

import daxbnb.DAO.DBConnection;

public class loadDemoData {
public static void main(String[] args) {
	try {
		// Leer el archivo SQL que contiene los INSERT
		String sql = new String(Files.readAllBytes(Paths.get("scripts/Procedures.sql")));
		// Conexión a la base de datos
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.connect(); 
		
		//Creamos el statement y ejecutamos el sql 
		Statement stmt = connection.createStatement();
		stmt.execute(sql);

        System.out.println("Datos insertados correctamente.");
        
        //Cerramos la conexion
        dbConnection.closeConnection(connection);
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
