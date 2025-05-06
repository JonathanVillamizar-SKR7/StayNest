package daxbnb.loadData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import daxbnb.DAO.DBConnection;

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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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

			String sql = "INSERT INTO Housing (name,location,numGuest,numBedroom,numBed,numBath,idType,price) VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, location);
			ps.setInt(3, numGuest);
			ps.setInt(4, numBedroom);
			ps.setInt(5, numBed);
			ps.setInt(6, numBath);
			ps.setInt(7, idType);
			ps.setDouble(8, price);

			result = ps.executeUpdate();
			ps.close();
			line = reader.readLine();
		}
		System.out.println("-Datos Housing ingresados");
		reader.close();
		return result;
	}

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

	public static int loadUser(Connection connection) throws Exception {
		FileReader fr = new FileReader(Paths.get("files/User.csv").toFile());
		BufferedReader reader = new BufferedReader(fr);
		String line = "";
		line = reader.readLine();
		line = reader.readLine();
		int result = 0;
		while (line != null) {
			String fields[] = line.split(";");
			int idUser = Integer.parseInt(fields[0]);
			long phone = Long.parseLong(fields[2]);
			int passport = Integer.parseInt(fields[4]);
			String sql = "INSERT INTO Users (idUser,userName,phone,email,passport) VALUES ( ?, ? , ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, idUser);
			ps.setString(2, fields[1]);
			ps.setLong(3, phone);
			ps.setString(4, fields[3]);
			ps.setInt(5, passport);
			result = ps.executeUpdate();
			ps.close();
			line = reader.readLine();
		}
		System.out.println("-Datos User ingresados");
		reader.close();
		return result;
	}

	public static int loadCreditCard(Connection connection) throws Exception {
		FileReader fr = new FileReader(Paths.get("files/CreditCards.csv").toFile());
		BufferedReader reader = new BufferedReader(fr);
		String line = "";
		line = reader.readLine();
		line = reader.readLine();
		int result = 0;
		while (line != null) {
			String fields[] = line.split(";");
			int idCreditCard = Integer.parseInt(fields[0]);
			long creditCardNumber = Long.parseLong(fields[2]);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date parsed = sdf.parse(fields[3]);
			java.sql.Date expirationDate = new java.sql.Date(parsed.getTime());
			int cvv = Integer.parseInt(fields[4]);
			int idUser = Integer.parseInt(fields[5]);
			String sql = "INSERT INTO CreditCards (idCreditCard,cardHolderName,creditCardNumber,expirationDate,cvv,idUser) VALUES ( ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, idCreditCard);
			ps.setString(2, fields[1]);
			ps.setLong(3, creditCardNumber);
			ps.setDate(4, expirationDate);
			ps.setInt(5, cvv);
			ps.setInt(6, idUser);
			result = ps.executeUpdate();
			ps.close();
			line = reader.readLine();
		}
		System.out.println("-Datos CreditCard ingresados");
		reader.close();
		return result;
	}

	public static int loadReserve(Connection connection) throws Exception {
		FileReader fr = new FileReader(Paths.get("files/Reserve.csv").toFile());
		BufferedReader reader = new BufferedReader(fr);
		String line = "";
		line = reader.readLine();
		line = reader.readLine();
		int result = 0;
		while (line != null) {
			String fields[] = line.split(";");
			int idReserve = Integer.parseInt(fields[0]);
			int idHouse = Integer.parseInt(fields[1]);
			int idUser = Integer.parseInt(fields[2]);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date parsed = sdf.parse(fields[4]);
			java.sql.Date checkIn = new java.sql.Date(parsed.getTime());
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
			Date parsed2 = sdf2.parse(fields[5]);
			java.sql.Date checkOut = new java.sql.Date(parsed2.getTime());
			int numGuests = Integer.parseInt(fields[6]);
			double totalPrice = Double.parseDouble(fields[7]);
			String sql = "INSERT INTO Reserves (idReserve,idHouse,idUser,name,checkIn,checkOut,numGuests,totalPrice) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, idReserve);
			ps.setInt(2, idHouse);
			ps.setInt(3, idUser);
			ps.setString(4, fields[3]);
			ps.setDate(5, checkIn);
			ps.setDate(6, checkOut);
			ps.setInt(7, numGuests);
			ps.setDouble(8, totalPrice);
			result = ps.executeUpdate();
			ps.close();
			line = reader.readLine();
		}
		System.out.println("-Datos Reserve ingresados");
		reader.close();
		return result;
	}

	public static int loadImages(Connection connection) throws Exception {
		FileReader fr = new FileReader(Paths.get("files/Images.csv").toFile());
		BufferedReader reader = new BufferedReader(fr);
		String line = "";
		line = reader.readLine();
		line = reader.readLine();
		int result = 0;
		while (line != null) {
			String fields[] = line.split(";");
			int idImage = Integer.parseInt(fields[0]);
			String sql = "INSERT INTO Images (idImage,imgRoute) VALUES ( ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, idImage);
			ps.setString(2, fields[1]);
			result = ps.executeUpdate();
			ps.close();
			line = reader.readLine();
		}
		System.out.println("-Datos Image ingresados");
		reader.close();
		return result;
	}

	public static int loadFacilities(Connection connection) throws Exception {
		FileReader fr = new FileReader(Paths.get("files/Facility.csv").toFile());
		BufferedReader reader = new BufferedReader(fr);
		String line = "";
		line = reader.readLine();
		line = reader.readLine();
		int result = 0;
		while (line != null) {
			String fields[] = line.split(";");
			int idFacility = Integer.parseInt(fields[0]);
			String sql = "INSERT INTO Facilities (idFacility,typeFacility) VALUES ( ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, idFacility);
			ps.setString(2, fields[1]);
			result = ps.executeUpdate();
			ps.close();
			line = reader.readLine();
		}
		System.out.println("-Datos Facilities ingresados");
		reader.close();
		return result;
	}

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
			boolean available = Integer.parseInt(fields[2]) == 1;
			int idImage = Integer.parseInt(fields[4]);
			String sql = "INSERT INTO HousingFacilities (idHouse,idFacility,available,description,idImage) VALUES ( ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, idHouse);
			ps.setInt(2, idFacility);
			ps.setBoolean(3, available);
			ps.setString(4, fields[3]);
			ps.setInt(5, idImage);
			result = ps.executeUpdate();
			ps.close();
			line = reader.readLine();
		}
		System.out.println("-Datos HousingFacilities ingresados");
		reader.close();
		return result;
	}
}
