package br.com.fiap.teste;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.ProfessorDAO;
import br.com.fiap.dao.impl.ProfessorDAOImpl;
import br.com.fiap.entity.Professor;
import br.com.fiap.exception.CommitException;

class ProfessorDAOTest {

	private static ProfessorDAO dao;

	// Método que será executado antes de todos os testes
	@BeforeAll
	public static void inicializar() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("teste");
		EntityManager em = fabrica.createEntityManager();

		dao = new ProfessorDAOImpl(em);
	}

	// Teste de cadastro
	@Test
	void cadastroTest() {
		// Arrange - instanciar os objetos
		Professor prof = new Professor("Parducci", null, "12312312312");

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
	void atualizarTest() {
		// Arrange
		Professor prof = new Professor("NovoProfessor", null, "32132132121");

		// Act
		// Cadastrar um professor
		// Atualizar o professor
		dao.atualizar(prof);
		try {
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
		// Assert
		// Pesquisa e valida se o valor foi alterado no banco
		assertNotEquals(1, prof.getCodigo());
	}
}
