package flowerShop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import flowerShop.model.Users;
import flowerShop.web.dto.UserChangePasswordDto;


public interface UserService {
	
	Optional<Users> findOne(Long id);
	
	List<Users> findAll();
	
	Page<Users> findAll(int number);
	
	Users findOneById(Long id);
	
	Users save(Users user);
	
	void delete(Long id);
	
	Optional<Users> findByUserName(String userName);
	
	boolean changePassword(Long id, UserChangePasswordDto userChangePasswordDto);

}
