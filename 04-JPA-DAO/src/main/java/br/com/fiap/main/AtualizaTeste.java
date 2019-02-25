package br.com.fiap.main;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.dao.impl.EmpresaDAOImpl;
import br.com.fiap.entity.Empresa;
import br.com.fiap.entity.Status;

public class AtualizaTeste {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");

		EntityManager em = fabrica.createEntityManager();

		EmpresaDAO dao = new EmpresaDAOImpl(em);

		// Atualizar empresa
		Empresa empresa = new Empresa(1, "FIAP SCHOOL", Calendar.getInstance(), Status.ABERTA, "23.123.123/0001-89");

		try {
			dao.atualizar(empresa);
			dao.commit();
			System.out.println("Cadastro atualizado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Erro ao atualizar");
		}

		em.close();
		fabrica.close();
	}

}
