package bordado;

public class Agrupamento {
	
	private String nome;
	
	private int[] bordadosAgrupados;
	
		public Agrupamento(String nome, int numBordados, int[] posicoesBordados) {
		this.nome = nome;
		this.bordadosAgrupados = new int[numBordados];
		for (int i = 0; i < numBordados; i++) {
			this.bordadosAgrupados[i] = posicoesBordados[i];	
		}
	}
	
	public String getNome() {
		return this.nome;
	}
		
	public int[] getBordadosAgrupados() {
		return this.bordadosAgrupados.clone();
	}
	
}
