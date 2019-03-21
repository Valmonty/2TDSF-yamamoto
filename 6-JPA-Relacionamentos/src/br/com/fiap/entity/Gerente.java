package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_GERENTE")
@SequenceGenerator(name = "gerente", sequenceName = "SQ_T_GERENTE", allocationSize = 1)
public class Gerente {

	@Id
	@GeneratedValue(generator = "gerente", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_gerente")
	private int codigo;

	@Column(name = "nm_gerente", nullable = false, length = 50)
	private String nome;

	@Column(name = "ds_nivel")
	@Enumerated(EnumType.STRING)
	private Nivel nivel;

	// mappedBy atributo que mapeia a FK na classe departamento
	@OneToOne(mappedBy = "gerente")
	private Departamento departamento;

	public Gerente(String nome, Nivel nivel, Departamento departamento) {
		super();
		this.nome = nome;
		this.nivel = nivel;
		this.departamento = departamento;
	}

	public Gerente() {
		super();
	}

	public Gerente(int codigo, String nome, Nivel nivel, Departamento departamento) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.nivel = nivel;
		this.departamento = departamento;
	}

	public Gerente(String nome, Nivel nivel) {
		super();
		this.nome = nome;
		this.nivel = nivel;
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

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
}
