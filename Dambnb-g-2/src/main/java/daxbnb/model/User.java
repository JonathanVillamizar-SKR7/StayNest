package daxbnb.model;

import java.util.List;

/**
<<<<<<< HEAD
 * Clase que representa un usuario en el sistema. Contiene información de
 * contacto y tarjetas de crédito asociadas.
 * 
 * @author Alfredo, Jonathan, Diana
=======
 * Representa un usuario con información personal y tarjetas de crédito.
 * 
 * @author Alfredo,Jonathan,Diana
>>>>>>> 89d4511 (JavaDoc 5.02)
 */
public class User {

	/** Nombre de usuario. */
	private String userName;

	/** ID del usuario. */
	private int idUser;
<<<<<<< HEAD
	private int phone;
=======

	/** Número de teléfono. */
	private long phone;

	/** Correo electrónico. */
>>>>>>> 89d4511 (JavaDoc 5.02)
	private String email;

	/** Número de pasaporte. */
	private int passport;

	/** Lista de tarjetas de crédito. */
	private List<CreditCard> creditCard;

	/**
<<<<<<< HEAD
	 * Constructor
	 * 
	 * @param userName   nombre de usuario
	 * @param idUser     id único de usuario
	 * @param phone      número de teléfono
	 * @param email      correo electrónico
	 * @param passport   número de pasaporte
	 * @param creditCard lista de tarjetas de crédito
	 */
	public User(String userName, int idUser, int phone, String email, int passport, List<CreditCard> creditCard) {
=======
	 * Constructor con todos los campos.
	 * 
	 * @param userName   Nombre de usuario
	 * @param idUser     ID
	 * @param phone      Teléfono
	 * @param email      Correo
	 * @param passport   Pasaporte
	 * @param creditCard Lista de tarjetas
	 */
	public User(String userName, int idUser, long phone, String email, int passport, List<CreditCard> creditCard) {
>>>>>>> 89d4511 (JavaDoc 5.02)
		this.userName = userName;
		this.idUser = idUser;
		this.phone = phone;
		this.email = email;
		this.passport = passport;
		this.creditCard = creditCard;
	}

<<<<<<< HEAD
	/**
	 * 
	 * @return nombre de usuario
	 */
=======
	/** @return Nombre de usuario */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public String getUserName() {
		return userName;
	}

<<<<<<< HEAD
	/**
	 * 
	 * @param userName nombre de usuario
	 */
=======
	/** @param userName Nuevo nombre */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public void setUserName(String userName) {
		this.userName = userName;
	}

<<<<<<< HEAD
	/**
	 * 
	 * @return id de usuario
	 */
=======
	/** @return ID del usuario */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public int getIdUser() {
		return idUser;
	}

<<<<<<< HEAD
	/**
	 * 
	 * @param idUser id de usuario
	 */
=======
	/** @param idUser Nuevo ID */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

<<<<<<< HEAD
	/**
	 * 
	 * @return número de teléfono
	 */
	public int getPhone() {
		return phone;
	}

	/**
	 * 
	 * @param phone número de teléfono
	 */
	public void setPhone(int phone) {
		this.phone = phone;
	}

	/**
	 * 
	 * @return correo electrónico
	 */
=======
	/** @return Teléfono */
	public long getPhone() {
		return phone;
	}

	/** @param phone Nuevo teléfono */
	public void setPhone(long phone) {
		this.phone = phone;
	}

	/** @return Correo */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public String getEmail() {
		return email;
	}

<<<<<<< HEAD
	/**
	 * 
	 * @param email correo electrónico
	 */
=======
	/** @param email Nuevo correo */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public void setEmail(String email) {
		this.email = email;
	}

<<<<<<< HEAD
	/**
	 * 
	 * @return número de pasaporte
	 */
=======
	/** @return Pasaporte */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public int getPassport() {
		return passport;
	}

<<<<<<< HEAD
	/**
	 * 
	 * @param passport número de pasaporte
	 */
=======
	/** @param passport Nuevo pasaporte */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public void setPassport(int passport) {
		this.passport = passport;
	}

<<<<<<< HEAD
	/**
	 * 
	 * @return lista de tarjetas de crédito
	 */
=======
	/** @return Lista de tarjetas */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public List<CreditCard> getCreditCard() {
		return creditCard;
	}

<<<<<<< HEAD
	/**
	 * 
	 * @param creditCard lista de tarjetas de crédito
	 */
=======
	/** @param creditCard Nueva lista de tarjetas */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public void setCreditCard(List<CreditCard> creditCard) {
		this.creditCard = creditCard;
	}

<<<<<<< HEAD
	/**
	 * @return Devuelve una representación en texto del objeto.
	 */
=======
	/** @return Datos del usuario como texto */
>>>>>>> 89d4511 (JavaDoc 5.02)
	@Override
	public String toString() {
		return "User [userName=" + userName + ", idUser=" + idUser + ", phone=" + phone + ", email=" + email
				+ ", passport=" + passport + ", creditCard=" + creditCard + "]";
	}
}
