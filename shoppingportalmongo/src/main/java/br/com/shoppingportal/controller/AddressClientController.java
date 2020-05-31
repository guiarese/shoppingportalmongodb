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

import br.com.shoppingportal.documents.AddressClient;
import br.com.shoppingportal.dto.AddressClientDTO;
import br.com.shoppingportal.service.AddressClientService;

@RestController
@RequestMapping({"/addressclient"})
public class AddressClientController {
	
	@Autowired
	private AddressClientService addressClientService;
	
	@GetMapping
	public List<AddressClient> listAll(){
		return addressClientService.listAll();
	}
	
	@GetMapping("/{idaddress}")
	public AddressClient findById(@PathVariable(name = "idaddress") String idaddress){
		return addressClientService.findById(idaddress);
	}
	
	// O endereço só será criado no create client
	/*@PostMapping
	public AddressClient create(@RequestBody AddressClientDTO addressClientDTO){
		return addressClientService.create(addressClientDTO);
	}*/
	
	@PutMapping("/{idaddress}")
	public AddressClient update(@PathVariable(name = "idaddress") String idaddress, @RequestBody AddressClientDTO addressClientDTO){
		return addressClientService.update(idaddress, addressClientDTO);
	}
	
	// O endereço só será deletado no delete client
	/*@DeleteMapping("/{idaddress}")
	public void delete(@PathVariable(name = "idaddress") String idaddress){
		addressClientService.remove(idaddress);
	}*/
	
}
