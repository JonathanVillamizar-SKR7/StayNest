package daxbnb.model;

import java.util.Date;

/**

 * Representa una reserva realizada por un usuario para un alojamiento.
 * 
 * @author Alfredo,Jonathan,Diana

 */
public class Reserve {

	/** ID de la reserva. */
	private int idReserva;

	/** Alojamiento reservado. */
	private Housing housing;

	/** Fecha de entrada (check-in). */
	private Date checkIn;

	/** Fecha de salida (check-out). */
	private Date checkOut;

	/** Número de huéspedes. */
	private int numeroGuests;

	/** Precio total de la reserva. */
	private double totalPrice;

	/** ID del usuario que realiza la reserva. */
	private int idUser;

	/**
	 * Constructor con todos los campos.
	 *
	 * @param idReserva    ID de la reserva
	 * @param housing      Alojamiento
	 * @param checkIn      Fecha de entrada
	 * @param checkOut     Fecha de salida
	 * @param numeroGuests Número de huéspedes
	 * @param totalPrice   Precio total
	 * @param idUser       ID del usuario
	 */
	public Reserve(int idReserva, Housing housing, Date checkIn, Date checkOut, int numeroGuests, double totalPrice,

			int idUser) {
		this.idReserva = idReserva;
		this.housing = housing;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numeroGuests = numeroGuests;
		this.totalPrice = totalPrice;
		this.idUser = idUser;
	}


	/**
	 * @return ID de la reserva
	 */

	public int getIdReserva() {
		return idReserva;
	}


	/**
	 * @param idReserva ID de la reserva
	 */

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}


	/**
	 * @return Alojamiento reservado
	 */

	public Housing getHousing() {
		return housing;
	}


	/**
	 * @param housing Alojamiento reservado
	 */

	public void setHousing(Housing housing) {
		this.housing = housing;
	}

	/**
	 * @return Fecha de entrada
	 */

	public Date getCheckIn() {
		return checkIn;
	}


	/**
	 * @param checkIn Fecha de entrada
	 */

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}


	/**
	 * @return Fecha de salida
	 */

	public Date getCheckOut() {
		return checkOut;
	}


	/**
	 * @param checkOut Fecha de salida
	 */

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}


	/** @return Número de huéspedes */
	public int getNumeroGuests() {
		return numeroGuests;
	}

	/** @param numeroGuests Nuevo número de huéspedes */
	public void setNumeroGuests(int numeroGuests) {
		this.numeroGuests = numeroGuests;
	}

	/** @return Precio total de la reserva */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public double getTotalPrice() {
		return totalPrice;
	}


	/**
	 * @param totalPrice Precio total
	 */

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	/**
	 * @return ID del usuario
	 */


	public int getIdUser() {
		return idUser;
	}


	/**
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
				+ checkOut + ", numeroGuests=" + numeroGuests + ", totalPrice=" + totalPrice + ", idUser=" + idUser
				+ "]";
	}
}
