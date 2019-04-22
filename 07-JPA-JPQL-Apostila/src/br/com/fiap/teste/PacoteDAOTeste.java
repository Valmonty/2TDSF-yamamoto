package br.com.fiap.teste;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

class PacoteDAOTeste {

	private static PacoteDAO pacoteDAO;
	private static TransporteDAO transporteDAO;

	@BeforeAll
	public static void init() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		pacoteDAO = new PacoteDAOImpl(em);
		transporteDAO = new TransporteDAOImpl(em);
	}

	@Test
	void pesquisarPorTransporteTeste() {
		Transporte transporte = transporteDAO.pesquisar(1);
		List<Pacote> lista = pacoteDAO.pesquisar(transporte);

		for (Pacote pacote : lista) {
			assertEquals(1, pacote.getTransporte().getId());
		}
	}

	@Test
	void pesquisarPorDataTeste() {

		Calendar inicio = new GregorianCalendar(2017, Calendar.JANUARY, 1);
		Calendar fim = new GregorianCalendar(2018, Calendar.JANUARY, 1);

		List<Pacote> lista = pacoteDAO.buscarPorDatas(inicio, fim);

		for (Pacote pacote : lista) {
			assertTrue(pacote.getDataSaida().after(inicio) && pacote.getDataSaida().before(fim));
		}
	}

	@Test
	void somarPrecoPorTransporteTeste() {
		Transporte transporte = transporteDAO.pesquisar(1);
		double total = pacoteDAO.somarPrecoPorTransporte(transporte);
		assertEquals(4300, total);
	}

	@Test
	void buscarPorPrecoTest() {
		List<Pacote> lista = pacoteDAO.buscarPorPreco(1000);
		for (Pacote pacote : lista) {
			assertTrue(pacote.getPreco() < 1000);
		}
	}

}
