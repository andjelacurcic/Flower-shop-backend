package flowerShop.service;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import flowerShop.model.Address;

public interface AddressService {

	List<Address> findAll();
	Address findById(Long id);
	Optional<Address> findOne (Long id);
	Address save(Address o);
	Address delete(Long id);
	Address update(Address address);
}
