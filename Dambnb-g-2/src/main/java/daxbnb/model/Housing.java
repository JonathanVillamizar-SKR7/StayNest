package daxbnb.model;

import java.util.List;

/**
 * 
 * Representa una propiedad disponible en la plataforma, incluyendo detalles
 * como su ubicación, capacidad, precio, imágenes y servicios disponibles.
 * 
 * @author Alfredo, Jonathan, Diana
 * 
 */
public class Housing {

	/**
	 * ID del alojamiento.
	 */
	private int idHouse;

	/**
	 * Nombre.
	 */
	private String name;

	/**
	 * Ubicación.
	 */
	private String location;

	/**
	 * Número de huéspedes.
	 */
	private int numGuest;

	/**
	 * Número de dormitorios.
	 */
	private int numBedroom;

	/** Número de camas. */
	private int numBed;

	/**
	 * Número de baños.
	 */
	private int numBath;

	/**
	 * Tipo de alojamiento (ID).
	 */
	private Types idType;

	/**
	 * Precio por noche.
	 */
	private double price;

	/**
	 * Descripcion de la casa
	 */
	private String description;

	/**
	 * Disponibilidad de la casa
	 */
	private boolean available;

	/**
	 * Lista de imágenes.
	 */
	private List<Images> images;

	/**
	 * Lista de facilidades.
	 */
	private List<Facilities> facilities;

	/**
	 * 
	 * @param idHouse     ID
	 * @param name        Nombre * @param location Ubicación
	 * @param numGuest    Número de huéspedes
	 * @param numBedroom  Número de dormitorios
	 * @param numBed      Número de camas
	 * @param numBath     Número de baños
	 * @param idType      Tipo (ID)
	 * @param price       Precio
	 * @param description Descripcion
	 * @param available   Disponible
	 * @param images	  Lista de imagenes
	 * @param facilities  Lista de facilities
	 */
	public Housing(int idHouse, String name, String location, int numGuest, int numBedroom, int numBed, int numBath,
			Types idType, double price, String description, boolean available, List<Images> images,
			List<Facilities> facilities) {
		this.idHouse = idHouse;
		this.name = name;
		this.location = location;
		this.numGuest = numGuest;
		this.numBedroom = numBedroom;
		this.numBed = numBed;
		this.numBath = numBath;
		this.idType = idType;
		this.price = price;
		this.description = description;
		this.available = available;
		this.images = images;
		this.facilities = facilities;
	}

	public Housing() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return ID único del alojamiento.
	 */

	public int getIdHouse() {
		return idHouse;
	}

	/**
	 * @param idHouse Establece el ID del alojamiento.
	 */
	public void setIdHouse(int idHouse) {
		this.idHouse = idHouse;
	}

	/**
	 * @return Nombre del alojamiento.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name Nombre del alojamiento.
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Ubicación del alojamiento.
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location Nueva ubicación del alojamiento.
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return Número máximo de huéspedes.
	 */

	public int getNumGuest() {
		return numGuest;
	}

	/**
	 * @param numGuest Número de huéspedes que puede recibir el alojamiento.
	 */
	public void setNumGuest(int numGuest) {
		this.numGuest = numGuest;
	}

	/**
	 * @return Número de habitaciones.
	 */
	public int getNumBedroom() {
		return numBedroom;
	}

	/**
	 * @param numBedroom Número de habitaciones disponibles.
	 */

	public void setNumBedroom(int numBedroom) {
		this.numBedroom = numBedroom;
	}

	/**
	 * 
	 * 
	 * @return Número de camas.
	 */
	public int getNumBed() {
		return numBed;
	}

	/**
	 * 
	 * @param numBed Número de camas en el alojamiento.
	 */
	public void setNumBed(int numBed) {
		this.numBed = numBed;
	}

	/**
	 * @return Número de baños.
	 */
	public int getNumBath() {
		return numBath;
	}

	/**
	 * @param numBath Número de baños disponibles.
	 */
	public void setNumBath(int numBath) {
		this.numBath = numBath;
	}

	/**
	 * @return Identificador del tipo de alojamiento.
	 */
	public Types getIdType() {
		return idType;
	}

	/**
	 * @param idType Nuevo tipo de alojamiento.
	 */
	public void setIdType(Types idType) {
		this.idType = idType;
	}

	/**
	 * @return Precio por noche.
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price Precio actualizado del alojamiento.
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return Lista de imágenes del alojamiento.
	 */
	public List<Images> getImages() {
		return images;
	}

	/**
	 * @param images Lista actualizada de imágenes.
	 * 
	 */
	public void setImages(List<Images> images) {
		this.images = images;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return available
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * 
	 * @param available
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

	/**
	 * @return Lista de facilidades o servicios del alojamiento.
	 */
	public List<Facilities> getFacilities() {
		return facilities;
	}

	/**
	 * @param facilities Lista actualizada de facilidades.
	 */
	public void setFacilities(List<Facilities> facilities) {
		this.facilities = facilities;
	}

	/**
	 * 
	 * Devuelve una representación en cadena del objeto Housing.
	 * 
	 * @return Cadena con los atributos del alojamiento.
	 */
	@Override
	public String toString() {
		return "Housing [idHouse=" + idHouse + ", name=" + name + ", location=" + location + ", numGuest=" + numGuest
				+ ", numBedroom=" + numBedroom + ", numBed=" + numBed + ", numBath=" + numBath + ", idType=" + idType
				+ ", price=" + price + ", images=" + images + ", facilities=" + facilities + "]";
	}
}
