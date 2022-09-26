package flowerShop.support;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import flowerShop.model.Address;
import flowerShop.service.AddressService;
import flowerShop.web.dto.AddressDTO;

@Component
public class AddressDtoToAddress implements Converter<AddressDTO, Address> {
	
	@Autowired
	private AddressService addressService;

	@Override
	public Address convert(AddressDTO source) {
		Address entity = null;
		
		if(source.getId()==null) {
			entity = new Address();
		}else {
			Optional<Address> addressOp = addressService.findOne(source.getId());
			if(addressOp.isPresent()) {
				entity = addressOp.get();
			}
		}
		
		if(entity != null) {
			entity.setId(source.getId());
			entity.setCity(source.getCity());
			entity.setFlatNumber(source.getFlatNumber());
			entity.setStreet(source.getCity());
			entity.setZIP(source.getZIP());
		}
		return entity;
	}
	
	

}
