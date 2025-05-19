package daxbnb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import daxbnb.model.Images;

public class HousingImagesDAO {

    // Consultas SQL
    private static final String SELECT_ALL_BY_HOUSING_ID = "SELECT i.idImage, i.imgRoute FROM Images i INNER JOIN HousingImages hi ON i.idImage = hi.idImage WHERE hi.idHouse = ? ORDER BY i.idImage ASC";
    private static final String INSERT_IMAGE = "INSERT INTO HousingImages (idHouse, idImage) VALUES (?, ?)";
    private static final String DELETE_IMAGE = "DELETE FROM HousingImages WHERE idHouse = ? AND idImage = ?";
    private static final String SELECT_ALL = "SELECT hi.idHouse, i.idImage, i.imgRoute FROM HousingImages hi JOIN Images i ON hi.idImage = i.idImage";

    private DBConnection db;

    public HousingImagesDAO() {
        db = new DBConnection();
    }

    /**
     * Método para obtener todas las imágenes de una vivienda específica.
     * @param idHouse ID de la vivienda.
     * @return Lista de objetos Images asociados a la vivienda.
     * @throws SQLException si ocurre un error en la conexión o en la consulta.
     */
    public List<Images> selectImagesByHousingId(int idHouse) throws SQLException, ClassNotFoundException {
        List<Images> images = new ArrayList<>();
        Connection connection = db.connect();
        PreparedStatement ps = connection.prepareStatement(SELECT_ALL_BY_HOUSING_ID);
        ps.setInt(1, idHouse);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Images image = new Images(rs.getInt("idImage"), rs.getString("imgRoute"));
            images.add(image);
        }

        rs.close();
        ps.close();
        db.closeConnection(connection);

        return images;
    }

    /**
     * Método para insertar una nueva imagen en una vivienda.
     * @param idHouse ID de la vivienda.
     * @param idImage ID de la imagen.
     * @throws SQLException si ocurre un error en la inserción.
     * @throws ClassNotFoundException si no se encuentra la clase de conexión.
     */
    public void insertImage(int idHouse, int idImage) throws SQLException, ClassNotFoundException {
        Connection connection = db.connect();
        PreparedStatement ps = connection.prepareStatement(INSERT_IMAGE);
        ps.setInt(1, idHouse);
        ps.setInt(2, idImage);
        ps.executeUpdate();
        ps.close();
        db.closeConnection(connection);
    }

    /**
     * Método para eliminar una imagen de una vivienda.
     * @param idHouse ID de la vivienda.
     * @param idImage ID de la imagen.
     * @throws SQLException si ocurre un error en la eliminación.
     * @throws ClassNotFoundException si no se encuentra la clase de conexión.
     */
    public void deleteImage(int idHouse, int idImage) throws SQLException, ClassNotFoundException {
        Connection connection = db.connect();
        PreparedStatement ps = connection.prepareStatement(DELETE_IMAGE);
        ps.setInt(1, idHouse);
        ps.setInt(2, idImage);
        ps.executeUpdate();
        ps.close();
        db.closeConnection(connection);
    }

    /**
     * Método para obtener todas las imágenes de todas las viviendas.
     * @return Lista de objetos Images asociados a sus respectivas viviendas.
     * @throws SQLException si ocurre un error en la consulta.
     * @throws ClassNotFoundException si no se encuentra la clase de conexión.
     */
    public List<Images> selectAllImages() throws SQLException, ClassNotFoundException {
        List<Images> images = new ArrayList<>();
        Connection connection = db.connect();
        PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Images image = new Images(rs.getInt("idImage"), rs.getString("imgRoute"));
            images.add(image);
        }

        rs.close();
        ps.close();
        db.closeConnection(connection);

        return images;
    }
}
