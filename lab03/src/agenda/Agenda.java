package agenda;

/**
 * Uma agenda que mant�m uma lista de contatos com posi��es.
 * Podem existir 100 contatos. 
 * 
 * @author nazarenoandrade
 * @author Pedro Raimundo
 *
 */
public class Agenda {
	
	/**
	 * Quantidade m�xima de contatos na agenda.
	 */
	private static final int TAMANHO_AGENDA = 100;
	/**
	 * Quantidade m�xima de favoritos na agenda.
	 */
	private static final int TAMANHO_FAVORITOS = 10;
	
	/**
	 * Array que armazena os contatos.
	 */
	private Contato[] contatos;
	/**
	 * Array que armazena os favoritos.
	 */
	private Contato[] favoritos;

	/**
	 * Cria uma agenda que armazena contatos e favoritos.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[TAMANHO_FAVORITOS];
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * 
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}
	
	/**
	 * Acessa um contato da agenda.
	 * 
	 * @param posicao Posi��o do contato na agenda.
	 * @return Dados do contato. Null se n�o h� contato na posi��o.
	 */
	public Contato getContato(int posicao) {
		return contatos[posicao];
	}

	/**
	 * Cadastra um contato em uma posi��o. Um cadastro em uma posi��o que
	 * j� existe sobrescreve o anterior.
	 * 
	 * @param posicao Posi��o do contato na agenda.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param prioritario N�mero principal do contato.
	 * @param whatsapp N�mero de whatsapp do contato.
	 * @param adicional N�mero adicional do contato.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String prioritario, String whatsapp, String adicional) {
		Contato contato = new Contato(nome, sobrenome, prioritario, whatsapp, adicional);
		if (!(posicao < 0 || posicao > 99)) {
			if (temCadastro(contato.getNomeCompleto()) == false) {
				this.contatos[posicao] = contato;
			}
		}
	}
	
	/**
	 * Verifica se um novo contato a ser inserido j� est� presente na agenda.
	 * 
	 * @param nomeCompleto O nome completo do contato.
	 * @return A presen�a do contato na agenda, no formato de boolean.
	 */
	public boolean temCadastro(String nomeCompleto) {
		boolean temCadastro = false;
		for (Contato registrado : contatos) {
			if (registrado != null) {
				if (nomeCompleto.equals(registrado.getNomeCompleto())) {
					temCadastro = true;
				}
			}
		}
		return temCadastro;
	}
	
	/**
	 * Acessa a lista de favoritos mantida.
	 * 
	 * @return O array de favoritos.
	 */
	public Contato[] getFavoritos() {
		return this.favoritos.clone();
	}
	
	/**
	 * Cadastra contatos como favoritos.
	 * 
	 * @param posicao Posi��o do contato na agenda.
	 * @param posicaoFavorito Posi��o do contato na lista de favoritos.
	 */
	public void cadastraFavorito(int posicao, int posicaoFavorito) {
		favoritos[posicaoFavorito] = contatos[posicao];
	}
	
	/**
	 * Verifica se um contato da agenda � favorito.
	 * 
	 * @param posicao Posi��o do contato na agenda.
	 * @return A presen�a do contato na lista de favoritos, no formato de boolean.
	 */
	public boolean verificaFavorito(int posicao) {
		boolean favorito = false;
		for (Contato registrado : favoritos) {
			if (registrado != null) {
				if (contatos[posicao].getNomeCompleto().equals(registrado.getNomeCompleto())) {
					favorito = true;
				}
			}
		}
		return favorito;
	}
}