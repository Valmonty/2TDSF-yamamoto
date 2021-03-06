package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_VEICULO")
@SequenceGenerator(name = "veiculo", sequenceName = "SQ_T_VEICULO", allocationSize = 1)
public class Veiculo {

	@Id
	@GeneratedValue(generator = "veiculo", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_veiculo")
	private int codigo;

	@Column(name = "ds_placa", length = 9, nullable = false)
	private String placa;

	@Column(name = "ds_cor", length = 20, nullable = false)
	private String cor;

	@Column(name = "nr_ano")
	@Temporal(TemporalType.DATE)
	private Calendar ano;

	public Veiculo() {
		super();
	}

	public Veiculo(String placa, String cor, Calendar ano) {
		super();
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
	}

	public Veiculo(int codigo, String placa, String cor, Calendar ano) {
		super();
		this.codigo = codigo;
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Calendar getAno() {
		return ano;
	}

	public void setAno(Calendar ano) {
		this.ano = ano;
	}

}
