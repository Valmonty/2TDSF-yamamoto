package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "TAB_CASO_TESTE")
@SequenceGenerator(name = "caso_teste", sequenceName = "SQ_T_CASO", allocationSize = 1)
public class Caso {

	@Id
	@Column(name = "cod_caso_teste")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "caso")
	private int cod_caso;

	@Column(name = "nom_caso_teste")
	private String nome_caso;

	@Column(name = "desc_caso_teste")
	private String desc_caso;

	
	@ManyToOne
	private Sistema sistema;
	
	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	@OneToMany(mappedBy="caso")
	private List<Item> itens;
	
	public int getCod_caso() {
		return cod_caso;
	}

	public void setCod_caso(int cod_caso) {
		this.cod_caso = cod_caso;
	}

	public String getNome_caso() {
		return nome_caso;
	}

	public void setNome_caso(String nome_caso) {
		this.nome_caso = nome_caso;
	}

	public String getDesc_caso() {
		return desc_caso;
	}

	public void setDesc_caso(String desc_caso) {
		this.desc_caso = desc_caso;
	}


}
