package br.com.shoppingportal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.shoppingportal.documents.AddressClient;

public interface AddressClientRepository extends MongoRepository<AddressClient, String>{

}
