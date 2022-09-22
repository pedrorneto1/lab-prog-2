/**
 * Laboratório de Programação 2 - Lab1
 * 
 * @author Pedro Raimundo dos Santos Neto - 120110121
 */

import java.util.Scanner;

public class Media {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double notaUm = sc.nextFloat();
		double notaDois = sc.nextFloat();
		double media = (notaUm + notaDois) / 2;
		if (media >= 7.0) {
			System.out.println("pass: True!");
		} else {
			System.out.println("pass: False!");
		}
	}
}