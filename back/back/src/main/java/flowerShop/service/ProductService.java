package flowerShop.service;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import flowerShop.model.Product;

public interface ProductService {

	List<Product> findAll();
	Page<Product> findAll(Pageable pageable);
	Product findOne (Long id);
	Product save(Product o);
	Product update(Product o);
	Product delete(Long id);
	Page<Product> find( Double cenaOd, Double cenaDo, int pageNo);
	List<Product> findByCategoryId(Long categoryId);
}
