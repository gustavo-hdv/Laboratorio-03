package agendatestes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Agenda;

/** Representação de testes para a classe Agenda.
 * 
 * Laboratório de Programação 2 - Lab 3.
 *
 * @author Gustavo Henrique Dias Ventura - 119110971.
 */
class AgendaTest {
	private Agenda contatosUm = new Agenda();
	private Agenda contatosDois = new Agenda();
	private Agenda contatosTres = new Agenda();
	private Agenda contatosQuatro = new Agenda();
	private Agenda contatosCinco = new Agenda();
	private Agenda contatosSeis = new Agenda();
	
	@BeforeEach
	public void criaContato() {
		contatosUm.cadastraContato("Gustavo", "Henrique", "1241-5000", 1);
		contatosDois.cadastraContato("Gustavo", "Henrique", "1241-5000", 1);
		contatosTres.cadastraContato("Matheus", "Lucas", "1661-4123", 1);
		contatosQuatro.cadastraContato("Matheus", "Lucas", "1661-4123", 2);
	}
	
	@Test
	void testCadastraContato() {
		String msg1 = "Falso, pois a posição é inválida.";
		String msg2 = "Verdade, pois a posição é valida.";
		
		assertEquals(contatosCinco.cadastraContato("Matheus", "Gaudencio", "(83) 99999-0000", 1), true);
		assertEquals(contatosSeis.cadastraContato("Pedro", "Silva", "(84) 98888-11111", 1), true);
		assertNotEquals(contatosCinco.cadastraContato("Kalec", "Lucas", "(83) 95699-0080", 0), true);
		assertNotEquals(contatosTres.cadastraContato("Gustavo", "Henrique", "1241-5000", 53453), true, msg1);
		assertNotEquals(contatosTres.cadastraContato("Teste", "verdade", "0804-1413", 101), true, msg1);
		assertEquals(contatosDois.cadastraContato("Maria", "Flor", "+1 (595) 5555-1234", 100), true, msg2);
		assertEquals(contatosTres.cadastraContato("Teste", "verdade", "0804-1413", 9), true, msg2);
	}

	@Test
	void testExibirContato() {
		assertEquals(contatosUm.exibirContato(900), "POSIÇÃO INVÁLIDA!");
		assertEquals(contatosDois.exibirContato(101), "POSIÇÃO INVÁLIDA!");
		assertEquals(contatosUm.exibirContato(0), "POSIÇÃO INVÁLIDA!");
		assertEquals(contatosDois.exibirContato(1), "Gustavo Henrique - 1241-5000");
		assertEquals(contatosUm.exibirContato(1), "Gustavo Henrique - 1241-5000");
		assertEquals(contatosTres.exibirContato(1), "Matheus Lucas - 1661-4123");
		
	}

	@Test
	void testToString() {
		assertEquals(contatosUm.toString(), "1 - Gustavo Henrique\n");
		assertEquals(contatosDois.toString(), "1 - Gustavo Henrique\n");
		assertEquals(contatosTres.toString(), "1 - Matheus Lucas\n");
	}

	@Test
	void testEqualsObject() {
		String msg1 = "Espera que duas agendas são iguais se tiverem os mesmos contatos nas mesmas posições.";
		String msg2 = "Espera que duas agendas não sejam iguais.";
		
		assertEquals(contatosUm.equals(contatosDois), true, msg1);
		assertNotEquals(contatosUm.equals(contatosTres), true, msg2);
		assertNotEquals(contatosDois.equals(contatosTres), true, msg2);	
		assertNotEquals(contatosTres.equals(contatosQuatro), true, msg2);
	}

}
