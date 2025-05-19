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
	

	/**
	 * Constructor sin nada
	 */
	public Details() {
		
	}
	
	

	/**
	 * Details con todos los campos
	 * 
	 * @param userName
	 * @param idUser
	 * @param phone
	 * @param email
	 * @param passport
	 * @param idCreditCard
	 * @param password
	 * @param userType
	 * @param userDescription
	 */
	public Details(String userName, int idUser, long phone, String email, int passport, List<CreditCard> idCreditCard,
			String password, String userType, String userDescription) {
		super(userName, idUser, phone, email, passport, idCreditCard, password, userType);
		this.userDescription = userDescription;
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
		return "Details [userDescription=" + userDescription
				+ ", toString()=" + super.toString() + "]";
	}
}
