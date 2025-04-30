package daxbnb.model;

import java.sql.Date;

/**
 * Representa una tarjeta de crédito asociada a un usuario.
 * 
 * @author Alfredo, Jonathan, Diana
 */
public class CreditCard {

	private String userName;
	private int idCreditCard;
	private String cardHolderName;
	private Date expiration;
	private int cvv;
	private long creditCardNum;

	/**
	 * Crea una nueva tarjeta de crédito con los datos especificados.
	 * 
	 * @param userName       Nombre de usuario al que está asociada la tarjeta.
	 * @param idCreditCard   Identificador único de la tarjeta.
	 * @param cardHolderName Nombre del titular de la tarjeta.
	 * @param expiration     Fecha de expiración de la tarjeta.
	 * @param cvv            Código de seguridad (CVV) de la tarjeta.
	 * @param creditCardNum  Número de la tarjeta de crédito.
	 */
	public CreditCard(String userName, int idCreditCard, String cardHolderName, Date expiration, int cvv,
			long creditCardNum) {
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
	 * @return Nombre del usuario.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Establece el nombre del usuario asociado a la tarjeta.
	 * 
	 * @param userName Nombre del usuario.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Obtiene el identificador único de la tarjeta de crédito.
	 * 
	 * @return ID de la tarjeta.
	 */
	public int getIdCreditCard() {
		return idCreditCard;
	}

	/**
	 * Establece el identificador único de la tarjeta de crédito.
	 * 
	 * @param idCreditCard ID de la tarjeta.
	 */
	public void setIdCreditCard(int idCreditCard) {
		this.idCreditCard = idCreditCard;
	}

	/**
	 * Obtiene el nombre del titular de la tarjeta.
	 * 
	 * @return Nombre del titular.
	 */
	public String getCardHolderName() {
		return cardHolderName;
	}

	/**
	 * Establece el nombre del titular de la tarjeta.
	 * 
	 * @param cardHolderName Nombre del titular.
	 */
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	/**
	 * Obtiene la fecha de expiración de la tarjeta.
	 * 
	 * @return Fecha de expiración.
	 */
	public Date getExpiration() {
		return expiration;
	}

	/**
	 * Establece la fecha de expiración de la tarjeta.
	 * 
	 * @param expiration Fecha de expiración.
	 */
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	/**
	 * Obtiene el código de seguridad (CVV) de la tarjeta.
	 * 
	 * @return CVV de la tarjeta.
	 */
	public int getCvv() {
		return cvv;
	}

	/**
	 * Establece el código de seguridad (CVV) de la tarjeta.
	 * 
	 * @param cvv CVV de la tarjeta.
	 */
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	/**
	 * Obtiene el número de la tarjeta de crédito.
	 * 
	 * @return Número de tarjeta.
	 */
	public long getCreditCardNum() {
		return creditCardNum;
	}

	/**
	 * Establece el número de la tarjeta de crédito.
	 * 
	 * @param creditCardNum Número de tarjeta.
	 */
	public void setCreditCardNum(int creditCardNum) {
		this.creditCardNum = creditCardNum;
	}

	/**
	 * Devuelve una representación en cadena de la tarjeta de crédito.
	 * 
	 * @return Cadena con la información de la tarjeta.
	 */
	@Override
	public String toString() {
		return "CreditCard [userName=" + userName + ", idCreditCard=" + idCreditCard + ", cardHolderName="
				+ cardHolderName + ", expiration=" + expiration + ", cvv=" + cvv + ", creditCardNum=" + creditCardNum
				+ "]";
	}
}