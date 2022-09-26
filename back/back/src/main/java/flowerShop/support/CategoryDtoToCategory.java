package flowerShop.support;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import flowerShop.model.Address;
import flowerShop.model.Category;
import flowerShop.service.CategoryService;
import flowerShop.web.dto.CategoryDTO;

@Component
public class CategoryDtoToCategory implements Converter<CategoryDTO, Category> {

	@Autowired
	private CategoryService categoryService;
	
	@Override
	public Category convert(CategoryDTO categoryDto) {
		
		Category entity = null;
		if(categoryDto.getId()==null) {
			entity = new Category();
		}else {
			 entity = categoryService.findOneById(categoryDto.getId());
			
		}
		
		if(entity != null) {
			entity.setId(categoryDto.getId());
			entity.setName(categoryDto.getName());
		}
		return entity;
	
	}
	
	

}
