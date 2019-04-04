package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{

	List<Cliente> pesquisar();
	
	List<Cliente> pesquisarPorParteNome(String nome);
	
}
