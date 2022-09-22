package lab2;

/**
 * Registra estado de saúde mental e física,
 * produzindo um relatório final.
 * 
 * @author Pedro Raimundo
 */
public class Saude {
	
	/**
	 * Saúde mental do aluno.
	 */
	private String saudeMental;
	/**
	 * Saúde física do aluno.
	 */
	private String saudeFisica;
	/**
	 * Saúde geral do aluno (considera saúde mental e física).
	 */
	private String saudeGeral;
	
	/**
	 * Constrói o aspecto de saúde do aluno, definindo
	 * a situação de ambas como boa.
	 */
	public Saude() {
		saudeMental = "boa";
		saudeFisica = "boa";
	}
	
	/**
	 * Define o estado de saúde mental de acordo
	 * com o valor inserido.
	 * 
	 * @param valor Estado de saúde mental no formato de String
	 */
	public void defineSaudeMental(String valor) {
		saudeMental = valor;
	}
	/**
	 * Define o estado de saúde física de acordo
	 * com o valor inserido.
	 * 
	 * @param valor Estado de saúde física no formato de String
	 */
	public void defineSaudeFisica(String valor) {
		saudeFisica = valor;
	}
	/**
	 * Verifica o estado de saúde mental e física,
	 * compara ambas e determina o estado de saúde geral.
	 * 
	 * @return Estado de saúde geral no formato de String
	 */
	public String getStatusGeral() {
		if (saudeMental.equals("boa") && saudeFisica.equals("boa")) {
			saudeGeral = "boa";
		} else if (saudeMental.equals("fraca") && saudeFisica.equals("fraca")) {
			saudeGeral = "fraca";
		} else {
			saudeGeral = "ok";
		}
		return saudeGeral;
	}
}