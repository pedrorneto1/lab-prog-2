/**
 * Laboratório de Programação 2 - Lab1
 * 
 * @author Pedro Raimundo dos Santos Neto - 120110121
 */

import java.util.Scanner;

public class Notas {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String entrada = "";
		int contaEntradas = 0;
		int[] notas = new int[20];
		int soma = 0;
		do {
			entrada = sc.nextLine();
			String[] array = entrada.split(" ");
			if (!entrada.equals("-")) {
				notas[contaEntradas] = Integer.parseInt(array[1]);
			}
			contaEntradas += 1;
		} while (!entrada.equals("-"));
		
		int maior = notas[0];
		int menor = notas[0];
		for (int j = 0; j < contaEntradas - 1; j++) {
			if (notas[j + 1] > notas[j]) {
				maior = notas[j + 1];
			} else if (notas[j + 1] < notas[j]) {
				menor = notas[j + 1];
			}
		}
		int contaAcima = 0;
		int contaAbaixo = 0;
		for (int k = 0; k < contaEntradas; k++) {
			if (notas[k] >= 700) {
				contaAcima += 1;
			} else if (notas[k] < 700) {
				contaAbaixo += 1;
			}
			soma += notas[k];
		}
		int media = soma / contaEntradas;
		System.out.println("maior: " + maior);
		System.out.println("menor: " + menor);
		System.out.println("media: " + (int)media);
		System.out.println("acima: " + contaAcima);
		System.out.println("abaixo: " + contaAbaixo);
	}
}