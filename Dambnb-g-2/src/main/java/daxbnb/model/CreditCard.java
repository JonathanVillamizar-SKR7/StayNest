package daxbnb.model;

import java.sql.Date;

/**
 * Clase que representa una tarjeta de crédito. Contiene información relevante
 * sobre una tarjeta de crédito, como el nombre del titular, el número de
 * tarjeta, la fecha de vencimiento, etc.
 * 
 * @author Alfredo, Jonathan, Diana
 */
public class CreditCard {

	private String userName;
	private int idCreditCard;
	private String cardHolderName;
	private Date expiration;
	private int cvv;
	private int creditCardNum;

	/**
	 * Constructor
	 * 
	 * @param userName       Nombre de usuario asociado a la tarjeta.
	 * @param idCreditCard   Identificador único de la tarjeta de crédito.
	 * @param cardHolderName Nombre del titular de la tarjeta.
	 * @param expiration     Fecha de vencimiento de la tarjeta.
	 * @param cvv            Código de seguridad de la tarjeta.
	 * @param creditCardNum  Número de la tarjeta de crédito.
	 */
	public CreditCard(String userName, int idCreditCard, String cardHolderName, Date expiration, int cvv,
			int creditCardNum) {
		this.userName = userName;
		this.idCreditCard = idCreditCard;
		this.cardHolderName = cardHolderName;
		this.expiration = expiration;
		this.cvv = cvv;
		this.creditCardNum = creditCardNum;
	}

	/**
	 * Obtiene el nombre del usuario asociado a la tarjeta.
	 * 
	 * @return El nombre del usuario.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 
	 * @param userName El nombre del usuario.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 
	 * @return El ID único de la tarjeta de crédito.
	 */
	public int getIdCreditCard() {
		return idCreditCard;
	}

	/**
	 * 
	 * @param idCreditCard El ID único de la tarjeta de crédito.
	 */
	public void setIdCreditCard(int idCreditCard) {
		this.idCreditCard = idCreditCard;
	}

	/**
	 * 
	 * @return El nombre del titular de la tarjeta.
	 */
	public String getCardHolderName() {
		return cardHolderName;
	}

	/**
	 * 
	 * @param cardHolderName El nombre del titular de la tarjeta.
	 */
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	/**
	 * 
	 * @return La fecha de vencimiento de la tarjeta.
	 */
	public Date getExpiration() {
		return expiration;
	}

	/**
	 * 
	 * @param expiration La fecha de vencimiento de la tarjeta.
	 */
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	/**
	 * 
	 * @return El código de seguridad (CVV) de la tarjeta.
	 */
	public int getCvv() {
		return cvv;
	}

	/**
	 * 
	 * @param cvv El código de seguridad (CVV) de la tarjeta.
	 */
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	/**
	 * 
	 * @return El número de la tarjeta de crédito.
	 */
	public int getCreditCardNum() {
		return creditCardNum;
	}

	/**
	 * 
	 * @param creditCardNum El número de la tarjeta de crédito.
	 */
	public void setCreditCardNum(int creditCardNum) {
		this.creditCardNum = creditCardNum;
	}

	/**
	 * @return Una cadena que representa todos los atributos de la tarjeta de
	 *         crédito
	 */
	@Override

	public String toString() {
		return "CreditCard [userName=" + userName + ", idCreditCard=" + idCreditCard + ", cardHolderName="
				+ cardHolderName + ", expiration=" + expiration + ", cvv=" + cvv + ", creditCardNum=" + creditCardNum
				+ "]";
	}

}
