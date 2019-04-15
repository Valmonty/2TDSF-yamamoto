package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
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
	public static void instanciar() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		dao = new ClienteDAOImpl(em);
	}

	@Test
	void pesquisaTeste() {
		List<Cliente> lista = dao.pesquisar();
		assertEquals(5, lista.size());
	}

	@Test
	void pesquisarPorNomeTeste() {
		List<Cliente> lista = dao.pesquisar("Mar");
		// Valida se a lista de cliente está correta
		for (Cliente cliente : lista) {
			assertTrue(cliente.getNome().contains("Mar"));
		}
	}

	@Test
	void pesquisarPorEstadoTeste() {
		List<Cliente> lista = dao.pesquisarPorEstado("BA");
		for (Cliente cliente : lista) {
			assertEquals("BA", cliente.getEndereco().getCidade().getUf());
		}
	}

	@Test
	void pesquisarPorDiasReserva() {
		List<Cliente> lista = dao.pesquisarPorDiaReserva(10);
		assertEquals(2, lista.size());
	}

	@Test
	void pesquisarPorNomeCidadeTeste() {
		List<Cliente> lista = dao.buscar("Lea", "Lon");

		for (Cliente cliente : lista) {
			assertTrue(
					cliente.getNome().contains("Lea") && cliente.getEndereco().getCidade().getNome().contains("Lon"));
		}
	}

	@Test
	void pesquisarPorEstados() {
		List<String> estados = new ArrayList<String>();

		estados.add("SP");
		estados.add("BA");

		List<Cliente> lista = dao.buscarPorEstados(estados);

		for (Cliente cliente : lista) {
			assertTrue(estados.contains(cliente.getEndereco().getCidade().getUf()));
		}
	}

}
