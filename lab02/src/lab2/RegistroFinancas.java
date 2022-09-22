package lab2;

/**
 * Registra receitas de acordo com seus tipos de origem,
 * eventuais despesas, exibe as diferentes fontes de renda e
 * produz um relat�rio final.
 * 
 * @author Pedro Raimundo
 */
public class RegistroFinancas {
	
	/**
	 * Entrada inicial de receita no registro.
	 */
	private int receitaInicial;
	/**
	 * Somat�rio das entradas de receita, dos diferentes tipos.
	 */
	private int receitaTotal;
	/**
	 * Saldo resultante ap�s despesas.
	 */
	private int receitaAtual;
	/**
	 * Array que armazena as fonte de renda,
	 * separadas por tipo.
	 */
	private int[] fontesDeRenda = new int[4];
	/**
	 * Total de despesas acumulado.
	 */
	private int despesaTotal;
	
	/**
	 * Constr�i o registro, guarda a receita inicial,
	 * armazena a receita inicial no Array e registra
	 * a receita total.
	 * 
	 * @param receitaInicial Entrada de receita inicial
	 */
	public RegistroFinancas(int receitaInicial) {
		this.receitaInicial = receitaInicial;
		fontesDeRenda[0] += receitaInicial;
		receitaTotal = this.receitaInicial;
	}
	
	/**
	 * Acrescenta � receita total as novas receitas e armazena
	 * no Array as receitas de acordo com seu tipo.
	 * 
	 * @param valorCentavos Novas receitas
	 * @param tipoFonte Tipo de receita
	 */
	public void aumentaReceita(int valorCentavos, int tipoFonte) {
		receitaTotal += valorCentavos;
		fontesDeRenda[tipoFonte - 1] += valorCentavos;
	}
	/**
	 * Atualiza a receita atual considerando as despesas e soma
	 * as despesas totais.
	 * 
	 * @param valorCentavos Despesas
	 */
	public void pagaDespesa(int valorCentavos) {
		receitaAtual = receitaTotal - valorCentavos;
		despesaTotal += valorCentavos;
	}
	/**
	 * Produz relat�rio com as diferentes fontes de renda,
	 * detalhando cada tipo.
	 * 
	 * @return Relat�rio das fontes de renda no formato de String
	 */
	public String exibeFontes() {
		String relatorioFontes = "1 - " + fontesDeRenda[0] + "\n2 - " + fontesDeRenda[1] + "\n3 - " + fontesDeRenda[2] + "\n4 - " + fontesDeRenda[3];
		return relatorioFontes;
	}
	@Override
	/**
	 * Produz relat�rio final que informa a receita total,
	 * receita atual (receita total menos as despesas) e as
	 * despesas totais.
	 * 
	 * @return Relat�rio das finan�as no formato de String
	 */
	public String toString() {
		String relatorioFinancas = "Receita total: " + receitaTotal + ", Receita atual: " + receitaAtual + ", Despesas totais: " + despesaTotal;
		return relatorioFinancas;
	}
}