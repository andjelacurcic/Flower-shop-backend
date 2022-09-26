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

import flowerShop.model.Address;
import flowerShop.model.Category;
import flowerShop.service.AddressService;
import flowerShop.support.AddressDtoToAddress;
import flowerShop.support.AddressToAddressDto;
import flowerShop.web.dto.AddressDTO;
import flowerShop.web.dto.CategoryDTO;

@RestController
@RequestMapping(value = "/api/address",produces = MediaType.APPLICATION_JSON_VALUE)
public class AddressController {
	
		@Autowired
		AddressService addressService;

		@Autowired
		AddressDtoToAddress toAddress;
		
		@Autowired
		AddressToAddressDto toAddressDto;
	
	  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<AddressDTO> create(@Valid @RequestBody AddressDTO addressDTO){
	        Address address = toAddress.convert(addressDTO);
	        Address saveAddress = addressService.save(address);

	        return new ResponseEntity<>(toAddressDto.convert(saveAddress), HttpStatus.CREATED);
	    }
	  
	  @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id){
		  Address deleteAddress = addressService.delete(id);

	        if(deleteAddress != null) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	  
	  @GetMapping("/{id}")
	    public ResponseEntity<AddressDTO> getOne(@PathVariable Long id){
		  Address address = addressService.findById(id);

	        if(address != null) {
	            return new ResponseEntity<>(toAddressDto.convert(address), HttpStatus.OK);
	        }else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }


	    //@PreAuthorize("hasRole('ROLE_ADMIN')")
	    @GetMapping
	    public ResponseEntity<List<AddressDTO>> getAll(){

	        List<Address> addresses = addressService.findAll();

	        return new ResponseEntity<>(toAddressDto.convert(addresses), HttpStatus.OK);
	    }

	  
}
