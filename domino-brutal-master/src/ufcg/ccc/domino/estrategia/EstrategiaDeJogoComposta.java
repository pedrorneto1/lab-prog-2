/**
 * 
 */
package ufcg.ccc.domino.estrategia;

import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;

/**
 * Alterna as estratégias em cada jogada, dentre uma lista de estratégias
 * fornecida.
 */
public class EstrategiaDeJogoComposta implements EstrategiaDeJogo {
	
	private int contaRodadas;
	
	private List<EstrategiaDeJogo> estrategias;
	
	public EstrategiaDeJogoComposta(List<EstrategiaDeJogo> estrategias) {
		this.estrategias = estrategias;
		this.contaRodadas = 0;
	}
	
	@Override
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
		if (contaRodadas % 2 == 0) {
			contaRodadas++;
			return estrategias.get(0).decideJogada(mao, mesa);
		} else if (contaRodadas % 2 == 1) {
			contaRodadas++;
			return estrategias.get(1).decideJogada(mao, mesa);
		} else {
			contaRodadas++;
			return new Jogada();
		}
	}
	
	@Override
	public String toString() {
		return "Estratégia Composta";
	}
}