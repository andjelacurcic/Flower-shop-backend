package flowerShop.service;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import flowerShop.model.Category;

public interface CategoryService {

	List<Category> findAll();
	//Optional<Category> findBy (Long id);
	Category save(Category o);
	Category findOneById(Long id);
	Category delete(Long id);
	
}
