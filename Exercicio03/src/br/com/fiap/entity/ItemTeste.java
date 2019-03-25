package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_ITEM_TESTE")
@SequenceGenerator(name = "itemTeste", allocationSize = 1, sequenceName = "SQ_TAB_ITEM_TESTE")
public class ItemTeste {

	@Id
	@GeneratedValue(generator = "itemTeste", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "des_item_teste")
	private String descricao;
	
}
