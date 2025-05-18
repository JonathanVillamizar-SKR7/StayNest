package daxbnb.DAO;

import java.sql.SQLException;

public class MainTesteo {

	public static void main(String[] args) {
		HousingDAO hDAO = new HousingDAO();
		try {
			//hDAO.selectAll();
			System.out.println(hDAO.selectById(1));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
