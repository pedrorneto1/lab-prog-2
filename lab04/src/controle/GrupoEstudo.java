package controle;

import java.util.ArrayList;

/**
 * Representa��o de um grupo de estudo que salva suas informa��es e comp�e
 * a classe de controle de alunos.
 * 
 * @author Pedro Raimundo
 *
 */
public class GrupoEstudo {
	
	/**
	 * Restri��o de curso caso exista.
	 */
	private String cursoRestrito;
	
	/**
	 * Lista dos alunos que pertencem ao grupo.
	 */
	private ArrayList<Aluno> alunosGrupo;
	
	/**
	 * Constr�i o grupo de estudo.
	 * 
	 * @param cursoRestrito Restri��o de curso caso exista.
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
	 * Acessa a restri��o de curso caso exista.
	 * 
	 * @return O curso de restri��o.
	 */
	public String getCursoGrupo() {
		return this.cursoRestrito;
	}
	
}
