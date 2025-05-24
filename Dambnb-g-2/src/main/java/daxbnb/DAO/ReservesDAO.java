package daxbnb.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import daxbnb.DAO.DBConnection;
import daxbnb.model.Housing;
import daxbnb.model.Reserves;

/**
 * Clase DAO para gestionar operaciones CRUD en la tabla 'Reserves'. Proporciona
 * métodos para insertar, actualizar, eliminar y consultar reservas.
 */
public class ReservesDAO {

	private static final String SELECT_ALL = "SELECT * FROM Reserves";
	private static final String SELECT_BY_IDHOUSE = "SELECT * FROM Reserves WHERE idHouse = ?";
	private static final String SELECT_BY_IDUSER = "SELECT * FROM Reserves WHERE idUser = ?";
	private static final String SELECT_BY_USERNAME = "SELECT * FROM Users WHERE userName = ?";
	private static final String INSERT_RESERVES = "INSERT INTO Reserves (idHouse, idUser, name, checkIn, checkOut, numGuests, totalPrice) VALUES (?, ?, ?, ?, ?, ?,?)";
	private static final String UPDATE_RESERVES = "UPDATE Reserves SET idHouse = ?, idUser = ?, name = ?, checkIn = ?, checkOut = ?, numGuests = ?, totalPrice = ? WHERE idReserve = ?";
	private static final String DELETE_RESERVES = "DELETE FROM Reserves WHERE idReserve = ?";

	private DBConnection db;

	/**
	 * Constructor que inicializa la conexión con la base de datos.
	 */
	public ReservesDAO() {
		db = new DBConnection();
	}

