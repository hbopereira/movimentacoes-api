package com.teste.movimentacao;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teste.base.BaseEntity;
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
	private TipoMovimentacao tipom;

	@Temporal(TemporalType.DATE)
	private Date datahi;

	@Temporal(TemporalType.DATE)
	private Date datahf;
	

	public Movimentacao() {

	}

	public Conteiner getConteiner() {
		return conteiner;
	}

	public void setConteiner(Conteiner conteiner) {
		this.conteiner = conteiner;
	}

	public TipoMovimentacao getTipom() {
		return tipom;
	}

	public void setTipom(TipoMovimentacao tipom) {
		this.tipom = tipom;
	}

	public Date getDatahi() {
		return datahi;
	}

	public void setDatahi(Date datahi) {
		this.datahi = datahi;
	}

	public Date getDatahf() {
		return datahf;
	}

	public void setDatahf(Date datahf) {
		this.datahf = datahf;
	}
}
