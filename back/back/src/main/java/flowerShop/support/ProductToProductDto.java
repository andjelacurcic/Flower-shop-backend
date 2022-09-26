package flowerShop.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import flowerShop.model.Address;
import flowerShop.model.Product;
import flowerShop.model.ProductDTO;
import flowerShop.web.dto.AddressDTO;

@Component
public class ProductToProductDto implements Converter<Product,ProductDTO>{

	@Override
	public ProductDTO convert(Product product) {
		ProductDTO productDto = new ProductDTO();
		productDto.setAvailable(product.isAvailable());
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		productDto.setCategoryId(product.getCategory().getId());
		productDto.setCategoryName(product.getCategory().getName());
		return productDto;
		
	}
	
	public List<ProductDTO> convert(List<Product> products){
		List<ProductDTO> productsDtos = new ArrayList<>();
		
		for(Product a:products) {
			ProductDTO dto = convert(a);
			productsDtos.add(dto);
		}
		return productsDtos;
	}

}
