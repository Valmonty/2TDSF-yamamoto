package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_CASO_TESTE")
@SequenceGenerator(name = "caso", allocationSize = 1, sequenceName = "SEQ_TAB_CASO_TESTE")
public class CasoTeste {

	@Id
	@GeneratedValue(generator = "caso", strategy = GenerationType.SEQUENCE)
	@Column(name = "cod_caso_teste")
	private int codigo;

	@Column(name = "nom_caso_teste")
	private String nome;

	@Column(name = "des_caso_teste")
	private String descricao;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cod_sistema")
	private Sistema sistema;

	@OneToMany(mappedBy = "caso", cascade = CascadeType.PERSIST)
	private List<ItemTeste> itensTeste = new ArrayList<>();
	
	public void addItem(ItemTeste item) {
		itensTeste.add(item);
		item.setCaso(this);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public List<ItemTeste> getItensTeste() {
		return itensTeste;
	}

	public void setItensTeste(List<ItemTeste> itensTeste) {
		this.itensTeste = itensTeste;
	}

	public CasoTeste() {
		super();
	}

	public CasoTeste(String nome, String descricao, Sistema sistema, List<ItemTeste> itensTeste) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.sistema = sistema;
		this.itensTeste = itensTeste;
	}

	public CasoTeste(int codigo, String nome, String descricao, Sistema sistema, List<ItemTeste> itensTeste) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.sistema = sistema;
		this.itensTeste = itensTeste;
	}
}
