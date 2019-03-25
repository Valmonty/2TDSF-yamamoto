package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_CASO_TESTE")
@SequenceGenerator(name = "casoTeste", allocationSize = 1, sequenceName = "SQ_TAB_CASO_TESTE")
public class CasoTeste {

	@Id
	@GeneratedValue(generator = "casoTeste", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "nom_caso_teste")
	private String nome;

	@Column(name = "des_caso_teste")
	private String descricao;
}
