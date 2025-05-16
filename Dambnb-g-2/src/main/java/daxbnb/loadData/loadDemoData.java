package daxbnb.loadData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.sql.Statement;
import java.util.Date;

import daxbnb.DAO.DBConnection;

/**
 * 
 * Clase encargada de cargar datos de demostración desde archivos CSV a la base
 * de datos para propósitos de prueba o desarrollo.
 * 
 * @author Alfredo, Jonathan, Diana
 */
public class loadDemoData {
	public static void main(String[] args) {
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.connect();

			loadTypes(connection);
			loadHousing(connection);
			loadUser(connection);
			loadDetails(connection);
			loadCreditCard(connection);
			loadReserve(connection);
			loadImages(connection);
			loadFacilities(connection);
			loadHousingFacilities(connection);

			dbConnection.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Carga datos a la tabla Types.
	 * 
	 * @param connection
	 * @return Resultado de la última inserción.
	 * @throws Exception
	 */
	private static int loadTypes(Connection connection) throws Exception {
		FileReader fr = new FileReader(Paths.get("files/Types.csv").toFile());
		BufferedReader reader = new BufferedReader(fr);
		String line = "";
		line = reader.readLine();
		line = reader.readLine();
		int result = 0;
		while (line != null) {
			String fields[] = line.split(";");
			int idType = Integer.parseInt(fields[0]);
			String sql = "INSERT INTO Types (idType,Type) VALUES ( ?, ? )";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, idType);
			ps.setString(2, fields[1]);
			result = ps.executeUpdate();
			ps.close();
			line = reader.readLine();
		}
		System.out.println("-Datos types ingresados");
		reader.close();
		return result;
	}

	/**
	 * Carga datos a la tabla Housing.
	 * 
	 * @param connection
	 * @return Resultado de la última inserción.
	 * @throws Exception
	 */
	private static int loadHousing(Connection connection) throws Exception {
		FileReader fr = new FileReader(Paths.get("files/Housing.csv").toFile());
		BufferedReader reader = new BufferedReader(fr);
		String line = "";
		line = reader.readLine();
		line = reader.readLine();
		int result = 0;
		while (line != null) {
			String fields[] = line.split(";");
			String name = fields[0];
			String location = fields[1];
			int numGuest = Integer.parseInt(fields[2]);
			int numBedroom = Integer.parseInt(fields[3]);
			int numBed = Integer.parseInt(fields[4]);
			int numBath = Integer.parseInt(fields[5]);
			int idType = Integer.parseInt(fields[6]);
			double price = Double.parseDouble(fields[7].trim().replace(",", "."));
			String description = fields[8];
			boolean available = Boolean.parseBoolean(fields[9]);

			String sql = "INSERT INTO Housing (name,location,numGuest,numBedroom,numBed,numBath,idType,price,description,available) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
			PreparedStatement ps = connection.prepareStatement(sql);
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

			result = ps.executeUpdate();
			ps.close();
			line = reader.readLine();
		}
		System.out.println("-Datos Housing ingresados");
		reader.close();
		return result;
	}

	/**
	 * Carga datos a la tabla Details.
	 * 
	 * @param connection
	 * @return Resultado de la última inserción.
	 * @throws Exception
	 */
	public static int loadDetails(Connection connection) throws Exception {
		FileReader fr = new FileReader(Paths.get("files/Details.csv").toFile());
		BufferedReader reader = new BufferedReader(fr);
		String line = "";
		line = reader.readLine();
		line = reader.readLine();
		int result = 0;
		while (line != null) {
			String fields[] = line.split(";");
			String sql = "INSERT INTO Details (userName,password,userType,userDescription) VALUES ( ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, fields[0]);
			ps.setString(2, fields[1]);
			ps.setString(3, fields[2]);
			ps.setString(4, fields[3]);
			result = ps.executeUpdate();
			ps.close();
			line = reader.readLine();
		}
		System.out.println("-Datos Details ingresados");
		reader.close();
		return result;
	}

