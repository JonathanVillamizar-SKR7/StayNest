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
	private static final String SELECT_ALL_FACILITY = "select hf.idHouse,f.idFacility, f.typeFacility from Facilities f JOIN HousingFacilities hf ON f.idFacility = hf.idFacility WHERE hf.idHouse = ?;";
	private static final String SELECT_ALL_IMAGES = "SELECT i.imgRoute FROM Housing h INNER JOIN HousingImages hi ON h.idHouse = hi.idHouse INNER JOIN Images i ON hi.idImage = i.idImage WHERE h.idHouse = ?;";
	private static final String SELECT_BY_ID = "SELECT * FROM Housing WHERE idHouse = ?";
	private static final String SELECT_BY_TYPE = "SELECT * FROM Housing WHERE idType = ?";
	private static final String SELECT_BY_BEDROOM = "SELECT * FROM Housing WHERE numBedroom = ?";
	private static final String INSERT_HOUSING = "INSERT INTO Housing (name, location, numGuest, numBedroom, numBed, numBath, idType, price, description, available) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_HOUSING = "UPDATE Housing SET name = ?, location = ?, numGuest = ?, numBedroom = ?, numBed = ?, numBath = ?, idType = ?, price = ?, description = ?, available = ? WHERE idHouse = ?";
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
				List<Images> images = new ArrayList<>();
				List<Facilities> facilities = new ArrayList<>();
				int id = resultSet.getInt("idHouse");
				Types types = typesDAO.selectById(resultSet.getInt("idType"));
				Housing housing = new Housing(resultSet.getInt("idHouse"), resultSet.getString("name"),
						resultSet.getString("location"), resultSet.getInt("numGuest"), resultSet.getInt("numBedroom"),
						resultSet.getInt("numBed"), resultSet.getInt("numBath"), types, resultSet.getDouble("price"),
						resultSet.getString("description"), resultSet.getBoolean("available"), images, facilities);

				PreparedStatement ps2 = connection.prepareStatement(SELECT_ALL_FACILITY);
				ps2.setInt(1, id);
				ResultSet rs2 = ps2.executeQuery();
				while (rs2.next()) {
					if (!rs2.wasNull()) {
						facilities.add(new Facilities(rs2.getString("typeFacility")));
					}
				}
				housing.setFacilities(facilities);

				PreparedStatement ps3 = connection.prepareStatement(SELECT_ALL_IMAGES);
				ps3.setInt(1, id);
				ResultSet rs3 = ps3.executeQuery();
				while (rs3.next()) {
					if (!rs3.wasNull()) {
						images.add(new Images(rs3.getString("imgRoute")));
					}
				}
				housing.setImages(images);
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
		List<Images> images = new ArrayList<>();
		List<Facilities> facilities = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		TypesDAO typesDAO = new TypesDAO();
		Housing housing = null;

		if (rs.next()) {
			Types type = typesDAO.selectById(rs.getInt("idType"));
			int id = rs.getInt("idHouse");
			housing = new Housing(rs.getInt("idHouse"), rs.getString("name"), rs.getString("location"),
					rs.getInt("numGuest"), rs.getInt("numBedroom"), rs.getInt("numBed"), rs.getInt("numBath"), type,
					rs.getDouble("price"), rs.getString("description"), rs.getBoolean("available"), images, facilities);

			PreparedStatement ps2 = connection.prepareStatement(SELECT_ALL_FACILITY);
			ps2.setInt(1, id);
			ResultSet rs2 = ps2.executeQuery();
			while (rs2.next()) {
				if (!rs2.wasNull()) {
					facilities.add(new Facilities(rs2.getString("typeFacility")));
				}
			}
			housing.setFacilities(facilities);

			PreparedStatement ps3 = connection.prepareStatement(SELECT_ALL_IMAGES);
			ps3.setInt(1, id);
			ResultSet rs3 = ps3.executeQuery();
			while (rs3.next()) {
				if (!rs3.wasNull()) {
					images.add(new Images(rs3.getString("imgRoute")));
				}
			}
			housing.setImages(images);
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
	public List<Housing> selectHousingByType(int idType) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_BY_TYPE);
		ps.setInt(1, idType);
		ResultSet rs = ps.executeQuery();
		TypesDAO typesDAO = new TypesDAO();
		List<Housing> housings = new ArrayList<>();
		List<Images> images = new ArrayList<>();
		List<Facilities> facilities = new ArrayList<>();
		while (rs.next()) {
			if (!rs.wasNull()) {
				int id = rs.getInt("idHouse");
				Types type = typesDAO.selectById(rs.getInt("idType"));
				Housing housing = new Housing(rs.getInt("idHouse"), rs.getString("name"), rs.getString("location"),
						rs.getInt("numGuest"), rs.getInt("numBedroom"), rs.getInt("numBed"), rs.getInt("numBath"), type,
						rs.getDouble("price"), rs.getString("description"), rs.getBoolean("available"), images,
						facilities);

				PreparedStatement ps2 = connection.prepareStatement(SELECT_ALL_FACILITY);
				ps2.setInt(1, id);
				ResultSet rs2 = ps2.executeQuery();
				while (rs2.next()) {
					if (!rs2.wasNull()) {
						facilities.add(new Facilities(rs2.getString("typeFacility")));
					}
				}
				housing.setFacilities(facilities);

				PreparedStatement ps3 = connection.prepareStatement(SELECT_ALL_IMAGES);
				ps3.setInt(1, id);
				ResultSet rs3 = ps3.executeQuery();
				while (rs3.next()) {
					if (!rs3.wasNull()) {
						images.add(new Images(rs3.getString("imgRoute")));
					}
				}
				housing.setImages(images);

				housings.add(housing);
			}
		}
		rs.close();
		db.closeConnection(connection);
		return housings;
	}

	/**
	 * Selecciona todas las viviendas que coinciden con un número de habitaciones
	 * específico.
	 * 
	 * @param numBedroom Número de habitaciones de la vivienda.
	 * @return Lista de objetos Housing que corresponden al número de habitaciones
	 *         proporcionado.
	 * @throws SQLException           si ocurre un error al ejecutar la consulta
	 *                                SQL.
	 * @throws ClassNotFoundException si la clase de conexión no se encuentra.
	 */
	public List<Housing> selectHousingByBedroom(int numBedroom) throws SQLException, ClassNotFoundException {
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_BY_BEDROOM);
		ps.setInt(1, numBedroom);
		ResultSet rs = ps.executeQuery();
		TypesDAO typesDAO = new TypesDAO();
		List<Housing> housings = new ArrayList<>();
		List<Images> images = new ArrayList<>();
		List<Facilities> facilities = new ArrayList<>();
		while (rs.next()) {
			if (!rs.wasNull()) {
				int id = rs.getInt("idHouse");
				Types type = typesDAO.selectById(rs.getInt("idType"));
				Housing housing = new Housing(rs.getInt("idHouse"), rs.getString("name"), rs.getString("location"),
						rs.getInt("numGuest"), rs.getInt("numBedroom"), rs.getInt("numBed"), rs.getInt("numBath"), type,
						rs.getDouble("price"), rs.getString("description"), rs.getBoolean("available"), images,
						facilities);

				PreparedStatement ps2 = connection.prepareStatement(SELECT_ALL_FACILITY);
				ps2.setInt(1, id);
				ResultSet rs2 = ps2.executeQuery();
				while (rs2.next()) {
					if (!rs2.wasNull()) {
						facilities.add(new Facilities(rs2.getString("typeFacility")));
					}
				}
				housing.setFacilities(facilities);

				PreparedStatement ps3 = connection.prepareStatement(SELECT_ALL_IMAGES);
				ps3.setInt(1, id);
				ResultSet rs3 = ps3.executeQuery();
				while (rs3.next()) {
					if (!rs3.wasNull()) {
						images.add(new Images(rs3.getString("imgRoute")));
					}
				}
				housing.setImages(images);

				housings.add(housing);
			}
		}
		rs.close();
		db.closeConnection(connection);
		return housings;
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
			int idType, double price, String description, boolean available)
			throws SQLException, ClassNotFoundException {
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
		ps.setString(9, description);
		ps.setBoolean(10, available);

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
			int numBath, int idType, double price, String description, boolean available)
			throws SQLException, ClassNotFoundException {
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
		ps.setString(9, description);
		ps.setBoolean(10, available);
		ps.setInt(11, idHouse);

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