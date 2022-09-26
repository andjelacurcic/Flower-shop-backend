package flowerShop.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import flowerShop.model.Address;
import flowerShop.model.Category;
import flowerShop.web.dto.AddressDTO;
import flowerShop.web.dto.CategoryDTO;

@Component
public class CategoryToCategoryDto implements Converter<Category,CategoryDTO> {

	@Override
	public CategoryDTO convert(Category category) {
		CategoryDTO categoryDto = new CategoryDTO();
		categoryDto.setId(category.getId());
		categoryDto.setName(category.getName());
		return categoryDto;
	}
	
	public List<CategoryDTO> convert(List<Category> categories){
		List<CategoryDTO> categoryDtos = new ArrayList<>();
		
		for(Category a:categories) {
			CategoryDTO dto = convert(a);
			categoryDtos.add(dto);
		}
		return categoryDtos;
	}

}
