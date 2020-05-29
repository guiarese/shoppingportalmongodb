package br.com.shoppingportal.service;

import java.util.List;

import br.com.shoppingportal.documents.Product;
import br.com.shoppingportal.dto.ProductDTO;

public interface ProductService {
	
	List<Product> listAll();
	Product findById(String idproduct);
	Product create(ProductDTO productDTO);
	Product update(String idproduct, ProductDTO productDTO);
	void remove(String id);

}
