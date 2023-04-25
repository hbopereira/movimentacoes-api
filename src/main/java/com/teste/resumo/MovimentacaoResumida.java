package com.teste.resumo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teste.enums.Categoria;
import com.teste.enums.Status;
import com.teste.enums.TipoConteiner;

public interface MovimentacaoResumida {

	@JsonIgnore
	Long getCod();

	String getNome();

	Categoria getCategoria();

	Status getStatus();

	TipoConteiner getTipo();

	String getNumero();

	String getTipom();

	Date getDatahi();

	Date getDatahf();

	@JsonIgnore
	Long getTotalImportacao();

	@JsonIgnore
	Long getTotalExportacao();

}
