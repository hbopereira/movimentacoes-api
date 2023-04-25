package com.teste.resumo;

import java.sql.Date;

import com.teste.enums.Categoria;
import com.teste.enums.Status;
import com.teste.enums.TipoConteiner;

public interface MovimentacaoResumida {
	
	Long getCod();
	String getNome();
	Categoria getCategoria();
	Status getStatus();
	TipoConteiner getTipo();
	String getNumero();
	String getTipom();
	Date getDatahi();
	Date getDatahf();
	Long getTotalImportacao();
	Long getTotalExportacao();

}
