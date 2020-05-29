package br.com.shoppingportal.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import br.com.shoppingportal.documents.ProductBuy;

public class OrderDTO {
	
	private String idclient;
	private String idaddress;
	private Date orderdate;
	private Set<ProductBuy> products = new HashSet<>();
	
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
	public Set<ProductBuy> getProducts() {
		return products;
	}
	public void setProducts(Set<ProductBuy> products) {
		this.products = products;
	}


}
