package com.teste.resumo;

import java.sql.Date;
import java.util.Map;

public interface MovimentacaoResumida {
	
	Long getCod();
	String getNome();
	String getCategoria();
	String getStatus();
	String getTipo();
	String getNumero();
	String getTipom();
	Date getDatahi();
	Date getDatahf();
	Long getTotalImportacao();
	Long getTotalExportacao();

}
