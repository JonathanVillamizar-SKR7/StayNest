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
<<<<<<< HEAD
 * Clase encargada de cargar datos de demostración desde archivos CSV a la base
 * de datos para propósitos de prueba o desarrollo.
=======
 * Carga datos de archivos CSV a la base de datos.
>>>>>>> 89d4511 (JavaDoc 5.02)
 * 
 * @author Alfredo, Jonathan, Diana
 */
public class loadDemoData {

<<<<<<< HEAD
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

    private static int loadTypes(Connection connection) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(Paths.get("files/Types.csv").toFile()));
        String line = reader.readLine(); // skip header
        line = reader.readLine();
        int result = 0;
        while (line != null) {
            String[] fields = line.split(";");
            int idType = Integer.parseInt(fields[0]);
            String sql = "INSERT INTO Types (idType, Type) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idType);
            ps.setString(2, fields[1]);
            result += ps.executeUpdate();
            ps.close();
            line = reader.readLine();
        }
        System.out.println("-Datos Types ingresados");
        reader.close();
        return result;
    }

    private static int loadHousing(Connection connection) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(Paths.get("files/Housing.csv").toFile()));
        reader.readLine(); // skip header
        String line = reader.readLine();
        int result = 0;
        while (line != null) {
            String[] fields = line.split(";");
            int idHouse = Integer.parseInt(fields[0]);
            int numGuest = Integer.parseInt(fields[3]);
            int numBedroom = Integer.parseInt(fields[4]);
            int numBed = Integer.parseInt(fields[5]);
            int numBath = Integer.parseInt(fields[6]);
            int idType = Integer.parseInt(fields[7]);
            double price = Double.parseDouble(fields[8].trim().replace(",", "."));
            String sql = "INSERT INTO Housing (idHouse, name, location, numGuest, numBedroom, numBed, numBath, idType, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idHouse);
            ps.setString(2, fields[1]);
            ps.setString(3, fields[2]);
            ps.setInt(4, numGuest);
            ps.setInt(5, numBedroom);
            ps.setInt(6, numBed);
            ps.setInt(7, numBath);
            ps.setInt(8, idType);
            ps.setDouble(9, price);
            result += ps.executeUpdate();
            ps.close();
            line = reader.readLine();
        }
        System.out.println("-Datos Housing ingresados");
        reader.close();
        return result;
    }

    public static int loadUser(Connection connection) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(Paths.get("files/User.csv").toFile()));
        reader.readLine(); // skip header
        String line = reader.readLine();
        int result = 0;
        while (line != null) {
            String[] fields = line.split(";");
            int idUser = Integer.parseInt(fields[0]);
            long phone = Long.parseLong(fields[2]);
            int passport = Integer.parseInt(fields[4]);
            String sql = "INSERT INTO Users (idUser, userName, phone, email, passport) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idUser);
            ps.setString(2, fields[1]);
            ps.setLong(3, phone);
            ps.setString(4, fields[3]);
            ps.setInt(5, passport);
            result += ps.executeUpdate();
            ps.close();
            line = reader.readLine();
        }
        System.out.println("-Datos Users ingresados");
        reader.close();
        return result;
    }

    public static int loadDetails(Connection connection) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(Paths.get("files/Details.csv").toFile()));
        reader.readLine(); // skip header
        String line = reader.readLine();
        int result = 0;
        while (line != null) {
            String[] fields = line.split(";");
            String sql = "INSERT INTO Details (userName, password, userType, userDescription) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, fields[0]);
            ps.setString(2, fields[1]);
            ps.setString(3, fields[2]);
            ps.setString(4, fields[3]);
            result += ps.executeUpdate();
            ps.close();
            line = reader.readLine();
        }
        System.out.println("-Datos Details ingresados");
        reader.close();
        return result;
    }

    public static int loadCreditCard(Connection connection) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(Paths.get("files/CreditCards.csv").toFile()));
        reader.readLine(); // skip header
        String line = reader.readLine();
        int result = 0;
        while (line != null) {
            String[] fields = line.split(";");
            int idCreditCard = Integer.parseInt(fields[0]);
            long creditCardNumber = Long.parseLong(fields[2]);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date expirationDate = new java.sql.Date(sdf.parse(fields[3]).getTime());
            int cvv = Integer.parseInt(fields[4]);
            int idUser = Integer.parseInt(fields[5]);
            String sql = "INSERT INTO CreditCards (idCreditCard, cardHolderName, creditCardNumber, expirationDate, cvv, idUser) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idCreditCard);
            ps.setString(2, fields[1]);
            ps.setLong(3, creditCardNumber);
            ps.setDate(4, expirationDate);
            ps.setInt(5, cvv);
            ps.setInt(6, idUser);
            result += ps.executeUpdate();
            ps.close();
            line = reader.readLine();
        }
        System.out.println("-Datos CreditCards ingresados");
        reader.close();
        return result;
    }

    public static int loadReserve(Connection connection) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(Paths.get("files/Reserve.csv").toFile()));
        reader.readLine(); // skip header
        String line = reader.readLine();
        int result = 0;
        while (line != null) {
            String[] fields = line.split(";");
            int idReserve = Integer.parseInt(fields[0]);
            int idHouse = Integer.parseInt(fields[1]);
            int idUser = Integer.parseInt(fields[2]);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date checkIn = new java.sql.Date(sdf.parse(fields[4]).getTime());
            java.sql.Date checkOut = new java.sql.Date(sdf.parse(fields[5]).getTime());
            int numGuests = Integer.parseInt(fields[6]);
            double totalPrice = Double.parseDouble(fields[7]);
            String sql = "INSERT INTO Reserves (idReserve, idHouse, idUser, name, checkIn, checkOut, numGuests, totalPrice) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idReserve);
            ps.setInt(2, idHouse);
            ps.setInt(3, idUser);
            ps.setString(4, fields[3]);
            ps.setDate(5, checkIn);
            ps.setDate(6, checkOut);
            ps.setInt(7, numGuests);
            ps.setDouble(8, totalPrice);
            result += ps.executeUpdate();
            ps.close();
            line = reader.readLine();
        }
        System.out.println("-Datos Reserves ingresados");
        reader.close();
        return result;
    }

    public static int loadImages(Connection connection) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(Paths.get("files/Images.csv").toFile()));
        reader.readLine(); // skip header
        String line = reader.readLine();
        int result = 0;
        while (line != null) {
            String[] fields = line.split(";");
            int idImage = Integer.parseInt(fields[0]);
            String sql = "INSERT INTO Images (idImage, imgRoute) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idImage);
            ps.setString(2, fields[1]);
            result += ps.executeUpdate();
            ps.close();
            line = reader.readLine();
        }
        System.out.println("-Datos Images ingresados");
        reader.close();
        return result;
    }

    public static int loadFacilities(Connection connection) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(Paths.get("files/Facility.csv").toFile()));
        reader.readLine(); // skip header
        String line = reader.readLine();
        int result = 0;
        while (line != null) {
            String[] fields = line.split(";");
            int idFacility = Integer.parseInt(fields[0]);
            String sql = "INSERT INTO Facilities (idFacility, typeFacility) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idFacility);
            ps.setString(2, fields[1]);
            result += ps.executeUpdate();
            ps.close();
            line = reader.readLine();
        }
        System.out.println("-Datos Facilities ingresados");
        reader.close();
        return result;
    }

    public static int loadHousingFacilities(Connection connection) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(Paths.get("files/HousingFacilities.csv").toFile()));
        reader.readLine(); // skip header
        String line = reader.readLine();
        int result = 0;
        while (line != null) {
            String[] fields = line.split(";");
            int idHouse = Integer.parseInt(fields[0]);
            int idFacility = Integer.parseInt(fields[1]);
            String sql = "INSERT INTO HousingFacilities (idHouse, idFacility) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idHouse);
            ps.setInt(2, idFacility);
            result += ps.executeUpdate();
            ps.close();
            line = reader.readLine();
        }
        System.out.println("-Datos HousingFacilities ingresados");
        reader.close();
        return result;
    }
=======
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
			int idHouse = Integer.parseInt(fields[0]);
			int numGuest = Integer.parseInt(fields[3]);
			int numBedroom = Integer.parseInt(fields[4]);
			int numBed = Integer.parseInt(fields[5]);
			int numBath = Integer.parseInt(fields[6]);
			int idType = Integer.parseInt(fields[7]);
			double price = Double.parseDouble(fields[8].trim().replace(",", "."));
			String sql = "INSERT INTO Housing (idHouse,name,location,numGuest,numBedroom,numBed,numBath,idType,price) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? )";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, idHouse);
			ps.setString(2, fields[1]);
			ps.setString(3, fields[2]);
			ps.setInt(4, numGuest);
			ps.setInt(5, numBedroom);
			ps.setInt(6, numBed);
			ps.setInt(7, numBath);
			ps.setInt(8, idType);
			ps.setDouble(9, price);
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
>>>>>>> 89d4511 (JavaDoc 5.02)
}
