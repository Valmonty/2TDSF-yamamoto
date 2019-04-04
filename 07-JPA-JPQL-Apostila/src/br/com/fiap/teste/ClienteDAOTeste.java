package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;

class ClienteDAOTeste {

	private static ClienteDAO dao;
	
	@BeforeAll
	public static void iniciar() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	
		dao = new ClienteDAOImpl(em);
	}
	
	@Test
	void pesquisa() {
		List<Cliente> lista = dao.pesquisar();
		assertEquals(5, lista.size());
	}
	
	@Test
	void pesquisarPorParteNome() {
		List<Cliente> lista = dao.pesquisarPorParteNome("T");
		assertEquals(1, lista.size());
	}

}
