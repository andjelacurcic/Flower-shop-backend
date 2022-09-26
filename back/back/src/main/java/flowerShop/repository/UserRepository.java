package flowerShop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import flowerShop.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
	
	Optional<Users> findFirstByUserName(String userName);
	
	Optional<Users> findFirstByUserNameAndPassword(String userName, String password);

}
