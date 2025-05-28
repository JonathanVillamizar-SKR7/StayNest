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

public class ImagesDAO {

	private static final String SELECT_ALL = "SELECT * FROM Images";
	private static final String SELECT_BY_ID = "SELECT * FROM Images where idImage = ?";
	private static final String INSERT_IMAGE = "INSERT INTO Images (imgRoute) VALUES (?)";
	private static final String UPDATE_FACILITY = "UPDATE Images SET imgRoute = ? WHERE idImage = ?";
	private static final String DELETE_FACILITY = "DELETE FROM Images WHERE idImage = ?";
	private DBConnection db;
	
	/**
	 * Constructor que inicializa la conexión con la base de datos.
	 */
	public ImagesDAO() {
		db = new DBConnection();
	}
	
	
	/**
	 * Selecciona todas las imagenes de la base de datos.
	 * 
	 * @return Lista de objetos Image con todas las imagenes encontradas
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Images> selectAll() throws SQLException,ClassNotFoundException{
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
		ResultSet rs = ps.executeQuery();
		List<Images> images = new ArrayList<>();
		
		while (rs.next()) {
			if(!rs.wasNull()) {
				Images image = new Images(rs.getInt("idImage"),rs.getString("imgRoute"));
				images.add(image);
			}
		}
		rs.close();
		db.closeConnection(connection);
		return images;
	}
	
	/**
	 * Selecciona una Imagen especifica por su ID.
	 * 
	 * @param idImage    ID de la instalacion a buscar
	 * @return Objeto Images correspondiente al ID proporcionado, o null si no
	 *         existe.
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Images selectById(int idImage) throws SQLException,ClassNotFoundException{
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID);
		ResultSet rs = ps.executeQuery();
		Images images = null;
		while (rs.next()) {
			if(!rs.wasNull()) {
				images = new Images(rs.getInt("idImage"),rs.getString("imgRoute"));
			}
		}
		rs.close();
		db.closeConnection(connection);
		return images;
	
	}
	
	/**
	 * Inserta una nueva Imagen a la base de datos
	 * 
	 * @param imgRoute
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int insertImage(String imgRoute) throws SQLException,ClassNotFoundException{
		Connection connection = db.connect();
		PreparedStatement ps = connection.prepareStatement(INSERT_IMAGE, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, imgRoute);
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
	
}
