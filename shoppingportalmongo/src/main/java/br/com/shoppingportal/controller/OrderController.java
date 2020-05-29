package br.com.shoppingportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.shoppingportal.documents.Order;
import br.com.shoppingportal.dto.OrderDTO;
import br.com.shoppingportal.service.OrderService;

@RestController
@RequestMapping({"/order"})
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public List<Order> listAll(){
		return orderService.listAll();
	}
	
	@GetMapping("/{idorder}")
	public Order findById(@PathVariable(name = "idorder") String idorder){
		return orderService.findById(idorder);
	}
	
	@PostMapping
	public Order create(@RequestBody OrderDTO orderDTO){
		return orderService.create(orderDTO);
	}
	
}
