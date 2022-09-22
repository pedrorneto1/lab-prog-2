package ufcg.ccc.domino.estrategia;

import java.util.Comparator;

import ufcg.ccc.domino.Peca;

/**
 * Comparador de peças para ordenar a mão do jogador.
 */
public class PecaPadraoComparator implements Comparator<Peca> {
	
	@Override
	public int compare(Peca peca1, Peca peca2) {
		if (peca1.getNumEsquerdo() > peca2.getNumEsquerdo()) {
			return 1;
		}
		if (peca1.getNumEsquerdo() < peca2.getNumEsquerdo()) {
			return -1;
		}
		if (peca1.getNumDireito() > peca2.getNumDireito()){
			return 1;
		}
		if (peca1.getNumDireito() < peca2.getNumDireito()){
			return -1;
		}
		return 0;
	}
	
}
