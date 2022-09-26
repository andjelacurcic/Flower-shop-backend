package flowerShop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Column
	private String street;
	
	@Column
	private String city;
	
	@Column
	private int ZIP;
	
	@Column
	private String flatNumber;

	@OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
	private List<Users> users = new ArrayList<>();

	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

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

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}
	
	
	

}
