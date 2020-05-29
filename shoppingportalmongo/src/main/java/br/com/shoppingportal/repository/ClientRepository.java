package br.com.shoppingportal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.shoppingportal.documents.Client;

public interface ClientRepository extends MongoRepository<Client, String>{

}
