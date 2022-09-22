package bordado;

import java.util.Arrays;
import java.util.Scanner;

public class MainBordado {

	public static void main(String[] args) {
		ListaBordados listaBordados = new ListaBordados();
		
		Scanner scanner = new Scanner(System.in);
		String acao = "";
		System.out.print("Bem-vindo ao BEP! (sistema de bordados)\n\nVoce pode cadastrar 10 bordados. O que deseja fazer?\n");
		while(true) {
			acao = menu(scanner);
			comando(acao, listaBordados, scanner);
		}
	}
	
	private static String menu(Scanner scanner) {
		System.out.print("\n"
				+ "A - Cadastrar bordado\n"
				+ "B - Atualizar bordado\n"
				+ "C - Imprimir bordado\n"
				+ "D - Listar bordados\n"
				+ "E - Agrupar bordados\n"
				+ "F - Atualizar agrupamentos\n"
				+ "\n"
				+ "G - Sair da aplicação\n" 
				+ "\n"
				+ "Acao? ");
		return scanner.next().toUpperCase();
	}
	
	private static void comando(String acao, ListaBordados listaBordados, Scanner scanner) {
		switch (acao) {
		case "A":
			cadastraBordado(listaBordados, scanner);
			break;
		case "B":
			atualizaBordado(listaBordados, scanner);
			break;
		case "C":
			imprimeBordado(listaBordados, scanner);
			break;
		case "D":
			listaBordados(listaBordados);
			break;
		case "E":
			agrupaBordados(listaBordados, scanner);
			break;
		case "F":
			atualizaAgrupamentos(listaBordados, scanner);
			break;
		case "G":
			sai();
			break;
		default:
			System.out.println("\nERRO!");
		}
	}
	
	private static void cadastraBordado(ListaBordados listaBordados, Scanner scanner) {
		System.out.print("\nNumero do bordado? [0-9] ");
		int posicaoBordado = scanner.nextInt();
		if (posicaoBordado < 0 || posicaoBordado > 9) {
			System.out.println("\nERRO!");
			return;
		}
		System.out.print("\nNumero de linhas? [2-100] ");
		int linhasBordado = scanner.nextInt();
		if (linhasBordado < 2 || linhasBordado > 100) {
			System.out.println("\nERRO!");
			return;
		}
		System.out.print("\nNumero de colunas [2-100] ");
		int colunasBordado = scanner.nextInt();
		if (colunasBordado < 2 || colunasBordado > 100) {
			System.out.println("\nERRO!");
			return;
		}
		listaBordados.cadastraBordado(posicaoBordado, linhasBordado, colunasBordado);
		int posicoesRestantes = 10;
		for (int i = 0; i < listaBordados.getBordados().length; i++) {
			if (listaBordados.getBordados()[i] != null) {
				posicoesRestantes -= 1;
			}
		}
		System.out.println("\nVoce pode cadastrar " + posicoesRestantes + " bordados. O que deseja fazer?");
	}
	
	private static void atualizaBordado(ListaBordados listaBordados, Scanner scanner) {
		Bordado[] listaBordadosClone = listaBordados.getBordados();
		System.out.print("\nNumero do bordado? [0-9] ");
		int posicaoBordado = scanner.nextInt();
		if (posicaoBordado < 0 || posicaoBordado > 9) {
			System.out.println("\nERRO!");
			return;
		}
		scanner.nextLine();
		System.out.print("\nNo a ser colocado no bordado? [/ \\ | - x, vazio para remover] ");
		String no = scanner.nextLine();
		if (!listaBordados.verificaNoValido(no)) {
			System.out.println("\nERRO!");
			return;
		}
		int linhas = listaBordadosClone[posicaoBordado].getLinhasBordado();
		int colunas = listaBordadosClone[posicaoBordado].getColunasBordado();
		System.out.print("\nLinha a ser inserida? [1-" + linhas + "] ");
		int linhaBordado = scanner.nextInt() - 1;
		if (linhaBordado < 0 || linhaBordado > linhas) {
			System.out.println("\nERRO!");
			return;
		}
		System.out.print("\nColuna a ser inserida? [1-" + colunas + "] ");
		int colunaBordado = scanner.nextInt() - 1;
		if (colunaBordado < 0 || colunaBordado > colunas) {
			System.out.println("\nERRO!");
			return;
		}
		listaBordados.atualizaBordado(posicaoBordado, no, linhaBordado, colunaBordado);
	}
	
