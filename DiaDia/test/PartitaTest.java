import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class PartitaTest {

	Giocatore g = new Giocatore();
	Labirinto l = new Labirinto();
	Partita p = new Partita(l);
	Stanza s1 = new Stanza("Stanza1");
	Stanza s2 = new Stanza("Stanza2");
	Stanza s3 = new Stanza("Stanza3");

	@BeforeEach
	public void setUp() {
		p.setGiocatore(g);
		g.setCfu(10);
		l.setStanzaIniziale(s1);
		p.setStanzaCorrente(s1);
		l.setStanzaVincente(s3);
		p.setNonFinita();
	}

	
	@Test
	public void testSetGetStanzaCorrente1() {
		assertEquals(s1, p.getStanzaCorrente());
	}

	
	@Test
	public void testSetGetStanzaCorrente2() {
		p.setStanzaCorrente(s2);
		assertEquals(s2, p.getStanzaCorrente());
	}



	@Test
	public void testSetGetStanzaCorrente3() {
		p.setStanzaCorrente(s2);
		assertFalse((p.getStanzaCorrente()) == s1);
	}

	@Test
	public void testNonVittoria() {
		assertFalse(p.vinta());
	}

	@Test
	public void testVittoria() {
		p.setStanzaCorrente(s3);
		assertTrue(p.vinta());
	}
	
	@Test 
	public void testFinita() {
		assertFalse(p.isFinita());
	}


}