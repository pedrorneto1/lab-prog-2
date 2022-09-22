package bordado;

public class ListaBordados {
	
	private static final int TAMANHO_LISTA = 10;
	private static final int TAMANHO_AGRUPAMENTOS = 10;
	
	private Bordado[] listaBordados;
	private Agrupamento[] listaAgrupamentos;
	
	public ListaBordados() {
		this.listaBordados = new Bordado[TAMANHO_LISTA];
		this.listaAgrupamentos = new Agrupamento[TAMANHO_AGRUPAMENTOS];
	}
	
	public Bordado[] getBordados() {
		return this.listaBordados.clone();
	}
	
	
	
	public void cadastraBordado(int posicaoBordado, int linhasBordado, int colunasBordado) {
		Bordado bordado = new Bordado(posicaoBordado, linhasBordado, colunasBordado);
		this.listaBordados[posicaoBordado] = bordado;
	}
	
	public void atualizaBordado(int posicaoBordado, String no, int linhaBordado, int colunaBordado) {
		this.listaBordados[posicaoBordado].setNoBordado(no, linhaBordado, colunaBordado);
	}
	
	public boolean verificaNoValido(String no) {
		String[] nosValidos = {"/", "\\", "|", "-", "x", " "};
		boolean eValido = false;
		for (String noValido : nosValidos) {
			if (no.equals(noValido)) {
				eValido = true;
			}
		}
		return eValido;
	}
	
	public void agrupaBordados(int posicaoAgrupamento, String nome, int numBordados, int contaBordados, int[] posicoesBordados) {
		Agrupamento agrupamento = new Agrupamento(nome, numBordados, posicoesBordados);
		this.listaAgrupamentos[posicaoAgrupamento] = agrupamento;
	}

	public int menuAgrupamento(String referenciaAgrupamento) {
		int posicaoAgrupamento = 0;
		switch (referenciaAgrupamento) {
		case "1":
			posicaoAgrupamento = 0;
		case "2":
			posicaoAgrupamento = 1;
		case "3":
			posicaoAgrupamento = 2;
		case "4":
			posicaoAgrupamento = 3;
		case "5":
			posicaoAgrupamento = 4;
		case "6":
			posicaoAgrupamento = 5;
		case "7":
			posicaoAgrupamento = 6;
		case "8":
			posicaoAgrupamento = 7;
		case "9":
			posicaoAgrupamento = 8;
		case "10":
			posicaoAgrupamento = 9;
		default:
			for (int i = 0 ; i < listaAgrupamentos.length; i++) {
				if (referenciaAgrupamento.equals(listaAgrupamentos[i].getNome())) {
					posicaoAgrupamento = i;
				}
			}
		}
		return posicaoAgrupamento;
	}
	
	public int getLinhasMaior(int posicaoAgrupamento) {
		int [] bordadosAgrupados = listaAgrupamentos[posicaoAgrupamento].getBordadosAgrupados();
		int indiceBordadoMaior = bordadosAgrupados[0];
		int linhasMaior = 0;
		for (int indiceBordado : bordadosAgrupados) {
			if (listaBordados[indiceBordado].getLinhasBordado() > listaBordados[indiceBordadoMaior].getLinhasBordado()) {
				indiceBordadoMaior = indiceBordado;
				linhasMaior = listaBordados[indiceBordado].getLinhasBordado();
			}
		}
		return linhasMaior;
	}
	
	public int getColunasMaior(int posicaoAgrupamento) {
		int [] bordadosAgrupados = listaAgrupamentos[posicaoAgrupamento].getBordadosAgrupados();
		int indiceBordadoMaior = bordadosAgrupados[0];
		int colunasMaior = 0;
		for (int indiceBordado : bordadosAgrupados) {
			if (listaBordados[indiceBordado].getColunasBordado() > listaBordados[indiceBordadoMaior].getColunasBordado()) {
				indiceBordadoMaior = indiceBordado;
				colunasMaior = listaBordados[indiceBordado].getColunasBordado();
			}
		}
		return colunasMaior;
	}
	
	public void atualizaAgrupamentos(int posicaoAgrupamento, String no, int linhas, int linhaBordado, int colunas, int colunaBordado) {
		int [] bordadosAtualizados = listaAgrupamentos[posicaoAgrupamento].getBordadosAgrupados();
		for (int indiceBordado : bordadosAtualizados) {
			if (linhaBordado > linhas) {
				return;
			}
			if (colunaBordado > colunas) {
				return;
			}
			listaBordados[indiceBordado].setNoBordado(no, linhaBordado, colunaBordado);
		}
	}
}