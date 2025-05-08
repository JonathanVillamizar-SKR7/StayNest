package daxbnb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import daxbnb.DAO.DBConnection;
import daxbnb.model.Facilities;
import daxbnb.model.Housing;
import daxbnb.model.Images;
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

		TypesDAO typesDAO = new TypesDAO(); // 🔄 Instancia del DAO para obtener el tipo

		while (resultSet.next()) {
			if (!resultSet.wasNull()) {

				// 🔄 Obtenemos el objeto Types desde el DAO
				Types types = typesDAO.selectById(resultSet.getInt("idType"));

				// 🔄 Creamos el objeto Housing usando el objeto types (Types)
				Housing housing = new Housing(resultSet.getInt("idHouse"), resultSet.getString("name"),
						resultSet.getString("location"), resultSet.getInt("numGuest"), resultSet.getInt("numBedroom"),
						resultSet.getInt("numBed"), resultSet.getInt("numBath"), types, resultSet.getDouble("price"),
						new ArrayList<>(), // images
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
		
		TypesDAO typesDAO = new TypesDAO(); // 🔄 Instancia del DAO
		Housing housing = null;
		
		if (rs.next()) {
			// 🔄 Obtenemos el objeto Types del DAO
			Types type = typesDAO.selectById(rs.getInt("idType"));

			// 🔄 Construimos el objeto Housing
			housing = new Housing(rs.getInt("idHouse"), rs.getString("name"), rs.getString("location"),
					rs.getInt("numGuest"), rs.getInt("numBedroom"), rs.getInt("numBed"), rs.getInt("numBath"),
					type, rs.getDouble("price"), new ArrayList<>(), // imágenes
					new ArrayList<>() // facilidades
			);
		}

		rs.close();
		db.closeConnection(connection);
		return housing;
	}

	/**
	 * Selecciona todas las viviendas que coinciden con un tipo específico.
	 * 
	 * @param idType ID del tipo de vivienda.
	 * @return Lista de objetos Housing que corresponden al tipo proporcionado.
	 * @throws SQLException           si ocurre un error al ejecutar la consulta
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public Housing selectHousingByType(int idType) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_BY_TYPE);
		ps.setInt(1, idType);
		ResultSet rs = ps.executeQuery();

		TypesDAO typesDAO = new TypesDAO(); // 🔄 Instancia del DAO

		while (rs.next()) {
			if (!rs.wasNull()) {
				// 🔄 Obtenemos el objeto Types
				Types type = typesDAO.selectById(rs.getInt("idType"));

				Housing housing = new Housing(rs.getInt("idHouse"), rs.getString("name"), rs.getString("location"),
						rs.getInt("numGuest"), rs.getInt("numBedroom"), rs.getInt("numBed"), rs.getInt("numBath"),
						type, rs.getDouble("price"), new ArrayList<>(), // imágenes
						new ArrayList<>() // facilidades
				);
				return housing;
			}
		}
		rs.close();
		db.closeConnection(connection);
		return null;
	}

	/**
	 * Selecciona todas las viviendas que coinciden con un número de habitaciones
	 * específico.
	 * 
	 * @param numBedroom Número de habitaciones.
	 * @return Lista de objetos Housing que corresponden al número de habitaciones.
	 * @throws SQLException           si ocurre un error al ejecutar la consulta
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public Housing selectHousingByBedroom(int numBedroom) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_BY_BEDROOM);
		ps.setInt(1, numBedroom);
		ResultSet rs = ps.executeQuery();
		TypesDAO typesDAO = new TypesDAO(); // 🔄 Instancia del DAO

		while (rs.next()) {
			if (!rs.wasNull()) {
				// 🔄 Obtenemos el objeto Types
				Types type = typesDAO.selectById(rs.getInt("idType"));
				Housing housing = new Housing(rs.getInt("idHouse"), rs.getString("name"), rs.getString("location"),
						rs.getInt("numGuest"), rs.getInt("numBedroom"), rs.getInt("numBed"), rs.getInt("numBath"),
						type, rs.getDouble("price"), new ArrayList<>(), // imágenes
						new ArrayList<>() // facilidades
				);
				return housing;
			}
		}
		rs.close();
		db.closeConnection(connection);
		return null;
	}
}
