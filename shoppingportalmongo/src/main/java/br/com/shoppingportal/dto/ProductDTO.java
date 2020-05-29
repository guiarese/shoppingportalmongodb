package br.com.shoppingportal.dto;

import java.math.BigDecimal;

import br.com.shoppingportal.documents.Product;

public class ProductDTO {
	
	private String name;
	private int amount;
	private BigDecimal price;
	
	public ProductDTO() {
		
	}
	
	public ProductDTO(Product product) {
		this.name = product.getName();
		this.amount = product.getAmount();
		this.price = product.getPrice();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
