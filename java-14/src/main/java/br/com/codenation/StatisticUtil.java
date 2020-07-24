package br.com.codenation;

import java.util.Arrays;

public class StatisticUtil {

	public static int average(int[] elements) {

		int soma = 0;

		for(int i = 0; i < elements.length; i++) {

			soma+= elements[i];
		}

		return soma/elements.length;

	}

	public static int mode(int[] elements) {

		int numMaisRepet = 0;
		int repeticoes = 0;

		for(int i = 0; i<elements.length;i++) {
			int count = 0;
			for(int j = 0; j< elements.length; j++) {
				if(elements[i] == elements[j]) {
					count++;
				}
			}
			if(count > repeticoes) {
				numMaisRepet = elements[i];
				repeticoes = count;
			}
		}

		return numMaisRepet;
	}

	public static int median(int[] elements) {

		Arrays.sort(elements);

		int media = elements.length/2;
		int mediana = 0;

		if(elements.length % 2 == 1 ) {
			mediana = elements[media];
		}else {
			mediana = (elements[media] + elements[media-1])/2;

		}

		return mediana;
	}
}