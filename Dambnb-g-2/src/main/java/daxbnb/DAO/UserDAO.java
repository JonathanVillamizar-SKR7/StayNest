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
 * Clase DAO para gestionar operaciones CRUD en la tabla 'User'.
 * Proporciona métodos para insertar, actualizar, eliminar y consultar reservas.
 */
public class UserDAO {

	private static final String SELECT_ALL = "SELECT * FROM Users";
	private static final String SELECT_BY_IDHOUSE = "SELECT * FROM Users WHERE idHouse = ?";
	private static final String SELECT_BY_IDUSER = "SELECT * FROM Reserves WHERE idUser = ?";
	private static final String INSERT_RESERVES = "INSERT INTO Reserves (idHouse, idUser, name, checkIn, checkOut, numGuests, totalPrice) VALUES (?, ?, ?, ?, ?, ?,?)";
	private static final String UPDATE_RESERVES = "UPDATE Reserves SET idHouse = ?, idUser = ?, name = ?, checkIn = ?, checkOut = ?, numGuests = ?, totalPrice = ?";
	private static final String DELETE_RESERVES = "DELETE FROM Reserves WHERE idReserve = ?";
}
