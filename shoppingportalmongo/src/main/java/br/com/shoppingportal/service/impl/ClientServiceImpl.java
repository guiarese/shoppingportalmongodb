package br.com.shoppingportal.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.shoppingportal.documents.AddressClient;
import br.com.shoppingportal.documents.Client;
import br.com.shoppingportal.dto.AddressClientDTO;
import br.com.shoppingportal.dto.ClientDTO;
import br.com.shoppingportal.repository.ClientRepository;
import br.com.shoppingportal.service.AddressClientService;
import br.com.shoppingportal.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressClientService addressClientService;

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
		
		if(clientDTO.getListAddress().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Ao menos um endereço deve ser informado");
		}
		
		Set<AddressClient> listAddressClient = new HashSet<>();
		for (AddressClientDTO w : clientDTO.getListAddress()) {
			AddressClient addressClient = new AddressClient();
			addressClient = addressClientService.create(w);
			listAddressClient.add(addressClient);
		}
		
		Set<String> idListAddressClient = new HashSet<>();
		for (AddressClient x : listAddressClient) {
			idListAddressClient.add(x.getIdaddress());
		}
		
		client.setListIdAddress(idListAddressClient);	
		return this.clientRepository.save(client);
		
	}

	@Override
	public Client update(String idclient, ClientDTO clientDTO) {
		
		if(clientDTO.getListAddress().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Ao menos um endereço deve ser informado");
		}
		
		Client client = new Client();
		client = findById(idclient);
		
		for(String x : client.getListIdAddress()) {
			this.addressClientService.remove(x);
		}
		
		Set<AddressClient> listAddressClient = new HashSet<>();
		for (AddressClientDTO w : clientDTO.getListAddress()) {
			AddressClient addressClient = new AddressClient();
			addressClient = addressClientService.create(w);
			listAddressClient.add(addressClient);
		}
		
		Set<String> idListAddressClient = new HashSet<>();
		for (AddressClient x : listAddressClient) {
			idListAddressClient.add(x.getIdaddress());
		}		
		
		client.setName(clientDTO.getName());
		client.setCpf(clientDTO.getCpf());
		client.setPhonenumber(clientDTO.getPhonenumber());
		client.setBirthdate(clientDTO.getBirthdate());
		client.setListIdAddress(idListAddressClient);
		return this.clientRepository.save(client);
	}

	@Override
	public void remove(String idclient) {
		Client client = new Client();
		client = findById(idclient);
		for(String x : client.getListIdAddress()) {
			this.addressClientService.remove(x);
		}
		this.clientRepository.deleteById(idclient);
	}

}
