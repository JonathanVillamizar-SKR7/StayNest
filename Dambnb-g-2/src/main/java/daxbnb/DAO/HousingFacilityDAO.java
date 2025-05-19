package daxbnb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import daxbnb.model.Facilities;

public class HousingFacilityDAO {

    // Consultas SQL
    private static final String SELECT_BY_HOUSING_ID = "SELECT f.idFacility, f.typeFacility FROM Facilities f JOIN HousingFacilities hf ON f.idFacility = hf.idFacility WHERE hf.idHouse = ?";
    private static final String INSERT_FACILITY = "INSERT INTO HousingFacilities (idHouse, idFacility) VALUES (?, ?)";
    private static final String DELETE_FACILITY = "DELETE FROM HousingFacilities WHERE idHouse = ? AND idFacility = ?";
    private static final String SELECT_ALL = "SELECT hf.idHouse, f.idFacility, f.typeFacility FROM HousingFacilities hf JOIN Facilities f ON hf.idFacility = f.idFacility";

    private DBConnection db;

    public HousingFacilityDAO() {
        db = new DBConnection();
    }

    /**
     * Método para obtener todas las instalaciones de una vivienda específica.
     * @param idHouse ID de la vivienda.
     * @return Lista de objetos Facilities asociados a la vivienda.
     * @throws SQLException si ocurre un error en la conexión o en la consulta.
     */
    public List<Facilities> selectFacilitiesByHousingId(int idHouse) throws SQLException, ClassNotFoundException {
        List<Facilities> facilities = new ArrayList<>();
        Connection connection = db.connect();
        PreparedStatement ps = connection.prepareStatement(SELECT_BY_HOUSING_ID);
        ps.setInt(1, idHouse);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Facilities facility = new Facilities(rs.getInt("idFacility"), rs.getString("typeFacility"));
            facilities.add(facility);
        }

        rs.close();
        ps.close();
        db.closeConnection(connection);

        return facilities;
    }

    /**
     * Método para insertar una nueva instalación en una vivienda.
     * @param idHouse ID de la vivienda.
     * @param idFacility ID de la instalación.
     * @throws SQLException si ocurre un error en la inserción.
     * @throws ClassNotFoundException si no se encuentra la clase de conexión.
     */
    public void insertFacility(int idHouse, int idFacility) throws SQLException, ClassNotFoundException {
        Connection connection = db.connect();
        PreparedStatement ps = connection.prepareStatement(INSERT_FACILITY);
        ps.setInt(1, idHouse);
        ps.setInt(2, idFacility);
        ps.executeUpdate();
        ps.close();
        db.closeConnection(connection);
    }

    /**
     * Método para eliminar una instalación de una vivienda.
     * @param idHouse ID de la vivienda.
     * @param idFacility ID de la instalación.
     * @throws SQLException si ocurre un error en la eliminación.
     * @throws ClassNotFoundException si no se encuentra la clase de conexión.
     */
    public void deleteFacility(int idHouse, int idFacility) throws SQLException, ClassNotFoundException {
        Connection connection = db.connect();
        PreparedStatement ps = connection.prepareStatement(DELETE_FACILITY);
        ps.setInt(1, idHouse);
        ps.setInt(2, idFacility);
        ps.executeUpdate();
        ps.close();
        db.closeConnection(connection);
    }

    /**
     * Método para obtener todas las instalaciones de todas las viviendas.
     * @return Lista de objetos Facilities asociados a sus respectivas viviendas.
     * @throws SQLException si ocurre un error en la consulta.
     * @throws ClassNotFoundException si no se encuentra la clase de conexión.
     */
    public List<Facilities> selectAllFacilities() throws SQLException, ClassNotFoundException {
        List<Facilities> facilities = new ArrayList<>();
        Connection connection = db.connect();
        PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Facilities facility = new Facilities(rs.getInt("idFacility"), rs.getString("typeFacility"));
            facilities.add(facility);
        }

        rs.close();
        ps.close();
        db.closeConnection(connection);

        return facilities;
    }
}
