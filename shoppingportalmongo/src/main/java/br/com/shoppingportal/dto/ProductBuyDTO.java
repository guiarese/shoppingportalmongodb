package br.com.shoppingportal.dto;

public class ProductBuyDTO {
	
	private String idproduct;
	private int amount;
	
	public ProductBuyDTO() {
		
	}
	
	public String getIdproduct() {
		return idproduct;
	}
	public void setIdproduct(String idproduct) {
		this.idproduct = idproduct;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
