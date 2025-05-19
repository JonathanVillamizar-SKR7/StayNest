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
import daxbnb.model.User;

/**
 * Clase DAO para gestionar operaciones CRUD en la tabla 'Users'. Proporciona
 * métodos para insertar, actualizar, eliminar y consultar usuarios.
 */
public class UserDAO {

	private static final String SELECT_ALL = "SELECT * FROM Users";
	private static final String SELECT_BY_PASSPORT = "SELECT * FROM Users WHERE passport = ?";
	private static final String SELECT_BY_EMAIL = "SELECT * FROM Users WHERE email = ?";
	private static final String INSERT_USER = "INSERT INTO Users (userName, phone, email, passport, password, userType) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_USER = "UPDATE Users SET userName = ?, phone = ?, email = ?, passport = ? WHERE idUser = ?";
	private static final String DELETE_USER = "DELETE FROM Users WHERE idUser = ?";

	private DBConnection db;

	/**
	 * Constructor que inicializa la conexión con la base de datos.
	 */
	public UserDAO() {
		db = new DBConnection();
	}

	/**
	 * Selecciona todos los usuarios registrados en la base de datos.
	 * 
	 * @return Lista de objetos User con toda la información de los usuarios.
	 * @throws SQLException           si ocurre un error al ejecutar la consulta
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public List<User> selectAll() throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
		ResultSet rs = ps.executeQuery();
		List<User> users = new ArrayList<>();

		while (rs.next()) {
			if (!rs.wasNull()) {
				List<CreditCard> creditcards = new ArrayList<>();
				User user = new User(rs.getString("userName"), rs.getInt("idUser"), rs.getLong("phone"), rs.getString("email"),
						rs.getInt("passport"), creditcards, rs.getString("password"), rs.getString("userName"),
						rs.getString("userDescription"));
				users.add(user);
			}
		}
		rs.close();
		db.closeConnection(connection);
		return users;
	}

	/**
	 * Selecciona un usuario específico por el número de pasaporte.
	 * 
	 * @param passport El número de pasaporte del usuario.
	 * @return Un objeto User si se encuentra; de lo contrario, {@code null}.
	 * @throws SQLException           si ocurre un error al ejecutar la consulta
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public User selectByPassport(int passport) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_BY_PASSPORT);
		ps.setInt(1, passport);
		ResultSet rs = ps.executeQuery();

		User user = null;

		if (rs.next()) {
			List<CreditCard> creditcards = new ArrayList<>();
			user = new User(rs.getString("userName"), rs.getInt("idUser"), rs.getLong("phone"), rs.getString("email"),
					rs.getInt("passport"), creditcards, rs.getString("password"), rs.getString("userName"),
					rs.getString("userDescription"));
		}
		rs.close();
		db.closeConnection(connection);
		return user;
	}

	/**
	 * Selecciona un usuario específico por su correo electrónico.
	 * 
	 * @param email El correo electrónico del usuario.
	 * @return Un objeto User si se encuentra; de lo contrario, {@code null}.
	 * @throws SQLException           si ocurre un error al ejecutar la consulta
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public User selectByEmail(String email) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_BY_EMAIL);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();

		User user = null;

		if (rs.next()) {
			List<CreditCard> creditcards = new ArrayList<>();
			user = new User(rs.getString("userName"), rs.getInt("idUser"), rs.getLong("phone"), rs.getString("email"),
					rs.getInt("passport"), creditcards, rs.getString("password"), rs.getString("userName"),
					rs.getString("userDescription"));
		}
		rs.close();
		db.closeConnection(connection);
		return user;
	}

	/**
	 * Inserta un nuevo usuario en la base de datos.
	 * 
	 * @param userName Nombre de usuario.
	 * @param phone    Número de teléfono del usuario.
	 * @param email    Correo electrónico del usuario.
	 * @param passport Número de pasaporte del usuario.
	 * @return El ID generado del nuevo usuario.
	 * @throws SQLException           si ocurre un error al ejecutar la inserción
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public int insertUser(String userName, long phone, String email, int passport, String password, String userType, String userDescription)
			throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, userName);
		ps.setLong(2, phone);
		ps.setString(3, email);
		ps.setInt(4, passport);
		ps.setString(5, password);
		ps.setString(6, userType);
		ps.setString(7, userDescription);

		int affectRows = ps.executeUpdate();
		if (affectRows == 0) {
			throw new SQLException("No se pudo insertar el User");
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
	 * Actualiza un usuario existente en la base de datos.
	 * 
	 * @param idUser   ID del usuario a actualizar.
	 * @param userName Nombre del usuario.
	 * @param phone    Número de teléfono del usuario.
	 * @param email    Correo electrónico del usuario.
	 * @param passport Número de pasaporte del usuario.
	 * @return El número de filas afectadas por la actualización.
	 * @throws SQLException           si ocurre un error al ejecutar la
	 *                                actualización SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public int updateUser(int idUser, String userName, long phone, String email, int passport, String password,
			String userType) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(UPDATE_USER);
		ps.setString(1, userName);
		ps.setLong(2, phone);
		ps.setString(3, email);
		ps.setInt(4, passport);
		ps.setString(5, password);
		ps.setString(6, userType);
		ps.setInt(7, idUser);

		int result = ps.executeUpdate();
		ps.close();
		db.closeConnection(connection);
		return result;
	}

	/**
	 * Elimina un usuario de la base de datos.
	 * 
	 * @param idUser ID del usuario a eliminar.
	 * @return El número de filas afectadas por la eliminación.
	 * @throws SQLException           si ocurre un error al ejecutar la eliminación
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public int deleteUser(int idUser) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(DELETE_USER);
		ps.setInt(1, idUser);
		int result = ps.executeUpdate();
		ps.close();
		db.closeConnection(connection);
		return result;
	}

}
