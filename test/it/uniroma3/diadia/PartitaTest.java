package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	Labirinto l = new Labirinto();
	Partita p = new Partita(l);
	Stanza s = new Stanza("Stanza");
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", p.getLabirinto().getStanzaVincente().getNome());
	}

	@Test
	public void testSetStanzaCorrente() {
		p.setStanzaCorrente(s);
		assertEquals(s, p.getStanzaCorrente());
	}

	@Test 
	public void testGetLabirinto() {
		assertEquals(p.getLabirinto(), l);
	}
	
	@Test
	public void testSetLabirinto() {
		Labirinto t = new Labirinto();
		p.setLabirinto(t);
		assertEquals(p.getLabirinto(), t);

	}
	
	@Test
	public void testIsFinita() {
		
		assertFalse(p.isFinita());
	}
	
}
