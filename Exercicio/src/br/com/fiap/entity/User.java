package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="TAB_USUARIO")
@SequenceGenerator(name="usuario", sequenceName="T_SQ_USUARIO", allocationSize=1)
public class User {

	@Id
	@Column(name = "cod_usuario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
	private int codigo;

	@Column(name = "nom_usuario")
	private String nome;

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
	
	@ManyToMany(mappedBy="usuarios")
	private List<Item> itens;

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
}
