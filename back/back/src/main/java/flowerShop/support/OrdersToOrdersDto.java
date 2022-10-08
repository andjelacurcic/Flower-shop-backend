package flowerShop.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import flowerShop.model.Orders;
import flowerShop.model.Product;
import flowerShop.model.ProductDTO;
import flowerShop.web.dto.OrdersDTO;

@Component
public class OrdersToOrdersDto implements Converter<Orders,OrdersDTO>{

	@Override
	public OrdersDTO convert(Orders orders) {
		OrdersDTO ordersDto = new OrdersDTO();
		ordersDto.setId(orders.getId());
		ordersDto.setDate(orders.getDate());
		ordersDto.setContact(orders.getContact());
		ordersDto.setFullPrice(orders.getFullPrice());
		ordersDto.setUsersId(orders.getUser().getId());
		ordersDto.setUsersName(orders.getUser().getFirstName());
		ordersDto.setLastName(orders.getUser().getLastName());
		return ordersDto;
	}
	
	public List<OrdersDTO> convert(List<Orders> products){
		List<OrdersDTO> productsDtos = new ArrayList<>();
		
		for(Orders a:products) {
			OrdersDTO dto = convert(a);
			productsDtos.add(dto);
		}
		return productsDtos;
	}
	
}


