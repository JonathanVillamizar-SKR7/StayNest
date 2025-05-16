package daxbnb.DAO;

import java.sql.SQLException;

public class MainTesteo {

	public static void main(String[] args) {
		HousingDAO hDAO = new HousingDAO();
		try {
			hDAO.selectAll();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
