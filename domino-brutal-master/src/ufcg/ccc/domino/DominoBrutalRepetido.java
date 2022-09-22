package ufcg.ccc.domino;

import java.util.List;
import java.util.ArrayList;
//import java.util.Comparator;

import ufcg.ccc.domino.estrategia.EstrategiaDeJogo;
import ufcg.ccc.domino.estrategia.EstrategiaDeJogoComposta;
import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivel;
import ufcg.ccc.domino.estrategia.JogaCarroca;
//import ufcg.ccc.domino.estrategia.JogaPecaAlta;
//import ufcg.ccc.domino.estrategia.PecaPadraoComparator;
//import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivelComparadora;

/**
 * Exemplo de como fazer um main com uma disputa de muuuitos jogos entre duas
 * estratégias.
 * 
 */
public class DominoBrutalRepetido {
	
	private static final int NUM_PECAS_INICIAL = 12;
	private static final int REPETICOES = 50000;

	public static void main(String[] args) throws EstrategiaInvalidaException, JogadaInvalidaException {
		float vitoriasJ1 = 0, vitoriasJ2 = 0, vitoriasCarrocaJ1 = 0, vitoriasCarrocaJ2 = 0, vitoriasLaeLoJ1 = 0, vitoriasLaeLoJ2 = 0, vitoriasQuadradaJ1 = 0, vitoriasQuadradaJ2 = 0, empates = 0;

		EstrategiaDeJogo estrategia1 = new JogaPrimeiraPossivel(), estrategia2 = new JogaCarroca(); //, estrategia3 = new JogaPecaAlta(); 
		
		List<EstrategiaDeJogo> estrategias = new ArrayList<>();
		estrategias.add(estrategia1);
		estrategias.add(estrategia2);
		EstrategiaDeJogo estrategiaComposta = new EstrategiaDeJogoComposta(estrategias);
		
		//Comparator<Peca> cmp = new PecaPadraoComparator();
		//EstrategiaDeJogo estrategiaCmp = new JogaPrimeiraPossivelComparadora(cmp);
		
		for (int i = 0; i < REPETICOES; i++) {
			
			Jogo j;
			
			// Cada estratégia começa jogando metade das partidas.
			if( i < REPETICOES / 2) {
				j = new Jogo("J1", estrategiaComposta, "J2", estrategia1, NUM_PECAS_INICIAL);
			} else {
				j = new Jogo("J2", estrategia1, "J1", estrategiaComposta, NUM_PECAS_INICIAL);
			}
			
			HistoricoDeJogo historico = j.jogaJogoCompleto();
			if (historico.isEmpate()) {
				empates++;
			} else if (historico.getVencedor() == "J1") {
				vitoriasJ1++;
				if (j.verificaCarroca() && j.verificaLaeLo()) {
					vitoriasJ1 += 5;
					vitoriasQuadradaJ1++;
					continue;
				}
				if (j.verificaLaeLo()) {
					vitoriasJ1 += 2;
					vitoriasLaeLoJ1++;
					continue;
				}
				if (j.verificaCarroca()) {
					vitoriasJ1++;
					vitoriasCarrocaJ1++;
					continue;
				}
			} else if (historico.getVencedor() == "J2") {
				vitoriasJ2++;
				if (j.verificaCarroca() && j.verificaLaeLo()) {
					vitoriasJ2 += 5;
					vitoriasQuadradaJ2++;
					continue;
				}
				if (j.verificaLaeLo()) {
					vitoriasJ2 += 2;
					vitoriasLaeLoJ2++;
					continue;
				}
				if (j.verificaCarroca()) {
					vitoriasJ1++;
					vitoriasCarrocaJ1++;
					continue;
				}
			}
		}

		System.out.println(
				"E1: " + estrategiaComposta.toString() 
				+ "\nE2: " + estrategia1.toString()
				+ "\nJogos:\t" + (REPETICOES) 
				+ "\n- Vitórias E1:\t" + vitoriasJ1 + " vitórias "
				+ "\n >> Por tipo: Carroça - " + vitoriasCarrocaJ1 + " vitórias || Lá e Lô - " + vitoriasLaeLoJ1 + " vitórias || Quadrada - " + vitoriasQuadradaJ1 + " vitórias"
				+ "\n- Vitórias E2:\t" + vitoriasJ2 + " vitórias "
				+ "\n >> Por tipo: Carroça - " + vitoriasCarrocaJ2 + " vitórias || Lá e Lô - " + vitoriasLaeLoJ2 + " vitórias || Quadrada - " + vitoriasQuadradaJ2 + " vitórias"
				+ "\n- Empates:\t" + empates + "\t\t(" + Math.round(empates / REPETICOES * 100) + "%)");
	}

}
