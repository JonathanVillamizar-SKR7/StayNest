package daxbnb.model;

import java.util.Date;

/**
 * Clase que representa una reserva realizada por un usuario para un
 * alojamiento.
 * 
 */
public class Reserves {

	/**
	 * ID de la reserva.
	 */
	private int idReserva;

	/**
	 * Alojamiento reservado.
	 */
	private Housing housing;

	/**
	 * 
	 */
	private String nameH;

	/**
	 * Fecha de entrada (check-in).
	 */
	private Date checkIn;

	/**
	 * Fecha de salida (check-out).
	 */
	private Date checkOut;

	/**
	 * Número de huéspedes.
	 */
	private int numGuests;

	/**
	 * Precio total de la reserva.
	 */
	private double totalPrice;

	/**
	 * ID del usuario que realiza la reserva.
	 */
	private int idUser;

	/**
	 * Constructor completo para inicializar una reserva.
	 * 
	 * @param idReserva  ID de la reserva.
	 * @param housing    Objeto Housing relacionado con la reserva.
	 * @param idUser     ID del usuario que realiza la reserva.
	 * @param nameH		 Nombre de la casa que se hará la reserva.
	 * @param checkIn    Fecha de entrada.
	 * @param checkOut   Fecha de salida.
	 * @param numGuests  Número de huéspedes.
	 * @param totalPrice Precio total de la reserva.
	 */
	public Reserves(int idReserva, Housing housing, int idUser, String nameH, Date checkIn, Date checkOut, int numGuests,
			double totalPrice) {
		this.idReserva = idReserva;
		this.housing = housing;
		this.idUser = idUser;
		this.nameH = nameH; // <-- falta este atributo en tu clase
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numGuests = numGuests;
		this.totalPrice = totalPrice;
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
	 * 
	 * @return nombre de la casa que se reserva
	 */
	public String getNameH() {
		return nameH;
	}

	/**
	 * 
	 * @param nameH nombre de la casa que se reverva
	 */
	public void setNameH(String nameH) {
		this.nameH = nameH;
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

	/**
	 * @return Número de huéspedes
	 */
	public int getNumGuests() {
		return numGuests;
	}

	/**
	 * @param numGuests Nuevo número de huéspedes
	 */
	public void setNumGuests(int numGuests) {
		this.numGuests = numGuests;
	}

	/**
	 * @return Precio total de la reserva
	 */
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
		return "Reserves [idReserva=" + idReserva + ", housing=" + housing + ", nameH=" + nameH + ", checkIn=" + checkIn
				+ ", checkOut=" + checkOut + ", numGuests=" + numGuests + ", totalPrice=" + totalPrice + ", idUser="
				+ idUser + "]";
	}

}
