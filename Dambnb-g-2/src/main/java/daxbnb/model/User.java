package daxbnb.model;

import java.util.List;

public class User {
	private String userName;
	private int idUser;
	private long phone;
	private String email;
	private int passport;
	private List<CreditCard> creditCard;
	
	public User(String userName, int idUser, long phone, String email, int passport, List<CreditCard> creditCard) {
		this.userName = userName;
		this.idUser = idUser;
		this.phone = phone;
		this.email = email;
		this.passport = passport;
		this.creditCard = creditCard;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPassport() {
		return passport;
	}

	public void setPassport(int passport) {
		this.passport = passport;
	}

	public List<CreditCard> getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(List<CreditCard> creditCard) {
		this.creditCard = creditCard;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", idUser=" + idUser + ", phone=" + phone + ", email=" + email
				+ ", passport=" + passport + ", creditCard=" + creditCard + "]";
	}
	
	
	

	
	
}
