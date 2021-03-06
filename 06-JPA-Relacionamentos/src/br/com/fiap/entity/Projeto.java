package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_PROJETO")
@SequenceGenerator(name = "projeto", sequenceName = "SQ_T_PROJETO", allocationSize = 1)
public class Projeto {

	@Id
	@GeneratedValue(generator = "projeto", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_projeto")
	private int codigo;

	@Column(name = "nm_nome", nullable = false)
	private String nome;

	@Column(name = "ds_status")
	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "dt_inicio")
	@Temporal(TemporalType.DATE)
	private Calendar dataInicio;

	@Column(name = "dt_fim")
	@Temporal(TemporalType.DATE)
	private Calendar dataFim;
	
	@ManyToMany(mappedBy = "projeto")
	private List<Funcionario> funcionarios;

	public int getCodigo() {
		return codigo;
	}

	public Projeto(String nome, Status status, Calendar dataInicio, Calendar dataFim) {
		super();
		this.nome = nome;
		this.status = status;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public Projeto(String nome, Status status, Calendar dataInicio, Calendar dataFim, List<Funcionario> funcionarios) {
		super();
		this.nome = nome;
		this.status = status;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.funcionarios = funcionarios;
	}

	public Projeto() {
		super();
	}

	public Projeto(int codigo, String nome, Status status, Calendar dataInicio, Calendar dataFim,
			List<Funcionario> funcionarios) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.status = status;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.funcionarios = funcionarios;
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

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataFim() {
		return dataFim;
	}

	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
