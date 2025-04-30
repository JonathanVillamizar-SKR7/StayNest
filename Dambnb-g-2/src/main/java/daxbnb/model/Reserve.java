package daxbnb.model;

import java.util.Date;

/**
 * Represents a reservation made by a user for a specific housing property.
 * 
 * @author Alfredo, Jonathan, Diana
 */
public class Reserve {

	private int idReserva;
	private Housing housing;
	private Date checkIn;
	private Date checkOut;
	private int numGuests;
	private double totalPrice;
	private int idUser;

	/**
	 * Constructs a new reservation with the specified details.
	 * 
	 * @param idReserva  Unique ID of the reservation.
	 * @param housing    The housing object reserved.
	 * @param checkIn    Date of check-in.
	 * @param checkOut   Date of check-out.
	 * @param numGuests  Number of guests included in the reservation.
	 * @param totalPrice Total price of the stay.
	 * @param idUser     ID of the user who made the reservation.
	 */
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

	/**
	 * Gets the reservation ID.
	 * 
	 * @return Reservation ID.
	 */
	public int getIdReserva() {
		return idReserva;
	}

	/**
	 * Sets the reservation ID.
	 * 
	 * @param idReserva New reservation ID.
	 */
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	/**
	 * Returns the reserved housing object.
	 * 
	 * @return Reserved housing.
	 */
	public Housing getHousing() {
		return housing;
	}

	/**
	 * Sets the housing to be reserved.
	 * 
	 * @param housing New housing object.
	 */
	public void setHousing(Housing housing) {
		this.housing = housing;
	}

	/**
	 * Gets the check-in date.
	 * 
	 * @return Check-in date.
	 */
	public Date getCheckIn() {
		return checkIn;
	}

	/**
	 * Sets the check-in date.
	 * 
	 * @param checkIn New check-in date.
	 */
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	/**
	 * Gets the check-out date.
	 * 
	 * @return Check-out date.
	 */
	public Date getCheckOut() {
		return checkOut;
	}

	/**
	 * Sets the check-out date.
	 * 
	 * @param checkOut New check-out date.
	 */
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	/**
	 * Returns the number of guests.
	 * 
	 * @return Number of guests.
	 */
	public int getNumGuests() {
		return numGuests;
	}

	/**
	 * Sets the number of guests.
	 * 
	 * @param numGuests New number of guests.
	 */
	public void setNumGuests(int numGuests) {
		this.numGuests = numGuests;
	}

	/**
	 * Gets the total price of the reservation.
	 * 
	 * @return Total price.
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Sets the total price of the reservation.
	 * 
	 * @param totalPrice New total price.
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * Gets the ID of the user who made the reservation.
	 * 
	 * @return User ID.
	 */
	public int getIdUser() {
		return idUser;
	}

	/**
	 * Sets the ID of the user who made the reservation.
	 * 
	 * @param idUser New user ID.
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	/**
	 * Returns a string representation of the reservation.
	 */
	@Override
	public String toString() {
		return "Reserve [idReserva=" + idReserva + ", housing=" + housing + ", checkIn=" + checkIn + ", checkOut="
				+ checkOut + ", numGuests=" + numGuests + ", totalPrice=" + totalPrice + ", idUser=" + idUser + "]";
	}
}