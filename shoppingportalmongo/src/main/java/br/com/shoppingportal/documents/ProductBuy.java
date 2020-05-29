package br.com.shoppingportal.documents;

public class ProductBuy {
	
	private String idproduct;
	private int amount;
	
	public ProductBuy() {
		
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
