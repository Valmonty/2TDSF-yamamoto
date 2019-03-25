package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_SISTEMA")
@SequenceGenerator(name = "sistema", sequenceName = "SQ_TAB_SISTEMA", allocationSize = 1)
public class Sistema {

	@Id
	@GeneratedValue(generator = "sistema", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "nom_nome")
	private String nome;
	
}
