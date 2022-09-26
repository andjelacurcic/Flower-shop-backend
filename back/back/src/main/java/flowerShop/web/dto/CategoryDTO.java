package flowerShop.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class CategoryDTO {
	
	@Positive(message = "Id mora biti pozitivan broj.")
	private Long id;
	
	@NotBlank
	private String name;

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
	
	
	

}
