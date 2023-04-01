package com.teste.container;

import com.teste.base.BaseEntity;
import com.teste.cliente.Cliente;
import com.teste.enums.Categoria;
import com.teste.enums.Status;
import com.teste.enums.TipoConteiner;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Conteiner extends BaseEntity {

	@OneToOne
	@JoinColumn(name = "cliente_cod")
	private Cliente cliente;

	@Enumerated(EnumType.STRING)
	private Categoria categoria;

	@Enumerated(EnumType.STRING)
	private Status status;

	@Enumerated(EnumType.STRING)
	private TipoConteiner tipo;

	private String numero;

	public Conteiner() {

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public TipoConteiner getTipo() {
		return tipo;
	}

	public void setTipo(TipoConteiner tipo) {
		this.tipo = tipo;
	}

}
