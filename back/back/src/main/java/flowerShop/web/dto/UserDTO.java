package flowerShop.web.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDTO {
	
	private Long id;
	
	@NotBlank
	private String userName;
	
	@NotEmpty
	@Email
	private String email;
	
	 @Size(min=3, max=50)
	private String firstName;
	
	 @Size(min=3, max=50)
	private String lastName;
	 
	 private AddressDTO adresaDTO;
	 
	 

	public AddressDTO getAdresaDTO() {
		return adresaDTO;
	}

	public void setAdresaDTO(AddressDTO adresaDTO) {
		this.adresaDTO = adresaDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	 
	

}
