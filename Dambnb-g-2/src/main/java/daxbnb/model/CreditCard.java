package daxbnb.model;

import java.sql.Date;

/**
<<<<<<< HEAD
 * Representa una tarjeta de crédito asociada a un usuario.
=======
 * Clase que representa una tarjeta de crédito. Contiene información relevante
 * sobre una tarjeta de crédito, como el nombre del titular, el número de
 * tarjeta, la fecha de vencimiento, etc.
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
 * 
 * @author Alfredo, Jonathan, Diana
 */
public class CreditCard {

	private String userName;
	private int idCreditCard;
	private String cardHolderName;
	private Date expiration;
	private int cvv;
<<<<<<< HEAD
	private long creditCardNum;

	/**
	 * Crea una nueva tarjeta de crédito con los datos especificados.
	 * 
	 * @param userName       Nombre de usuario al que está asociada la tarjeta.
	 * @param idCreditCard   Identificador único de la tarjeta.
	 * @param cardHolderName Nombre del titular de la tarjeta.
	 * @param expiration     Fecha de expiración de la tarjeta.
	 * @param cvv            Código de seguridad (CVV) de la tarjeta.
=======
	private int creditCardNum;

	/**
	 * Constructor
	 * 
	 * @param userName       Nombre de usuario asociado a la tarjeta.
	 * @param idCreditCard   Identificador único de la tarjeta de crédito.
	 * @param cardHolderName Nombre del titular de la tarjeta.
	 * @param expiration     Fecha de vencimiento de la tarjeta.
	 * @param cvv            Código de seguridad de la tarjeta.
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
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
<<<<<<< HEAD
	 * @return Nombre del usuario.
=======
	 * @return El nombre del usuario.
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public String getUserName() {
		return userName;
	}

	/**
<<<<<<< HEAD
	 * Establece el nombre del usuario asociado a la tarjeta.
	 * 
	 * @param userName Nombre del usuario.
=======
	 * 
	 * @param userName El nombre del usuario.
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
<<<<<<< HEAD
	 * Obtiene el identificador único de la tarjeta de crédito.
	 * 
	 * @return ID de la tarjeta.
=======
	 * 
	 * @return El ID único de la tarjeta de crédito.
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public int getIdCreditCard() {
		return idCreditCard;
	}

	/**
<<<<<<< HEAD
	 * Establece el identificador único de la tarjeta de crédito.
	 * 
	 * @param idCreditCard ID de la tarjeta.
=======
	 * 
	 * @param idCreditCard El ID único de la tarjeta de crédito.
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public void setIdCreditCard(int idCreditCard) {
		this.idCreditCard = idCreditCard;
	}

	/**
<<<<<<< HEAD
	 * Obtiene el nombre del titular de la tarjeta.
	 * 
	 * @return Nombre del titular.
=======
	 * 
	 * @return El nombre del titular de la tarjeta.
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public String getCardHolderName() {
		return cardHolderName;
	}

	/**
<<<<<<< HEAD
	 * Establece el nombre del titular de la tarjeta.
	 * 
	 * @param cardHolderName Nombre del titular.
=======
	 * 
	 * @param cardHolderName El nombre del titular de la tarjeta.
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	/**
<<<<<<< HEAD
	 * Obtiene la fecha de expiración de la tarjeta.
	 * 
	 * @return Fecha de expiración.
=======
	 * 
	 * @return La fecha de vencimiento de la tarjeta.
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public Date getExpiration() {
		return expiration;
	}

	/**
<<<<<<< HEAD
	 * Establece la fecha de expiración de la tarjeta.
	 * 
	 * @param expiration Fecha de expiración.
=======
	 * 
	 * @param expiration La fecha de vencimiento de la tarjeta.
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	/**
<<<<<<< HEAD
	 * Obtiene el código de seguridad (CVV) de la tarjeta.
	 * 
	 * @return CVV de la tarjeta.
=======
	 * 
	 * @return El código de seguridad (CVV) de la tarjeta.
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public int getCvv() {
		return cvv;
	}

	/**
<<<<<<< HEAD
	 * Establece el código de seguridad (CVV) de la tarjeta.
	 * 
	 * @param cvv CVV de la tarjeta.
=======
	 * 
	 * @param cvv El código de seguridad (CVV) de la tarjeta.
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	/**
<<<<<<< HEAD
	 * Obtiene el número de la tarjeta de crédito.
	 * 
	 * @return Número de tarjeta.
	 */
	public long getCreditCardNum() {
=======
	 * 
	 * @return El número de la tarjeta de crédito.
	 */
	public int getCreditCardNum() {
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
		return creditCardNum;
	}

	/**
<<<<<<< HEAD
	 * Establece el número de la tarjeta de crédito.
	 * 
	 * @param creditCardNum Número de tarjeta.
=======
	 * 
	 * @param creditCardNum El número de la tarjeta de crédito.
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	public void setCreditCardNum(int creditCardNum) {
		this.creditCardNum = creditCardNum;
	}

	/**
<<<<<<< HEAD
	 * Devuelve una representación en cadena de la tarjeta de crédito.
	 * 
	 * @return Cadena con la información de la tarjeta.
=======
	 * @return Una cadena que representa todos los atributos de la tarjeta de
	 *         crédito
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
	 */
	@Override

	public String toString() {
		return "CreditCard [userName=" + userName + ", idCreditCard=" + idCreditCard + ", cardHolderName="
				+ cardHolderName + ", expiration=" + expiration + ", cvv=" + cvv + ", creditCardNum=" + creditCardNum
				+ "]";
	}
<<<<<<< HEAD
}
=======

}
>>>>>>> 5ae4eac9714f5f85d2991e8f2558e33b32651612
