package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Estado;
import br.com.fiap.entity.Produto;

public class Exercicio {

	public static void main(String[] args) {

		EntityManagerFactory f = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = f.createEntityManager();

		Produto produto = new Produto();
		// Realizar o CRUD para o produto

		// Cadastrar
		new Produto("Produto", 2, Estado.USADO, new GregorianCalendar(1878, Calendar.NOVEMBER, 1),
				new GregorianCalendar(1975, Calendar.MARCH, 6), 6, null);
		em.persist(produto);

		// Pesquisar
		em.find(Cliente.class, 1);

		// Atualizar
		new Produto(1, "Produto", 2, Estado.USADO, new GregorianCalendar(1999, Calendar.JULY, 5),
				new GregorianCalendar(1977, Calendar.AUGUST, 2), 8, null);
		em.merge(produto);

		// Remover
		em.remove(produto);

		em.getTransaction().begin();
		em.getTransaction().commit();

		em.close();
		f.close();
	}

}
