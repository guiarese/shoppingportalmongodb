package br.com.shoppingportal.service;

import java.util.List;

import br.com.shoppingportal.documents.AddressClient;
import br.com.shoppingportal.dto.AddressClientDTO;

public interface AddressClientService {
	
	List<AddressClient> listAll();
	AddressClient findById(String idaddress);
	AddressClient create(AddressClientDTO addressClientDTO);
	AddressClient update(String idaddress, AddressClientDTO addressClientDTO);
	void remove(String idaddress);

}
