package flowerShop.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flowerShop.model.Address;
import flowerShop.model.Orders;
import flowerShop.repository.AddressRepository;
import flowerShop.service.AddressService;
import flowerShop.web.dto.AddressDTO;
import flowerShop.web.dto.OrdersDTO;

@Service
public class JpaAddressService implements AddressService{

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<Address> findAll() {
		return addressRepository.findAll();
	}

	@Override
	public Optional<Address> findOne(Long id) {
		return addressRepository.findById(id);
	}

	@Override
	public Address save(Address o) {
		return addressRepository.save(o);
	}

	@Override
	public Address delete(Long id) {
		Address address = addressRepository.findOneById(id);
        if(address != null){
            addressRepository.deleteById(id);
            return address;
        }
        return null;
		
	}

	@Override
	public Address update(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Address findById(Long id) {
		// TODO Auto-generated method stub
		return addressRepository.findOneById(id);
	}
	
	/*private AddressDTO convertEntityToDto (Address address) {
		
		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.LOOSE);
		AddressDTO addressDTO = new AddressDTO();
		
		addressDTO = modelMapper.map(address, AddressDTO.class);
		return addressDTO;
	}
	
	private Address convertDtoToEntity (AddressDTO addressDTO) {
		
		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.LOOSE);
		Address address = new Address();
		
		address = modelMapper.map(addressDTO, Address.class);
		return address;
	}*/

}
