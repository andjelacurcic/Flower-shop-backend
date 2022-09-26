package flowerShop.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flowerShop.model.Category;
import flowerShop.model.Orders;
import flowerShop.model.Product;
import flowerShop.repository.CategoryRepository;
import flowerShop.service.CategoryService;
import flowerShop.web.dto.CategoryDTO;
import flowerShop.web.dto.OrdersDTO;

@Service
public class JpaCategoryService implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	

	@Override
	public Category save(Category o) {
		return categoryRepository.save(o);
	}
	
	/*private CategoryDTO convertEntityToDto (Category category) {
		
		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.LOOSE);
		CategoryDTO categoryDTO = new CategoryDTO();
		
		categoryDTO = modelMapper.map(category, CategoryDTO.class);
		return categoryDTO;
	}
	
	private Category convertDtoToEntity (CategoryDTO categoryDTO) {
		
		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.LOOSE);
		Category category = new Category();
		
		category = modelMapper.map(categoryDTO, Category.class);
		return category;
	}
*/


	/*@Override
	public Optional<Category> findBy(Long id) {
		return categoryRepository.findBy(id);
	}*/



	@Override
	public Category findOneById(Long id) {
		return categoryRepository.findOneById(id);
	}



	@Override
	public Category delete(Long id) {
		Optional<Category> product = categoryRepository.findById(id);
        if(product.isPresent()){
        	categoryRepository.deleteById(id);
            return product.get();
        }
        return null;
	}

}
