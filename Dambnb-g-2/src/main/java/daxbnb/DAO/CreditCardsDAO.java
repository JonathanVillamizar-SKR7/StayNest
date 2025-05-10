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
import daxbnb.model.CreditCard;

/**
 * Clase DAO para gestionar operaciones CRUD en la tabla 'CreditCards'.
 * Proporciona métodos para insertar, actualizar, eliminar y consultar tarjetas
 * de crédito.
 */
public class CreditCardsDAO {

	private static final String SELECT_ALL = "SELECT * FROM CreditCards";
	private static final String SELECT_BY_IDUSER = "SELECT * FROM CreditCards WHERE passport = ?";
	private static final String INSERT_CREDITCARD = "INSERT INTO CreditCards (cardHolderName, creditCardNumber, expirationDate, cvv, idUser) VALUES (?, ?, ?, ?, ?)";
	private static final String UPDATE_CREDITCARD = "UPDATE CreditCards SET cardHolderName = ?, creditCardNumber = ?, expirationDate = ?, cvv = ?, idUser = ? WHERE idCreditCard = ?";
	private static final String DELETE_CREDITCARD = "DELETE FROM CreditCards WHERE idCreditCard = ?";

	private DBConnection db;

	/**
	 * Constructor que inicializa la conexión con la base de datos.
	 */
	public CreditCardsDAO() {
		db = new DBConnection();
	}

	/**
	 * Selecciona todas las tarjetas de crédito registradas en la base de datos.
	 * 
	 * @return Una lista de objetos CreditCard con toda la información de las
	 *         tarjetas.
	 * @throws SQLException           si ocurre un error al ejecutar la consulta
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public List<CreditCard> selectAll() throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
		ResultSet rs = ps.executeQuery();
		List<CreditCard> creditCards = new ArrayList<>();

		while (rs.next()) {
			if (!rs.wasNull()) {
				CreditCard creditCard = new CreditCard(rs.getInt("idCreditCard"), rs.getString("cardHolderName"),
						rs.getLong("creditCardNumber"), rs.getDate("expirationDate"), rs.getInt("cvv"),
						rs.getInt("idUser"));
				creditCards.add(creditCard);
			}
		}
		rs.close();
		db.closeConnection(connection);
		return creditCards;
	}

	/**
	 * Selecciona una tarjeta de crédito específica por el ID del usuario.
	 * 
	 * @param idUser El ID del usuario asociado a la tarjeta de crédito.
	 * @return Un objeto CreditCard si se encuentra; de lo contrario, {@code null}.
	 * @throws SQLException           si ocurre un error al ejecutar la consulta
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public CreditCard selectByIdUser(int idUser) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_BY_IDUSER);
		ps.setInt(1, idUser);
		ResultSet rs = ps.executeQuery();

		CreditCard creditCards = null;

		if (rs.next()) {
			creditCards = new CreditCard(rs.getInt("idCreditCard"), rs.getString("cardHolderName"),
					rs.getLong("creditCardNumber"), rs.getDate("expirationDate"), rs.getInt("cvv"),
					rs.getInt("idUser"));
		}
		rs.close();
		db.closeConnection(connection);
		return creditCards;
	}

	/**
	 * Inserta una nueva tarjeta de crédito en la base de datos.
	 * 
	 * @param cardHolderName   Nombre del titular de la tarjeta.
	 * @param creditCardNumber Número de la tarjeta de crédito.
	 * @param expirationDate   Fecha de expiración de la tarjeta.
	 * @param cvv              Código de verificación (CVV).
	 * @param idUser           ID del usuario al que está asociada la tarjeta.
	 * @return El ID generado de la nueva tarjeta de crédito.
	 * @throws SQLException           si ocurre un error al ejecutar la inserción
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public int insertCreditCard(String cardHolderName, long creditCardNumber, Date expirationDate, int cvv, int idUser)
			throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(INSERT_CREDITCARD, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, cardHolderName);
		ps.setLong(2, creditCardNumber);
		ps.setDate(3, expirationDate);
		ps.setInt(4, cvv);
		ps.setInt(5, idUser);

		int affectRows = ps.executeUpdate();
		if (affectRows == 0) {
			throw new SQLException("No se pudo insertar la CreditCard");
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
	 * Actualiza una tarjeta de crédito existente en la base de datos.
	 * 
	 * @param idCreditCard     ID de la tarjeta de crédito a actualizar.
	 * @param cardHolderName   Nombre del titular de la tarjeta.
	 * @param creditCardNumber Número de la tarjeta de crédito.
	 * @param expirationDate   Fecha de expiración de la tarjeta.
	 * @param cvv              Código de verificación (CVV).
	 * @param idUser           ID del usuario al que está asociada la tarjeta.
	 * @return El número de filas afectadas por la actualización.
	 * @throws SQLException           si ocurre un error al ejecutar la
	 *                                actualización SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public int updateCreditCard(int idCreditCard, String cardHolderName, long creditCardNumber, Date expirationDate,
			int cvv, int idUser) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(UPDATE_CREDITCARD);
		ps.setString(1, cardHolderName);
		ps.setLong(2, creditCardNumber);
		ps.setDate(3, expirationDate);
		ps.setInt(4, cvv);
		ps.setInt(5, idUser);
		ps.setInt(6, idCreditCard);

		int result = ps.executeUpdate();
		ps.close();
		db.closeConnection(connection);
		return result;
	}

	/**
	 * Elimina una tarjeta de crédito de la base de datos.
	 * 
	 * @param idCreditCard ID de la tarjeta de crédito a eliminar.
	 * @return El número de filas afectadas por la eliminación.
	 * @throws SQLException           si ocurre un error al ejecutar la eliminación
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public int deleteCreditCard(int idCreditCard) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(DELETE_CREDITCARD);
		ps.setInt(1, idCreditCard);
		int result = ps.executeUpdate();
		ps.close();
		db.closeConnection(connection);
		return result;
	}
}
