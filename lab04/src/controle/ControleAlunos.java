package controle;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Representa��o do sistema de controle de alunos, que recebe os dados
 * dos alunos e dos grupos e os gerencia.
 * 
 * @author Pedro Raimundo
 *
 */
public class ControleAlunos {
	
	/**
	 * Mapa que armazena os alunos e suas matr�culas correspondentes.
	 */
	private HashMap<String, Aluno> alunos;
	/**
	 * Mapa que armazena os grupos e seus nomes correspondentes.
	 */
	private HashMap<String, GrupoEstudo> grupos;
	/**
	 * Lista de armazena as perguntas respondidas pelos alunos.
	 */
	private ArrayList<String> registroPerguntas;
	
	/**
	 * Constr�i o controle de alunos, criando os mapas de alunos e grupos
	 * e a lista de perguntas respondidas.
	 */
	public ControleAlunos() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.registroPerguntas = new ArrayList<>();
	}
	
	/**
	 * Verifica se um aluno j� tem cadastro
	 * 
	 * @param matricula A matr�cula do aluno.
	 * @return Valor booleano que diz se aluno j� tem cadastro.
	 */
	public boolean verificaCadastro(String matricula) {
		for (String id : this.alunos.keySet()) {
			if (matricula == id) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Cadastra o aluno no mapa.
	 * 
	 * @param matricula A matr�cula do aluno.
	 * @param nome O nome do aluno
	 * @param curso O curso do aluno.
	 */
	public void cadastraAluno(String matricula, String nome, String curso) {
		Aluno aluno = new Aluno(nome, curso);
		this.alunos.put(matricula, aluno);
	}
	
	/**
	 * Verifica se a refer�ncia de matr�cula n�o possui valor cadastrado.
	 * 
	 * @param matricula A matr�cula
	 * @return Valor booleano que diz se n�o tem cadastro para aquela matr�cula.
	 */
	public boolean verificaInvalida(String matricula) {
		Aluno aluno = this.alunos.get(matricula);
		if (aluno == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * Exibe o aluno com aquela matr�cula correspondente.
	 * 
	 * @param matricula A matr�cula.
	 * @return String formatada com detalhes do aluno.
	 */
	public String exibeAluno(String matricula) {
		Aluno aluno = this.alunos.get(matricula);
		String exibicao = matricula + aluno.formataAluno();
		return exibicao;
	}
	
	/**
	 * Acessa o mapa de alunos.
	 * 
	 * @return O mapa de alunos.
	 */
	public HashMap<String, Aluno> getAlunos(){
		return this.alunos;
	}
	
	/**
	 * Acessa o mapa de grupos.
	 * 
	 * @return O mapa de grupos.
	 */
	public HashMap<String, GrupoEstudo> getGrupos(){
		return this.grupos;
	}
	
	/**
	 * Verifica se um grupo j� tem cadastro.
	 * 
	 * @param nomeGrupo O nome do grupo.
	 * @return Valor booleano que diz se o grupo j� tem cadastro.
	 */
	public boolean verificaCadastroGrupo(String nomeGrupo) {
		for (String idGrupo : this.grupos.keySet()) {
			if (nomeGrupo == idGrupo) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Cria o grupo de estudo.
	 * 
	 * @param nomeGrupo O nome do grupo.
	 * @param restricaoCurso Curso de restri��o do grupo, se houver.
	 */
	public void criaGrupo(String nomeGrupo, String restricaoCurso) {
		GrupoEstudo grupo = new GrupoEstudo(restricaoCurso);
		this.grupos.put(nomeGrupo, grupo);
	}
	
	/**
	 * Verifica se n�o tem grupo cadastrado para o nome de grupo buscado.
	 * 
	 * @param nomeGrupo O nome do grupo.
	 * @return Valor que diz se o grupo n�o est� cadastrado.
	 */
	public boolean verificaGrupoInvalido(String nomeGrupo) {
		GrupoEstudo grupo = this.grupos.get(nomeGrupo);
		if (grupo == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * Verifica se o aluno faz parte do grupo de estudo.
	 * 
	 * @param matricula A matr�cula do aluno.
	 * @param nomeGrupo O nome do grupo.
	 * @return Valor booleano que diz se o aluno faz parte do grupo.
	 */
	public boolean verificaAlunoGrupo(String matricula, String nomeGrupo) {
		Aluno aluno = this.alunos.get(matricula);
		GrupoEstudo grupo = this.grupos.get(nomeGrupo);
		ArrayList<Aluno> alunosGrupo = grupo.getAlunosGrupo();
		for (Aluno alunoGrupo : alunosGrupo) {
			if (aluno.hashCode() == alunoGrupo.hashCode() && aluno.equals(alunoGrupo)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Verifica se um grupo � restrito a dado aluno.
	 * 
	 * @param matricula A matr�cula do aluno.
	 * @param nomeGrupo O nome do grupo.
	 * @return Valor booleano que diz se o grupo � restrito ao aluno.
	 */
	public boolean verificaGrupoRestrito(String matricula, String nomeGrupo) {
		Aluno aluno = this.alunos.get(matricula);
		GrupoEstudo grupo = this.grupos.get(nomeGrupo);
		if (aluno.getCurso() != grupo.getCursoGrupo()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Aloca aluno num grupo.
	 * 
	 * @param matricula A matr�cula do aluno.
	 * @param nomeGrupo O nome do grupo.
	 */
	public void alocaAluno(String matricula, String nomeGrupo) {
		Aluno aluno = this.alunos.get(matricula);
		this.grupos.get(nomeGrupo).getAlunosGrupo().add(aluno);
	}
	
	/**
	 * Registra aluno que respondeu a quest�o.
	 * 
	 * @param matricula A matr�cula do aluno.
	 */
	public void registraResposta(String matricula) {
		this.registroPerguntas.add(matricula);
	}
	
	/**
	 * Acessa a lista de alunos que responderam.
	 * 
	 * @return A lista de alunos que responderam.
	 */
	public ArrayList<String> getRegistroPerguntas() {
		return this.registroPerguntas;
	}
	
}
