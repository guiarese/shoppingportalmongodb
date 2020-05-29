package br.com.shoppingportal.service;

import java.util.List;

import br.com.shoppingportal.documents.Order;
import br.com.shoppingportal.dto.OrderDTO;

public interface OrderService {
	
	List<Order> listAll();
	Order findById(String idorder);
	Order create(OrderDTO orderDTO);

}