	/**
	 * Selecciona todas las reservas de la base de datos.
	 * 
	 * @return Lista de objetos Reserves con todas las reservas registradas.
	 * @throws SQLException           si ocurre un error al ejecutar la consulta
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public List<Reserves> selectAll() throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
		ResultSet resultSet = ps.executeQuery();

		List<Reserves> reservesList = new ArrayList<>();
		HousingDAO housingDAO = new HousingDAO(); // Para buscar Housing por Id

		while (resultSet.next()) {
			int idReserve = resultSet.getInt("idReserve");
			int idHouse = resultSet.getInt("idHouse");
			int idUser = resultSet.getInt("idUser");
			String nameH = resultSet.getString("nameH");
			int numGuests = resultSet.getInt("numGuests");
			double totalPrice = resultSet.getDouble("totalPrice");
			java.util.Date checkIn = resultSet.getDate("checkIn");
			java.util.Date checkOut = resultSet.getDate("checkOut");

			Housing housing = housingDAO.selectById(idHouse);

			Reserves reserve = new Reserves(idReserve, housing, idUser, nameH, checkIn, checkOut, numGuests,
					totalPrice);
			reservesList.add(reserve);
		}
		resultSet.close();
		db.closeConnection(connection);
		return reservesList;
	}

	/**
	 * Selecciona una reserva específica por el ID de la vivienda.
	 * 
	 * @param idHouse ID de la vivienda.
	 * @return Objeto Reserves correspondiente al ID proporcionado.
	 * @throws SQLException           si ocurre un error al ejecutar la consulta
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public Reserves selectByIdHouse(int idHouse) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_BY_IDHOUSE);
		ps.setInt(1, idHouse);
		ResultSet resultSet = ps.executeQuery();

		Reserves reserve = null;
		HousingDAO housingDAO = new HousingDAO();

		if (resultSet.next()) {
			int idReserve = resultSet.getInt("idReserve");
			int idUser = resultSet.getInt("idUser");
			String nameH = resultSet.getString("nameH");
			int numGuests = resultSet.getInt("numGuests");
			double totalPrice = resultSet.getDouble("totalPrice");
			java.util.Date checkIn = resultSet.getDate("checkIn");
			java.util.Date checkOut = resultSet.getDate("checkOut");

			Housing housing = housingDAO.selectById(idHouse);

			reserve = new Reserves(idReserve, housing, idUser, nameH, checkIn, checkOut, numGuests, totalPrice);
		}
		resultSet.close();
		db.closeConnection(connection);
		return reserve;
	}

	/**
	 * Selecciona todas las reservas de un usuario por su ID.
	 * 
	 * @param idUser ID del usuario.
	 * @return Lista de reservas asociadas al usuario.
	 * @throws SQLException           si ocurre un error al ejecutar la consulta
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public List<Reserves> selectByIdUser(int idUser) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_BY_IDUSER);
		ps.setInt(1, idUser);
		ResultSet resultSet = ps.executeQuery();

		List<Reserves> reserveList = new ArrayList<>();
		HousingDAO housingDAO = new HousingDAO();

		while (resultSet.next()) {
			int idReserve = resultSet.getInt("idReserve");
			int idHouse = resultSet.getInt("idHouse");
			String nameH = resultSet.getString("nameH");
			int numGuests = resultSet.getInt("numGuests");
			double totalPrice = resultSet.getDouble("totalPrice");
			java.util.Date checkIn = resultSet.getDate("checkIn");
			java.util.Date checkOut = resultSet.getDate("checkOut");

			Housing housing = housingDAO.selectById(idHouse);
			Reserves reserve = new Reserves(idReserve, housing, idUser, nameH, checkIn, checkOut, numGuests,
					totalPrice);
			reserveList.add(reserve);
		}
		resultSet.close();
		db.closeConnection(connection);
		return reserveList;
	}

	/**
	 * Inserta una nueva reserva en la base de datos.
	 * 
	 * @param idHouse    ID de la vivienda.
	 * @param idUser     ID del usuario.
	 * @param name       Nombre de la reserva.
	 * @param numGuests  Número de huéspedes.
	 * @param totalPrice Precio total de la reserva.
	 * @param checkIn    Fecha de entrada.
	 * @param checkOut   Fecha de salida.
	 * @return El ID generado de la nueva reserva.
	 * @throws SQLException           si ocurre un error al ejecutar la inserción.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public int insertReserve(int idHouse, int idUser, String nameH, int numGuests, double totalPrice,
			java.util.Date checkIn, java.util.Date checkOut) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(INSERT_RESERVES, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, idHouse);
		ps.setInt(2, idUser);
		ps.setString(3, nameH);
		ps.setDate(4, new java.sql.Date(checkIn.getTime()));
		ps.setDate(5, new java.sql.Date(checkOut.getTime()));
		ps.setInt(6, numGuests);
		ps.setDouble(7, totalPrice);

		int affectedRows = ps.executeUpdate();
		if (affectedRows == 0) {
			throw new SQLException("No se pudo insertar la reserva");
		}

		int generateId = -1;
		ResultSet generateKeys = ps.getGeneratedKeys();
		if (generateKeys.next()) {
			generateId = generateKeys.getInt(1);
		}
		db.closeConnection(connection);
		return generateId;

	}

	/**
	 * Actualiza una reserva existente en la base de datos.
	 * 
	 * @param idReserve  ID de la reserva a actualizar.
	 * @param idHouse    ID de la vivienda.
	 * @param idUser     ID del usuario.
	 * @param name       Nombre de la reserva.
	 * @param numGuests  Número de huéspedes.
	 * @param checkIn    Fecha de entrada.
	 * @param checkOut   Fecha de salida.
	 * @param totalPrice Precio total de la reserva.
	 * @return El número de filas afectadas por la actualización.
	 * @throws SQLException           si ocurre un error al ejecutar la
	 *                                actualización.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public int updateReserve(int idReserve, int idHouse, int idUser, String nameH, int numGuests, java.util.Date checkIn,
			java.util.Date checkOut, double totalPrice) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(UPDATE_RESERVES);
		ps.setInt(1, idHouse);
		ps.setInt(2, idUser);
		ps.setString(3, nameH);
		ps.setDate(4, new java.sql.Date(checkIn.getTime()));
		ps.setDate(5, new java.sql.Date(checkOut.getTime()));
		ps.setInt(6, numGuests);
		ps.setDouble(7, totalPrice);
		ps.setInt(8, idReserve); // El ID va al final para identificar qué reserva actualizar
		int result = ps.executeUpdate();
		db.closeConnection(connection);
		return result;
	}

	/**
	 * Elimina una reserva de la base de datos.
	 * 
	 * @param idReserve ID de la reserva a eliminar.
	 * @return El número de filas afectadas por la eliminación.
	 * @throws SQLException           si ocurre un error al ejecutar la eliminación.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public int deleteReserve(int idReserve) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(DELETE_RESERVES);
		ps.setInt(1, idReserve);
		int result = ps.executeUpdate();
		db.closeConnection(connection);
		return result;
	}
}
