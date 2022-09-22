/**
 * Laboratório de Programação 2 - Lab1
 * 
 * @author Pedro Raimundo dos Santos Neto - 120110121
 */

import java.util.Scanner;

public class Calculadora {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String operador = sc.next();
		boolean temOperador = operador.equals("+") || operador.equals("-") || operador.equals("*") || operador.equals("/");
		if (temOperador == false) {
			System.out.println("ENTRADA INVALIDA");
		} else {
			double entradaUm = sc.nextDouble();
			double entradaDois = sc.nextDouble();
			if (operador.equals("/") && entradaDois == 0) {
				System.out.println("ERRO");
			} else {
				double resultado = 0;
				if (operador.equals("+")) {
					resultado = entradaUm + entradaDois;
				} if (operador.equals("-")) {
					resultado = entradaUm - entradaDois;
				} if (operador.equals("*")) {
					resultado = entradaUm * entradaDois;
				} if (operador.equals("/")) {
					resultado = entradaUm / entradaDois;
				}
				if (resultado != 0) {
					System.out.println("RESULTADO: " + resultado);
				}
			}
		}
	}
}