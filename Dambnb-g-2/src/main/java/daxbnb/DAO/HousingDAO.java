package daxbnb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import daxbnb.DAO.DBConnection;
import daxbnb.model.Housing;

/**
 * Gestiona operaciones de base de datos para viviendas.
 * 
 * @author Alfredo, Jonathan, Diana
 */
public class HousingDAO {
	/** Conexión a la base de datos. */
	private DBConnection db;

	/**
	 * Constructor que inicializa la conexión.
	 */

	public HousingDAO() {
		db = new DBConnection();
	}

	/**
	 * Obtiene todas las viviendas de la base de datos.
	 * 
	 * @return lista de viviendas
	 * @throws SQLException           si hay error en la consulta
	 * @throws ClassNotFoundException si no se encuentra el driver
	 */
	public List<Housing> selectAll() throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		String sentence = "SELECT * FROM Housing";
		PreparedStatement ps = connection.prepareStatement(sentence);
		ResultSet resultSet = ps.executeQuery();
		List<Housing> housings = new ArrayList<>();

		while (resultSet.next()) {
			if (!resultSet.wasNull()) {
				Housing housing = new Housing(resultSet.getInt("idHouse"), resultSet.getString("name"),
						resultSet.getString("location"), resultSet.getInt("numGuest"), resultSet.getInt("numBedroom"),
						resultSet.getInt("numBed"), resultSet.getInt("numBath"), resultSet.getInt("idType"),
						resultSet.getDouble("price"), new ArrayList<>(), // images
						new ArrayList<>() // facilities
				);

				housings.add(housing);
			}
		}
		resultSet.close();
		db.closeConnection(connection);
		return housings;

	}

	/**
	 * Busca una vivienda según id, nombre y tipo.
	 * 
	 * @param idHouse
	 * @param name
	 * @param idType
	 * @return vivienda encontrada o null
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public Housing selectHousing(int idHouse, String name, int idType) throws SQLException, ClassNotFoundException {
		return null;

	}

}
