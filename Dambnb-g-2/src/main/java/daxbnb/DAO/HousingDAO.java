package daxbnb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import daxbnb.DAO.DBConnection;
<<<<<<< HEAD
import daxbnb.model.Facilities;
import daxbnb.model.Housing;
import daxbnb.model.Images;

/**
 * Data Access Object (DAO) for the Housing table. Provides methods to retrieve
 * housing data from the database.
 */
public class HousingDAO {
	private static final String SELECT_ALL = "SELECT * FROM Housing";
	private static final String SELECT_BY_TYPE = "SELECT * FROM Housing WHERE idType = ?";
	private static final String SELECT_BY_BEDROOM = "SELECT * FROM Housing WHERE numBedroom = ?";
	private static final String INSERT_HOUSING = "INSERT INTO Housing (name, location, numGuest, numBedroom, numBed, numBath, idType, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private DBConnection db;

	/**
	 * Constructs a new HousingDAO and initializes the database connection manager.
	 */
=======
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

>>>>>>> 09e51f5682343e54753144ba76038887edffc7fc
	public HousingDAO() {
		db = new DBConnection();
	}

	/**
<<<<<<< HEAD
	 * Retrieves all housing records from the database
	 * 
	 * @return a list of {@link Housing} objects retrieved from the database
	 * @throws SQLException           if a database access error occurs
	 * @throws ClassNotFoundException if the database driver class is not found
	 */
	public List<Housing> selectAll() throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
=======
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
>>>>>>> 09e51f5682343e54753144ba76038887edffc7fc
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
<<<<<<< HEAD
	 * Retrieves a single {@link Housing} object from the database based on the
	 * given type ID.
	 * 
	 * @param idType the ID of the housing type to retrieve.
	 * @return a {@link Housing} object if found; otherwise, {@code null}
	 * @throws SQLException           if a database access error occurs
	 * @throws ClassNotFoundException if the database driver class is not found
	 */
	public Housing selectHousingByType(int idType) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_BY_TYPE);
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
=======
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
>>>>>>> 09e51f5682343e54753144ba76038887edffc7fc
		return null;

	}

<<<<<<< HEAD
	public Housing selectHousingByBedroom(int numBedroom) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_BY_BEDROOM);
		ps.setInt(1, numBedroom);
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

	public int insertHousing(String name, String location, int numGuest, int numBedroom, int numBed,
			int numBath, int idType, double price, List<Images> images, List<Facilities> facilities)
			throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(INSERT_HOUSING, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, name);
		ps.setString(2, location);
		ps.setInt(3, numGuest);
		ps.setInt(4, numBedroom);
		ps.setInt(5, numBed);
		ps.setInt(6, numBath);
		ps.setInt(7, idType);
		ps.setDouble(8, price);
		
		int affectedRows = ps.executeUpdate();
		if (affectedRows == 0) {
			throw new SQLException("No se pudo insertar la vivienda");
		}
		
		int generateId = -1;
		ResultSet generateKeys = ps.getGeneratedKeys();
		if (generateKeys.next()) {
			generateId = generateKeys.getInt(1);
		}
		db.closeConnection(connection);
		return generateId;
	}

=======
>>>>>>> 09e51f5682343e54753144ba76038887edffc7fc
}