	/**
	 * Carga datos a la tabla Users.
	 * 
	 * @param connection
	 * @return Resultado de la última inserción.
	 * @throws Exception
	 */
	public static int loadUser(Connection connection) throws Exception {
		FileReader fr = new FileReader(Paths.get("files/User.csv").toFile());
		BufferedReader reader = new BufferedReader(fr);
		String line = "";
		line = reader.readLine();
		line = reader.readLine();
		int result = 0;
		while (line != null) {
			String fields[] = line.split(";");
			long phone = Long.parseLong(fields[1]);
			int passport = Integer.parseInt(fields[3]);
			String sql = "INSERT INTO Users (userName, phone, email, passport) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, fields[0]);
			ps.setLong(2, phone);
			ps.setString(3, fields[2]);
			ps.setInt(4, passport);

			result = ps.executeUpdate();
			ps.close();
			line = reader.readLine();
		}
		System.out.println("-Datos User ingresados");
		reader.close();
		return result;
	}

	/**
	 * Carga datos a la tabla CreditCards.
	 * 
	 * @param connection
	 * @return Resultado de la última inserción.
	 * @throws Exception
	 */
	public static int loadCreditCard(Connection connection) throws Exception {
		FileReader fr = new FileReader(Paths.get("files/CreditCards.csv").toFile());
		BufferedReader reader = new BufferedReader(fr);
		String line = "";
		line = reader.readLine();
		line = reader.readLine();
		int result = 0;
		while (line != null) {
			String fields[] = line.split(";");
			long creditCardNumber = Long.parseLong(fields[1]);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date parsed = sdf.parse(fields[2]);
			java.sql.Date expirationDate = new java.sql.Date(parsed.getTime());
			int cvv = Integer.parseInt(fields[3]);
			int idUser = Integer.parseInt(fields[4]);
			String sql = "INSERT INTO CreditCards (cardHolderName, creditCardNumber, expirationDate, cvv, idUser) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, fields[0]);
			ps.setLong(2, creditCardNumber);
			ps.setDate(3, expirationDate);
			ps.setInt(4, cvv);
			ps.setInt(5, idUser);
			result = ps.executeUpdate();
			ps.close();
			line = reader.readLine();
		}
		System.out.println("-Datos CreditCard ingresados");
		reader.close();
		return result;
	}

	/**
	 * 
	 * Carga datos a la tabla Reserves.
	 * 
	 * @param connection
	 * @return Resultado de la última inserción.
	 * @throws Exception
	 */
	public static int loadReserve(Connection connection) throws Exception {
		FileReader fr = new FileReader(Paths.get("files/Reserve.csv").toFile());
		BufferedReader reader = new BufferedReader(fr);
		String line = "";
		line = reader.readLine();
		line = reader.readLine();
		int result = 0;

		while (line != null) {
			String fields[] = line.split(";");

			int idHouse = Integer.parseInt(fields[0]);
			int idUser = Integer.parseInt(fields[1]);
			String nameH = fields[2];
			// Parseo de fechas
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date parsed = sdf.parse(fields[3]);
			java.sql.Date checkIn = new java.sql.Date(parsed.getTime());

			Date parsed2 = sdf.parse(fields[4]);
			java.sql.Date checkOut = new java.sql.Date(parsed2.getTime());

			int numGuests = Integer.parseInt(fields[5]);
			double totalPrice = Double.parseDouble(fields[6]);

			String sql = "INSERT INTO Reserves (idHouse, idUser, nameH, checkIn, checkOut, numGuests, totalPrice) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, idHouse);
			ps.setInt(2, idUser);
			ps.setString(3, nameH);
			ps.setDate(4, checkIn);
			ps.setDate(5, checkOut);
			ps.setInt(6, numGuests);
			ps.setDouble(7, totalPrice);

			result = ps.executeUpdate();
			ps.close();
			line = reader.readLine();
		}
		System.out.println("-Datos Reserve ingresados");
		reader.close();
		return result;
	}

