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
 * Data Access Object (DAO) for the Housing table.
 * Provides methos to retrieve housing data from the database.
 */
public class HousingDAO {

	private DBConnection db;

	/**
	 * Constructs a new HousingDAO and initializes the database connection manager.
	 */
	public HousingDAO() {
		db = new DBConnection();
	}

	/**
	 * Retrieves all housing records from the database
	 * 
	 * @return a list of {@link Housing} objects retrieved from the database 
	 * @throws SQLException if a database access error occurs
	 * @throws ClassNotFoundException if the database driver class is not found
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
	 * Retrieves a single {@link Housing} object from the database based on the given type ID.
	 * 
	 * @param idType the ID of the housing type to retrieve.
	 * @return a {@link Housing} object if found; otherwise, {@code null}
	 * @throws SQLException if a database access error occurs
	 * @throws ClassNotFoundException if the database driver class is not found
	 */
	public Housing selectHousing(int idType) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		String sentence = "SELECT * FROM Housing WHERE idType = ?";
		PreparedStatement ps = connection.prepareStatement(sentence);
		ps.setInt(1, idType);
		ResultSet resultSet = ps.executeQuery();

		while (resultSet.next()) {
			if (!resultSet.wasNull()) {
				Housing housing = new Housing(resultSet.getInt("idHouse"), resultSet.getString("name"),
						resultSet.getString("location"), resultSet.getInt("numGuest"), resultSet.getInt("numBedroom"),
						resultSet.getInt("numBed"), resultSet.getInt("numBath"), resultSet.getInt("idType"),
						resultSet.getDouble("price"), new ArrayList<>(), new ArrayList<>());
				return housing;
			}
		}
		resultSet.close();
		db.closeConnection(connection);
		return null;

	}

}
