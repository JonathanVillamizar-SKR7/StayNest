package daxbnb.model;

import java.util.List;

/**
 * Represents a user of the DaxBnB platform, which may include guests or hosts.
 * 
 * @author Alfredo, Jonathan, Diana
 */
public class User {
	private String userName;
	private int idUser;
	private long phone;
	private String email;
	private int passport;
	private List<CreditCard> creditCard;

	/**
	 * Constructs a User object with the specified parameters.
	 * 
	 * @param userName   the user's full name
	 * @param idUser     unique identifier for the user
	 * @param phone      contact phone number
	 * @param email      email address of the user
	 * @param passport   passport number
	 * @param creditCard list of credit cards associated with the user
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
	 * @return the user's name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the user's name to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the user's ID
	 */
	public int getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser the user's ID to set
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the user's phone number
	 */
	public long getPhone() {
		return phone;
	}

	/**
	 * @param phone the user's phone number to set
	 */
	public void setPhone(long phone) {
		this.phone = phone;
	}

	/**
	 * @return the user's email address
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the user's email address to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the user's passport number
	 */
	public int getPassport() {
		return passport;
	}

	/**
	 * @param passport the user's passport number to set
	 */
	public void setPassport(int passport) {
		this.passport = passport;
	}

	/**
	 * @return list of the user's credit cards
	 */
	public List<CreditCard> getCreditCard() {
		return creditCard;
	}

	/**
	 * @param creditCard the list of credit cards to associate with the user
	 */
	public void setCreditCard(List<CreditCard> creditCard) {
		this.creditCard = creditCard;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", idUser=" + idUser + ", phone=" + phone + ", email=" + email
				+ ", passport=" + passport + ", creditCard=" + creditCard + "]";
	}
}