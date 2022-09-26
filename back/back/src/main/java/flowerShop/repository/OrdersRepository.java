package flowerShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import flowerShop.model.Orders;


@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>{

	
	Orders findOneById(Long id);
}
