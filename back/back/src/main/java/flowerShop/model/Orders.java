package flowerShop.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Orders {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private LocalDate date;
	
	@Column
	private Double fullPrice;
	
	@Column
	private String contact;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems = new ArrayList<>();

	
	@ManyToOne
	//@JoinColumn(name = "fk_user")
	private Users user;
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users getUser() {
		return user;
	}



	public void setUser(Users user) {
		this.user = user;
	}



	public List<OrderItem> getOrderItems() {
		return orderItems;
	}



	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getFullPrice() {
		return fullPrice;
	}

	public void setFullPrice(Double fullPrice) {
		this.fullPrice = fullPrice;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}


	
	
	
	
}
