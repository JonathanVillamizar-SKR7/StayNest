package daxbnb.model;

import java.util.Date;

public class Reserve {

	private int idReserva;
	private Housing housing;
	private Date checkIn;
	private Date checkOut;
	private int numGuests;
	private double totalPrice;
	private int idUser;
	
	public Reserve(int idReserva, Housing housing, Date checkIn, Date checkOut, int numGuests, double totalPrice,
			int idUser) {
		this.idReserva = idReserva;
		this.housing = housing;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numGuests = numGuests;
		this.totalPrice = totalPrice;
		this.idUser = idUser;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Housing getHousing() {
		return housing;
	}

	public void setHousing(Housing housing) {
		this.housing = housing;
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

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return "Reserve [idReserva=" + idReserva + ", housing=" + housing + ", checkIn=" + checkIn + ", checkOut="
				+ checkOut + ", numGuests=" + numGuests + ", totalPrice=" + totalPrice + ", idUser=" + idUser + "]";
	}
	
	
	
	
	
}
