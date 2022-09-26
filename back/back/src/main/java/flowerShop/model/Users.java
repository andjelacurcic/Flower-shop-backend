package flowerShop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import flowerShop.enumeration.UserRole;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String userName;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String password;
	
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	
	@ManyToOne
	private Address address;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Orders> orders = new ArrayList<>();

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Users(String userName, String email, String firstName, String lastName, String password,
			UserRole userRole) {
		this.userName = userName;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.userRole = userRole;
	}

	



	public Address getAdress() {
		return address;
	}



	public void setAdress(Address address) {
		this.address = address;
	}



	public List<Orders> getOrders() {
		return orders;
	}



	public void setOrders(List<Orders> orders) {
		this.orders = orders;
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



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public UserRole getUserRole() {
		return userRole;
	}



	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}



	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, password, userName, userRole);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		 if (id == null) {
	            if (other.id != null)
	                return false;
	        } else if (!id.equals(other.id))
	            return false;
	        return true;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName +  "]";
	}
	
	
	

}
