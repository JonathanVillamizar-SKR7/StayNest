package daxbnb.model;

import java.sql.Date;

public class CreditCard extends User{

    private int idCreditCard;
    private int idUser;
    private String cardHolderName;
    private Date expiration;
    private int cvv;
    private int creditCardNum;
    
	public CreditCard(int idHouse, String name, String description, String location, int numGuest, int numBedroom,
			int numBed, int numBath, int idType, double price, int idReserva, int idHouse2, int idUser, String name2,
			Date checkIn, Date checkOut, int numGuests, double totalPrice, String userName, int idUser2, int phone,
			String email, int passport, int idCreditCard, int idUser3, String cardHolderName, Date expiration, int cvv,
			int creditCardNum) {
		super(idHouse, name, description, location, numGuest, numBedroom, numBed, numBath, idType, price, idReserva,
				idHouse2, idUser, name2, checkIn, checkOut, numGuests, totalPrice, userName, idUser2, phone, email,
				passport);
		this.idCreditCard = idCreditCard;
		idUser = idUser3;
		this.cardHolderName = cardHolderName;
		this.expiration = expiration;
		this.cvv = cvv;
		this.creditCardNum = creditCardNum;
	}

	public int getIdCreditCard() {
		return idCreditCard;
	}

	public void setIdCreditCard(int idCreditCard) {
		this.idCreditCard = idCreditCard;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public int getCreditCardNum() {
		return creditCardNum;
	}

	public void setCreditCardNum(int creditCardNum) {
		this.creditCardNum = creditCardNum;
	}

	@Override
	public String toString() {
		return "CreditCard [idCreditCard=" + idCreditCard + ", idUser=" + idUser + ", cardHolderName=" + cardHolderName
				+ ", expiration=" + expiration + ", cvv=" + cvv + ", creditCardNum=" + creditCardNum + ", toString()="
				+ super.toString() + "]";
	}
    
	
    
}
