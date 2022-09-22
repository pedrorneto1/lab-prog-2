/**
 * 
 */
package ufcg.ccc.domino.estrategia;

import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Peca;

/**
 * Joga a primeira peça com altos valores (soma maior que 6). Tenta primeiro
 * no lado direito e depois esquerdo, se encaixar em ambas. Se a soma não
 * for alta, joga a primeira peça possível.
 */
public class JogaPecaAlta implements EstrategiaDeJogo {

	@Override
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
		if (mesa.getNumPecas() == 0) {
			for (Peca peca : mao) {
				if (peca.getNumDireito() + peca.getNumEsquerdo() > 6) {
					return new Jogada(peca, TipoJogada.NA_DIREITA);
				}
			}
			return new Jogada(mao.get(0), TipoJogada.NA_DIREITA);
		}

		for (Peca peca : mao) {
			if (peca.getNumDireito() + peca.getNumEsquerdo() > 6) {
				if (peca.encaixa(mesa.getNumNaDireita())) {
					return new Jogada(peca, TipoJogada.NA_DIREITA);
				}
				if (peca.encaixa(mesa.getNumNaEsquerda())) {
					return new Jogada(peca, TipoJogada.NA_ESQUERDA);
				}
			}
			if (peca.encaixa(mesa.getNumNaDireita())) {
				return new Jogada(peca, TipoJogada.NA_DIREITA);
			}
			if (peca.encaixa(mesa.getNumNaEsquerda())) {
				return new Jogada(peca, TipoJogada.NA_ESQUERDA);
			}
		}

		return new Jogada();
	}

	@Override
	public String toString() {
		return "Joga Peça Alta";
	}
}