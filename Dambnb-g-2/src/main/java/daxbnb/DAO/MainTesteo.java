package daxbnb.DAO;

import java.sql.SQLException;

public class MainTesteo {

	public static void main(String[] args) {
		HousingDAO hDAO = new HousingDAO();
		UserDAO sDAO = new UserDAO();
		ReservesDAO rDAO = new ReservesDAO();
		try {
			//System.out.println(hDAO.selectAll()); 
			//System.out.println(hDAO.selectById(1));
			//System.out.println(hDAO.selectById(1));
			//System.out.println(hDAO.selectHousingByBedroom(2));
			//System.out.println(sDAO.selectAll());
			System.out.println(rDAO.selectByIdUser(3));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
