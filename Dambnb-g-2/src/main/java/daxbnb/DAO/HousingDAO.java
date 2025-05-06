package daxbnb.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import daxbnb.model.Facilities;
import daxbnb.model.Housing;
import daxbnb.model.Images;

/**
 * DAO para gestionar operaciones de base de datos relacionadas con viviendas.
 * Proporciona métodos para consultar, insertar y filtrar viviendas.
 * 
 * Usa la clase {@link DBConnection} para manejar la conexión a la base de datos.
 * 
 * @author Alfredo, Jonathan, Diana
 * 
 */
public class HousingDAO {

    /** Consulta todas las viviendas. */
    private static final String SELECT_ALL = "SELECT * FROM Housing";

    /** Consulta por tipo de vivienda. */
    private static final String SELECT_BY_TYPE = "SELECT * FROM Housing WHERE idType = ?";

    /** Consulta por número de habitaciones. */
    private static final String SELECT_BY_BEDROOM = "SELECT * FROM Housing WHERE numBedroom = ?";

    /** Consulta para insertar nueva vivienda. */
    private static final String INSERT_HOUSING =
        "INSERT INTO Housing (name, location, numGuest, numBedroom, numBed, numBath, idType, price) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    /** Gestor de conexión con la base de datos. */
    private DBConnection db;

    /**
     * Constructor que inicializa el acceso a la base de datos.
     */
    public HousingDAO() {
        db = new DBConnection();
    }

    /**
     * Obtiene todas las viviendas registradas.
     * 
     * @return Lista de objetos {@link Housing}.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Housing> selectAll() throws SQLException, ClassNotFoundException {
        Connection connection = db.connect();
        PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
        ResultSet resultSet = ps.executeQuery();
        List<Housing> housings = new ArrayList<>();

        while (resultSet.next()) {
            Housing housing = new Housing(
                resultSet.getInt("idHouse"),
                resultSet.getString("name"),
                resultSet.getString("location"),
                resultSet.getInt("numGuest"),
                resultSet.getInt("numBedroom"),
                resultSet.getInt("numBed"),
                resultSet.getInt("numBath"),
                resultSet.getInt("idType"),
                resultSet.getDouble("price"),
                new ArrayList<>(), // imágenes
                new ArrayList<>()  // instalaciones
            );
            housings.add(housing);
        }

        resultSet.close();
        db.closeConnection(connection);
        return housings;
    }

    /**
     * Busca una vivienda por tipo.
     * 
     * @param idType ID del tipo de vivienda.
     * @return Objeto {@link Housing} o {@code null}.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Housing selectHousingByType(int idType) throws SQLException, ClassNotFoundException {
        Connection connection = db.connect();
        PreparedStatement ps = connection.prepareStatement(SELECT_BY_TYPE);
        ps.setInt(1, idType);
        ResultSet resultSet = ps.executeQuery();

        if (resultSet.next()) {
            Housing housing = new Housing(
                resultSet.getInt("idHouse"),
                resultSet.getString("name"),
                resultSet.getString("location"),
                resultSet.getInt("numGuest"),
                resultSet.getInt("numBedroom"),
                resultSet.getInt("numBed"),
                resultSet.getInt("numBath"),
                resultSet.getInt("idType"),
                resultSet.getDouble("price"),
                new ArrayList<>(), new ArrayList<>()
            );
            resultSet.close();
            db.closeConnection(connection);
            return housing;
        }

        resultSet.close();
        db.closeConnection(connection);
        return null;
    }

    /**
     * Busca una vivienda por número de habitaciones.
     * 
     * @param numBedroom Número de habitaciones.
     * @return Objeto {@link Housing} o {@code null}.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Housing selectHousingByBedroom(int numBedroom) throws SQLException, ClassNotFoundException {
        Connection connection = db.connect();
        PreparedStatement ps = connection.prepareStatement(SELECT_BY_BEDROOM);
        ps.setInt(1, numBedroom);
        ResultSet resultSet = ps.executeQuery();

        if (resultSet.next()) {
            Housing housing = new Housing(
                resultSet.getInt("idHouse"),
                resultSet.getString("name"),
                resultSet.getString("location"),
                resultSet.getInt("numGuest"),
                resultSet.getInt("numBedroom"),
                resultSet.getInt("numBed"),
                resultSet.getInt("numBath"),
                resultSet.getInt("idType"),
                resultSet.getDouble("price"),
                new ArrayList<>(), new ArrayList<>()
            );
            resultSet.close();
            db.closeConnection(connection);
            return housing;
        }

        resultSet.close();
        db.closeConnection(connection);
        return null;
    }

    /**
     * Inserta una nueva vivienda en la base de datos.
     * 
     * @param name Nombre.
     * @param location Ubicación.
     * @param numGuest Número de huéspedes.
     * @param numBedroom Número de habitaciones.
     * @param numBed Número de camas.
     * @param numBath Número de baños.
     * @param idType ID del tipo.
     * @param price Precio.
     * @param images Lista de imágenes (no se insertan en esta operación).
     * @param facilities Lista de servicios (no se insertan en esta operación).
     * @return ID generado de la nueva vivienda.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int insertHousing(String name, String location, int numGuest, int numBedroom, int numBed,
                             int numBath, int idType, double price,
                             List<Images> images, List<Facilities> facilities)
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

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("No se pudo insertar la vivienda");
        }

        int generatedId = -1;
        ResultSet generatedKeys = ps.getGeneratedKeys();
        if (generatedKeys.next()) {
            generatedId = generatedKeys.getInt(1);
        }

        db.closeConnection(connection);
        return generatedId;
    }
}
