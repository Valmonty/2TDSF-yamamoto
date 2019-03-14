package br.com.fiap.teste;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.ProfessorDAO;
import br.com.fiap.dao.impl.ProfessorDAOImpl;
import br.com.fiap.entity.Professor;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

class ProfessorDAOTest {

	private static ProfessorDAO dao;

	private Professor prof;

	// método que será executado antes de cada teste
	@BeforeEach
	public void antesTeste() {
		// cadastrar
		prof = new Professor("CadastroProf", null, "32132132121");

		try {
			dao.cadastrar(prof);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
	}

	// Método que será executado antes de todos os testes
	@BeforeAll
	public static void inicializar() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("teste");
		EntityManager em = fabrica.createEntityManager();

		dao = new ProfessorDAOImpl(em);
	}

	// Teste de cadastro
	@Test
	@DisplayName("Teste de cadastro de professor com sucesso")
	void cadastroTest() {
		// Arrange - instanciar os objetos
		prof = new Professor("Parducci", null, "12312312312");

		// Act - realizar a ação (chamar o método para teste)
		dao.cadastrar(prof);
		try {
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}

		// Assert - validar o resultado
		// Valida se foi gerado um código pela sequence
		assertNotEquals(0, prof.getCodigo());
	}

	// Teste de atualizar
	@Test
	@DisplayName("Teste de atualização de professor com sucesso")
	void atualizarTest() {
		// Act
		Professor prof2 = new Professor(prof.getCodigo(), "AtualizaProf", null, "123123");
		dao.atualizar(prof2);

		// Atualizar o professor
		try {
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
		// Assert
		// Pesquisa e valida se o valor foi alterado no banco
		try {
			Professor prof3 = dao.pesquisar(prof.getCodigo());
			assertEquals("AtualizaProf", prof3.getNome());
			assertEquals(prof2.getCpf(), prof3.getCpf());
		} catch (CodigoInexistenteException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
	}

	@Test
	@DisplayName("Teste de pesquisa de professor com sucesso")
	void pesquisaTest() {
		try {
			Professor busca = dao.pesquisar(prof.getCodigo());

			// encontrou alguem
			assertNotNull(busca);
			// encontrou o prof correto
			assertEquals(busca.getNome(), prof.getNome());
		} catch (CodigoInexistenteException e) {
			e.printStackTrace();
			fail("Erro na pesquisa");
		}
	}

	@Test
	@DisplayName("Teste de remoção de professor com sucesso")
	void removerTest() {
		try {
			dao.excluir(prof.getCodigo());
			dao.commit();
		} catch (CodigoInexistenteException | CommitException e) {
			e.printStackTrace();
			fail("Erro no delete");
		}

		assertThrows(CodigoInexistenteException.class, () -> dao.pesquisar(prof.getCodigo()));

		// try {
		// Professor pesquisa = dao.pesquisar(prof.getCodigo());
		// fail("Erro no teste");
		// } catch (CodigoInexistenteException e) {
		// e.printStackTrace();
		// fail("Erro no teste");
		// }
	}
}
