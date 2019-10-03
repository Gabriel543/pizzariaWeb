package br.com.senac.pizzariaweb.util;

public class SequenceID {
	// atributo estatico
	private static int id;
	
	// construtor incrementa o id
	
	
	// o método retorna o valor do id incrementado
	public static int nextID() {
		return ++id;
	}
}
