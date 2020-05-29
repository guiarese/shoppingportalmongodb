package br.com.shoppingportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.shoppingportal.documents.Client;
import br.com.shoppingportal.dto.ClientDTO;
import br.com.shoppingportal.service.ClientService;

@RestController
@RequestMapping({"/client"})
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping
	public List<Client> listAll(){
		return clientService.listAll();
	}
	
	@GetMapping("/{idclient}")
	public Client findById(@PathVariable(name = "idclient") String idclient){
		return clientService.findById(idclient);
	}
	
	@PostMapping
	public Client create(@RequestBody ClientDTO clientDTO){
		return clientService.create(clientDTO);
	}
	
	@PutMapping("/{idclient}")
	public Client update(@PathVariable(name = "idclient") String idclient, @RequestBody ClientDTO clientDTO){
		return clientService.update(idclient, clientDTO);
	}
	
	@DeleteMapping("/{idclient}")
	public void delete(@PathVariable(name = "idclient") String idclient){
		clientService.remove(idclient);
	}
	

}
