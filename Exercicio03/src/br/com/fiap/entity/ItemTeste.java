package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_ITEM_TESTE")
@SequenceGenerator(name = "item", allocationSize = 1, sequenceName = "SEQ_TAB_ITEM_TESTE")
public class ItemTeste {

	@Id
	@GeneratedValue(generator = "item", strategy = GenerationType.SEQUENCE)
	@Column(name = "cod_item_teste")
	private int codigo;

	@Column(name = "des_item_teste")
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "cod_caso_teste")
	private CasoTeste caso;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "TAB_ITEM_TESTE_USUARIO", joinColumns = @JoinColumn(name = "COD_ITEM_TESTE"), inverseJoinColumns = @JoinColumn(name = "COD_USUARIO"))
	private List<Usuario> usuarios;

	public ItemTeste(int codigo, String descricao, CasoTeste caso, List<Usuario> usuarios) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.caso = caso;
		this.usuarios = usuarios;
	}

	public ItemTeste(String descricao, CasoTeste caso, List<Usuario> usuarios) {
		super();
		this.descricao = descricao;
		this.caso = caso;
		this.usuarios = usuarios;
	}

	public ItemTeste() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CasoTeste getCaso() {
		return caso;
	}

	public void setCaso(CasoTeste caso) {
		this.caso = caso;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
