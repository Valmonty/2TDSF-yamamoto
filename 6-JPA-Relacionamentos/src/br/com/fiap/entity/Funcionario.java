package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_FUNCIONARIO")
@SequenceGenerator(name = "funcionario", sequenceName = "SQ_T_FUNCIONARIO", allocationSize = 1)
public class Funcionario {

	@Id
	@GeneratedValue(generator = "funcionario", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_funcionario")
	private int codigo;

	@Column(name = "nm_nome", nullable = false, length = 50)
	private String nome;

	@Column(name = "dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	@Column(name = "vl_salario")
	private float salario;

	@ManyToOne
	@JoinColumn(name = "cd_departamento")
	private Departamento departamento;
}
