package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Inheritance(strategy = InheritanceType.JOINED)
// @DiscriminatorValue("V")
// @DiscriminatorColumn(name = "DS_TIPO")

@Entity
@Table(name = "T_VEICULO")
@SequenceGenerator(name = "veiculo", sequenceName = "SQ_T_VEICULO", allocationSize = 1)
public class Veiculo {

	@Id
	@GeneratedValue(generator = "veiculo", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_veiculo")
	private int codigo;

	@Column(name = "vl_velocidade")
	private double velocidade;

	@Column(name = "nm_veiculo")
	private String nome;

	public Veiculo() {
		super();
	}

	public Veiculo(double velocidade, String nome) {
		super();
		this.velocidade = velocidade;
		this.nome = nome;
	}

	public Veiculo(int codigo, double velocidade, String nome) {
		super();
		this.codigo = codigo;
		this.velocidade = velocidade;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(double velocidade) {
		this.velocidade = velocidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
