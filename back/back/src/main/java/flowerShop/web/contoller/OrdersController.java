package flowerShop.web.contoller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import flowerShop.model.OrderItem;
import flowerShop.model.Orders;
import flowerShop.service.OrdersService;
import flowerShop.support.OrdersDtoToOrders;
import flowerShop.support.OrdersToOrdersDto;
import flowerShop.web.dto.OrderItemDTO;
import flowerShop.web.dto.OrdersDTO;

@RestController
@RequestMapping(value = "/api/orders",produces = MediaType.APPLICATION_JSON_VALUE)
public class OrdersController {
	
	@Autowired
	OrdersService orderService;
	
	@Autowired
	OrdersToOrdersDto toOrdersDto;
	
	@Autowired
	OrdersDtoToOrders toOrders;
	
	 @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<OrdersDTO> create(@Valid @RequestBody OrdersDTO ordersDTO){
		 Orders orders = toOrders.convert(ordersDTO);
		 Orders ordersSave = orderService.save(orders);

	        return new ResponseEntity<>(toOrdersDto.convert(ordersSave), HttpStatus.CREATED);
	    }
	 
	  //@PreAuthorize("hasRole('ROLE_ADMIN')")
	    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<OrdersDTO> update(@PathVariable Long id, @Valid @RequestBody OrdersDTO ordersDTO){

	        if(!id.equals(ordersDTO.getId())) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }

	        Orders orders = toOrders.convert(ordersDTO);
	        Orders ordersSave = orderService.update(orders);

	        return new ResponseEntity<>(toOrdersDto.convert(ordersSave),HttpStatus.OK);
	    }

	  
	 /* @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id){
		  Orders deleteOrderItem = orderService.delete(id);

	        if(deleteOrderItem != null) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }*/
	  
	  @GetMapping("/{id}")
	    public ResponseEntity<OrdersDTO> getOne(@PathVariable Long id){
		  Orders orderItem = orderService.findOne(id);

	        if(orderItem != null) {
	            return new ResponseEntity<>(toOrdersDto.convert(orderItem), HttpStatus.OK);
	        }else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }


	    //@PreAuthorize("hasRole('ROLE_ADMIN')")
	    @GetMapping
	    public ResponseEntity<List<OrdersDTO>> getAll(){

	        List<Orders> oi = orderService.findAll();

	        return new ResponseEntity<>(toOrdersDto.convert(oi), HttpStatus.OK);
	    }
	
	

}
