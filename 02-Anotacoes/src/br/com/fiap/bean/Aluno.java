package br.com.fiap.bean;

import br.com.fiap.anotacao.Tabela;

@Tabela(nome="T_ALUNO")
public class Aluno {
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
