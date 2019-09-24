package agendatestes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Contato;

/** Representação de testes para a classe Contato.
 * 
 * Laboratório de Programação 2 - Lab 3.
 *
 * @author Gustavo Henrique Dias Ventura - 119110971.
 */
class ContatoTest {
	private Contato contatoUm;
	private Contato contatoDois;
	private Contato contatoTres;
	private Contato contatoQuatro;
	
	@BeforeEach
	public void criaContato() {
		contatoUm = new Contato("Gustavo", "Henrique", "1234-0000");
		contatoDois = new Contato("Gustavo", "Henrique", "1235-0030");
		contatoTres = new Contato("Matheus", "Livia", "1244-5431");
		contatoQuatro = new Contato("Matheus", "Livia", "1244-5431");
	}
	
	@Test
	void testEqualsObject() {
		String msg1 = "Esperando obter que os contatos são iguais";
		String msg2 = "Esperando obter que os contatos não não iguais";
		
		assertEquals(contatoUm.equals(contatoDois), true, msg1);
		assertEquals(contatoTres.equals(contatoQuatro), true, msg1);
		assertNotEquals(contatoUm.equals(contatoTres), true, msg2);
		assertNotEquals(contatoDois.equals(contatoTres), true, msg2);
	}

	@Test
	void testToString() {
		String msg1 = "Esperando toString ser igual ao contato digitado";
		String msg2 = "Esperando toString ser diferente ao contato digitado";
		
		assertEquals("Gustavo Henrique 1234-0000", contatoUm.toString(), msg1);
		assertEquals("Matheus Livia 1244-5431", contatoTres.toString(), msg1);
		assertEquals(contatoQuatro.toString(), contatoTres.toString(), msg1);
		assertNotEquals("Gustavo Henrique 1234-0000", contatoDois.toString(), msg2);
		assertNotEquals("Matheus Livia 1244-5431", contatoUm.toString(), msg2);
		assertNotEquals(contatoUm.toString(), contatoDois.toString(), msg2);
	}

	@SuppressWarnings("unused")
	@Test
	public void testNull() {
		try {
			Contato contatoInvalido = new Contato(null, "Gustavo", "312335434");
			fail("Era esperado exceção ao passar código nulo");
		} catch (NullPointerException npe) {
			
		}
		try {
			Contato contatoInvalido = new Contato("Gustavo", null, "31224242");
			fail("Era esperado exceção ao passar código nulo");
		} catch (NullPointerException npe) {
			
		}
		try {
			Contato contatoInvalido = new Contato("Gustavo", "Henrique", null);
			fail("Era esperado exceção ao passar código nulo");
		} catch (NullPointerException npe) {
			
		}
	}

	@SuppressWarnings("unused")
	@Test
	public void testIllegalArgument() {
		try {
			Contato contatoInvalido = new Contato("", "Gustavo", "44412");
			fail("Era esperado exceção ao passar um argumento ilegal");
		} catch (IllegalArgumentException iae) {
			
		}
		try {
			Contato contatoInvalido = new Contato("Gustavo", "    ", "44412");
			fail("Era esperado exceção ao passar um argumento ilegal");
		} catch (IllegalArgumentException iae) {
			
		}
		try {
			Contato contatoInvalido = new Contato("Gustavo", "Henrique", " ");
			fail("Era esperado exceção ao passar um argumento ilegal");
		} catch (IllegalArgumentException iae) {
			
		}
	}
}
