package br.com.fiap.teste;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.DepartamentoDAO;
import br.com.fiap.dao.GerenteDAO;
import br.com.fiap.dao.impl.DepartamentoDAOImpl;
import br.com.fiap.dao.impl.GerenteDAOImpl;
import br.com.fiap.entity.Departamento;
import br.com.fiap.entity.Funcionario;
import br.com.fiap.entity.Gerente;
import br.com.fiap.entity.Nivel;
import br.com.fiap.entity.Projeto;
import br.com.fiap.entity.Status;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class DepartamentoDAOTest {

	private static DepartamentoDAO depDAO;
	private static GerenteDAO gerenteDAO;

	// Método que executa antes de todos os testes
	@BeforeAll
	public static void inicializar() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		depDAO = new DepartamentoDAOImpl(em);
		gerenteDAO = new GerenteDAOImpl(em);
	}

	private Departamento departamento;
	private Gerente gerente;

	// Método que executa antes de cada teste
	@BeforeEach
	public void cadastrarAntesDosTestes() {
		try {
			gerente = new Gerente("Humberto", Nivel.SENIOR);
			departamento = new Departamento("Dev", Status.ATIVO, gerente);

			Funcionario f1 = new Funcionario("Henrique", Calendar.getInstance(), 1000);
			Funcionario f2 = new Funcionario("Maria", Calendar.getInstance(), 500);

			departamento.addFuncionario(f1);
			departamento.addFuncionario(f2);

			Projeto p1 = new Projeto("Projeto churros", Status.ATIVO, Calendar.getInstance(),
					new GregorianCalendar(2019, Calendar.OCTOBER, 10));

			Projeto p2 = new Projeto("Projeto AM", Status.ATIVO, Calendar.getInstance(),
					new GregorianCalendar(2019, Calendar.OCTOBER, 10));

			// associar os projetos no funcionario
			List<Projeto> projetos = new ArrayList<>();
			projetos.add(p1);
			projetos.add(p2);

			f1.setProjetos(projetos);

			// gerenteDAO.cadastrar(gerente);
			// gerenteDAO.commit();

			depDAO.cadastrar(departamento);
			depDAO.commit();

		} catch (Exception e) {
			e.printStackTrace();
			fail("Não cadastrou antes do teste");
		}
	}

	@Test
	void busca() {
		try {
			Departamento busca = depDAO.pesquisar(departamento.getCodigo());
			assertNotNull(busca);
			assertNotNull(busca.getGerente());

		} catch (CodigoInexistenteException e) {
			e.printStackTrace();
			fail("Errou...");
		}
	}

	@Test
	void cadastro() {
		assertNotEquals(0, gerente.getCodigo());
		assertNotEquals(0, departamento.getCodigo());
	}

}
