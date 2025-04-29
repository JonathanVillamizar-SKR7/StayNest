package daxbnb.model;

import java.util.List;

/**
 * Clase que representa los detalles de un usuario.
 * 
 * @author Alfredo, Jonathan, Diana
 */
public class Details extends User {

	// Prueba de Diana, git push primera vez
	private String password;
	private String userType;
	private String userDescription;

	/**
	 * Constructor
	 * 
	 * @param userName        Nombre del usuario.
	 * @param idUser          ID del usuario.
	 * @param phone           Teléfono del usuario.
	 * @param email           Correo electrónico del usuario.
	 * @param passport        Pasaporte del usuario.
	 * @param creditCard      Lista de tarjetas de crédito del usuario.
	 * @param password        Contraseña del usuario.
	 * @param userType        Tipo de usuario.
	 * @param userDescription Descripción del usuario.
	 */
	public Details(String userName, int idUser, int phone, String email, int passport, List<CreditCard> creditCard,
			String password, String userType, String userDescription) {
		super(userName, idUser, phone, email, passport, creditCard);
		this.password = password;
		this.userType = userType;
		this.userDescription = userDescription;
	}

	/**
	 * 
	 * @return La contraseña del usuario.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password La nueva contraseña del usuario.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return El tipo de usuario.
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * 
	 * @param userType El nuevo tipo de usuario (por ejemplo, "administrador",
	 *                 "cliente").
	 */

	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * 
	 * @return La descripción del usuario.
	 */
	public String getUserDescription() {
		return userDescription;
	}

	/**
	 * 
	 * @param userDescription La nueva descripción del usuario.
	 */
	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}

	/**
	 * @return Una cadena que representa todos los detalles del usuario.
	 */
	@Override
	public String toString() {
		return "Details [password=" + password + ", userType=" + userType + ", userDescription=" + userDescription
				+ ", toString()=" + super.toString() + "]";
	}

}
