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

/**
 * Clase DAO para gestionar operaciones CRUD en la tabla 'Facilities'.
 * Proporciona métodos para insertar, actualizar, eliminar y consultar
 * instalaciones.
 */
public class FacilityDAO {

	private static final String SELECT_ALL = "SELECT * FROM Facilities";
	private static final String SELECT_BY_ID = "SELECT * FROM Facilities WHERE idFacility = ?";
	private static final String INSERT_FACILITY = "INSERT INTO Facilities (typeFacility) VALUES (?)";
	private static final String UPDATE_FACILITY = "UPDATE Facilities SET typeFacility = ? WHERE idFacility = ?";
	private static final String DELETE_FACILITY = "DELETE FROM Facilities WHERE idFacility = ?";

	private DBConnection db;

	/**
	 * Constructor que inicializa la conexión con la base de datos.
	 */
	public FacilityDAO() {
		db = new DBConnection();
	}

	/**
	 * Selecciona todas las instalaciones registradas en la base de datos.
	 * 
	 * @return Lista de objetos Facilities con todas las instalaciones encontradas.
	 * @throws SQLException           si ocurre un error al ejecutar la consulta
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public List<Facilities> selectAll() throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
		ResultSet rs = ps.executeQuery();
		List<Facilities> facilities = new ArrayList<>();

		while (rs.next()) {
			if (!rs.wasNull()) {
				Facilities facility = new Facilities(rs.getInt("idFacility"), rs.getString("typeFacility"));
				facilities.add(facility);
			}
		}
		rs.close();
		db.closeConnection(connection);
		return facilities;
	}

	/**
	 * Selecciona una instalación específica por su ID.
	 * 
	 * @param idFacility ID de la instalación a buscar.
	 * @return Objeto Facilities correspondiente al ID proporcionado, o null si no
	 *         existe.
	 * @throws SQLException           si ocurre un error al ejecutar la consulta
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public Facilities selectById(int idFacility) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID);
		ps.setInt(1, idFacility);
		ResultSet rs = ps.executeQuery();

		Facilities facility = null;

		if (rs.next()) {
			facility = new Facilities(rs.getInt("idFacility"), rs.getString("typeFacility"));
		}
		rs.close();
		db.closeConnection(connection);
		return facility;
	}

	/**
	 * Inserta una nueva instalación en la base de datos.
	 * 
	 * @param typeFacility Tipo de la instalación.
	 * @return El ID generado de la nueva instalación.
	 * @throws SQLException           si ocurre un error al ejecutar la inserción
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public int insertFacility(String typeFacility) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(INSERT_FACILITY, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, typeFacility);

		int affectedRows = ps.executeUpdate();
		if (affectedRows == 0) {
			throw new SQLException("No se pudo insertar la instalación");
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
	 * Actualiza una instalación existente en la base de datos.
	 * 
	 * @param idFacility   ID de la instalación a actualizar.
	 * @param typeFacility Nuevo tipo de instalación.
	 * @return El número de filas afectadas por la actualización.
	 * @throws SQLException           si ocurre un error al ejecutar la
	 *                                actualización SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public int updateFacility(int idFacility, String typeFacility) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(UPDATE_FACILITY);
		ps.setString(1, typeFacility);
		ps.setInt(2, idFacility);

		int result = ps.executeUpdate();
		ps.close();
		db.closeConnection(connection);
		return result;
	}

	/**
	 * Elimina una instalación de la base de datos.
	 * 
	 * @param idFacility ID de la instalación a eliminar.
	 * @return El número de filas afectadas por la eliminación.
	 * @throws SQLException           si ocurre un error al ejecutar la eliminación
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public int deleteFacility(int idFacility) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(DELETE_FACILITY);
		ps.setInt(1, idFacility);
		int result = ps.executeUpdate();
		ps.close();
		db.closeConnection(connection);
		return result;
	}
}
