package flowerShop.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import flowerShop.model.OrderItem;
import flowerShop.model.Product;
import flowerShop.model.ProductDTO;
import flowerShop.web.dto.OrderItemDTO;

@Component
public class OrderItemToOrderItemDto implements Converter<OrderItem,OrderItemDTO>{

	@Override
	public OrderItemDTO convert(OrderItem source) {
		
		OrderItemDTO orderItemDto = new OrderItemDTO();
		orderItemDto.setId(source.getId());
		orderItemDto.setQuantity(source.getQuantity());
		orderItemDto.setOrdersId(source.getOrder().getId());
		orderItemDto.setProductId(source.getProduct().getId());
		orderItemDto.setProductName(source.getProduct().getName());
		orderItemDto.setProductPrice(source.getProduct().getPrice());
		
		return orderItemDto;
		
			
	}

	public List<OrderItemDTO> convert(List<OrderItem> products){
		
		List<OrderItemDTO> productsDtos = new ArrayList<>();
	
		for(OrderItem a:products) {
			OrderItemDTO dto = convert(a);
			productsDtos.add(dto);
		}
		return productsDtos;
}

}
