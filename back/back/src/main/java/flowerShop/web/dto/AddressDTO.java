package flowerShop.web.dto;

import javax.validation.constraints.Positive;

public class AddressDTO {
	
	@Positive(message = "Id mora biti pozitivan broj.")
	private Long id;
	
	private String street;
	
	private String city;
	
	private int ZIP;
	
	private String flatNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZIP() {
		return ZIP;
	}

	public void setZIP(int zIP) {
		ZIP = zIP;
	}

	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}
	
	

}
