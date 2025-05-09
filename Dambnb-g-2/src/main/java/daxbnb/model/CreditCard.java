package daxbnb.model;

import java.sql.Date;

/**
 * Representa una tarjeta de crédito asociada a un usuario.
 * 
 * @author Alfredo,Jonathan,Diana
 */
public class CreditCard {

	/**
	 * Nombre de usuario al que pertenece la tarjeta.
	 */
	private int idUser;

	/**
	 * Identificador único de la tarjeta de crédito.
	 */
	private int idCreditCard;

	/**
	 * Nombre del titular de la tarjeta de crédito.
	 */
	private String cardHolderName;

	/**
	 * Fecha de expiración de la tarjeta de crédito.
	 */
	private Date expiration;

	/**
	 * Código de verificación de la tarjeta (CVV).
	 */
	private int cvv;

	/**
	 * Número de la tarjeta de crédito.
	 */
	private long creditCardNum;

	/**
	 * Constructor con todos los campos.
	 * 
	 * @param userName       Nombre de usuario
	 * @param idCreditCard   ID de la tarjeta
	 * @param cardHolderName Nombre del titular
	 * @param expiration     Fecha de expiración
	 * @param cvv            Código CVV
	 * @param creditCardNum  Número de tarjeta
	 * 
	 */
	public CreditCard(int idUser, int idCreditCard, String cardHolderName, Date expiration, int cvv,
			long creditCardNum) {
		this.idUser = idUser;
		this.idCreditCard = idCreditCard;
		this.cardHolderName = cardHolderName;
		this.expiration = expiration;
		this.setCvv(cvv); // Validación
		this.creditCardNum = creditCardNum;
	}

	/**
	 * Obtiene el nombre del usuario asociado a la tarjeta.
	 * 
	 * @return El nombre del usuario.
	 */
	public int getUserName() {
		return idUser;
	}

	/**
	 * Establece el nombre del usuario asociado a la tarjeta.
	 * 
	 * @param userName Nombre del usuario.
	 */
	public void setUserName(int idUser) {
		this.idUser = idUser;
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
		if (cvv >= 100 && cvv <= 9999) {
			this.cvv = cvv;
		} else {
			throw new IllegalArgumentException("El CVV debe tener entre 3 y 4 dígitos.");
		}
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
	public void setCreditCardNum(long creditCardNum) {
		this.creditCardNum = creditCardNum;
	}

	/**
	 * Devuelve una representación en cadena de la tarjeta de crédito.
	 * 
	 * @return Cadena con la información de la tarjeta.
	 */
	@Override
	public String toString() {
		return "CreditCard [idUser=" + idUser + ", idCreditCard=" + idCreditCard + ", cardHolderName="
				+ cardHolderName + ", expiration=" + expiration + ", cvv=" + cvv + ", creditCardNum=" + creditCardNum
				+ "]";
	}
}
