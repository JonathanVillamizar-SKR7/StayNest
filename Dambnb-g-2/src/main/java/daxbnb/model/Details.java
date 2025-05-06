package daxbnb.model;

import java.util.List;

/**
<<<<<<< HEAD
<<<<<<< HEAD
 * Representa los detalles adicionales de un usuario, extendiendo la clase
 * {@link User}.
=======
 * Clase que representa los detalles de un usuario.
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
=======
 * Usuario con detalles extra.
>>>>>>> 89d4511 (JavaDoc 5.02)
 * 
 * @author Alfredo, Jonathan, Diana
 */
public class Details extends User {

<<<<<<< HEAD
    private String password;
    private String userType;
    private String userDescription;
    
=======
<<<<<<< HEAD
	// Prueba de Diana, git push primera vez
	private String password;
	private String userType;
	private String userDescription;

	/**
<<<<<<< HEAD
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
=======
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
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
=======
	/** Contraseña. */
	private String password;

	/** Tipo de usuario. */
	private String userType;

	/** Descripción. */
	private String userDescription;

	/**
	 * Constructor con todos los campos.
	 * 
	 * @param userName        Nombre
	 * @param idUser          ID
	 * @param phone           Teléfono
	 * @param email           Correo
	 * @param passport        Pasaporte
	 * @param creditCard      Tarjetas
	 * @param password        Contraseña
	 * @param userType        Tipo
	 * @param userDescription Descripción
>>>>>>> 89d4511 (JavaDoc 5.02)
	 */
>>>>>>> 09e51f5682343e54753144ba76038887edffc7fc
	public Details(String userName, int idUser, int phone, String email, int passport, List<CreditCard> creditCard,
			String password, String userType, String userDescription) {
		super(userName, idUser, phone, email, passport, creditCard);
		this.password = password;
		this.userType = userType;
		this.userDescription = userDescription;
	}

<<<<<<< HEAD
	/**
<<<<<<< HEAD
	 * Obtiene la contraseña del usuario.
	 * 
	 * @return Contraseña.
=======
	 * 
	 * @return La contraseña del usuario.
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
=======
	/** @return Contraseña */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public String getPassword() {
		return password;
	}

<<<<<<< HEAD
	/**
<<<<<<< HEAD
	 * Establece la contraseña del usuario.
	 * 
	 * @param password Nueva contraseña.
=======
	 * 
	 * @param password La nueva contraseña del usuario.
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
=======
	/** @param password Nueva contraseña */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public void setPassword(String password) {
		this.password = password;
	}

<<<<<<< HEAD
	/**
<<<<<<< HEAD
	 * Obtiene el tipo de usuario (e.g., "admin", "cliente").
	 * 
	 * @return Tipo de usuario.
=======
	 * 
	 * @return El tipo de usuario.
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
=======
	/** @return Tipo de usuario */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public String getUserType() {
		return userType;
	}

<<<<<<< HEAD
	/**
<<<<<<< HEAD
	 * Establece el tipo de usuario.
	 * 
	 * @param userType Tipo de usuario.
	 */
=======
	 * 
	 * @param userType El nuevo tipo de usuario (por ejemplo, "administrador",
	 *                 "cliente").
	 */

>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
=======
	/** @param userType Nuevo tipo */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public void setUserType(String userType) {
		this.userType = userType;
	}

<<<<<<< HEAD
	/**
<<<<<<< HEAD
	 * Obtiene la descripción del usuario.
	 * 
	 * @return Descripción del usuario.
=======
	 * 
	 * @return La descripción del usuario.
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
=======
	/** @return Descripción */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public String getUserDescription() {
		return userDescription;
	}

<<<<<<< HEAD
	/**
<<<<<<< HEAD
	 * Establece la descripción del usuario.
	 * 
	 * @param userDescription Descripción del usuario.
=======
	 * 
	 * @param userDescription La nueva descripción del usuario.
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
=======
	/** @param userDescription Nueva descripción */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}

<<<<<<< HEAD
	/**
<<<<<<< HEAD
	 * Devuelve una representación en cadena del objeto {@code Details}, incluyendo
	 * información adicional y heredada del usuario.
	 * 
	 * @return Cadena con los detalles del usuario.
=======
	 * @return Una cadena que representa todos los detalles del usuario.
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
=======
	/** @return Datos como texto */
>>>>>>> 89d4511 (JavaDoc 5.02)
	@Override
	public String toString() {
		return "Details [password=" + password + ", userType=" + userType + ", userDescription=" + userDescription
				+ ", toString()=" + super.toString() + "]";
	}
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 89d4511 (JavaDoc 5.02)
}
=======

}
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
