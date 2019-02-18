package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.Produto;

public class Exercicio {

	public static void main(String[] args) {

		EntityManagerFactory f = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = f.createEntityManager();
		
		Produto produto = new Produto();
		//Realizar o CRUD para o produto
		
		//Cadastrar
		new Produto(nome, quantidade, estado, dataValidade, dataFabricacao, preco, imagem)
		em.persist(produto);
		
		//Pesquisar
		em.find(Cliente.class, 1);
		
		//Atualizar
		new Produto(codigo, nome, quantidade, estado, dataValidade, dataFabricacao, preco, imagem)
		em.merge(produto);
		
		//Remover
		em.remove(produto);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		f.close();
	}

}
