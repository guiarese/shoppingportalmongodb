package br.com.shoppingportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.shoppingportal.documents.Client;
import br.com.shoppingportal.dto.ClientDTO;
import br.com.shoppingportal.repository.ClientRepository;
import br.com.shoppingportal.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public List<Client> listAll() {
		return this.clientRepository.findAll();
	}

	@Override
	public Client findById(String idclient) {
		return this.clientRepository.findById(idclient).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public Client create(ClientDTO clientDTO) {
		Client client = new Client(clientDTO);
		return this.clientRepository.save(client);
	}

	@Override
	public Client update(String idclient, ClientDTO clientDTO) {
		Client client = new Client();
		client = findById(idclient);
		client.setName(clientDTO.getName());
		client.setCpf(clientDTO.getCpf());
		client.setPhonenumber(clientDTO.getPhonenumber());
		client.setBirthdate(clientDTO.getBirthdate());
		return this.clientRepository.save(client);
	}

	@Override
	public void remove(String idclient) {
		this.clientRepository.deleteById(idclient);
	}

}
