package controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Interface com menus texto que faz o controle dos alunos de Programa��o II.
 * 
 * @author Pedro Raimundo
 *
 */
public class MainControle {

	public static void main(String[] args) {
		
		ControleAlunos controle = new ControleAlunos();
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, controle, scanner);
		}

	}
	
	/**
	 * Exibe o menu e captura a escolha da entrada.
	 * 
	 * @param scanner Para captura da op��o de entrada.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.print(
				"\n"
				+ "(C)adastrar Aluno\n"
				+ "(E)xibir Aluno\n"
				+ "(N)ovo Grupo\n"
				+ "(A)locar Aluno no Grupo e Verificar pertin�ncia a Grupos\n"
				+ "(R)egistrar Aluno que Respondeu\n"
				+ "(I)mprimir Alunos que Responderam\n"
				+ "(O)xe, e a contagem dos grupos com restri��o de curso?\n"
				+ "(S)im, quero fechar o programa!\n"
				+ "\n"
				+ "Op��o> ");
		return scanner.next().toUpperCase();
	}
	
	/**
	 * Interpreta a op��o escolhida e designa a a��o do sistema.
	 * 
	 * @param opcao Op��o escolhida.
	 * @param controle O sistema de controle dos alunos. 
	 * @param scanner Objeto scanner caso o comando necessite de novas entradas.
	 */
	private static void comando(String opcao, ControleAlunos controle, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraAluno(controle, scanner);
			break;
		case "E":
			exibeAluno(controle, scanner);
		break;
		case "N":
			criaGrupo(controle, scanner);
			break;
		case "A":
			String novaEscolha = scanner.next().toUpperCase();
			switch (novaEscolha) {
			case "A":
				alocaAluno(controle, scanner);
				break;
			case "P":
				verificaPertinencia(controle, scanner);
				break;
			}
		case "R":
			registraResposta(controle, scanner);
			break;
		case "I":
			imprimeRespostas(controle);
			break;
		case "O":
			verificaGruposRestritos(controle, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			throw new IllegalArgumentException("ENTRADA INV�LIDA");
		}
	}
	
	/**
	 * Cadastra o aluno no sistema.
	 * 
	 * @param controle O controle dos alunos.
	 * @param scanner Scanner para capturar dados do aluno.
	 */
	private static void cadastraAluno(ControleAlunos controle, Scanner scanner) {
		System.out.print("Matr�cula: ");
		String matricula = scanner.next();
		System.out.print("Nome: ");
		String nome = scanner.next();
		System.out.print("Curso: ");
		String curso = scanner.next();
		if (controle.verificaCadastro(matricula)) {
			System.out.println("MATR�CULA J� CADASTRADA!");
			return;
		}
		controle.cadastraAluno(matricula, nome, curso);
		System.out.println("CADASTRO REALIZADO!");
	}
	
	/**
	 * Exibe os detalhes de um aluno escolhido.
	 * 
	 * @param controle O controle.
	 * @param scanner Scanner para capturar a matr�cula do aluno.
	 */
	private static void exibeAluno(ControleAlunos controle, Scanner scanner) {
		System.out.print("Matr�cula: ");
		String matricula = scanner.next();
		if (controle.verificaInvalida(matricula)) {
			System.out.println("Aluno n�o cadastrado.");
			return;
		}
		System.out.println(controle.exibeAluno(matricula));
	}
	
	/**
	 * Cria um grupo de estudo de alunos.
	 * 
	 * @param controle O controle.
	 * @param scanner Scanner para capturar dados do grupo.
	 */
	private static void criaGrupo(ControleAlunos controle, Scanner scanner) {
		System.out.print("Grupo: ");
		String nomeGrupo = scanner.next().toUpperCase();
		if (controle.verificaCadastroGrupo(nomeGrupo)) {
			System.out.println("GRUPO J� CADASTRADO!");
			return;
		}
		System.out.print("Restri��o? ");
		String restricaoCurso = scanner.next();
		controle.criaGrupo(nomeGrupo, restricaoCurso);
		System.out.println("CADASTRO REALIZADO!");
	}
	
	/**
	 * Aloca aluno cadastrado no controle num grupo.
	 * 
	 * @param controle O controle.
	 * @param scanner Scanner para capturar dados do aluno e do grupo.
	 */
	private static void alocaAluno(ControleAlunos controle, Scanner scanner) {
		System.out.print("Matricula: ");
		String matricula = scanner.next();
		if (controle.verificaInvalida(matricula)) {
			System.out.print("Aluno n�o cadastrado.");
			return;
		}
		System.out.print("Grupo: ");
		String nomeGrupo = scanner.next().toUpperCase();
		if (controle.verificaGrupoInvalido(nomeGrupo)) {
			System.out.print("Grupo n�o cadastrado.");
			return;
		}
		if (controle.verificaAlunoGrupo(matricula, nomeGrupo)) {
			System.out.print("ALUNO ALOCADO");
			return;
		}
		if (controle.verificaGrupoRestrito(matricula, nomeGrupo)) {
			System.out.print("GRUPO COM RESTRI��O DE CURSO");
		}
		controle.alocaAluno(matricula, nomeGrupo);
		System.out.println("ALUNO ALOCADO");
	}
	
	/**
	 * Verifica a pertin�ncia de um aluno a um grupo.
	 * 
	 * @param controle O controle.
	 * @param scanner Scanner para receber os dados para an�lise.
	 */
	private static void verificaPertinencia(ControleAlunos controle, Scanner scanner) {
		System.out.print("Grupo: ");
		String nomeGrupo = scanner.next().toUpperCase();
		if (controle.verificaGrupoInvalido(nomeGrupo)) {
			System.out.print("GRUPO N�O CADASTRADO.");
			return;
		}
		System.out.print("Aluno: ");
		String matricula = scanner.next();
		if (controle.verificaAlunoGrupo(matricula, nomeGrupo)) {
			System.out.print("ALUNO PERTENCE AO GRUPO");
		} else {
			System.out.print("ALUNO N�O PERTENCE AO GRUPO");
		}
		
		
	}
	
	/**
	 * Registra aluno que respondeu quest�o no quadro.
	 * 
	 * @param controle O controle.
	 * @param scanner Scanner para capturar qual aluno.
	 */
	private static void registraResposta(ControleAlunos controle, Scanner scanner) {
		System.out.print("Matricula: ");
		String matricula = scanner.next();
		if (controle.verificaInvalida(matricula)) {
			System.out.print("Aluno n�o cadastrado.");
			return;
		}
		controle.registraResposta(matricula);
		System.out.println("ALUNO REGISTRADO!");
	}
	
	/**
	 * Imprime detalhes dos alunos que responderam a quest�es.
	 * 
	 * @param controle O controle.
	 */
	private static void imprimeRespostas(ControleAlunos controle) {
		System.out.print("Alunos:\n");
		ArrayList<String> registroPerguntas = controle.getRegistroPerguntas();
		for (int i = 0; i < registroPerguntas.size(); i++) {
			String id = registroPerguntas.get(i);
			Aluno aluno = controle.getAlunos().get(id);
			System.out.println(i + ". " + id + aluno.formataAluno());
		}
	}
	
	/**
	 * Verifica a quantidade de grupos de estudo com restri��o de curso.
	 * 
	 * @param controle O controle.
	 * @param scanner Scanner para capturar o curso a procurar.
	 */
	private static void verificaGruposRestritos(ControleAlunos controle, Scanner scanner) {
		System.out.print("Curso: ");
		String curso = scanner.next();
		HashMap<String, GrupoEstudo> grupos = controle.getGrupos();
		int contaGruposRestritos = 0;
		for (GrupoEstudo grupo : grupos.values()) {
			if (grupo.getCursoGrupo() == curso) {
				contaGruposRestritos += 1;
			}
		}
		System.out.println(curso + " " + contaGruposRestritos);
	}
	
	/**
	 * Encerra a aplica��o.
	 */
	private static void sai() {
		System.exit(0);
	}
}