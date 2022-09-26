package flowerShop.support;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import flowerShop.model.Address;
import flowerShop.model.Product;
import flowerShop.model.ProductDTO;
import flowerShop.service.CategoryService;
import flowerShop.service.ProductService;

@Component
public class ProductDtoToProduct implements Converter<ProductDTO,Product> {

	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	
	@Override
	public Product convert(ProductDTO source) {
		Product entity = null;
		
		if(source.getId()==null) {
			entity = new Product();
		}else {
			entity = productService.findOne(source.getId());
		}
		
		if(entity!=null) {
			entity.setId(source.getId());
			entity.setAvailable(source.isAvailable());
			entity.setName(source.getName());
			entity.setPrice(source.getPrice());
			entity.setCategory(categoryService.findOneById(source.getCategoryId()));
			
		}
		
		return entity;
	}

	
	
}
