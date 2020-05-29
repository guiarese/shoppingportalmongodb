package br.com.shoppingportal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.shoppingportal.documents.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
