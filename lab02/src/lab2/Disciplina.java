package lab2;

import java.util.Arrays;

/**
 * Cadastra horas de estudo em uma disciplina, suas notas,
 * se foi aprovado e produz um relatório final.
 * 
 * @author Pedro Raimundo
 */
public class Disciplina {
	
	/**
	 * Nome da disciplina.
	 */
	private String nomeDisciplina;
	/**
	 * Horas dedicadas ao estudo da disciplina.
	 */
	private int horas = 0;
	/**
	 * Array que armazena as notas.
	 */
	private double[] notas = new double[4];
	/**
	 * Média das notas.
	 */
	private double mediaNotas;
	/**
	 * Booleano que afirma se aluno foi aprovado ou não.
	 */
	private boolean aprovado;
	
	/**
	 * Constrói a disciplina e registra seu nome.
	 * 
	 * @param nomeDisciplina Nome da disciplina
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	/**
	 * Registra as horas estudadas para a disciplina.
	 * 
	 * @param horas Horas de estudo na disciplina
	 */
	public void cadastraHoras(int horas) {
		this.horas += horas;
	}
	/**
	 * Cadastra as notas da disciplina no Array que as armazena.
	 * 
	 * @param nota Identificação da nota
	 * @param valorNota Valor da nota
	 */
	public void cadastraNota(int nota, double valorNota) {
		notas[nota - 1] = valorNota;
	}
	/**
	 * Calcula a média das notas e verifica se o resultado
	 * é suficiente para ser aprovado por média.
	 * 
	 * @return Booleano que informa se foi aprovado
	 */
	public boolean aprovado() {
		double somaNotas = 0;
		for (int i = 0; i < notas.length; i++) {
			somaNotas += notas[i];
		}
		mediaNotas = somaNotas / notas.length;
		if (mediaNotas >= 7.0) {
			aprovado = true;
		} else {
			aprovado = false;
		}
		return aprovado;
	}
	@Override
	/**
	 * Cria relatório das notas na disciplina,
	 * no formato de String.
	 * 
	 * @return Relatório da disciplina e suas respectivas notas
	 */
	public String toString() {
		String relatorioDisciplina = nomeDisciplina + " " + horas + " " + mediaNotas + " " + Arrays.toString(notas);
		return relatorioDisciplina;
	}
}