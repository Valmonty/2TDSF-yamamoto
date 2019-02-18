package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;

public class PesquisaTeste {

	public static void main(String[] args) {

		EntityManagerFactory f = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");

		EntityManager em = f.createEntityManager();

		// Pesquisar um cliente com código 1
		Cliente cliente = em.find(Cliente.class, 1);

		System.out.println(cliente.getNome());

		// Modificar o nome no banco de dados
		cliente.setNome("Francisco");

		em.getTransaction().begin();
		em.getTransaction().commit();

		System.out.println(cliente.getNome());

		em.close();
		f.close();
	}

}
