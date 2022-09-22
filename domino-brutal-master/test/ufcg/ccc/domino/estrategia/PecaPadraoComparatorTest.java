package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Comparator;

import ufcg.ccc.domino.Peca;

class PecaPadraoComparatorTest {
	
	Peca peca1 = new Peca(3, 1);
	Peca peca2 = new Peca(2, 4);
	Peca peca3 = new Peca(2, 2);
	
	Comparator<Peca> cmp = new PecaPadraoComparator();
	
	@Test
	void testCompare() {
		assertEquals(1, cmp.compare(peca1, peca2));
		assertEquals(-1, cmp.compare(peca2, peca1));
		assertEquals(1, cmp.compare(peca2, peca3));
		assertEquals(-1, cmp.compare(peca3, peca2));
		assertEquals(0, cmp.compare(peca2, peca2));
	}
	
}
