package flowerShop.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import flowerShop.model.Address;
import flowerShop.web.dto.AddressDTO;

@Component
public class AddressToAddressDto implements Converter<Address,AddressDTO> {

	@Override
	public AddressDTO convert(Address address) {
		AddressDTO addressDto = new AddressDTO();
		addressDto.setCity(address.getCity());
		addressDto.setId(address.getId());
		addressDto.setFlatNumber(address.getFlatNumber());
		addressDto.setZIP(address.getZIP());
		addressDto.setStreet(address.getStreet());
		return addressDto;
		
	}
	public List<AddressDTO> convert(List<Address> addresses){
		List<AddressDTO> addressDtos = new ArrayList<>();
		
		for(Address a:addresses) {
			AddressDTO dto = convert(a);
			addressDtos.add(dto);
		}
		return addressDtos;
	}
	
	

}
