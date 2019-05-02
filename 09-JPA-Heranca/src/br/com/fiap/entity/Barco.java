package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@DiscriminatorValue("B")

@Entity
@Table(name = "T_BARCO")
public class Barco extends Veiculo {

	@Column(name = "vl_pes")
	private int pes;

	@Column(name = "ds_tipoBarco")
	private TipoBarco tipoBarco;

	public Barco() {
		super();
	}

	public Barco(int pes, TipoBarco tipoBarco) {
		super();
		this.pes = pes;
		this.tipoBarco = tipoBarco;
	}

	public Barco(double velocidade, String nome, int pes, TipoBarco tipoBarco) {
		super(velocidade, nome);
		this.pes = pes;
		this.tipoBarco = tipoBarco;
	}

	public Barco(double velocidade, String nome) {
		super(velocidade, nome);
	}

	public Barco(int codigo, double velocidade, String nome) {
		super(codigo, velocidade, nome);
	}

	public int getPes() {
		return pes;
	}

	public void setPes(int pes) {
		this.pes = pes;
	}

	public TipoBarco getTipoBarco() {
		return tipoBarco;
	}

	public void setTipoBarco(TipoBarco tipoBarco) {
		this.tipoBarco = tipoBarco;
	}

}
