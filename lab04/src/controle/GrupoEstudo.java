package controle;

import java.util.ArrayList;

/**
 * Representação de um grupo de estudo que salva suas informações e compõe
 * a classe de controle de alunos.
 * 
 * @author Pedro Raimundo
 *
 */
public class GrupoEstudo {
	
	/**
	 * Restrição de curso caso exista.
	 */
	private String cursoRestrito;
	
	/**
	 * Lista dos alunos que pertencem ao grupo.
	 */
	private ArrayList<Aluno> alunosGrupo;
	
	/**
	 * Constrói o grupo de estudo.
	 * 
	 * @param cursoRestrito Restrição de curso caso exista.
	 */
	public GrupoEstudo(String cursoRestrito) {
		this.cursoRestrito = cursoRestrito;
		this.alunosGrupo = new ArrayList<>();
	}

	/**
	 * Acessa a lista de alunos do grupo.
	 * 
	 * @return A lista de alunos.
	 */
	public ArrayList<Aluno> getAlunosGrupo() {
		return this.alunosGrupo;
	}
	
	/**
	 * Acessa a restrição de curso caso exista.
	 * 
	 * @return O curso de restrição.
	 */
	public String getCursoGrupo() {
		return this.cursoRestrito;
	}
	
}
