package daxbnb.model;

import java.util.List;

/**
 * 
 * Clase que representa un usuario en el sistema. Contiene información de
 * contacto y tarjetas de crédito asociadas.
 * 
 * @author Alfredo, Jonathan, Diana
 * 
 */
public class User {

	/**
	 * Nombre de usuario.
	 */
	private String userName;

	/**
	 * ID del usuario.
	 */
	private int idUser;

	/**
	 * Número de teléfono.
	 */
	private long phone;

	/**
	 * Correo electrónico.
	 */

	private String email;

	/**
	 * Número de pasaporte.
	 */
	private int passport;

	/**
	 * Lista de tarjetas de crédito.
	 */
	private List<CreditCard> creditCard;

	/**
	 * 
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

		this.userName = userName;
		this.idUser = idUser;
		this.phone = phone;
		this.email = email;
		this.passport = passport;
		this.creditCard = creditCard;
	}

	/**
	 * @return Nombre de usuario
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName Nuevo nombre
	 */

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return ID del usuario
	 */

	public int getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser Nuevo ID
	 */

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	/**
	 * 
	 * @return número de teléfono
	 */
	public long getPhone() {
		return phone;
	}

	/**
	 * 
	 * @param phone número de teléfono
	 */
	public void setPhone(long phone) {
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
	 * @param email Nuevo correo
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return Pasaporte
	 */
	public int getPassport() {
		return passport;
	}

	/**
	 * @param passport Nuevo pasaporte
	 */
	public void setPassport(int passport) {
		this.passport = passport;
	}

	/**
	 * @return Lista de tarjetas
	 */
	public List<CreditCard> getCreditCard() {
		return creditCard;
	}

	/**
	 * @param creditCard Nueva lista de tarjetas
	 */
	public void setCreditCard(List<CreditCard> creditCard) {
		this.creditCard = creditCard;
	}

	/**
	 * @return Datos del usuario como texto
	 */
	@Override
	public String toString() {
		return "User [userName=" + userName + ", idUser=" + idUser + ", phone=" + phone + ", email=" + email
				+ ", passport=" + passport + ", creditCard=" + creditCard + "]";
	}
}
