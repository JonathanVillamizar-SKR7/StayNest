package daxbnb.model;

import java.util.List;

/**
<<<<<<< HEAD
 * Representa una propiedad disponible en la plataforma, incluyendo detalles
 * como su ubicación, capacidad, precio, imágenes y servicios disponibles.
=======
 * Clase que representa una vivienda con sus características.
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
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
<<<<<<< HEAD
	 * 
	 * @param idHouse    Identificador único del alojamiento.
	 * @param name       Nombre del alojamiento.
	 * @param location   Ubicación del alojamiento.
	 * @param numGuest   Número máximo de huéspedes permitidos.
	 * @param numBedroom Número de habitaciones.
	 * @param numBed     Número total de camas.
	 * @param numBath    Número de baños.
	 * @param idType     Tipo de propiedad (puede relacionarse con una tabla externa
	 *                   de tipos).
	 * @param price      Precio por noche.
	 * @param images     Lista de imágenes asociadas al alojamiento.
	 * @param facilities Lista de facilidades o servicios disponibles.
=======
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
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
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
<<<<<<< HEAD
	 * @return ID único del alojamiento.
	 * 
=======
	 * 
	 * @return Id de la casa
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public int getIdHouse() {
		return idHouse;
	}

	/**
	 * 
<<<<<<< HEAD
	 * @param idHouse Establece el ID del alojamiento.
=======
	 * @param idHouse Id de la casa
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public void setIdHouse(int idHouse) {
		this.idHouse = idHouse;
	}

	/**
	 * 
<<<<<<< HEAD
	 * @return Nombre del alojamiento.
=======
	 * @return Nombre
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
<<<<<<< HEAD
	 * @param name Nombre del alojamiento.
=======
	 * @param name Nombre
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
<<<<<<< HEAD
	 * @return Ubicación del alojamiento.
=======
	 * @return Ubicacion
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public String getLocation() {
		return location;
	}

	/**
<<<<<<< HEAD
	 * 
	 * @param location Nueva ubicación del alojamiento.
=======
	 * \
	 * 
	 * @param location Ubicasion
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * 
<<<<<<< HEAD
	 * @return Número máximo de huéspedes.
=======
	 * @return Número de huéspedes
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public int getNumGuest() {
		return numGuest;
	}

	/**
	 * 
<<<<<<< HEAD
	 * @param numGuest Número de huéspedes que puede recibir el alojamiento.
=======
	 * @param numGuest Número de huéspedes
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public void setNumGuest(int numGuest) {
		this.numGuest = numGuest;
	}

	/**
	 * 
<<<<<<< HEAD
	 * @return Número de habitaciones.
=======
	 * @return Número de habitaciones
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public int getNumBedroom() {
		return numBedroom;
	}

	/**
	 * 
<<<<<<< HEAD
	 * @param numBedroom Número de habitaciones disponibles.
=======
	 * @param numBedroom Número de habitaciones
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public void setNumBedroom(int numBedroom) {
		this.numBedroom = numBedroom;
	}

	/**
	 * 
<<<<<<< HEAD
	 * @return Número de camas.
=======
	 * @return Numero de camas
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public int getNumBed() {
		return numBed;
	}

	/**
	 * 
<<<<<<< HEAD
	 * @param numBed Número de camas en el alojamiento.
=======
	 * @param numBed Numero de camas
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public void setNumBed(int numBed) {
		this.numBed = numBed;
	}

	/**
	 * 
<<<<<<< HEAD
	 * @return Número de baños.
=======
	 * @return Número de baños
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public int getNumBath() {
		return numBath;
	}

	/**
	 * 
<<<<<<< HEAD
	 * @param numBath Número de baños disponibles.
=======
	 * @param numBath Número de baños
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public void setNumBath(int numBath) {
		this.numBath = numBath;
	}

	/**
	 * 
<<<<<<< HEAD
	 * @return Identificador del tipo de alojamiento.
=======
	 * @return Id del tipo de alojamiento
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public int getIdType() {
		return idType;
	}

	/**
	 * 
<<<<<<< HEAD
	 * @param idType Nuevo tipo de alojamiento.
=======
	 * @param idType Id del tipo de alojamiento
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public void setIdType(int idType) {
		this.idType = idType;
	}

	/**
	 * 
<<<<<<< HEAD
	 * @return Precio por noche.
=======
	 * @return Precio
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * 
<<<<<<< HEAD
	 * @param price Precio actualizado del alojamiento.
=======
	 * @param price Precio
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * 
<<<<<<< HEAD
	 * @return Lista de imágenes del alojamiento.
=======
	 * @return Lista de imágenes
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public List<Images> getImages() {
		return images;
	}

	/**
	 * 
<<<<<<< HEAD
	 * @param images Lista actualizada de imágenes.
=======
	 * @param images Lista de imágenes
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public void setImages(List<Images> images) {
		this.images = images;
	}

	/**
	 * 
<<<<<<< HEAD
	 * @return Lista de facilidades o servicios del alojamiento.
=======
	 * @return Lista de facilidades
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public List<Facilities> getFacilities() {
		return facilities;
	}

	/**
	 * 
<<<<<<< HEAD
	 * @param facilities Lista actualizada de facilidades.
=======
	 * @param facilities Lista de facilidades
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public void setFacilities(List<Facilities> facilities) {
		this.facilities = facilities;
	}

	/**
<<<<<<< HEAD
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
=======
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
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
