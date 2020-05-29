package br.com.shoppingportal.service;

import java.util.List;

import br.com.shoppingportal.documents.Client;
import br.com.shoppingportal.dto.ClientDTO;

public interface ClientService {
	
	List<Client> listAll();
	Client findById(String idclient);
	Client create(ClientDTO clientDTO);
	Client update(String idclient, ClientDTO clientDTO);
	void remove(String idclient);

}
