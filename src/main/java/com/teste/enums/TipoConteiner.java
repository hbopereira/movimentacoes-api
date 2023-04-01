package com.teste.enums;

public enum TipoConteiner {
	Vinte(20), Quarenta(40);

	private int valor;

	TipoConteiner(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

}
