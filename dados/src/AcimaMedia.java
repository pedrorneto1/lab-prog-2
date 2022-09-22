/**
 * Laboratório de Programação 2 - Lab1
 * 
 * @author Pedro Raimundo dos Santos Neto - 120110121
 */

import java.util.Scanner;

public class AcimaMedia {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String entrada = sc.nextLine();
		String[] array = entrada.split(" ");
		int[] inteiros = new int[array.length];
		
		double soma = 0;
		for (int i = 0; i < array.length; i++) {
			inteiros[i] = Integer.parseInt(array[i]);
			soma += inteiros[i];
		}
		
		double media = soma / inteiros.length;
		String saida = "";
		for (int j = 0; j < inteiros.length; j++) {
			if ((inteiros[j] > media) && (saida.length() == 0)) {
				saida += inteiros[j];
			} else if ((inteiros[j] > media) && (saida.length() > 0)) {
				saida += " " + inteiros[j];
			}
		}
		System.out.println(saida);
	}
}