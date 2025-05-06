package daxbnb.model;

import java.util.List;

/**
 * Clase que representa los detalles adicionales de un usuario en el sistema.
 * Extiende {@link User} para incluir atributos como contraseña, tipo de usuario
 * y una descripción personalizada.
 * 
 * @author Alfredo, Jonathan, Diana
 * 
 */
public class Details extends User {
	/**
	 * Contraseña del usuario.
	 */
	private String password;
	/**
	 * Tipo de usuario en la aplicación, por ejemplo, "admin", "cliente", etc.
	 */
	private String userType;
	/**
	 * Descripción personalizada del usuario. Puede incluir información adicional
	 * como intereses o roles.
	 */
	private String userDescription;

	/**
	 * Crea una instancia de {@code Details} con todos los atributos necesarios,
	 * incluyendo los heredados de {@link User}.
	 *
	 * @param userName        Nombre del usuario.
	 * @param idUser          Identificador único del usuario.
	 * @param phone           Número de teléfono.
	 * @param email           Correo electrónico.
	 * @param passport        Número de pasaporte.
	 * @param creditCard      Lista de tarjetas de crédito asociadas al usuario.
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
	 * Devuelve la contraseña del usuario.
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
	 * Devuelve el tipo de usuario (por ejemplo, "admin", "cliente").
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
	 * Devuelve la descripción personalizada del usuario.
	 *
	 * @return Descripción del usuario.
	 */
	public String getUserDescription() {
		return userDescription;
	}

	/**
	 * Establece la descripción personalizada del usuario.
	 *
	 * @param userDescription Nueva descripción.
	 */
	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}

	/**
	 * Devuelve una representación en cadena del objeto {@code Details}, incluyendo
	 * los atributos adicionales y los heredados.
	 *
	 * @return Cadena de texto con los detalles del usuario.
	 */
	@Override
	public String toString() {
		return "Details [password=" + password + ", userType=" + userType + ", userDescription=" + userDescription
				+ ", toString()=" + super.toString() + "]";
	}
}
