package controle;

/**
 * Representação de um aluno que armazena seus dados e compõe a classe
 * de controle de alunos.
 * 
 * @author Pedro Raimundo
 *
 */
public class Aluno {
	
	/**
	 * Nome do aluno.
	 */
	private String nome;
	/**
	 * Curso do aluno.
	 */
	private String curso;
	
	/**
	 * Constrói o aluno, adicionando seus dados da entrada.
	 * 
	 * @param nome Nome do aluno.
	 * @param curso Curso do aluno.
	 */
	public Aluno(String nome, String curso) {
		this.nome = nome;
		this.curso = curso;
	}
	
	/**
	 * Acessa o nome do aluno.
	 * 
	 * @return O nome do aluno.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Acessa o curso do aluno.
	 * 
	 * @return O curso do aluno.
	 */
	public String getCurso() {
		return this.curso;
	}
	
	/**
	 * Formata os dados de um aluno para impressão na interface.
	 * 
	 * @return A String formatada.
	 */
	public String formataAluno() {
		String detalhes = " - " + this.nome + " - " + this.curso;
		return detalhes;
	}
	
	@Override
	public int hashCode() {
		return this.nome.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o.getClass() != this.getClass()) {
			return false;
		}
		Aluno aluno = (Aluno) o;
		return this.nome.equals(aluno.nome) && this.curso.equals(aluno.curso);
	}
	
	
}
