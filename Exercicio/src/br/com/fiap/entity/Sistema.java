package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "TAB_SISTEMA")
@SequenceGenerator(name = "sistema", sequenceName = "SQ_T_SISTEMA", allocationSize = 1)
public class Sistema {

	@Id
	@Column(name = "cod_sistema")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sistema")
	private int codigo;

	@Column(name = "nom_sistema")
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
	
	@OneToMany(mappedBy="sistema")
	private List<Caso> casos;

	public List<Caso> getCasos() {
		return casos;
	}

	public void setCasos(List<Caso> casos) {
		this.casos = casos;
	}

}
