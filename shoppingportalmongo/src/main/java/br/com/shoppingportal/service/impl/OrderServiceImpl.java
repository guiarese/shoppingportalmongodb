package br.com.shoppingportal.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.shoppingportal.documents.Client;
import br.com.shoppingportal.documents.Order;
import br.com.shoppingportal.documents.Product;
import br.com.shoppingportal.dto.OrderDTO;
import br.com.shoppingportal.dto.ProductBuyDTO;
import br.com.shoppingportal.dto.ProductDTO;
import br.com.shoppingportal.repository.OrderRepository;
import br.com.shoppingportal.service.ClientService;
import br.com.shoppingportal.service.OrderService;
import br.com.shoppingportal.service.ProductService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ProductService productService;

	@Override
	public List<Order> listAll() {
		return this.orderRepository.findAll();
	}

	@Override
	public Order findById(String idorder) {
		return this.orderRepository.findById(idorder).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public Order create(OrderDTO orderDTO) {
		
		Order order = new Order(orderDTO);
		
		Client client = new Client();
		client = clientService.findById(order.getIdclient());
		
		if (client.getListIdAddress().contains(orderDTO.getIdaddress()) == false) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "O cliente não contém esse endereço");
		}
		
		BigDecimal sumValues = new BigDecimal(0);
		
		for (ProductBuyDTO w : order.getProducts()) {
			
			Product product = new Product();
			product = productService.findById(w.getIdproduct());
			
			if (product.getAmount() < w.getAmount()) {
				throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Quantidade solicitada maior que a quantidade do estoque");
			}
			if (product.getAmount() == 0) {
				throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Produto com quantidade 0 em estoque");
			}
			if (w.getAmount() <= 0) {
				throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Quantidade do produto deve ser maior do que zero");
			}
			
			BigDecimal sum1 = new BigDecimal(w.getAmount());
			BigDecimal sum2 = new BigDecimal(0).add(product.getPrice());
			sum1 = sum1.multiply(sum2);
			sumValues = sumValues.add(sum1);
			
			ProductDTO productDTO = new ProductDTO(product);
			productDTO.setAmount(product.getAmount() - w.getAmount());
			productService.update(product.getIdproduct(), productDTO);
			
		}
		
		order.setValue(sumValues);
		orderRepository.save(order);
		
		return order;
	}

}
