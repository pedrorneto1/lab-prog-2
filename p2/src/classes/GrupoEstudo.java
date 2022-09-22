package classes;

public class GrupoEstudo {
	private String nomeDisciplina;
	private int numColegas;
	private String nomeColega;
	private int colegasCadastrados = 0;
	private String[] nomesColegas;

	public GrupoEstudo(String nomeDisciplina, int numColegas) {
		this.nomeDisciplina = nomeDisciplina;
		this.numColegas = numColegas;
		this.nomesColegas = new String[numColegas];
	}

	public void cadastraColega(int idColega, String nomeColega) {
		nomesColegas[idColega] = nomeColega;
	}
	public int totalCadastrados() {
		for (String nome : nomesColegas) {
			if (nome != null) {
				colegasCadastrados += 1;
			}
		}
		return colegasCadastrados;
	}
	public String getColega(int idColega) {
		if (nomesColegas[idColega] != null) {
			nomeColega = nomesColegas[idColega];
		} else if (nomesColegas[idColega] == null) {
			nomeColega = "-- SEM COLEGA --";
		}
		return nomeColega;
	}
	public boolean isColega(String nomeColega) {
		boolean presente = false;
		for (String nome : nomesColegas) {
			if (nomeColega.equals(nome)) {
				presente = true;
			}
		}
		return presente;
	}
	@Override
	public String toString() {
		String relatorioEstudos = "Grupo de Estudo de " + nomeDisciplina + " Capacidade: " + colegasCadastrados + "/" + numColegas;
		return relatorioEstudos;
	}
}