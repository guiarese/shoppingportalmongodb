package br.com.shoppingportal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.shoppingportal.documents.Order;

public interface OrderRepository extends MongoRepository<Order, String>{

}
