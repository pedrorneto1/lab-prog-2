package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author nazarenoandrade
 * @author Pedro Raimundo
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}
	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.print(
					"(C)adastrar Contato\n" + 
					"(L)istar Contatos\n" + 
					"(E)xibir Contato\n" + 
					"(F)avoritos\n" + 
					"(A)dicionar Favorito\n" + 
					"(S)air\n" + 
					"\n" + 
					"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			favoritos(agenda);
			break;
		case "A":
			adicionaFavorito(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("OPÇÃO INVÁLIDA!\n");
		}
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.print("\n");
		Contato[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(contatos[i].formataContato(i + 1, contatos[i].getNomeCompleto()));
			}
		}
		System.out.print("\n");
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("Contato> ");
		String dadosContato = "";
		int posicao = scanner.nextInt() - 1;
		if (agenda.getContato(posicao) != null) {
			dadosContato = agenda.getContato(posicao).getDados(posicao, agenda);
		}
		System.out.println(dadosContato + "\n");
	}

	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("Posição: ");
		int posicao = scanner.nextInt() - 1;
		if (posicao < 0 || posicao > 99) {
			System.out.println("POSIÇÃO INVÁLIDA\n");
			return;
		}
		scanner.nextLine();
		String nomeCompleto = "";
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		System.out.print("Sobrenome: ");
		String sobrenome = scanner.nextLine();
		if (sobrenome.isEmpty()) {
			nomeCompleto = nome;
		} else {
			nomeCompleto = nome + " " + sobrenome;
		}
		if (agenda.temCadastro(nomeCompleto)) {
			System.out.println("CONTATO JA CADASTRADO\n");
			return;
		}
		System.out.print("Prioritario: ");
		String prioritario = scanner.nextLine();
		System.out.print("Whatsapp: ");
		String whatsapp = scanner.nextLine();
		System.out.print("Adicional: ");
		String adicional = scanner.nextLine();
		agenda.cadastraContato(posicao, nome, sobrenome, prioritario, whatsapp, adicional);
		System.out.println("CADASTRO REALIZADO\n");
	}
	
	/**
	 * Exibe uma lista dos favoritos formatada.
	 * 
	 * @param agenda A agenda.
	 */
	private static void favoritos(Agenda agenda) {
		System.out.print("\n");
		Contato[] favoritos = agenda.getFavoritos();
		for (int i = 0; i < favoritos.length; i++) {
			if (favoritos[i] != null) {
				System.out.println(favoritos[i].formataContato(i + 1, favoritos[i].getNomeCompleto()));
			}
		}
		System.out.print("\n");
	}
	
	/**
	 * Adiciona contatos à lista de favoritos.
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para receber as posições do contato na agenda e a ser adicionado na lista de favoritos.
	 */
	private static void adicionaFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("Contato> ");
		int posicao = scanner.nextInt() - 1;
		System.out.print("Posição> ");
		int posicaoFavorito = scanner.nextInt() - 1;
		if (!agenda.verificaFavorito(posicao)) {
			agenda.cadastraFavorito(posicao, posicaoFavorito);
			System.out.println("CONTATO FAVORITADO NA POSIÇÃO " + (posicaoFavorito + 1) + "!\n");
		}
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}