package flowerShop.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import flowerShop.model.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findOneById(Long id);
	//Optional<Category> findBy(Long id);
}
