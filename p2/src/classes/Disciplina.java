package classes;

public class Disciplina {
	String nomeDisciplina;
	int exercicios = 0;
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	public void adicionaExercicios(int novoExercicio) {
		exercicios += novoExercicio;
	}
	public int totalExercicios() {
		return exercicios;
	}
	@Override
	public String toString() {
		String relatorioExercicios = nomeDisciplina + ": " + exercicios + " exercicio(s)";
		return relatorioExercicios;
	}
}