package daxbnb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import daxbnb.DAO.DBConnection;
import daxbnb.model.Types;

public class TypesDAO {

    private static final String SELECT_BY_ID = "SELECT * FROM Types WHERE idType = ?";
    private DBConnection db;

    /**
     * Constructor para inicializar la conexión.
     */
    public TypesDAO() {
        db = new DBConnection();
    }

    /**
     * Busca un objeto Types por su ID en la base de datos.
     * 
     * @param idType ID del tipo de vivienda.
     * @return Un objeto Types si se encuentra; de lo contrario, null.
     * @throws SQLException           Si ocurre un error al ejecutar la consulta.
     * @throws ClassNotFoundException Si no se encuentra la clase de conexión.
     */
    public Types selectById(int idType) throws SQLException, ClassNotFoundException {
        Connection connection = db.connect();
        PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID);
        ps.setInt(1, idType);
        ResultSet rs = ps.executeQuery();

        Types type = null;

        // 🔄 Si se encuentra el resultado, creamos el objeto
        if (rs.next()) {
            String typeName = rs.getString("typeName"); // El nombre del tipo en la base de datos
            try {
                type = Types.valueOf(typeName); // 🔄 Esto convierte el nombre al valor del Enum
            } catch (IllegalArgumentException e) {
                System.out.println("Error: No se encontró un valor enum para: " + typeName);
            }
        }

        rs.close();
        db.closeConnection(connection);
        return type;
    }
}
