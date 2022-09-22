package agenda;

/**
 * Representação de um contato que armazena seus dados e compõe a classe Agenda.
 * 
 * @author Pedro Raimundo
 *
 */
public class Contato {
	
	/**
	 * Nome do contato.
	 */
	private String nome;
	/**
	 * Sobrenome do contato.
	 */
	private String sobrenome;
	/**
	 * Nome completo do contato.
	 */
	private String nomeCompleto;
	/**
	 * Número principal do contato.
	 */
	private String prioritario;
	/**
	 * Número de whatsapp do contato.
	 */
	private String whatsapp;
	/**
	 * Número adicional do contato.
	 */
	private String adicional;
	
	/**
	 * Array que armazena os contatos da agenda.
	 */
	private Contato[] contatos;
	
	/**
	 * Constrói o contato da agenda, adicionando seus dados da entrada.
	 * 
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param prioritario Número principal do contato.
	 * @param whatsapp Número de whatsapp do contato.
	 * @param adicional Número adicional do contato.
	 */
	public Contato(String nome, String sobrenome, String prioritario, String whatsapp, String adicional) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.prioritario = prioritario;
		this.whatsapp = whatsapp;
		this.adicional = adicional;
	}

	/**
	 * Formata e armazena o nome completo do contato.
	 * 
	 * @return O nome completo do contato.
	 */
	public String getNomeCompleto() {
		if (sobrenome.isEmpty()) {
			nomeCompleto = nome;
		} else {
			nomeCompleto = nome + " " + sobrenome;
		}
		return nomeCompleto;
	}
	
	/**
	 * Acessa o número principal do contato.
	 * 
	 * @return O número principal do contato.
	 */
	public String getPrioritario() {
		return prioritario;
	}
	
	/**
	 * Acessa o número de whatsapp do contato.
	 * 
	 * @return O número de whatsapp do contato.
	 */
	public String getWhatsapp() {
		return whatsapp;
	}
	
	/**
	 * Acessa o número adicional do contato.
	 * 
	 * @return O número adicional do contato.
	 */
	public String getAdicional() {
		return adicional;
	}
	
	/**
	 * Acessa os dados de um contato específico e exibe na saída.
	 * 
	 * @param posicao Posição do contato na agenda.
	 * @param agenda Agenda de contatos.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public String getDados(int posicao, Agenda agenda) {
		contatos = agenda.getContatos();
		String dadosContato = "";
		
		if (contatos[posicao] == null) {
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");
		}
		if (!contatos[posicao].nomeCompleto.isEmpty() && agenda.verificaFavorito(posicao)) {
			dadosContato += "\n" + "S2 " + contatos[posicao].nomeCompleto;
		} else if (!contatos[posicao].nomeCompleto.isEmpty()) {
			dadosContato += "\n" + contatos[posicao].nomeCompleto;
		}
		if (!contatos[posicao].prioritario.isEmpty()) {
			dadosContato += "\n" + contatos[posicao].prioritario + " (Prioritário)";
		}
		if (!contatos[posicao].whatsapp.isEmpty()) {
			dadosContato += "\n" + contatos[posicao].whatsapp + " (Whatsapp)";
		}
		if (!contatos[posicao].adicional.isEmpty()) {
			dadosContato += "\n" + contatos[posicao].adicional + " (Adicional)";
		}
		return dadosContato;
	}
	
	/**
	 * Formata um contato para impressão na interface. 
	 * 
	 * @param posicao A posição do contato (que é exibida).
	 * @param nomeCompleto O nome completo do contato (que é exibido).
	 * @return A String formatada.
	 */
	public String formataContato(int posicao, String nomeCompleto) {
		return posicao + " - " + nomeCompleto;
	}
}