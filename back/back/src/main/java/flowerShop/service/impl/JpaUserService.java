package flowerShop.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import flowerShop.enumeration.UserRole;
import flowerShop.model.Users;
import flowerShop.repository.UserRepository;
import flowerShop.service.UserService;
import flowerShop.web.dto.UserChangePasswordDto;

@Service
public class JpaUserService implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public Optional<Users> findOne(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public List<Users> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Page<Users> findAll(int number) {
		return userRepository.findAll(PageRequest.of(number,10));
	}

	@Override
	public Users save(Users user) {
		user.setUserRole(UserRole.USER);
		return userRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public Optional<Users> findByUserName(String userName) {
		return userRepository.findFirstByUserName(userName);
	}

	@Override
	public boolean changePassword(Long id, UserChangePasswordDto userChangePasswordDto) {
		Optional<Users> res = userRepository.findById(id);
		
		if(!res.isPresent()) {
			throw new EntityNotFoundException();
		}
		
		Users user = res.get();
		
		if(!user.getUserName().equals(userChangePasswordDto.getUserName())
				|| !user.getPassword().equals(userChangePasswordDto.getOldPassword())) {
			return false;
		}
		
		String password = userChangePasswordDto.getPassword();
		if(!userChangePasswordDto.getPassword().equals("")) {
			password = passwordEncoder.encode(userChangePasswordDto.getPassword());
		}
		
		user.setPassword(password);
		userRepository.save(user);
		
		return true;
	}

	@Override
	public Users findOneById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.getById(id);
	}

}
