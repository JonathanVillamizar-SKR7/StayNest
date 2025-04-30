package daxbnb.model;

import java.util.List;

/**
 * Representa los detalles adicionales de un usuario, extendiendo la clase
 * {@link User}.
 * 
 * @author Alfredo, Jonathan, Diana
 */
public class Details extends User {

	// Prueba de Diana, git push primera vez
	private String password;
	private String userType;
	private String userDescription;

	/**
	 * Crea una instancia de {@code Details} con toda la información heredada de
	 * {@link User} y atributos adicionales como contraseña, tipo y descripción.
	 * 
	 * @param userName        Nombre de usuario.
	 * @param idUser          Identificador único del usuario.
	 * @param phone           Número de teléfono.
	 * @param email           Correo electrónico.
	 * @param passport        Número de pasaporte.
	 * @param creditCard      Lista de tarjetas de crédito asociadas.
	 * @param password        Contraseña del usuario.
	 * @param userType        Tipo de usuario (por ejemplo, "admin", "cliente").
	 * @param userDescription Descripción personalizada del usuario.
	 */
	public Details(String userName, int idUser, int phone, String email, int passport, List<CreditCard> creditCard,
			String password, String userType, String userDescription) {
		super(userName, idUser, phone, email, passport, creditCard);
		this.password = password;
		this.userType = userType;
		this.userDescription = userDescription;
	}

	/**
	 * Obtiene la contraseña del usuario.
	 * 
	 * @return Contraseña.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Establece la contraseña del usuario.
	 * 
	 * @param password Nueva contraseña.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Obtiene el tipo de usuario (e.g., "admin", "cliente").
	 * 
	 * @return Tipo de usuario.
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * Establece el tipo de usuario.
	 * 
	 * @param userType Tipo de usuario.
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * Obtiene la descripción del usuario.
	 * 
	 * @return Descripción del usuario.
	 */
	public String getUserDescription() {
		return userDescription;
	}

	/**
	 * Establece la descripción del usuario.
	 * 
	 * @param userDescription Descripción del usuario.
	 */
	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}

	/**
	 * Devuelve una representación en cadena del objeto {@code Details}, incluyendo
	 * información adicional y heredada del usuario.
	 * 
	 * @return Cadena con los detalles del usuario.
	 */
	@Override
	public String toString() {
		return "Details [password=" + password + ", userType=" + userType + ", userDescription=" + userDescription
				+ ", toString()=" + super.toString() + "]";
	}
}