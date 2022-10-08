package flowerShop.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flowerShop.model.Orders;
import flowerShop.model.Product;
import flowerShop.model.ProductDTO;
import flowerShop.repository.OrdersRepository;
import flowerShop.service.OrdersService;
import flowerShop.web.dto.OrdersDTO;

@Service
public class JpaOrdersService implements OrdersService {

	@Autowired
	OrdersRepository ordersRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<Orders> findAll() {
		return ordersRepository.findAll();
	}

	@Override
	public Orders findOne(Long id) {
		return ordersRepository.findOneById(id);
	}

	@Override
	public Orders save(Orders o) {
		return ordersRepository.save(o);
	}
	
/*private OrdersDTO convertEntityToDto (Orders orders) {
		
		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.LOOSE);
		OrdersDTO ordersDTO = new OrdersDTO();
		
		ordersDTO = modelMapper.map(orders, OrdersDTO.class);
		return ordersDTO;
	}
	
	private Orders convertDtoToEntity (OrdersDTO ordersDTO) {
		
		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.LOOSE);
		Orders orders = new Orders();
		
		orders = modelMapper.map(ordersDTO, Orders.class);
		return orders;
	}*/

	@Override
	public Orders update(Orders orders) {
		return ordersRepository.save(orders);	
		}

}
