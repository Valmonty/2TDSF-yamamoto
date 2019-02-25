package br.com.fiap.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.bean.Carro;
import br.com.fiap.bean.Transmissao;

public class Teste {

	public static void main(String args[]) {
		
		Carro carro = new Carro();
		carro.setCambio(Transmissao.SEMI_AUTOMATICO);
		
		Calendar data = Calendar.getInstance(); //DATA ATUAL
											   //ano, mes, dia
		Calendar data2 = new GregorianCalendar(2000, Calendar.JANUARY ,19);
		
		carro.setDataLancamento(data);
		
		//Formatar a data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(sdf.format(data.getTime()));
		System.out.println(sdf.format(data2.getTime()));
		
		
		//new Date("");
	}
	
}
