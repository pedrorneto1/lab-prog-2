package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;

class EstrategiaDeJogoCompostaTest {
	
	private Mesa mesa;
	
	@BeforeEach
	void setUp() throws Exception {
		mesa = new Mesa();
		mesa.jogaNaDireita(new Peca(1, 2));
		mesa.jogaNaEsquerda(new Peca(1, 1));
	}

	@Test
	void testPassa() {
		List<EstrategiaDeJogo> estrategias = new ArrayList<>();
		estrategias.add(new JogaPrimeiraPossivel());
		estrategias.add(new JogaCarroca());
		EstrategiaDeJogo estrategiaComposta = new EstrategiaDeJogoComposta(estrategias);

		Jogada j1 = estrategiaComposta.decideJogada(List.of(new Peca(3, 3), new Peca(0, 3)), mesa);

		assertEquals(TipoJogada.PASSA, j1.getTipo());
	}

	@Test
	void testJogaPrimeira() {
		List<EstrategiaDeJogo> estrategias = new ArrayList<>();
		estrategias.add(new JogaPrimeiraPossivel());
		estrategias.add(new JogaCarroca());
		EstrategiaDeJogo estrategiaComposta = new EstrategiaDeJogoComposta(estrategias);

		Jogada j1 = estrategiaComposta.decideJogada(List.of(new Peca(3, 3), new Peca(0, 2), new Peca(2, 6)), mesa);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(0, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testJogaCarroca() {
		List<EstrategiaDeJogo> estrategias = new ArrayList<>();
		estrategias.add(new JogaPrimeiraPossivel());
		estrategias.add(new JogaCarroca());
		EstrategiaDeJogo estrategiaComposta = new EstrategiaDeJogoComposta(estrategias);

		estrategiaComposta.decideJogada(List.of(new Peca(3, 3), new Peca(0, 2), new Peca(2, 6)), mesa);
		
		Jogada j2 = estrategiaComposta.decideJogada(List.of(new Peca(4, 4), new Peca(2, 2), new Peca(1, 1)), mesa);
		
		assertEquals(TipoJogada.NA_DIREITA, j2.getTipo());
		assertEquals(2, j2.getPeca().getNumEsquerdo());
		assertEquals(2, j2.getPeca().getNumDireito());
	}
	
}