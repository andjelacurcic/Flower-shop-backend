package flowerShop.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flowerShop.model.OrderItem;
import flowerShop.model.Orders;
import flowerShop.repository.OrderItemRepository;
import flowerShop.service.OrderItemService;
import flowerShop.web.dto.OrderItemDTO;
import flowerShop.web.dto.OrdersDTO;

@Service
public class JpaOrderItemService implements OrderItemService {

	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<OrderItem> findAll() {
		return orderItemRepository.findAll();
	}

	@Override
	public OrderItem findOne(Long id) {
		return orderItemRepository.findOneById(id);
	}

	@Override
	public OrderItem save(OrderItem o) {
		return orderItemRepository.save(o);
	}

	@Override
	public OrderItem delete(Long id) {
		OrderItem oi = orderItemRepository.findOneById(id);
		if(oi != null ) {
			orderItemRepository.delete(oi);
		}
		return null;
	}

	@Override
	public OrderItem update(OrderItem o) {
		return orderItemRepository.save(o);
	}
	
/*private OrderItemDTO convertEntityToDto (OrderItem orderItem) {
		
		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.LOOSE);
		OrderItemDTO orderItemDTO = new OrderItemDTO();
		
		orderItemDTO = modelMapper.map(orderItem, OrderItemDTO.class);
		return orderItemDTO;
	}
	
	private OrderItem convertDtoToEntity (OrderItemDTO orderItemDTO) {
		
		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.LOOSE);
		OrderItem orderItem = new OrderItem();
		
		orderItem = modelMapper.map(orderItemDTO, OrderItem.class);
		return orderItem;
	}*/

	

}
