package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Contato;
import agenda.Agenda;

class ContatoTest {
	
	private Agenda agenda;
	private Contato contatoBase;
	
	@BeforeEach
	void preparaContatos() {
		this.contatoBase = new Contato("Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		this.agenda = new Agenda();
	}
	
	@Test
	void testContato() {
		agenda.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		assertEquals("Matheus Gaudencio", agenda.getContato(0).getNomeCompleto());
		assertEquals("(83) 99999-0000", agenda.getContato(0).getPrioritario());
		assertEquals("(83) 99999-0001", agenda.getContato(0).getWhatsapp());
		assertEquals("(83) 99999-0002", agenda.getContato(0).getAdicional());
		
	}

	@Test
	void testGetNomeCompleto() {
		assertEquals("Matheus Gaudencio", contatoBase.getNomeCompleto());
	}

	@Test
	void testGetDados() {
		agenda.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		assertEquals("\nMatheus Gaudencio"
				+ "\n(83) 99999-0000 (Prioritário)"
				+ "\n(83) 99999-0001 (Whatsapp)"
				+ "\n(83) 99999-0002 (Adicional)", agenda.getContato(0).getDados(0, agenda));
	}

	@Test
	void testFormataContato() {
		agenda.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		assertEquals("1 - Matheus Gaudencio", agenda.getContato(0).formataContato(1, agenda.getContato(0).getNomeCompleto()));
	}

}
