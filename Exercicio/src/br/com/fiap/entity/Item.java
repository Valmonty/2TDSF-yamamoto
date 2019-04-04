package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "TAB_ITEM_TESTE")
@SequenceGenerator(name = "item_teste", sequenceName = "SQ_T_ITEM_TESTE", allocationSize = 1)
public class Item {

	@Id
	@Column(name = "cod_item_teste")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item")
	private int cod_item;

	@Column(name = "desc_item_teste")
	private String desc_item;

	public int getCod_item() {
		return cod_item;
	}

	public void setCod_item(int cod_item) {
		this.cod_item = cod_item;
	}

	public String getDesc_item() {
		return desc_item;
	}

	public void setDesc_item(String desc_item) {
		this.desc_item = desc_item;
	}

	@ManyToOne
	private Caso casos;

	@ManyToMany
	@JoinTable(name = "TAB_ITEM_TESTE_USUARIO", 
		joinColumns = @JoinColumn(name = "cod_item"), 
		inverseJoinColumns = @JoinColumn(name = "cod_user"))
	private List<User> usuarios;

	public Caso getCasos() {
		return casos;
	}

	public void setCasos(Caso casos) {
		this.casos = casos;
	}

	public List<User> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<User> usuarios) {
		this.usuarios = usuarios;
	}

}
