package daxbnb.model;

/**
 * Clase que representa las instalaciones disponibles en una casa. Contiene
 * información sobre la casa, el tipo de instalación y si está disponible.
 * 
 * @author Alfredo, Jonathan, Diana
 */
public class Facilities {
	private int idHouse;
	private int idFacilities;
	private String typeFacilities;
	private boolean available;

	/**
	 * Constructor
	 * 
	 * @param idHouse        El ID de la casa asociada a estas instalaciones.
	 * @param idFacilities   El ID de la instalación.
	 * @param typeFacilities El tipo de la instalación (p. ej., "piscina", "WiFi").
	 * @param available      El estado de disponibilidad de la instalación (true si
	 *                       está disponible, false si no).
	 */
	public Facilities(int idHouse, int idFacilities, String typeFacilities, boolean available) {
		this.idHouse = idHouse;
		this.idFacilities = idFacilities;
		this.typeFacilities = typeFacilities;
		this.available = available;
	}

	/**
	 * Obtiene el identificador de la vivienda asociada.
	 * 
	 * @return El ID de la casa.
	 */
	public int getIdHouse() {
		return idHouse;
	}

	/**
	 * Establece el identificador de la vivienda asociada.
	 * 
	 * @param idHouse El nuevo ID de la casa.
	 */
	public void setIdHouse(int idHouse) {
		this.idHouse = idHouse;
	}

	/**
	 * Obtiene el identificador de la instalación.
	 * 
	 * @return El ID de la instalación.
	 */
	public int getIdFacilities() {
		return idFacilities;
	}

	/**
	 * Establece el identificador de la instalación.
	 * 
	 * @param idFacilities El nuevo ID de la instalación.
	 */
	public void setIdFacilities(int idFacilities) {
		this.idFacilities = idFacilities;
	}

	/**
	 * Obtiene el tipo o nombre de la instalación.
	 * 
	 * @return El tipo de la instalación.
	 */
	public String getTypeFacilities() {
		return typeFacilities;
	}

	/**
	 * Establece el tipo o nombre de la instalación.
	 * 
	 * @param typeFacilities El nuevo tipo de instalación (por ejemplo, "piscina",
	 *                       "WiFi").
	 */
	public void setTypeFacilities(String typeFacilities) {
		this.typeFacilities = typeFacilities;
	}

	/**
	 * Indica si la instalación está disponible.
	 * 
	 * @return true si la instalación está disponible, false si no.
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * Establece la disponibilidad de la instalación.
	 * 
	 * @param available El nuevo estado de disponibilidad (true si está disponible,
	 *                  false si no).
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

	/**
	 * @return Una cadena que representa todos los detalles de la instalación.
	 */
	@Override
	public String toString() {
		return "Facilities [idHouse=" + idHouse + ", idFacilities=" + idFacilities + ", typeFacilities="
				+ typeFacilities + ", available=" + available + "]";
	}
}
