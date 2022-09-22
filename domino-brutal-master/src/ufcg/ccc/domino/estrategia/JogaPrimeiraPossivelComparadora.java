package ufcg.ccc.domino.estrategia;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;

/**
 * Ordena as peças na mão do jogador baseado no critério de comparação e
 * então usa a estratégia de JogaPrimeiraPossivel.
 */
public class JogaPrimeiraPossivelComparadora extends JogaPrimeiraPossivel {
	
	private Comparator<Peca> cmp;
	
	public JogaPrimeiraPossivelComparadora (Comparator<Peca> cmp) {
		this.cmp = cmp;
	}
	
	@Override
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
		Collections.sort(mao, cmp);
		return super.decideJogada(mao, mesa);
	}
	
}
