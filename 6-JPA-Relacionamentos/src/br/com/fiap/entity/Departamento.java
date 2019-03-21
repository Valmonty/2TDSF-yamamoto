package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_DEPARTAMENTO")
@SequenceGenerator(name = "departamento", sequenceName = "SQ_T_DEPARTAMENTO", allocationSize = 1)
public class Departamento {

	@Id
	@GeneratedValue(generator = "departamento", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "nm_departamento", nullable = false)
	private String nome;

	@Column(name = "ds_status")
	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_gerente")
	private Gerente gerente;

	@OneToMany(mappedBy = "departamento", cascade = CascadeType.PERSIST)
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	public void addFuncionario(Funcionario funcionario) {
		// adicionar o funcionario na lista
		funcionarios.add(funcionario);

		// adicionar o departamento no funcionario
		funcionario.setDepartamento(this);
	}

	public Departamento(String nome, Status status, Gerente gerente) {
		super();
		this.nome = nome;
		this.status = status;
		this.gerente = gerente;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
