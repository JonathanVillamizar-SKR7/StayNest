package daxbnb.model;

import java.util.List;

/**
 * Clase que representa una vivienda con sus características.
 * 
 * @author Alfredo, Jonathan, Diana
 */
public class Housing {
	private int idHouse;
	private String name;
	private String location;
	private int numGuest;
	private int numBedroom;
	private int numBed;
	private int numBath;
	private int idType;
	private double price;
	private List<Images> images;
	private List<Facilities> facilities;

	/**
	 * Constructor
	 * 
	 * @param idHouse    Identificador de la casa
	 * @param name       Nombre de la casa
	 * @param location   Ubicacion de la casa
	 * @param numGuest   Numero de huespedes
	 * @param numBedroom Numero de habitaciones
	 * @param numBed     Numero de camas
	 * @param numBath    Numero de baños
	 * @param idType     Tipo de alojamiento
	 * @param price      Precio por noche
	 * @param images     Lista de imagenes asocoadas
	 * @param facilities Lista de servicios disponibles
	 */
	public Housing(int idHouse, String name, String location, int numGuest, int numBedroom, int numBed, int numBath,
			int idType, double price, List<Images> images, List<Facilities> facilities) {
		this.idHouse = idHouse;
		this.name = name;
		this.location = location;
		this.numGuest = numGuest;
		this.numBedroom = numBedroom;
		this.numBed = numBed;
		this.numBath = numBath;
		this.idType = idType;
		this.price = price;
		this.images = images;
		this.facilities = facilities;
	}

	/**
	 * 
	 * @return Id de la casa
	 */
	public int getIdHouse() {
		return idHouse;
	}

	/**
	 * 
	 * @param idHouse Id de la casa
	 */
	public void setIdHouse(int idHouse) {
		this.idHouse = idHouse;
	}

	/**
	 * 
	 * @return Nombre
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name Nombre
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return Ubicacion
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * \
	 * 
	 * @param location Ubicasion
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * 
	 * @return Número de huéspedes
	 */
	public int getNumGuest() {
		return numGuest;
	}

	/**
	 * 
	 * @param numGuest Número de huéspedes
	 */
	public void setNumGuest(int numGuest) {
		this.numGuest = numGuest;
	}

	/**
	 * 
	 * @return Número de habitaciones
	 */
	public int getNumBedroom() {
		return numBedroom;
	}

	/**
	 * 
	 * @param numBedroom Número de habitaciones
	 */
	public void setNumBedroom(int numBedroom) {
		this.numBedroom = numBedroom;
	}

	/**
	 * 
	 * @return Numero de camas
	 */
	public int getNumBed() {
		return numBed;
	}

	/**
	 * 
	 * @param numBed Numero de camas
	 */
	public void setNumBed(int numBed) {
		this.numBed = numBed;
	}

	/**
	 * 
	 * @return Número de baños
	 */
	public int getNumBath() {
		return numBath;
	}

	/**
	 * 
	 * @param numBath Número de baños
	 */
	public void setNumBath(int numBath) {
		this.numBath = numBath;
	}

	/**
	 * 
	 * @return Id del tipo de alojamiento
	 */
	public int getIdType() {
		return idType;
	}

	/**
	 * 
	 * @param idType Id del tipo de alojamiento
	 */
	public void setIdType(int idType) {
		this.idType = idType;
	}

	/**
	 * 
	 * @return Precio
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * 
	 * @param price Precio
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * 
	 * @return Lista de imágenes
	 */
	public List<Images> getImages() {
		return images;
	}

	/**
	 * 
	 * @param images Lista de imágenes
	 */
	public void setImages(List<Images> images) {
		this.images = images;
	}

	/**
	 * 
	 * @return Lista de facilidades
	 */
	public List<Facilities> getFacilities() {
		return facilities;
	}

	/**
	 * 
	 * @param facilities Lista de facilidades
	 */
	public void setFacilities(List<Facilities> facilities) {
		this.facilities = facilities;
	}

	/**
	 * @return Representación en texto de la clase Housing.
	 */
	@Override
	public String toString() {
		return "Housing [idHouse=" + idHouse + ", name=" + name + ", description=" + ", location=" + location
				+ ", numGuest=" + numGuest + ", numBedroom=" + numBedroom + ", numBed=" + numBed + ", numBath="
				+ numBath + ", idType=" + idType + ", price=" + price + ", images=" + images + ", facilities="
				+ facilities + "]";
	}

}
