/**
 * Laboratório de Programação 2 - Lab1
 * 
 * @author Pedro Raimundo dos Santos Neto - 120110121
 */

import java.util.Scanner;

public class Wally {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String entrada = "";
		while (!entrada.equals("wally")) {
			entrada = sc.nextLine();
			String ultimoNome = "";
			String[] nomes = entrada.split(" ");
			
			boolean temNome = false;
			for (int i = 0; i < nomes.length; i++) {
				if (nomes[i].length() == 5 && !entrada.equals("wally")) {
					ultimoNome = nomes[i];
					temNome = true;
				}
			}
			if (temNome == false && !entrada.equals("wally")) {
				ultimoNome = "?";
			}
			System.out.println(ultimoNome);
		}
	}
}