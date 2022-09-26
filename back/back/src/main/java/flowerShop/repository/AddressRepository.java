package flowerShop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import flowerShop.model.Address;


@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

	Address findOneById(Long id);
}
