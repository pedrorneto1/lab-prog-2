package lab2;

/**
 * Registra o tempo online dedicado a cada disciplina pelo aluno,
 * a quantidade de horas esperada, se a meta foi atingida e produz
 * um relatório final.
 * 
 * @author Pedro Raimundo
 */
public class RegistroTempoOnline {
	
	/**
	 * Nome da disciplina a ser registrada as horas.
	 */
	private String nomeDisciplina;
	/**
	 * Tempo de uso online da disciplina esperado.
	 */
	private int tempoOnlineEsperado;
	/**
	 * Tempo de uso online da disciplina dedicado.
	 */
	private int tempoOnlineUsado = 0;
	/**
	 * Booleano que retorna se o tempo usado
	 * foi maior ou igual que o esperado.
	 */
	private boolean atingiuMeta;
	
	/**
	 * Registra uma disciplina e seu tempo online esperado.
	 * 
	 * @param nomeDisciplina Nome da disciplina
	 * @param tempoOnlineEsperado Tempo online esperado para a disciplina
	 */
	public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = tempoOnlineEsperado;
	}
	
	/**
	 * Registra as sessões de tempo online usado.
	 * 
	 * @param tempo Tempo online usado para a disciplina
	 */
	public void adicionaTempoOnline(int tempo) {
		tempoOnlineUsado += tempo;
	}
	/**
	 * Retorna se a meta de tempo online usado foi atingida,
	 * ou seja, se o tempo usado foi maior que o tempo esperado.
	 * 
	 * @return Booleano que informa se a meta foi atingida.
	 */
	public boolean atingiuMetaTempoOnline() {
		if (tempoOnlineUsado >= tempoOnlineEsperado) {
			atingiuMeta = true;
		}
		else {
			atingiuMeta = false;
		}
		return atingiuMeta;
	}
	@Override
	/**
	 * Cria relatório final das horas na disciplina,
	 * no formato de String.
	 * 
	 * @return Relatório da disciplina e seus respectivos tempos
	 */
	public String toString() {
		String relatorioTempoOnline = nomeDisciplina + " " + tempoOnlineUsado + "/" + tempoOnlineEsperado;
		return relatorioTempoOnline;
	}
}