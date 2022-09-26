package flowerShop.service;

import java.util.List;
//import java.util.Optional;

import flowerShop.model.OrderItem;

public interface OrderItemService {

	List<OrderItem> findAll();
	OrderItem findOne (Long id);
	OrderItem save(OrderItem o);
}
