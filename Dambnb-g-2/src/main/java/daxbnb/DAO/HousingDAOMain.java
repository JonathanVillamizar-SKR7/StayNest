package daxbnb.DAO;

import java.sql.SQLException;
import java.util.List;
import daxbnb.DAO.HousingDAO;
import daxbnb.model.Housing;

public class HousingDAOMain {
	public static void main(String[] args) {
		HousingDAO housingDAO = new HousingDAO();
		try {

			List<Housing> housings = housingDAO.selectAll();
			housings.stream().forEach(System.out::println);
		} catch (ClassNotFoundException e) {
			System.err.println("Error: Driver not found.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Error connecting to Data Base.");
			e.printStackTrace();
		}
	}
}
