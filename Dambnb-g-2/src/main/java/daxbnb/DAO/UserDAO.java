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
import daxbnb.model.User;

/**
 * Clase DAO para gestionar operaciones CRUD en la tabla 'User'. Proporciona
 * métodos para insertar, actualizar, eliminar y consultar reservas.
 */
public class UserDAO {

	private static final String SELECT_ALL = "SELECT * FROM Users";
	private static final String SELECT_BY_IDHOUSE = "SELECT * FROM Users WHERE passport = ?";
	private static final String SELECT_BY_IDUSER = "SELECT * FROM Users WHERE email = ?";
	private static final String INSERT_RESERVES = "INSERT INTO Users (userName, phone, email, passport) VALUES (?, ?, ?, ?)";
	private static final String UPDATE_RESERVES = "UPDATE Users SET idHouse = ?, idUser = ?, name = ?, checkIn = ?, checkOut = ?, numGuests = ?, totalPrice = ?";
	private static final String DELETE_RESERVES = "DELETE FROM Users WHERE idUser = ?";

	private DBConnection db;

	public UserDAO() {
		db = new DBConnection();
	}

	public List<User> selectAll() throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
		ResultSet rs = ps.executeQuery();
		List<User> users = new ArrayList<>();

		while (rs.next()) {
			if (!rs.wasNull()) {
				User user = new User(rs.getString("userName"), rs.getInt("idUser"), rs.getInt("phone"),
						rs.getString("email"), rs.getInt("passport"));

			}
		}
		return User;
	}

}
