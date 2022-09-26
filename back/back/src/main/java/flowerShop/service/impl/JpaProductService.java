package flowerShop.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import flowerShop.model.Product;
import flowerShop.model.ProductDTO;
import flowerShop.repository.ProductRepository;
import flowerShop.service.ProductService;

@Service
public class JpaProductService implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	

	@Override
	public Product findOne(Long id) {
		return productRepository.findOneById(id);
	}

	@Override
	public Product save(Product o) {
		return productRepository.save(o);
	}

	@Override
	public Product update(Product o) {
	     return productRepository.save(o);
	}

	@Override
	public Product delete(Long id) {
		Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
           productRepository.deleteById(id);
            return product.get();
        }
        return null;
	}

	@Override
	public Page<Product> find(Double cenaOd, Double cenaDo, int pageNo) {
		if(cenaOd == null) {
			cenaOd = 0.0;
		}
		if(cenaDo == null) {
			cenaDo = 100000.0;
		}
		return productRepository.findByPriceBetween(cenaOd, cenaDo, PageRequest.of(pageNo, 4));
	}

	@Override
	public List<Product> findByCategoryId(Long categoryId) {
		return productRepository.findByCategoryId(categoryId);
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}
	
	private ProductDTO convertEntityToDto (Product product) {
		
		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.LOOSE);
		ProductDTO productDTO = new ProductDTO();
		
		productDTO = modelMapper.map(product, ProductDTO.class);
		return productDTO;
	}
	
	private Product convertDtoToEntity (ProductDTO productDTO) {
		
		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.LOOSE);
		Product product = new Product();
		
		product = modelMapper.map(productDTO, Product.class);
		return product;
	}

}
