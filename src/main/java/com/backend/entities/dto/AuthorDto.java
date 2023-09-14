package com.backend.entities.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.backend.entities.User;

public class AuthorDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String nome;
	
	public AuthorDto() {
		
	}
	public AuthorDto(User obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	public AuthorDto(String id, String nome) {
		this.id = id;
		this.nome = nome;
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
	
	

}
