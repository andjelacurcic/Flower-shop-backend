package flowerShop.service;

import java.util.List;
//import java.util.Optional;

import flowerShop.model.Orders;

public interface OrdersService {

	List<Orders> findAll();
	Orders findOne (Long id);
	Orders save(Orders o);
	Orders update(Orders orders);
	


}
