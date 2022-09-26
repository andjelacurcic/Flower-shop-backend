package flowerShop.web.dto;

public class UserRegistrationDTO extends UserDTO{
	
	private String password;
	
	private String passwordAgain;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordAgain() {
		return passwordAgain;
	}

	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
	}
	
	

}
