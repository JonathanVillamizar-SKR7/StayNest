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
	private List<CreditCard> idCreditCard;

	/**
	 * Contraseña del usuario
	 */
	private String password;
	
	/**
	 * Tipo de usuario
	 */
	private String UserType;
	
	/**
	 * Descripción personalizada del usuario. Puede incluir información adicional
	 * como intereses o roles.
	 */
	private String userDescription;
	
	
	
	

	/**
	 * Constructor con todos los campos
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
	public User(String userName, int idUser, long phone, String email, int passport, List<CreditCard> idCreditCard,
			String password, String userType, String userDescription) {
		super();
		this.userName = userName;
		this.idUser = idUser;
		this.phone = phone;
		this.email = email;
		this.passport = passport;
		this.idCreditCard = idCreditCard;
		this.password = password;
		UserType = userType;
		this.userDescription = userDescription;
	}

	/**
	 * Constructor sin credit Card
	 * @param userName
	 * @param idUser
	 * @param phone
	 * @param email
	 * @param passport
	 * @param password
	 * @param userType
	 */
	public User(String userName, int idUser, long phone, String email, int passport, String password, String userType) {
		super();
		this.userName = userName;
		this.idUser = idUser;
		this.phone = phone;
		this.email = email;
		this.passport = passport;
		this.password = password;
		UserType = userType;
	}

	/**
	 * Contructor sin nada
	 */
	public User() {
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
		return idCreditCard;
	}

	/**
	 * @param creditCard Nueva lista de tarjetas
	 */
	public void setCreditCard(List<CreditCard> creditCard) {
		this.idCreditCard = creditCard;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return UserType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		UserType = userType;
	}

	/**
	 * @return the userDescription
	 */
	public String getUserDescription() {
		return userDescription;
	}

	/**
	 * @param userDescription the userDescription to set
	 */
	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", idUser=" + idUser + ", phone=" + phone + ", email=" + email
				+ ", passport=" + passport + ", idCreditCard=" + idCreditCard + ", password=" + password + ", UserType="
				+ UserType + ", userDescription=" + userDescription + "]\n";
	}
	
}
