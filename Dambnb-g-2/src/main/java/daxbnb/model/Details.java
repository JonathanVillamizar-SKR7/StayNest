package daxbnb.model;

import java.util.List;

public class Details extends User{

    private String password;
    private String userType;
    private String userDescription;
    
	public Details(String userName, int idUser, int phone, String email, int passport, List<CreditCard> creditCard,
			String password, String userType, String userDescription) {
		super(userName, idUser, phone, email, passport, creditCard);
		this.password = password;
		this.userType = userType;
		this.userDescription = userDescription;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserDescription() {
		return userDescription;
	}

	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}

	@Override
	public String toString() {
		return "Details [password=" + password + ", userType=" + userType + ", userDescription=" + userDescription
				+ ", toString()=" + super.toString() + "]";
	}


    
	
    
    
    
    
}
