package daxbnb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import daxbnb.DAO.DBConnection;
import daxbnb.model.CreditCard;
import daxbnb.model.Details;

/**
 * Clase DAO para gestionar operaciones CRUD en la tabla 'Details'. Proporciona
 * métodos para insertar, actualizar, eliminar y consultar detalles de usuario.
 */
public class DetailsDAO {

	private static final String SELECT_ALL = "SELECT * FROM Details";
	private static final String SELECT_BY_USERTYPE = "SELECT * FROM Details WHERE userType = ?";
	private static final String SELECT_BY_USERNAME = "SELECT * FROM Details WHERE userName = ?";
	private static final String INSERT_DETAILS = "INSERT INTO Details (userName, password, userType, userDescription) VALUES (?, ?, ?, ?)";
	private static final String UPDATE_DETAILS = "UPDATE Details SET userName = ?, password = ?, userType = ?, userDescription = ? WHERE userName = ?";
	private static final String DELETE_DETAILS = "DELETE FROM Details WHERE userName = ?";

	private DBConnection db;

	/**
	 * Constructor que inicializa la conexión con la base de datos.
	 */
	public DetailsDAO() {
		db = new DBConnection();
	}

	/**
	 * Selecciona todos los detalles de usuario registrados en la base de datos.
	 * 
	 * @return Lista de objetos Details con toda la información de los detalles.
	 * @throws SQLException           si ocurre un error al ejecutar la consulta
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public List<Details> selectAll() throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
		ResultSet rs = ps.executeQuery();
		List<Details> detailsList = new ArrayList<>();

		while (rs.next()) {
			if (!rs.wasNull()) {
				// Construcción del objeto Details
				Details detail = new Details(rs.getString("userName"), rs.getInt("idUser"), rs.getInt("phone"),
						rs.getString("email"), rs.getInt("passport"), new ArrayList<CreditCard>(), 
						rs.getString("password"), rs.getString("userType"), rs.getString("userDescription"));
				detailsList.add(detail);
			}
		}
		rs.close();
		db.closeConnection(connection);
		return detailsList;
	}

	/**
	 * Selecciona un detalle de usuario específico por el tipo de usuario.
	 * 
	 * @param userType El tipo de usuario (ej: "admin", "client").
	 * @return Un objeto Details si se encuentra; de lo contrario, {@code null}.
	 * @throws SQLException           si ocurre un error al ejecutar la consulta
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public Details selectByUserType(String userType) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_BY_USERTYPE);
		ps.setString(1, userType);
		ResultSet rs = ps.executeQuery();

		Details detail = null;

		if (rs.next()) {
			detail = new Details(rs.getString("userName"), rs.getInt("idUser"), rs.getInt("phone"),
					rs.getString("email"), rs.getInt("passport"), new ArrayList<CreditCard>(), 
					rs.getString("password"), rs.getString("userType"), rs.getString("userDescription"));
		}
		rs.close();
		db.closeConnection(connection);
		return detail;
	}

	/**
	 * Selecciona un detalle de usuario específico por el nombre de usuario.
	 * 
	 * @param userName El nombre de usuario.
	 * @return Un objeto Details si se encuentra; de lo contrario, {@code null}.
	 * @throws SQLException           si ocurre un error al ejecutar la consulta
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public Details selectByUserName(String userName) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_BY_USERNAME);
		ps.setString(1, userName);
		ResultSet rs = ps.executeQuery();

		Details detail = null;

		if (rs.next()) {
			detail = new Details(rs.getString("userName"), rs.getInt("idUser"), rs.getInt("phone"),
					rs.getString("email"), rs.getInt("passport"), new ArrayList<CreditCard>(), 
					rs.getString("password"), rs.getString("userType"), rs.getString("userDescription"));
		}
		rs.close();
		db.closeConnection(connection);
		return detail;
	}

	/**
	 * Inserta un nuevo detalle de usuario en la base de datos.
	 * 
	 * @param userName        Nombre del usuario.
	 * @param password        Contraseña del usuario.
	 * @param userType        Tipo de usuario (ej: "admin", "client").
	 * @param userDescription Descripción del usuario.
	 * @return El ID generado del nuevo detalle.
	 * @throws SQLException           si ocurre un error al ejecutar la inserción
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public int insertDetails(String userName, String password, String userType, String userDescription)
			throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(INSERT_DETAILS);
		ps.setString(1, userName);
		ps.setString(2, password);
		ps.setString(3, userType);
		ps.setString(4, userDescription);

		int affectRows = ps.executeUpdate();
		if (affectRows == 0) {
			throw new SQLException("No se pudo insertar el detalle del usuario");
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
	 * Actualiza un detalle de usuario existente en la base de datos.
	 * 
	 * @param userName        Nombre del usuario a actualizar.
	 * @param password        Nueva contraseña del usuario.
	 * @param userType        Nuevo tipo de usuario.
	 * @param userDescription Nueva descripción del usuario.
	 * @return El número de filas afectadas por la actualización.
	 * @throws SQLException           si ocurre un error al ejecutar la
	 *                                actualización SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public int updateDetails(String userName, String password, String userType, String userDescription)
			throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(UPDATE_DETAILS);
		ps.setString(1, userName);
		ps.setString(2, password);
		ps.setString(3, userType);
		ps.setString(4, userDescription);
		ps.setString(5, userName);

		int result = ps.executeUpdate();
		ps.close();
		db.closeConnection(connection);
		return result;
	}

	/**
	 * Elimina un detalle de usuario de la base de datos.
	 * 
	 * @param userName Nombre del usuario a eliminar.
	 * @return El número de filas afectadas por la eliminación.
	 * @throws SQLException           si ocurre un error al ejecutar la eliminación
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public int deleteDetails(String userName) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(DELETE_DETAILS);
		ps.setString(1, userName);
		int result = ps.executeUpdate();
		ps.close();
		db.closeConnection(connection);
		return result;
	}
}
