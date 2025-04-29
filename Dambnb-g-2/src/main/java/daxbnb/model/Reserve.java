package daxbnb.model;

import java.util.Date;

/**
 * Clase que representa una reserva de un alojamiento.
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
	 * Constructor
	 * 
	 * @param idReserva  ID de la reserva
	 * @param housing    Alojamiento reservado
	 * @param checkIn    Fecha de entrada
	 * @param checkOut   Fecha de salida
	 * @param numGuests  Número de huéspedes
	 * @param totalPrice Precio total de la reserva
	 * @param idUser     ID del usuario que reserva
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
	 * 
	 * @return ID de la reserva
	 */
	public int getIdReserva() {
		return idReserva;
	}

	/**
	 * 
	 * @param idReserva ID de la reserva
	 */
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	/**
	 * 
	 * @return Alojamiento reservado
	 */
	public Housing getHousing() {
		return housing;
	}

	/**
	 * 
	 * @param housing Alojamiento reservado
	 */
	public void setHousing(Housing housing) {
		this.housing = housing;
	}

	/**
	 * 
	 * @return Fecha de entrada
	 */
	public Date getCheckIn() {
		return checkIn;
	}

	/**
	 * 
	 * @param checkIn Fecha de entrada
	 */
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	/**
	 * 
	 * @return Fecha de salida
	 */
	public Date getCheckOut() {
		return checkOut;
	}

	/**
	 * 
	 * @param checkOut Fecha de salida
	 */
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	/**
	 * 
	 * @return Número de huéspedes
	 */
	public int getNumGuests() {
		return numGuests;
	}

	/**
	 * 
	 * @param numGuests Número de huéspedes
	 */
	public void setNumGuests(int numGuests) {
		this.numGuests = numGuests;
	}

	/**
	 * 
	 * @return Precio total
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * 
	 * @param totalPrice Precio total
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * 
	 * @returnID del usuario
	 */
	public int getIdUser() {
		return idUser;
	}

	/**
	 * 
	 * @param idUser ID del usuario
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return Representación en texto del objeto Reserve.
	 */
	@Override
	public String toString() {
		return "Reserve [idReserva=" + idReserva + ", housing=" + housing + ", checkIn=" + checkIn + ", checkOut="
				+ checkOut + ", numGuests=" + numGuests + ", totalPrice=" + totalPrice + ", idUser=" + idUser + "]";
	}

}
