package br.com.shoppingportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.shoppingportal.documents.Product;
import br.com.shoppingportal.dto.ProductDTO;
import br.com.shoppingportal.service.ProductService;

@RestController
@RequestMapping({"/product"})
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<Product> listAll(){
		return productService.listAll();
	}
	
	@GetMapping("/{idproduct}")
	public Product findById(@PathVariable(name = "idproduct") String idproduct){
		return productService.findById(idproduct);
	}
	
	@PostMapping
	public Product create(@RequestBody ProductDTO productDTO){
		return productService.create(productDTO);
	}
	
	@PutMapping("/{idproduct}")
	public Product update(@PathVariable(name = "idproduct") String idproduct, @RequestBody ProductDTO productDTO){
		return productService.update(idproduct, productDTO);
	}
	
	@DeleteMapping("/{idproduct}")
	public void delete(@PathVariable(name = "idproduct") String idproduct){
		productService.remove(idproduct);
	}
	

}
