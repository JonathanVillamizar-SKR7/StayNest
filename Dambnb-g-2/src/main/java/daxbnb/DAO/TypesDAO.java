package daxbnb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import daxbnb.DAO.DBConnection;
import daxbnb.model.Types;

/**
 * Clase DAO para gestionar operaciones CRUD en la tabla 'Types'. Proporciona
 * métodos para insertar, actualizar, eliminar y consultar tipos de alojamiento.
 */
public class TypesDAO {

	private static final String SELECT_ALL = "SELECT * FROM Types";
	private static final String SELECT_BY_ID = "SELECT * FROM Types WHERE idType = ?";
	private static final String INSERT_TYPE = "INSERT INTO Types (Type) VALUES (?)";
	private static final String UPDATE_TYPE = "UPDATE Types SET Type = ? WHERE idType = ?";
	private static final String DELETE_TYPE = "DELETE FROM Types WHERE idType = ?";

	private DBConnection db;

	/**
	 * Constructor para inicializar la conexión con la base de datos.
	 */
	public TypesDAO() {
		db = new DBConnection();
	}

	/**
	 * Obtiene todos los tipos de alojamiento registrados en la base de datos.
	 * 
	 * @return Lista de enumeraciones Types con los tipos encontrados.
	 * @throws SQLException           si ocurre un error al ejecutar la consulta
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public List<Types> selectAll() throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
		ResultSet rs = ps.executeQuery();
		List<Types> typesList = new ArrayList<>();

		while (rs.next()) {
			String typeName = rs.getString("Type");
			try {
				Types type = Types.valueOf(typeName.replace(" ", "_").toUpperCase());
				typesList.add(type);
			} catch (IllegalArgumentException e) {
				System.out.println("Advertencia: Tipo no válido en la base de datos: " + typeName);
			}
		}
		rs.close();
		db.closeConnection(connection);
		return typesList;
	}

	/**
	 * Busca un tipo de alojamiento por su ID.
	 * 
	 * @param idType ID del tipo de alojamiento.
	 * @return El tipo de alojamiento correspondiente, o null si no se encuentra.
	 * @throws SQLException           si ocurre un error al ejecutar la consulta
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public Types selectById(int idType) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID);
		ps.setInt(1, idType);
		ResultSet rs = ps.executeQuery();

		Types type = null;
		if (rs.next()) {
			String typeName = rs.getString("Type");
			try {
				type = Types.valueOf(typeName.replace(" ", "_").toUpperCase());
			} catch (IllegalArgumentException e) {
				System.out.println("Advertencia: Tipo no válido en la base de datos: " + typeName);
			}
		}
		rs.close();
		db.closeConnection(connection);
		return type;
	}

	/**
	 * Inserta un nuevo tipo de alojamiento en la base de datos.
	 * 
	 * @param typeName Nombre del tipo de alojamiento.
	 * @return El ID generado de la nueva instalación.
	 * @throws SQLException           si ocurre un error al ejecutar la inserción
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public int insertType(String typeName) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(INSERT_TYPE, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, typeName);

		int affectedRows = ps.executeUpdate();
		if (affectedRows == 0) {
			throw new SQLException("No se pudo insertar el tipo de alojamiento");
		}

		int generateId = -1;
		ResultSet generateKeys = ps.getGeneratedKeys();
		if (generateKeys.next()) {
			generateId = generateKeys.getInt(1);
		}
		ps.close();
		db.closeConnection(connection);
		return generateId;
	}

	/**
	 * Actualiza un tipo de alojamiento en la base de datos.
	 * 
	 * @param idType   ID del tipo de alojamiento.
	 * @param typeName Nuevo nombre del tipo de alojamiento.
	 * @return El número de filas afectadas por la actualización.
	 * @throws SQLException           si ocurre un error al ejecutar la
	 *                                actualización SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public int updateType(int idType, String typeName) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(UPDATE_TYPE);
		ps.setString(1, typeName);
		ps.setInt(2, idType);

		int result = ps.executeUpdate();
		ps.close();
		db.closeConnection(connection);
		return result;
	}

	/**
	 * Elimina un tipo de alojamiento de la base de datos.
	 * 
	 * @param idType ID del tipo de alojamiento a eliminar.
	 * @return El número de filas afectadas por la eliminación.
	 * @throws SQLException           si ocurre un error al ejecutar la eliminación
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public int deleteType(int idType) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(DELETE_TYPE);
		ps.setInt(1, idType);
		int result = ps.executeUpdate();
		ps.close();
		db.closeConnection(connection);
		return result;
	}
}