	private static void imprimeBordado(ListaBordados listaBordados, Scanner scanner) {
		System.out.print("Bordado a ser impresso? ");
		int posicaoBordado = scanner.nextInt();
		if (posicaoBordado < 0 || posicaoBordado > 9 || listaBordados.getBordados()[posicaoBordado] == null) {
			System.out.println("\nERRO!");
			return;
		}
		int colunas = listaBordados.getBordados()[posicaoBordado].getColunasBordado();
		char linha = '-';
		char[] arrayBorda = new char[colunas];
		Arrays.fill(arrayBorda, linha);
		String borda = new String(arrayBorda);
		System.out.print("\n|" + borda + "|");
		for (int i = 0; i < listaBordados.getBordados()[posicaoBordado].getLinhasBordado(); i++) {
			System.out.print("\n|");
			for (int j = 0; j < listaBordados.getBordados()[posicaoBordado].getColunasBordado(); j++) {
				System.out.print(listaBordados.getBordados()[posicaoBordado].getNoBordado(i, j));
			}
			System.out.print("|");
		}
		System.out.print("\n|" + borda + "|");
	}
	
	private static void listaBordados(ListaBordados listaBordados) {
		for (int i = 0; i < listaBordados.getBordados().length; i++) {
			if (listaBordados.getBordados()[i] != null) {
				int linhas = listaBordados.getBordados()[i].getLinhasBordado();
				int colunas = listaBordados.getBordados()[i].getColunasBordado();
				int nosPontos = listaBordados.getBordados()[i].getNosPontos();
				System.out.println(i + " - " + linhas + " x " + colunas + " - " + nosPontos + " pontos");
			}
		}
	}
	
	private static void agrupaBordados(ListaBordados listaBordados, Scanner scanner) {
		System.out.print("Numero do agrupamento? [1-10] ");
		int posicaoAgrupamento = scanner.nextInt() - 1;
		System.out.print("Nome do grupo? ");
		String nome = scanner.next();
		System.out.print("Numero de bordados? [1-10]  ");
		int numBordados = scanner.nextInt();
		int[] posicoesBordados = new int[numBordados];
		int contaBordados = 0;
		while (contaBordados < numBordados) {
			System.out.print((contaBordados + 1) + "o Bordado a ser inserido? ");
			int posicaoBordado = scanner.nextInt() - 1;
			posicoesBordados[contaBordados] = posicaoBordado;
			contaBordados += 1;
		}
		listaBordados.agrupaBordados(posicaoAgrupamento, nome, numBordados, contaBordados, posicoesBordados);
	}
	
	private static void atualizaAgrupamentos(ListaBordados listaBordados, Scanner scanner) {
		System.out.print("Numero ou nome do agrupamento? ");
		String referenciaAgrupamento = scanner.next();
		int posicaoAgrupamento = listaBordados.menuAgrupamento(referenciaAgrupamento);
		System.out.print("No a ser colocado no bordado? [/ \\ | - x, vazio para remover] ");
		String no = scanner.next();
		if (!listaBordados.verificaNoValido(no)) {
			System.out.println("\nERRO!");
			return;
		}
		int linhas = listaBordados.getLinhasMaior(posicaoAgrupamento);
		System.out.print("\nLinha a ser inserida? [1-" + linhas + "] ");
		int linhaBordado = scanner.nextInt() - 1;
		if (linhaBordado < 0 || linhaBordado > linhas - 1) {
			System.out.println("\nERRO!");
			return;
		}
		int colunas = listaBordados.getColunasMaior(posicaoAgrupamento);
		System.out.print("Coluna a ser inserida? [1-" + colunas + "] ");
		int colunaBordado = scanner.nextInt() - 1;
		if (colunaBordado < 0 || colunaBordado > colunas - 1) {
			System.out.println("\nERRO!");
			return;
		}
		listaBordados.atualizaAgrupamentos(posicaoAgrupamento, no, linhas, linhaBordado, colunas, colunaBordado);
	}
	
	private static void sai() {
		System.exit(0);
	}
	
	
}
