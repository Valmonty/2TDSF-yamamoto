package br.com.fiap.teste;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Calendar;

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

			// gerenteDAO.cadastrar(gerente);
			// gerenteDAO.commit();

			depDAO.cadastrar(departamento);
			depDAO.commit();

		} catch (Exception e) {
			e.printStackTrace();
			fail("Não cadastrou antes dos teste");
		}
	}

	@Test
	void cadastro() {
		assertNotEquals(0, gerente.getCodigo());
		assertNotEquals(0, departamento.getCodigo());
	}

	@Test
	void busca() {
		try {
			Departamento busca = depDAO.pesquisar(departamento.getCodigo());
			assertNotNull(busca);
			assertNotNull(busca.getGerente());
		} catch (CodigoInexistenteException e) {
			e.printStackTrace();
		}
	}

}
