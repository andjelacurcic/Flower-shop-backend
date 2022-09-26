package flowerShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import flowerShop.model.OrderItem;



@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	OrderItem findOneById(Long id);
}
