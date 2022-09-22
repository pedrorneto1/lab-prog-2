/**
 * Laboratório de Programação 2 - Lab1
 * 
 * @author Pedro Raimundo dos Santos Neto - 120110121
 */

import java.util.Scanner;

public class Inteiro {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inteiro = sc.nextInt();
		int dobro = 2 * inteiro;
		int triplo = 3 * inteiro;
		System.out.println("dobro: " + dobro + ", triplo: " + triplo);
	}
}