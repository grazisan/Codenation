package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {

		if (salarioBase < 1039) {
			return 0;
		}else {
			double salarioLiquido = this.calcularIr(this.calcularInss(salarioBase));
			return Math.round(salarioLiquido);
		}
	}


	private double calcularInss(double salarioBase) {

		double percInss = 0;

		if(salarioBase <= 1500) {
			percInss = 0.08;
		}else if(salarioBase > 1500 && salarioBase<= 4000) {
			percInss = 0.09;
		}else if (salarioBase > 4000) {
			percInss = 0.11;
		}
		double salInss = salarioBase - (salarioBase * percInss);
		return salInss;
	}

	private double calcularIr(double salInss) {

		double percIr = 0;

		if(salInss <= 3000) {
			percIr = 0;
		}else if(salInss > 3000 && salInss <= 6000) {
			percIr = 0.075;
		}else if(salInss > 6000) {
			percIr = 0.15;
		}

		double ir = salInss - (salInss * percIr);

		return ir;
	}



}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/