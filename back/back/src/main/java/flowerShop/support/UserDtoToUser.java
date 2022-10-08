package flowerShop.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import flowerShop.model.Users;
import flowerShop.service.AddressService;
import flowerShop.service.UserService;
import flowerShop.web.dto.UserDTO;

@Component
public class UserDtoToUser implements Converter<UserDTO, Users> {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressService addressService;
	
	@Override
	public Users convert(UserDTO userDTO) {
		Users user = null;
		if(userDTO.getId()!=null) {
			user = userService.findOne(userDTO.getId()).get();
		}
		
		if(user == null) {
			user = new Users();
		}
		
		user.setUserName(userDTO.getUserName());
		user.setEmail(userDTO.getEmail());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setAddress(addressService.findById(userDTO.getAdresaDTO().getId()));
		
		return user;
		
	}
	
	

}
