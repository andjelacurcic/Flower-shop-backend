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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import flowerShop.model.Product;
import flowerShop.model.ProductDTO;
import flowerShop.service.ProductService;
import flowerShop.support.ProductDtoToProduct;
import flowerShop.support.ProductToProductDto;

@RestController
@RequestMapping(value = "/api/product",produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductDtoToProduct toProduct;
	
	@Autowired
	ProductToProductDto toProductDto;
	
	 @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<ProductDTO> create(@Valid @RequestBody ProductDTO productDTO){
		 Product product = toProduct.convert(productDTO);
		 Product productSave = productService.save(product);

	        return new ResponseEntity<>(toProductDto.convert(productSave), HttpStatus.CREATED);
	    }
	  
	  @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id){
		  Product deleteProduct = productService.delete(id);

	        if(deleteProduct != null) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	  
	  @GetMapping("/{id}")
	    public ResponseEntity<ProductDTO> getOne(@PathVariable Long id){
		  Product product = productService.findOne(id);

	        if(product != null) {
	            return new ResponseEntity<>(toProductDto.convert(product), HttpStatus.OK);
	        }else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }


	    //@PreAuthorize("hasRole('ROLE_ADMIN')")
	    @GetMapping
	    public ResponseEntity<List<ProductDTO>> getAll(){

	        List<Product> products = productService.findAll();

	        return new ResponseEntity<>(toProductDto.convert(products), HttpStatus.OK);
	    }
	

}
