package daxbnb.model;

/**
 * Representa una instalación asociada a una vivienda (por ejemplo, piscina,
 * wifi, garaje). Contiene información sobre su disponibilidad y tipo.
 * 
 * @author Alfredo, Jonathan, Diana
 */
public class Facilities {
	private int idHouse;
	private int idFacilities;
	private String typeFacilities;
	private boolean available;

	/**
	 * Crea una nueva instancia de {@code Facilities} asociada a una vivienda.
	 * 
	 * @param idHouse        Identificador de la vivienda a la que pertenece la
	 *                       instalación.
	 * @param idFacilities   Identificador único de la instalación.
	 * @param typeFacilities Tipo o nombre de la instalación (e.g.,
	 *                       "Wifi","Piscina").
	 * @param available      Indica si la instalación está disponible actualmente.
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
	 * @return ID de la vivienda.
	 */
	public int getIdHouse() {
		return idHouse;
	}

	/**
	 * Establece el identificador de la vivienda asociada.
	 * 
	 * @param idHouse Nuevo ID de la vivienda.
	 */
	public void setIdHouse(int idHouse) {
		this.idHouse = idHouse;
	}

	/**
	 * Obtiene el identificador de la instalación.
	 * 
	 * @return ID de la instalación.
	 */
	public int getIdFacilities() {
		return idFacilities;
	}

	/**
	 * Establece el identificador de la instalación.
	 * 
	 * @param idFacilities Nuevo ID de la instalación.
	 */
	public void setIdFacilities(int idFacilities) {
		this.idFacilities = idFacilities;
	}

	/**
	 * Obtiene el tipo o nombre de la instalación.
	 * 
	 * @return Tipo de instalación (e.g., "Wifi", "Piscina").
	 */
	public String getTypeFacilities() {
		return typeFacilities;
	}

	/**
	 * Establece el tipo o nombre de la instalación.
	 * 
	 * @param typeFacilities Tipo de instalación.
	 */
	public void setTypeFacilities(String typeFacilities) {
		this.typeFacilities = typeFacilities;
	}

	/**
	 * Indica si la instalación está disponible.
	 * 
	 * @return {@code true} si está disponible; {@code false} en caso contrario.
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * Establece la disponibilidad de la instalación.
	 * 
	 * @param available {@code true} si está disponible; {@code false} si no.
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

	/**
	 * Devuelve una representación en cadena de la instalación.
	 * 
	 * @return Una cadena con los valores de todos los atributos.
	 */
	@Override
	public String toString() {
		return "Facilities [idHouse=" + idHouse + ", idFacilities=" + idFacilities + ", typeFacilities="
				+ typeFacilities + ", available=" + available + "]";
	}
}