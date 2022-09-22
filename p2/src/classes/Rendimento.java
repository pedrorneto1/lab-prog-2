package classes;

public class Rendimento {
	private String nomeDisciplina;
	private int[] pesosAtividade;
	private double[] notasAtividade;
	private double mediaPonderada;
	private boolean aprovado;
	
	public Rendimento(String nomeDisciplina, int[] pesosAtividade) {
		this.nomeDisciplina = nomeDisciplina;
		this.pesosAtividade = pesosAtividade;
		notasAtividade = new double[pesosAtividade.length];
	}
	
	public void cadastraAtividade(int idNota, double nota) {
		notasAtividade[idNota] = nota;
	}
	public double media() {
		int somaNotas = 0;
		int somaPesos = 0;
		for (int i = 0; i < notasAtividade.length; i++) {
			somaNotas += notasAtividade[i] * pesosAtividade[i];
			somaPesos += pesosAtividade[i];
		}
		mediaPonderada = somaNotas / somaPesos;
		return mediaPonderada;
	}
	public boolean aprovado() {
		media();
		if (mediaPonderada >= 7.0) {
			aprovado = true;
		} else {
			aprovado = false;
		}
		return aprovado;
	}
	@Override
	public String toString() {
		String relatorioNotas = "Rendimento de " + nomeDisciplina + " Media: " + mediaPonderada;
		return relatorioNotas;
	}
}