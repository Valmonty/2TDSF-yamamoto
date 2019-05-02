package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_CARRO")
public class Carro extends Veiculo {

	@Column(name = "nr_portas")
	private int numeroPortas;

	@Column(name = "nr_rodas")
	private int aroRodas;

	public Carro() {
		super();
	}

	public Carro(double velocidade, String nome, int numeroPortas, int aroRodas) {
		super(velocidade, nome);
		this.numeroPortas = numeroPortas;
		this.aroRodas = aroRodas;
	}

	public Carro(int codigo, double velocidade, String nome) {
		super(codigo, velocidade, nome);
	}

	public Carro(int codigo, double velocidade, String nome, int numeroPortas, int aroRodas) {
		super(codigo, velocidade, nome);
		this.numeroPortas = numeroPortas;
		this.aroRodas = aroRodas;
	}

	public int getNumeroPortas() {
		return numeroPortas;
	}

	public void setNumeroPortas(int numeroPortas) {
		this.numeroPortas = numeroPortas;
	}

	public int getAroRodas() {
		return aroRodas;
	}

	public void setAroRodas(int aroRodas) {
		this.aroRodas = aroRodas;
	}

}
