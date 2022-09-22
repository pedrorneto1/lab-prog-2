package agenda;

/**
 * Representa��o de um contato que armazena seus dados e comp�e a classe Agenda.
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
	 * N�mero principal do contato.
	 */
	private String prioritario;
	/**
	 * N�mero de whatsapp do contato.
	 */
	private String whatsapp;
	/**
	 * N�mero adicional do contato.
	 */
	private String adicional;
	
	/**
	 * Array que armazena os contatos da agenda.
	 */
	private Contato[] contatos;
	
	/**
	 * Constr�i o contato da agenda, adicionando seus dados da entrada.
	 * 
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param prioritario N�mero principal do contato.
	 * @param whatsapp N�mero de whatsapp do contato.
	 * @param adicional N�mero adicional do contato.
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
	 * Acessa o n�mero principal do contato.
	 * 
	 * @return O n�mero principal do contato.
	 */
	public String getPrioritario() {
		return prioritario;
	}
	
	/**
	 * Acessa o n�mero de whatsapp do contato.
	 * 
	 * @return O n�mero de whatsapp do contato.
	 */
	public String getWhatsapp() {
		return whatsapp;
	}
	
	/**
	 * Acessa o n�mero adicional do contato.
	 * 
	 * @return O n�mero adicional do contato.
	 */
	public String getAdicional() {
		return adicional;
	}
	
	/**
	 * Acessa os dados de um contato espec�fico e exibe na sa�da.
	 * 
	 * @param posicao Posi��o do contato na agenda.
	 * @param agenda Agenda de contatos.
	 * @return Dados do contato. Null se n�o h� contato na posi��o.
	 */
	public String getDados(int posicao, Agenda agenda) {
		contatos = agenda.getContatos();
		String dadosContato = "";
		
		if (contatos[posicao] == null) {
			throw new IllegalArgumentException("POSI��O INV�LIDA");
		}
		if (!contatos[posicao].nomeCompleto.isEmpty() && agenda.verificaFavorito(posicao)) {
			dadosContato += "\n" + "S2 " + contatos[posicao].nomeCompleto;
		} else if (!contatos[posicao].nomeCompleto.isEmpty()) {
			dadosContato += "\n" + contatos[posicao].nomeCompleto;
		}
		if (!contatos[posicao].prioritario.isEmpty()) {
			dadosContato += "\n" + contatos[posicao].prioritario + " (Priorit�rio)";
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
	 * Formata um contato para impress�o na interface. 
	 * 
	 * @param posicao A posi��o do contato (que � exibida).
	 * @param nomeCompleto O nome completo do contato (que � exibido).
	 * @return A String formatada.
	 */
	public String formataContato(int posicao, String nomeCompleto) {
		return posicao + " - " + nomeCompleto;
	}
}