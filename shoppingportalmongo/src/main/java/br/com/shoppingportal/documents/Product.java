package br.com.shoppingportal.documents;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.shoppingportal.dto.ProductDTO;

@Document
public class Product {
	
	@Id
	private String idproduct;
	private String name;
	private int amount;
	private BigDecimal price;
	
	public Product() {
		
	}
	
	public Product(ProductDTO productDTO) {
		this.name = productDTO.getName();
		this.amount = productDTO.getAmount();
		this.price = productDTO.getPrice();
	}

	public String getIdproduct() {
		return idproduct;
	}

	public void setIdproduct(String idproduct) {
		this.idproduct = idproduct;
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
