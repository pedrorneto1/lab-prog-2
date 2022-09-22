package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Agenda;

class AgendaTest {
	
	private Agenda agenda;
	
	@BeforeEach
	void preparaAgenda() {
		this.agenda = new Agenda();
	}

	@Test
	void testCadastraContato1() {
		agenda.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		assertEquals("Matheus Gaudencio", agenda.getContato(0).getNomeCompleto());
		assertEquals("(83) 99999-0000", agenda.getContato(0).getPrioritario());
		assertEquals("(83) 99999-0001", agenda.getContato(0).getWhatsapp());
		assertEquals("(83) 99999-0002", agenda.getContato(0).getAdicional());
	}
	
	@Test
	void testCadastraContato2() {
		agenda.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		agenda.cadastraContato(0, "Pedro", "Silva", "(84) 98888-1111", "(84) 98888-1112", "(84) 98888-1113");
		assertEquals("Pedro Silva", agenda.getContato(0).getNomeCompleto());
		assertEquals("(84) 98888-1111", agenda.getContato(0).getPrioritario());
		assertEquals("(84) 98888-1112", agenda.getContato(0).getWhatsapp());
		assertEquals("(84) 98888-1113", agenda.getContato(0).getAdicional());
	}
	
	@Test
	void testCadastraContato3() {
		agenda.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		agenda.cadastraContato(2, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		assert (agenda.getContato(2) == null);
	}

	@Test
	void testCadastraContato4() {
		agenda.cadastraContato(99, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		assertEquals("Matheus Gaudencio", agenda.getContato(99).getNomeCompleto());
		assertEquals("(83) 99999-0000", agenda.getContato(99).getPrioritario());
		assertEquals("(83) 99999-0001", agenda.getContato(99).getWhatsapp());
		assertEquals("(83) 99999-0002", agenda.getContato(99).getAdicional());
	}
	
	@Test
	void testCadastraContato5() {
		agenda.cadastraContato(100, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		boolean vazia = true;
		for (int i = 0; i < agenda.getContatos().length; i++) {
			if (agenda.getContato(i) != null) {
				vazia = false;
			}
		}
		assert (vazia);
	}
	
	@Test
	void testCadastraContato6() {
		agenda.cadastraContato(-1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		boolean vazia = true;
		for (int i = 0; i < agenda.getContatos().length; i++) {
			if (agenda.getContato(i) != null) {
				vazia = false;
			}
		}
		assert (vazia);
	}
	
	@Test
	void testCadastraContato7() {
		agenda.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "");
		assertEquals("", agenda.getContato(0).getAdicional());
	}
	
	@Test
	void testTemCadastro() {
		agenda.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		String nomeCompleto = "Matheus Gaudencio";
		assertEquals(true, agenda.temCadastro(nomeCompleto));
	}

	@Test
	void testExibeContato1() {
		agenda.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		assertEquals("\nMatheus Gaudencio"
				+ "\n(83) 99999-0000 (Prioritário)"
				+ "\n(83) 99999-0001 (Whatsapp)"
				+ "\n(83) 99999-0002 (Adicional)", agenda.getContato(0).getDados(0, agenda));
	}
	
	@Test
	void testExibeContato2() {
		agenda.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "");
		assertEquals("\nMatheus Gaudencio"
				+ "\n(83) 99999-0000 (Prioritário)"
				+ "\n(83) 99999-0001 (Whatsapp)", agenda.getContato(0).getDados(0, agenda));
	}
	
	@Test
	void testExibeContato3() {
		try {
			assertEquals("", agenda.getContato(99).getDados(99, agenda));
		} catch (NullPointerException e) {
			assert(true);
		}
	}
	
	@Test
	void testExibeContato4() {
		try {
			assertEquals("", agenda.getContato(-1).getDados(-1, agenda));
		} catch (ArrayIndexOutOfBoundsException e) {
			assert(true);
		}
	}
	
	@Test
	void testExibeContato5() {
		try {
			assertEquals("", agenda.getContato(100).getDados(100, agenda));
		} catch (ArrayIndexOutOfBoundsException e) {
			assert(true);
		}
	}

	@Test
	void testExibeContato6() {
		agenda.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		agenda.cadastraFavorito(0, 0);
		assertEquals("\nS2 Matheus Gaudencio"
				+ "\n(83) 99999-0000 (Prioritário)"
				+ "\n(83) 99999-0001 (Whatsapp)"
				+ "\n(83) 99999-0002 (Adicional)", agenda.getContato(0).getDados(0, agenda));
	}
	
	@Test
	void testVerificaFavorito() {
		agenda.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		agenda.cadastraFavorito(0, 0);
		assertEquals(true, agenda.verificaFavorito(0));
	}

}
