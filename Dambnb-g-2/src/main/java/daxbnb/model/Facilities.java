package daxbnb.model;

/**
 * 
 * Clase que representa las instalaciones disponibles en una casa. Contiene
 * información sobre la casa, el tipo de instalación y si está disponible.
 * 
 * @author Alfredo, Jonathan, Diana
 * 
 */
public class Facilities {

	/**
	 * ID de la instalación.
	 */
	private int idFacilities;

	/**
	 * Tipo de instalación.
	 */
	private String typeFacilities;

	/**
	 * Constructor con todos los campos
	 * 
	 * @param idFacilities   ID de la Instalación
	 * @param typeFacilities Tipo
	 */
	public Facilities(int idFacilities, String typeFacilities) {
		this.idFacilities = idFacilities;
		this.typeFacilities = typeFacilities;
	}

	/**
	 * Constructor con solo el tipo de facilidad
	 * 
	 * @param typeFacilities
	 */
	public Facilities(String typeFacilities) {
		this.typeFacilities = typeFacilities;
	}

	/**
	 * Obtiene el identificador de la vivienda asociada.
	 * 
	 * @return El ID de la casa.
	 */

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

	/**
	 * @return Una cadena que representa todos los detalles de la instalación.
	 */

	@Override
	public String toString() {
		return "Facilities [idFacilities=" + idFacilities + ", typeFacilities=" + typeFacilities + "]";
	}

}
