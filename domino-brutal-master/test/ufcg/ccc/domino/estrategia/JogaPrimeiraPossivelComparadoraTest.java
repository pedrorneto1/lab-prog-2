package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.Jogada.TipoJogada;

class JogaPrimeiraPossivelComparadoraTest {
	
	private Peca peca1 = new Peca(4, 3);
	private Peca peca2 = new Peca(2, 4);
	private Peca peca3 = new Peca(2, 2);
	private Mesa mesa;
	
	Comparator<Peca> cmp = new PecaPadraoComparator();
	
	List<Peca> mao = new LinkedList<Peca>();
	
	@BeforeEach
	void setUp() throws Exception {
		mesa = new Mesa();
		mesa.jogaNaDireita(new Peca(1, 2));
		mesa.jogaNaEsquerda(new Peca(1, 1));
		mao.add(peca1);
		mao.add(peca2);
		mao.add(peca3);
	}
	
	@Test
	void testSort() {
		Collections.sort(mao, cmp);
		assertTrue(mao.get(0).getNumEsquerdo() <= mao.get(1).getNumEsquerdo() && mao.get(1).getNumEsquerdo() <= mao.get(2).getNumEsquerdo());
		assertTrue(mao.get(0).getNumDireito() <= mao.get(1).getNumDireito());
	}
	
	@Test
	void testJogaPrimeira() {
		JogaPrimeiraPossivelComparadora estrategia = new JogaPrimeiraPossivelComparadora(cmp);

		Jogada j1 = estrategia.decideJogada(mao, mesa);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
	}
	
}
