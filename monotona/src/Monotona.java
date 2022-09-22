/**
 * Laboratório de Programação 2 - Lab1
 * 
 * @author Pedro Raimundo dos Santos Neto - 120110121
 */

import java.util.Scanner;

public class Monotona {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int entradaUm = sc.nextInt();
		int entradaDois = sc.nextInt();
		int entradaTres = sc.nextInt();
		int entradaQuatro = sc.nextInt();
		if (entradaUm < entradaDois && entradaDois < entradaTres && entradaTres < entradaQuatro) {
			System.out.println("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
		} else if (entradaUm > entradaDois && entradaDois > entradaTres && entradaTres > entradaQuatro){
			System.out.println("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
		} else {
			System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
		}
	}
}