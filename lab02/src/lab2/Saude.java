package lab2;

/**
 * Registra estado de sa�de mental e f�sica,
 * produzindo um relat�rio final.
 * 
 * @author Pedro Raimundo
 */
public class Saude {
	
	/**
	 * Sa�de mental do aluno.
	 */
	private String saudeMental;
	/**
	 * Sa�de f�sica do aluno.
	 */
	private String saudeFisica;
	/**
	 * Sa�de geral do aluno (considera sa�de mental e f�sica).
	 */
	private String saudeGeral;
	
	/**
	 * Constr�i o aspecto de sa�de do aluno, definindo
	 * a situa��o de ambas como boa.
	 */
	public Saude() {
		saudeMental = "boa";
		saudeFisica = "boa";
	}
	
	/**
	 * Define o estado de sa�de mental de acordo
	 * com o valor inserido.
	 * 
	 * @param valor Estado de sa�de mental no formato de String
	 */
	public void defineSaudeMental(String valor) {
		saudeMental = valor;
	}
	/**
	 * Define o estado de sa�de f�sica de acordo
	 * com o valor inserido.
	 * 
	 * @param valor Estado de sa�de f�sica no formato de String
	 */
	public void defineSaudeFisica(String valor) {
		saudeFisica = valor;
	}
	/**
	 * Verifica o estado de sa�de mental e f�sica,
	 * compara ambas e determina o estado de sa�de geral.
	 * 
	 * @return Estado de sa�de geral no formato de String
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