package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_USUARIO")
@SequenceGenerator(name = "usuario", sequenceName = "SEQ_TAB_USUARIO", allocationSize = 1)
public class Usuario {

	@Id
	@GeneratedValue(generator = "usuario", strategy = GenerationType.SEQUENCE)
	@Column(name = "cod_usuario")
	private int codigo;

	@Column(name = "nom_usuario")
	private String nome;

	@ManyToMany(mappedBy = "usuarios")
	private List<ItemTeste> itens;

}
