package br.com.shoppingportal.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ClientDTO {
	
	private String name;
	private String cpf;
	private String phonenumber;
	private Date birthdate;
	private Set<AddressClientDTO> listAddress = new HashSet<>();
	
	public ClientDTO() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Set<AddressClientDTO> getListAddress() {
		return listAddress;
	}

	public void setListAddress(Set<AddressClientDTO> listAddress) {
		this.listAddress = listAddress;
	}

}
