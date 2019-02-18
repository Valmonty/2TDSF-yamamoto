package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Genero;

public class AtualizaTeste {

	public static void main(String[] args) {

		EntityManagerFactory f = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = f.createEntityManager();

		// Atualizar um cliente
		// Instanciar um cliente com um Id que existe no banco
		Cliente cliente = new Cliente(1, "Francisco", new GregorianCalendar(1970, Calendar.AUGUST, 2), "456.545.123-78",
				Genero.MASCULINO, null, false);
		
		em.merge(cliente);
		
		em.getTransaction().begin();
		em.getTransaction().commit();

		em.close();
		f.close();
	}

}
