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
import flowerShop.model.Product;
import flowerShop.model.ProductDTO;
import flowerShop.service.OrderItemService;
import flowerShop.support.OrderItemDtoToOrderItem;
import flowerShop.support.OrderItemToOrderItemDto;
import flowerShop.web.dto.OrderItemDTO;

@RestController
@RequestMapping(value = "/api/orderitem",produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderItemController {
	
	@Autowired
	OrderItemService orderItemService;
	
	@Autowired
	OrderItemToOrderItemDto toOrderItemDTO;
	
	@Autowired
	OrderItemDtoToOrderItem toOrderItem;
	
	 @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<OrderItemDTO> create(@Valid @RequestBody OrderItemDTO orderItemDTO){
		 OrderItem orderItem = toOrderItem.convert(orderItemDTO);
		 OrderItem orderItemSave = orderItemService.save(orderItem);

	        return new ResponseEntity<>(toOrderItemDTO.convert(orderItemSave), HttpStatus.CREATED);
	    }
	 
	  //@PreAuthorize("hasRole('ROLE_ADMIN')")
	    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<OrderItemDTO> update(@PathVariable Long id, @Valid @RequestBody OrderItemDTO orderItemDTO){

	        if(!id.equals(orderItemDTO.getId())) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }

	        OrderItem orderItem = toOrderItem.convert(orderItemDTO);
	        OrderItem saveOrderItem = orderItemService.update(orderItem);

	        return new ResponseEntity<>(toOrderItemDTO.convert(saveOrderItem),HttpStatus.OK);
	    }

	  
	  @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id){
		  OrderItem deleteOrderItem = orderItemService.delete(id);

	        if(deleteOrderItem != null) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	  
	  @GetMapping("/{id}")
	    public ResponseEntity<OrderItemDTO> getOne(@PathVariable Long id){
		  OrderItem orderItem = orderItemService.findOne(id);

	        if(orderItem != null) {
	            return new ResponseEntity<>(toOrderItemDTO.convert(orderItem), HttpStatus.OK);
	        }else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }


	    //@PreAuthorize("hasRole('ROLE_ADMIN')")
	    @GetMapping
	    public ResponseEntity<List<OrderItemDTO>> getAll(){

	        List<OrderItem> oi = orderItemService.findAll();

	        return new ResponseEntity<>(toOrderItemDTO.convert(oi), HttpStatus.OK);
	    }
	

}
