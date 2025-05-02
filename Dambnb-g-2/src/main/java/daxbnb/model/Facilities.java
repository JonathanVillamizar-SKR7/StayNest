package daxbnb.model;

/**
<<<<<<< HEAD
 * Clase que representa las instalaciones disponibles en una casa. Contiene
 * información sobre la casa, el tipo de instalación y si está disponible.
 * 
 * @author Alfredo, Jonathan, Diana
=======
 * Instalación de una casa.
 * 
 * @author Alfredo,Jonathan,Diana
>>>>>>> 89d4511 (JavaDoc 5.02)
 */
public class Facilities {

	/** ID de la casa. */
	private int idHouse;

	/** ID de la instalación. */
	private int idFacilities;

	/** Tipo de instalación. */
	private String typeFacilities;

	/** Disponible o no. */
	private boolean available;

	/**
<<<<<<< HEAD
	 * Constructor
	 * 
	 * @param idHouse        El ID de la casa asociada a estas instalaciones.
	 * @param idFacilities   El ID de la instalación.
	 * @param typeFacilities El tipo de la instalación (p. ej., "piscina", "WiFi").
	 * @param available      El estado de disponibilidad de la instalación (true si
	 *                       está disponible, false si no).
=======
	 * Constructor con todos los campos.
	 * 
	 * @param idHouse        ID de la casa
	 * @param idFacilities   ID de la instalación
	 * @param typeFacilities Tipo
	 * @param available      Disponible
>>>>>>> 89d4511 (JavaDoc 5.02)
	 */
	public Facilities(int idHouse, int idFacilities, String typeFacilities, boolean available) {
		this.idHouse = idHouse;
		this.idFacilities = idFacilities;
		this.typeFacilities = typeFacilities;
		this.available = available;
	}

<<<<<<< HEAD
	/**
	 * Obtiene el identificador de la vivienda asociada.
	 * 
	 * @return El ID de la casa.
	 */
=======
	/** @return ID de la casa */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public int getIdHouse() {
		return idHouse;
	}

<<<<<<< HEAD
	/**
	 * Establece el identificador de la vivienda asociada.
	 * 
	 * @param idHouse El nuevo ID de la casa.
	 */
=======
	/** @param idHouse Nuevo ID de la casa */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public void setIdHouse(int idHouse) {
		this.idHouse = idHouse;
	}

<<<<<<< HEAD
	/**
	 * Obtiene el identificador de la instalación.
	 * 
	 * @return El ID de la instalación.
	 */
=======
	/** @return ID de la instalación */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public int getIdFacilities() {
		return idFacilities;
	}

<<<<<<< HEAD
	/**
	 * Establece el identificador de la instalación.
	 * 
	 * @param idFacilities El nuevo ID de la instalación.
	 */
=======
	/** @param idFacilities Nuevo ID */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public void setIdFacilities(int idFacilities) {
		this.idFacilities = idFacilities;
	}

<<<<<<< HEAD
	/**
	 * Obtiene el tipo o nombre de la instalación.
	 * 
	 * @return El tipo de la instalación.
	 */
=======
	/** @return Tipo de instalación */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public String getTypeFacilities() {
		return typeFacilities;
	}

<<<<<<< HEAD
	/**
	 * Establece el tipo o nombre de la instalación.
	 * 
	 * @param typeFacilities El nuevo tipo de instalación (por ejemplo, "piscina",
	 *                       "WiFi").
	 */
=======
	/** @param typeFacilities Nuevo tipo */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public void setTypeFacilities(String typeFacilities) {
		this.typeFacilities = typeFacilities;
	}

<<<<<<< HEAD
	/**
	 * Indica si la instalación está disponible.
	 * 
	 * @return true si la instalación está disponible, false si no.
	 */
=======
	/** @return Si está disponible */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public boolean isAvailable() {
		return available;
	}

<<<<<<< HEAD
	/**
	 * Establece la disponibilidad de la instalación.
	 * 
	 * @param available El nuevo estado de disponibilidad (true si está disponible,
	 *                  false si no).
	 */
=======
	/** @param available Nuevo estado */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public void setAvailable(boolean available) {
		this.available = available;
	}

<<<<<<< HEAD
	/**
	 * @return Una cadena que representa todos los detalles de la instalación.
	 */
=======
	/** @return Datos como texto */
>>>>>>> 89d4511 (JavaDoc 5.02)
	@Override
	public String toString() {
		return "Facilities [idHouse=" + idHouse + ", idFacilities=" + idFacilities + ", typeFacilities="
				+ typeFacilities + ", available=" + available + "]";
	}
<<<<<<< HEAD
=======

>>>>>>> 89d4511 (JavaDoc 5.02)
}
