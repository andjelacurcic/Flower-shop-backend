package flowerShop.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class ProductDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
	private Long id;
	
	@NotBlank
	private String name;
	
	private Double price;
	
	private boolean available;
	
	private Long categoryId;
	
	private String categoryName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	
	
	
}
