package br.com.shoppingportal.dto;

public class AddressClientDTO {

	private String address;
	private String numberaddress;
	private String reference;
	private String district;
	private String postalcode;
	private String city;
	private String stateabbreviation;
	
	public AddressClientDTO() {
		
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumberaddress() {
		return numberaddress;
	}

	public void setNumberaddress(String numberaddress) {
		this.numberaddress = numberaddress;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateabbreviation() {
		return stateabbreviation;
	}

	public void setStateabbreviation(String stateabbreviation) {
		this.stateabbreviation = stateabbreviation;
	}

}
