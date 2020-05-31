package br.com.shoppingportal.documents;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.shoppingportal.dto.OrderDTO;
import br.com.shoppingportal.dto.ProductBuyDTO;

@Document
public class Order {
	
	@Id
	private String idorder;
	private String idclient;
	private String idaddress;
	private Date orderdate;
	private Set<ProductBuyDTO> products = new HashSet<>();
	private BigDecimal value;
	
	public Order() {
		
	}
	
	public Order(OrderDTO orderDTO) {
		this.idclient = orderDTO.getIdclient();
		this.idaddress = orderDTO.getIdaddress();
		this.orderdate = orderDTO.getOrderdate();
		this.products = orderDTO.getProducts();
	}

	public String getIdorder() {
		return idorder;
	}

	public void setIdorder(String idorder) {
		this.idorder = idorder;
	}

	public String getIdclient() {
		return idclient;
	}

	public void setIdclient(String idclient) {
		this.idclient = idclient;
	}

	public String getIdaddress() {
		return idaddress;
	}

	public void setIdaddress(String idaddress) {
		this.idaddress = idaddress;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public Set<ProductBuyDTO> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductBuyDTO> products) {
		this.products = products;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}
