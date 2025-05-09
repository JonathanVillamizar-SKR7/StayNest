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
import daxbnb.model.Types;

/**
 * Clase DAO para gestionar operaciones CRUD en la tabla 'Housing'. Proporciona
 * métodos para insertar, actualizar, eliminar y consultar viviendas.
 */
public class HousingDAO {
	private static final String SELECT_ALL = "SELECT * FROM Housing";
	private static final String SELECT_BY_ID = "SELECT * FROM Housing WHERE idHouse = ?";
	private static final String SELECT_BY_TYPE = "SELECT * FROM Housing WHERE idType = ?";
	private static final String SELECT_BY_BEDROOM = "SELECT * FROM Housing WHERE numBedroom = ?";
	private static final String INSERT_HOUSING = "INSERT INTO Housing (name, location, numGuest, numBedroom, numBed, numBath, idType, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_HOUSING = "UPDATE Housing SET name = ?, location = ?, numGuest = ?, numBedroom = ?, numBed = ?, numBath = ?, idType = ?, price = ? WHERE idHouse = ?";
	private static final String DELETE_HOUSING = "DELETE FROM Housing WHERE idHouse = ?";

	private DBConnection db;

	/**
	 * Constructor que inicializa la conexión con la base de datos.
	 */
	public HousingDAO() {
		db = new DBConnection();
	}

	/**
	 * Selecciona todas las viviendas de la base de datos.
	 * 
	 * @return Lista de objetos Housing con todas las viviendas registradas.
	 * @throws SQLException           si ocurre un error al ejecutar la consulta
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public List<Housing> selectAll() throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
		ResultSet resultSet = ps.executeQuery();
		List<Housing> housings = new ArrayList<>();

		TypesDAO typesDAO = new TypesDAO();
		while (resultSet.next()) {
			if (!resultSet.wasNull()) {
				Types types = typesDAO.selectById(resultSet.getInt("idType"));
				Housing housing = new Housing(resultSet.getInt("idHouse"), resultSet.getString("name"),
						resultSet.getString("location"), resultSet.getInt("numGuest"), resultSet.getInt("numBedroom"),
						resultSet.getInt("numBed"), resultSet.getInt("numBath"), types, resultSet.getDouble("price"),
						new ArrayList<>(), new ArrayList<>());

				housings.add(housing);
			}
		}
		resultSet.close();
		db.closeConnection(connection);
		return housings;
	}

	/**
	 * Selecciona una vivienda específica por su ID.
	 * 
	 * @param idHouse ID de la vivienda a buscar.
	 * @return Objeto Housing correspondiente al ID proporcionado, o null si no
	 *         existe.
	 * @throws SQLException           si ocurre un error al ejecutar la consulta
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public Housing selectById(int idHouse) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID);
		ps.setInt(1, idHouse);
		ResultSet rs = ps.executeQuery();
		TypesDAO typesDAO = new TypesDAO();
		Housing housing = null;

		if (rs.next()) {
			Types type = typesDAO.selectById(rs.getInt("idType"));
			housing = new Housing(rs.getInt("idHouse"), rs.getString("name"), rs.getString("location"),
					rs.getInt("numGuest"), rs.getInt("numBedroom"), rs.getInt("numBed"), rs.getInt("numBath"), type,
					rs.getDouble("price"), new ArrayList<>(), new ArrayList<>());
		}
		rs.close();
		db.closeConnection(connection);
		return housing;
	}


	/**
	 * Inserta una nueva vivienda en la base de datos.
	 * 
	 * @param name       Nombre de la vivienda.
	 * @param location   Ubicación de la vivienda.
	 * @param numGuest   Número de huéspedes permitidos.
	 * @param numBedroom Número de habitaciones.
	 * @param numBed     Número de camas.
	 * @param numBath    Número de baños.
	 * @param idType     Tipo de vivienda.
	 * @param price      Precio por noche.
	 * @return El ID generado de la nueva vivienda.
	 * @throws SQLException           si ocurre un error al ejecutar la inserción.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public int insertHousing(String name, String location, int numGuest, int numBedroom, int numBed, int numBath,
			int idType, double price) throws SQLException, ClassNotFoundException {
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

		int generatedId = -1;
		ResultSet generatedKeys = ps.getGeneratedKeys();
		if (generatedKeys.next()) {
			generatedId = generatedKeys.getInt(1);
		}
		ps.close();
		db.closeConnection(connection);
		return generatedId;
	}

	/**
	 * Actualiza una vivienda existente en la base de datos.
	 * 
	 * @param idHouse    ID de la vivienda a actualizar.
	 * @param name       Nombre de la vivienda.
	 * @param location   Ubicación de la vivienda.
	 * @param numGuest   Número de huéspedes permitidos.
	 * @param numBedroom Número de habitaciones.
	 * @param numBed     Número de camas.
	 * @param numBath    Número de baños.
	 * @param idType     Tipo de vivienda.
	 * @param price      Precio por noche.
	 * @return El número de filas afectadas por la actualización.
	 * @throws SQLException           si ocurre un error al ejecutar la
	 *                                actualización.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public int updateHousing(int idHouse, String name, String location, int numGuest, int numBedroom, int numBed,
			int numBath, int idType, double price) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(UPDATE_HOUSING);
		ps.setString(1, name);
		ps.setString(2, location);
		ps.setInt(3, numGuest);
		ps.setInt(4, numBedroom);
		ps.setInt(5, numBed);
		ps.setInt(6, numBath);
		ps.setInt(7, idType);
		ps.setDouble(8, price);
		ps.setInt(9, idHouse);

		int result = ps.executeUpdate();
		ps.close();
		db.closeConnection(connection);
		return result;
	}

	/**
	 * Elimina una vivienda de la base de datos.
	 * 
	 * @param idHouse ID de la vivienda a eliminar.
	 * @return El número de filas afectadas por la eliminación.
	 * @throws SQLException           si ocurre un error al ejecutar la eliminación.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public int deleteHousing(int idHouse) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(DELETE_HOUSING);
		ps.setInt(1, idHouse);
		int result = ps.executeUpdate();
		ps.close();
		db.closeConnection(connection);
		return result;
	}
}