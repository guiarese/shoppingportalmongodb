package br.com.shoppingportal.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.shoppingportal.dto.AddressClientDTO;

@Document
public class AddressClient {
	
	@Id
	private String idaddress;
	private String address;
	private String numberaddress;
	private String reference;
	private String district;
	private String postalcode;
	private String city;
	private String stateabbreviation;
	
	public AddressClient() {
		
	}
	
	public AddressClient(AddressClientDTO addressClientDTO) {
		this.address = addressClientDTO.getAddress();
		this.numberaddress = addressClientDTO.getNumberaddress();
		this.reference = addressClientDTO.getReference();
		this.district = addressClientDTO.getDistrict();
		this.postalcode = addressClientDTO.getPostalcode();
		this.city = addressClientDTO.getCity();
		this.stateabbreviation = addressClientDTO.getStateabbreviation();
	}

	public String getIdaddress() {
		return idaddress;
	}

	public void setIdaddress(String idaddress) {
		this.idaddress = idaddress;
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
