package flowerShop.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import flowerShop.model.OrderItem;
import flowerShop.model.Product;
import flowerShop.service.OrderItemService;
import flowerShop.service.OrdersService;
import flowerShop.service.ProductService;
import flowerShop.web.dto.OrderItemDTO;

@Component
public class OrderItemDtoToOrderItem implements Converter<OrderItemDTO, OrderItem>{

	@Autowired
	OrderItemService  orderItemService;
	
	@Autowired
	OrdersService ordersService;
	
	@Autowired
	ProductService productService;
	
	@Override
	public OrderItem convert(OrderItemDTO source) {
		OrderItem entity = null;
		
		if(source.getId()==null) {
			entity = new OrderItem();
		}else {
			entity = orderItemService.findOne(source.getId());
		}
		
		if(entity!=null) {
			entity.setId(source.getId());
			entity.setQuantity(source.getQuantity());
			entity.setOrder(ordersService.findOne(source.getOrdersId()));
			entity.setProduct(productService.findOne(source.getProductId()));
		}
		return entity;
	}
	
	

}