	/**
	 * Carga datos a la tabla Images.
	 * 
	 * @param connection
	 * @return Resultado de la última inserción.
	 * @throws Exception
	 */
	public static int loadImages(Connection connection) throws Exception {
		FileReader fr = new FileReader(Paths.get("files/Images.csv").toFile());
		BufferedReader reader = new BufferedReader(fr);
		String line = "";
		line = reader.readLine();
		line = reader.readLine();
		int result = 0;
		while (line != null) {
			String fields[] = line.split(";");
			String idRoute = (fields[0]);
			String sql = "INSERT INTO Images (imgRoute) VALUES ( ? )";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, idRoute);
			result = ps.executeUpdate();
			ps.close();
			line = reader.readLine();
		}
		System.out.println("-Datos Image ingresados");
		reader.close();
		return result;
	}

	/**
	 * Carga datos a la tabla Facilities.
	 * 
	 * @param connection
	 * @return Resultado de la última inserción.
	 * @throws Exception
	 */
	public static int loadFacilities(Connection connection) throws Exception {
		FileReader fr = new FileReader(Paths.get("files/Facility.csv").toFile());
		BufferedReader reader = new BufferedReader(fr);
		String line = "";
		line = reader.readLine();
		line = reader.readLine();
		int result = 0;

		while (line != null) {
			String fields[] = line.split(";");

			if (fields.length > 0 && !fields[0].isEmpty()) {
				String typeFacility = fields[0];
				String sql = "INSERT INTO Facilities (typeFacility) VALUES (?)";
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, typeFacility);

				result = ps.executeUpdate();
				ps.close();

			}
			line = reader.readLine();
		}
		System.out.println("-Datos Facilities ingresados");
		reader.close();
		return result;
	}

	/**
	 * Carga datos a la tabla HousingFacilities.
	 * 
	 * @param connection
	 * @return Resultado de la última inserción.
	 * @throws Exception
	 */
	public static int loadHousingFacilities(Connection connection) throws Exception {
		FileReader fr = new FileReader(Paths.get("files/HousingFacilities.csv").toFile());
		BufferedReader reader = new BufferedReader(fr);
		String line = "";
		line = reader.readLine();
		line = reader.readLine();
		int result = 0;
		while (line != null) {
			String fields[] = line.split(";");
			int idHouse = Integer.parseInt(fields[0]);
			int idFacility = Integer.parseInt(fields[1]);

			String sql = "INSERT INTO HousingFacilities (idHouse,idFacility) VALUES ( ?, ? )";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, idHouse);
			ps.setInt(2, idFacility);

			result = ps.executeUpdate();
			ps.close();
			line = reader.readLine();
		}
		System.out.println("-Datos HousingFacilities ingresados");
		reader.close();
		return result;
	}

	/**
	 * 	Carga datos a la tabla HousingImages
	 * 
	 * @param connection
	 * @return resultado de los cambios
	 * @throws Exception
	 */
	public static int loadHousingImages(Connection connection) throws Exception {
		FileReader fr = new FileReader(Paths.get("files/HousingImages.csv").toFile());
		BufferedReader reader = new BufferedReader(fr);
		String line = "";
		line = reader.readLine();
		line = reader.readLine();
		int result = 0;
		while (line != null) {
			String fields[] = line.split(";");
			int idHouse = Integer.parseInt(fields[0]);
			int idImage = Integer.parseInt(fields[1]);
			
			String sql = "INSERT INTO HousingImages (idHouse,idImage) VALUES ( ?, ? )";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, idHouse);
			ps.setInt(2, idImage);
			result = ps.executeUpdate();
			ps.close();
			line = reader.readLine();
		}
		System.out.println("-Datos HousingImages ingresados");
		reader.close();
		return result;
	}
}
