package br.com.shoppingportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.shoppingportal.documents.Product;
import br.com.shoppingportal.dto.ProductDTO;
import br.com.shoppingportal.repository.ProductRepository;
import br.com.shoppingportal.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> listAll() {
		return this.productRepository.findAll();
	}

	@Override
	public Product findById(String idproduct) {
		return this.productRepository.findById(idproduct).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public Product create(ProductDTO productDTO) {
		Product product = new Product(productDTO);
		return this.productRepository.save(product);
	}

	@Override
	public Product update(String idproduct, ProductDTO productDTO) {
		Product product = new Product();
		product = findById(idproduct);
		product.setName(productDTO.getName());
		product.setAmount(productDTO.getAmount());
		product.setPrice(productDTO.getPrice());
		return this.productRepository.save(product);
	}

	@Override
	public void remove(String id) {
		this.productRepository.deleteById(id);
	}

}
