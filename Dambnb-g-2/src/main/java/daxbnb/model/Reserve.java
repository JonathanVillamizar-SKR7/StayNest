package daxbnb.model;

import java.util.Date;

public class Reserve extends Housing{

	private int idReserva;
	private int idHouse;
	private int idUser;
	private String name;
	private Date checkIn;
	private Date checkOut;
	private int numGuests;
	private double totalPrice;
	
	public Reserve(int idHouse, String name, String description, String location, int numGuest, int numBedroom,
			int numBed, int numBath, int idType, double price, int idReserva, int idHouse2, int idUser, String name2,
			Date checkIn, Date checkOut, int numGuests, double totalPrice) {
		super(idHouse, name, description, location, numGuest, numBedroom, numBed, numBath, idType, price);
		this.idReserva = idReserva;
		idHouse = idHouse2;
		this.idUser = idUser;
		name = name2;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numGuests = numGuests;
		this.totalPrice = totalPrice;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public int getIdHouse() {
		return idHouse;
	}

	public void setIdHouse(int idHouse) {
		this.idHouse = idHouse;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public int getNumGuests() {
		return numGuests;
	}

	public void setNumGuests(int numGuests) {
		this.numGuests = numGuests;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Reserve [idReserva=" + idReserva + ", idHouse=" + idHouse + ", idUser=" + idUser + ", name=" + name
				+ ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", numGuests=" + numGuests + ", totalPrice="
				+ totalPrice + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
