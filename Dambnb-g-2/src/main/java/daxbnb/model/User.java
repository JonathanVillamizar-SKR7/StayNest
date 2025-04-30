package daxbnb.model;

import java.util.List;

/**
 * Clase que representa un usuario en el sistema. Contiene información de
 * contacto y tarjetas de crédito asociadas.
 * 
 * @author Alfredo, Jonathan, Diana
 */
public class User {
	private String userName;
	private int idUser;
	private int phone;
	private String email;
	private int passport;
	private List<CreditCard> creditCard;

	/**
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
		this.userName = userName;
		this.idUser = idUser;
		this.phone = phone;
		this.email = email;
		this.passport = passport;
		this.creditCard = creditCard;
	}

	/**
	 * 
	 * @return nombre de usuario
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 
	 * @param userName nombre de usuario
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 
	 * @return id de usuario
	 */
	public int getIdUser() {
		return idUser;
	}

	/**
	 * 
	 * @param idUser id de usuario
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

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
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email correo electrónico
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return número de pasaporte
	 */
	public int getPassport() {
		return passport;
	}

	/**
	 * 
	 * @param passport número de pasaporte
	 */
	public void setPassport(int passport) {
		this.passport = passport;
	}

	/**
	 * 
	 * @return lista de tarjetas de crédito
	 */
	public List<CreditCard> getCreditCard() {
		return creditCard;
	}

	/**
	 * 
	 * @param creditCard lista de tarjetas de crédito
	 */
	public void setCreditCard(List<CreditCard> creditCard) {
		this.creditCard = creditCard;
	}

	/**
	 * @return Devuelve una representación en texto del objeto.
	 */
	@Override
	public String toString() {
		return "User [userName=" + userName + ", idUser=" + idUser + ", phone=" + phone + ", email=" + email
				+ ", passport=" + passport + ", creditCard=" + creditCard + "]";
	}
}
