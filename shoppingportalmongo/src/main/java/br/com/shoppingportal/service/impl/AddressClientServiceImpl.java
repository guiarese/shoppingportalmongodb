package br.com.shoppingportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.shoppingportal.documents.AddressClient;
import br.com.shoppingportal.documents.Client;
import br.com.shoppingportal.dto.AddressClientDTO;
import br.com.shoppingportal.repository.AddressClientRepository;
import br.com.shoppingportal.service.AddressClientService;
import br.com.shoppingportal.service.ClientService;

@Service
public class AddressClientServiceImpl implements AddressClientService {
	
	@Autowired
	private AddressClientRepository addressClientRepository;
	
	@Autowired
	private ClientService clientService;

	@Override
	public List<AddressClient> listAll() {
		return this.addressClientRepository.findAll();
	}

	@Override
	public AddressClient findById(String idaddress) {
		return this.addressClientRepository.findById(idaddress).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public AddressClient create(AddressClientDTO addressClientDTO) {
		Client client = new Client();
		client = clientService.findById(addressClientDTO.getIdclient());
		AddressClient address = new AddressClient(addressClientDTO);
		return this.addressClientRepository.save(address);
	}

	@Override
	public AddressClient update(String idaddress, AddressClientDTO addressClientDTO) {
		Client client = new Client();
		client = clientService.findById(addressClientDTO.getIdclient());
		AddressClient address = new AddressClient();
		address = findById(idaddress);
		address.setAddress(addressClientDTO.getAddress());
		address.setCity(addressClientDTO.getCity());
		address.setDistrict(addressClientDTO.getDistrict());
		address.setNumberaddress(addressClientDTO.getNumberaddress());
		address.setPostalcode(addressClientDTO.getPostalcode());
		address.setReference(addressClientDTO.getReference());
		address.setStateabbreviation(addressClientDTO.getStateabbreviation());
		return this.addressClientRepository.save(address);
	}

	@Override
	public void remove(String idaddress) {
		this.addressClientRepository.deleteById(idaddress);
	}

}
