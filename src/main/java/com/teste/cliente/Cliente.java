package com.teste.cliente;

import com.teste.base.BaseEntity;
import jakarta.persistence.Entity;

@Entity
public class Cliente extends BaseEntity {

	private String nome;

	public Cliente() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
