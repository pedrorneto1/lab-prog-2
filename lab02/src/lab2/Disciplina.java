package lab2;

import java.util.Arrays;

/**
 * Cadastra horas de estudo em uma disciplina, suas notas,
 * se foi aprovado e produz um relat�rio final.
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
	 * M�dia das notas.
	 */
	private double mediaNotas;
	/**
	 * Booleano que afirma se aluno foi aprovado ou n�o.
	 */
	private boolean aprovado;
	
	/**
	 * Constr�i a disciplina e registra seu nome.
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
	 * @param nota Identifica��o da nota
	 * @param valorNota Valor da nota
	 */
	public void cadastraNota(int nota, double valorNota) {
		notas[nota - 1] = valorNota;
	}
	/**
	 * Calcula a m�dia das notas e verifica se o resultado
	 * � suficiente para ser aprovado por m�dia.
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
	 * Cria relat�rio das notas na disciplina,
	 * no formato de String.
	 * 
	 * @return Relat�rio da disciplina e suas respectivas notas
	 */
	public String toString() {
		String relatorioDisciplina = nomeDisciplina + " " + horas + " " + mediaNotas + " " + Arrays.toString(notas);
		return relatorioDisciplina;
	}
}