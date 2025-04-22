package daxbnb.model;

import java.sql.Date;

public class Details extends User{

    private String userName;
    private String password;
    private String userType;
    private String description;
    
	public Details(int idHouse, String name, String description, String location, int numGuest, int numBedroom,
			int numBed, int numBath, int idType, double price, int idReserva, int idHouse2, int idUser, String name2,
			Date checkIn, Date checkOut, int numGuests, double totalPrice, String userName, int idUser2, int phone,
			String email, int passport, String userName2, String password, String userType, String description2) {
		super(idHouse, name, description, location, numGuest, numBedroom, numBed, numBath, idType, price, idReserva,
				idHouse2, idUser, name2, checkIn, checkOut, numGuests, totalPrice, userName, idUser2, phone, email,
				passport);
		userName = userName2;
		this.password = password;
		this.userType = userType;
		description = description2;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Details [userName=" + userName + ", password=" + password + ", userType=" + userType + ", description="
				+ description + ", toString()=" + super.toString() + "]";
	}
    
    
}
