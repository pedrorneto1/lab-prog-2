package bordado;

public class Bordado {
	
	private int linhasBordado;
	private int colunasBordado;
	
	private String[][] bordado;
	
	public Bordado(int posicaoBordado, int linhasBordado, int colunasBordado) {
		this.linhasBordado = linhasBordado;
		this.colunasBordado = colunasBordado;
		this.bordado = new String[linhasBordado][colunasBordado];
		
		for (int i = 0; i < this.linhasBordado; i++) {
			for (int j = 0; j < this.colunasBordado; j++) {
				this.bordado[i][j] = " ";
			}
		}
	}

	public int getLinhasBordado() {
		return this.linhasBordado;
	}
	
	public int getColunasBordado() {
		return this.colunasBordado;
	}
	
	public String getNoBordado(int linhaBordado, int colunaBordado) {
		return this.bordado[linhaBordado][colunaBordado];
	}
	
	public int getNosPontos() {
		int contaNosPontos = 0;
		for (int i = 0; i < linhasBordado; i++) {
			for (int j = 0; j < colunasBordado; j++) {
				if (this.bordado[i][j] != " ") {
					contaNosPontos += 1;
				}
			}
		}
		return contaNosPontos;
	}
	
	public void setNoBordado(String no, int linhaBordado, int colunaBordado) {
		this.bordado[linhaBordado][colunaBordado] = no;
	}
}
