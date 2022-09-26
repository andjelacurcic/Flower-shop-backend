package flowerShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import flowerShop.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findOneById(Long id); 
	List<Product> findByCategoryId(Long categoryId);
	Page<Product> findByNameIgnoreCaseContains(String name, Pageable of);
	Page<Product> findByPriceBetween(Double minPrice, Double maxPrice, Pageable pageable);
	
}
