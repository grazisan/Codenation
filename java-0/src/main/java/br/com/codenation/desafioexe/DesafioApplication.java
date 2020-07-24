package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {

		List<Integer> lista = new ArrayList<Integer>();

		int primeiro = 0;
		int segundo = 1;
		int proximo= 0;

		while(primeiro < 378) {

			lista.add(primeiro);
			proximo = primeiro + segundo;
			primeiro = segundo;
			segundo = proximo;
		}
		return lista;
	}

	public static Boolean isFibonacci(Integer x) {

		return fibonacci().contains(x);

	}

}