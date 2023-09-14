package com.backend.entities.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.backend.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String nome;
	private String email;
	
	public UserDto() {
		
	}
	
	public UserDto(User obj) {
		id = obj.getId();
		nome = obj.getNome();	
		email = obj.getEmail();
	}

	public UserDto(String id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
