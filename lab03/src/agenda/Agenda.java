package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições.
 * Podem existir 100 contatos. 
 * 
 * @author nazarenoandrade
 * @author Pedro Raimundo
 *
 */
public class Agenda {
	
	/**
	 * Quantidade máxima de contatos na agenda.
	 */
	private static final int TAMANHO_AGENDA = 100;
	/**
	 * Quantidade máxima de favoritos na agenda.
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
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public Contato getContato(int posicao) {
		return contatos[posicao];
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que
	 * já existe sobrescreve o anterior.
	 * 
	 * @param posicao Posição do contato na agenda.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param prioritario Número principal do contato.
	 * @param whatsapp Número de whatsapp do contato.
	 * @param adicional Número adicional do contato.
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
	 * Verifica se um novo contato a ser inserido já está presente na agenda.
	 * 
	 * @param nomeCompleto O nome completo do contato.
	 * @return A presença do contato na agenda, no formato de boolean.
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
	 * @param posicao Posição do contato na agenda.
	 * @param posicaoFavorito Posição do contato na lista de favoritos.
	 */
	public void cadastraFavorito(int posicao, int posicaoFavorito) {
		favoritos[posicaoFavorito] = contatos[posicao];
	}
	
	/**
	 * Verifica se um contato da agenda é favorito.
	 * 
	 * @param posicao Posição do contato na agenda.
	 * @return A presença do contato na lista de favoritos, no formato de boolean.
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