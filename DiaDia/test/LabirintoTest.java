import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {
	Labirinto l = new Labirinto();
	
	@BeforeEach
	public void setUp() {
		l.creaStanze();
	}
	
	@Test
	public void testGetStanzaIniziale1() {
		assertEquals(l.getStanzaIniziale().getNome(), "Atrio");
	}
	
	@Test
	public void testGetStanzaIniziale2() {
		assertFalse(l.getStanzaIniziale().getNome() == "Aula N11");
	}
	
	@Test 
	public void testSetStanzaIniziale1() {
		Stanza s = new Stanza("s");
		l.setStanzaIniziale(s);
		assertFalse(l.getStanzaIniziale().getNome() == "Atrio");
	}
	
	@Test 
	public void testSetStanzaIniziale2() {
		Stanza s = new Stanza("s");
		l.setStanzaIniziale(s);
		assertTrue(l.getStanzaIniziale().getNome() == "s");
	}
	
	@Test
	public void testGetStanzaVincente1() {
		assertEquals("Biblioteca", l.getStanzaVincente().getNome());
	}
	
	@Test
	public void testGetStanzaVincente2() {
		assertFalse("atrio" == l.getStanzaVincente().getNome());
	}
	
	@Test
	public void testSetStanzaVincente1() {
		Stanza s = new Stanza("s");
		l.setStanzaVincente(s);
		assertFalse("Biblioteca" == l.getStanzaVincente().getNome());
	}
	
	@Test
	public void testSetStanzaVincente2() {
		Stanza s = new Stanza("s");
		l.setStanzaVincente(s);
		assertTrue("s" == l.getStanzaVincente().getNome());
	}
}