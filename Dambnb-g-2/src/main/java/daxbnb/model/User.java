package daxbnb.model;

import java.sql.Date;

public class User extends Reserve {
	private String userName;
	private int idUser;
	private int phone;
	private String email;
	private int passport;
	
	public User(int idHouse, String name, String description, String location, int numGuest, int numBedroom, int numBed,
			int numBath, int idType, double price, int idReserva, int idHouse2, int idUser, String name2, Date checkIn,
			Date checkOut, int numGuests, double totalPrice, String userName, int idUser2, int phone, String email,
			int passport) {
		super(idHouse, name, description, location, numGuest, numBedroom, numBed, numBath, idType, price, idReserva,
				idHouse2, idUser, name2, checkIn, checkOut, numGuests, totalPrice);
		this.userName = userName;
		idUser = idUser2;
		this.phone = phone;
		this.email = email;
		this.passport = passport;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPassport() {
		return passport;
	}

	public void setPassport(int passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", idUser=" + idUser + ", phone=" + phone + ", email=" + email
				+ ", passport=" + passport + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
