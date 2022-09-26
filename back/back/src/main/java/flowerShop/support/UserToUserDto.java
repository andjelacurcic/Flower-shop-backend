package flowerShop.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import flowerShop.model.Users;
import flowerShop.web.dto.UserDTO;

@Component
public class UserToUserDto implements Converter<Users, UserDTO> {

	private AddressToAddressDto toAddress;
	
	@Override
	public UserDTO convert(Users user) {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setId(user.getId());
		userDTO.setEmail(user.getEmail());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		userDTO.setUserName(user.getUserName());
		userDTO.setAdresaDTO(toAddress.convert(user.getAdress()));
		
		
		return userDTO;
	}
	
	public List<UserDTO> convert(List<Users> users){
        List<UserDTO> userDTOS = new ArrayList<>();

        for(Users k : users) {
            UserDTO dto = convert(k);
            userDTOS.add(dto);
        }

        return userDTOS;
    }
	
	

}
