package daxbnb.model;

import java.util.Date;

/**
<<<<<<< HEAD
 * Clase que representa una reserva de un alojamiento.
 * 
 * @author Alfredo, Jonathan, Diana
=======
 * Representa una reserva realizada por un usuario para un alojamiento.
 * 
 * @author Alfredo,Jonathan,Diana
>>>>>>> 89d4511 (JavaDoc 5.02)
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
<<<<<<< HEAD
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
=======
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
>>>>>>> 89d4511 (JavaDoc 5.02)
			int idUser) {
		this.idReserva = idReserva;
		this.housing = housing;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numeroGuests = numeroGuests;
		this.totalPrice = totalPrice;
		this.idUser = idUser;
	}

<<<<<<< HEAD
	/**
	 * @return ID de la reserva
	 */
=======
	/** @return ID de la reserva */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public int getIdReserva() {
		return idReserva;
	}

<<<<<<< HEAD
	/**
	 * @param idReserva ID de la reserva
	 */
=======
	/** @param idReserva Nuevo ID de reserva */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

<<<<<<< HEAD
	/**
	 * @return Alojamiento reservado
	 */
=======
	/** @return Alojamiento reservado */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public Housing getHousing() {
		return housing;
	}

<<<<<<< HEAD
	/**
	 * @param housing Alojamiento reservado
	 */
=======
	/** @param housing Nuevo alojamiento */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public void setHousing(Housing housing) {
		this.housing = housing;
	}

<<<<<<< HEAD
	/**
	 * @return Fecha de entrada
	 */
=======
	/** @return Fecha de entrada */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public Date getCheckIn() {
		return checkIn;
	}

<<<<<<< HEAD
	/**
	 * @param checkIn Fecha de entrada
	 */
=======
	/** @param checkIn Nueva fecha de entrada */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

<<<<<<< HEAD
	/**
	 * @return Fecha de salida
	 */
=======
	/** @return Fecha de salida */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public Date getCheckOut() {
		return checkOut;
	}

<<<<<<< HEAD
	/**
	 * @param checkOut Fecha de salida
	 */
=======
	/** @param checkOut Nueva fecha de salida */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

<<<<<<< HEAD
	/**
	 * @return Número de huéspedes
	 */
	public int getNumGuests() {
		return numGuests;
	}

	/**
	 * @param numGuests Número de huéspedes
	 */
	public void setNumGuests(int numGuests) {
		this.numGuests = numGuests;
	}

	/**
	 * @return Precio total
	 */
=======
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

<<<<<<< HEAD
	/**
	 * @param totalPrice Precio total
	 */
=======
	/** @param totalPrice Nuevo precio total */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

<<<<<<< HEAD
	/**
	 * @return ID del usuario
	 */
=======
	/** @return ID del usuario */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public int getIdUser() {
		return idUser;
	}

<<<<<<< HEAD
	/**
	 * @param idUser ID del usuario
	 */
=======
	/** @param idUser Nuevo ID de usuario */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

<<<<<<< HEAD
	/**
	 * @return Representación en texto del objeto Reserve.
	 */
=======
	/** @return Datos de la reserva como texto */
>>>>>>> 89d4511 (JavaDoc 5.02)
	@Override
	public String toString() {
		return "Reserve [idReserva=" + idReserva + ", housing=" + housing + ", checkIn=" + checkIn + ", checkOut="
				+ checkOut + ", numeroGuests=" + numeroGuests + ", totalPrice=" + totalPrice + ", idUser=" + idUser
				+ "]";
	}
}
