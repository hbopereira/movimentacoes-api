package com.teste.enums;

public enum TipoMovimentacao {
	Embarque(1),
	Descarga(2),
	GateIn(3),
	Gateout(4),
	Reposicionamento(5),
	Pesagem(6),
	Scanner(7);
	
	private int valor;

	TipoMovimentacao(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

}
