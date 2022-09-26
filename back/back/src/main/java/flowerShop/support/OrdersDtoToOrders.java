package flowerShop.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import flowerShop.model.Orders;
import flowerShop.model.Product;
import flowerShop.service.OrdersService;
import flowerShop.service.UserService;
import flowerShop.web.dto.OrdersDTO;

@Component
public class OrdersDtoToOrders implements Converter<OrdersDTO, Orders>{

	@Autowired
	OrdersService ordersService;
	
	@Autowired
	UserService usersService;
	
	@Override
	public Orders convert(OrdersDTO source) {
		Orders entity = null;
		
		if(source.getId()==null) {
			entity = new Orders();
		}else {
			entity = ordersService.findOne(source.getId());
		}
		
		if(entity != null) {
			entity.setId(source.getId());
			entity.setContact(source.getContact());
			entity.setDate(source.getDate());
			entity.setFullPrice(source.getFullPrice());
			entity.setUser(usersService.findOneById(source.getUsersId()));
		}
		return entity;
	}

}
