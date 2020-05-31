package br.com.shoppingportal.documents;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.shoppingportal.dto.ClientDTO;

@Document
public class Client {
	
	@Id
	private String idclient;
	private String name;
	private String cpf;
	private String phonenumber;
	private Date birthdate;
	private Set<String> listIdAddress = new HashSet<>();
	
	public Client() {
		
	}
	
	public Client(ClientDTO clientDTO) {
		this.name = clientDTO.getName();
		this.cpf = clientDTO.getCpf();
		this.phonenumber = clientDTO.getPhonenumber();
		this.birthdate = clientDTO.getBirthdate();
	}

	public String getIdclient() {
		return idclient;
	}

	public void setIdclient(String idclient) {
		this.idclient = idclient;
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

	public Set<String> getListIdAddress() {
		return listIdAddress;
	}

	public void setListIdAddress(Set<String> listAddress) {
		this.listIdAddress = listAddress;
	}

}
