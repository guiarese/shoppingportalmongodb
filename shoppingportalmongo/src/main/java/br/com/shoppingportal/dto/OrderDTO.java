package br.com.shoppingportal.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class OrderDTO {
	
	private String idclient;
	private String idaddress;
	private Date orderdate;
	private Set<ProductBuyDTO> products = new HashSet<>();
	
	public OrderDTO() {
		
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


}
