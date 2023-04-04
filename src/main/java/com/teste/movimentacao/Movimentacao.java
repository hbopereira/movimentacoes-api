package com.teste.movimentacao;

import java.util.Date;

import com.teste.base.BaseEntity;
import com.teste.cliente.Cliente;
import com.teste.container.Conteiner;
import com.teste.enums.TipoMovimentacao;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table
public class Movimentacao extends BaseEntity {

	@OneToOne
	@JoinColumn(name = "conteiner_cod")
	private Conteiner conteiner;

	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipo;

	@Temporal(TemporalType.DATE)
	private Date dataHoraInicio;

	@Temporal(TemporalType.DATE)
	private Date dataHoraFim;

	public Movimentacao() {

	}

	public Conteiner getConteiner() {
		return conteiner;
	}

	public void setConteiner(Conteiner conteiner) {
		this.conteiner = conteiner;
	}

	public TipoMovimentacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimentacao tipo) {
		this.tipo = tipo;
	}

	public Date getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(Date dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public Date getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(Date dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

}
