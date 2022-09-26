package flowerShop.web.contoller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import flowerShop.model.Category;
import flowerShop.service.CategoryService;
import flowerShop.support.CategoryDtoToCategory;
import flowerShop.support.CategoryToCategoryDto;
import flowerShop.web.dto.CategoryDTO;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping(value = "/api/category",produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryToCategoryDto toCategoryDto;
	
	@Autowired
	private CategoryDtoToCategory toCategory;
	
	// @PreAuthorize("hasRole('ROLE_ADMIN')")
	    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<CategoryDTO> create(@Valid @RequestBody CategoryDTO categoryDTO){
	        Category category = toCategory.convert(categoryDTO);
	        Category saveCategory = categoryService.save(category);

	        return new ResponseEntity<>(toCategoryDto.convert(saveCategory), HttpStatus.CREATED);
	    }

	   /* @PreAuthorize("hasRole('ROLE_ADMIN')")
	    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @Valid @RequestBody CategoryDTO categoryDTO){

	        if(!id.equals(categoryDTO.getId())) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }

	        Category category = toCategory.convert(categoryDTO);
	        Category saveCategory = categoryService.update(category);

	        return new ResponseEntity<>(toCategoryDto.convert(saveCategory),HttpStatus.OK);
	    }*/

	   // @PreAuthorize("hasRole('ROLE_ADMIN')")
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id){
	        Category deleteCategory = categoryService.delete(id);

	        if(deleteCategory != null) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    //@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	    @GetMapping("/{id}")
	    public ResponseEntity<CategoryDTO> getOne(@PathVariable Long id){
	        Category category = categoryService.findOneById(id);

	        if(category != null) {
	            return new ResponseEntity<>(toCategoryDto.convert(category), HttpStatus.OK);
	        }else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }


	    //@PreAuthorize("hasRole('ROLE_ADMIN')")
	    @GetMapping
	    public ResponseEntity<List<CategoryDTO>> getAll(){

	        List<Category> categories = categoryService.findAll();

	        return new ResponseEntity<>(toCategoryDto.convert(categories), HttpStatus.OK);
	    }

	   

}
