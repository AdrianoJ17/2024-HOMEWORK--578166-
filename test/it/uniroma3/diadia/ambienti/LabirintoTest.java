package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;

public class LabirintoTest {
	Partita p;
	Labirinto l;
	Stanza biblioteca;
	Stanza DS1;

	@BeforeEach
	public void setUp() {
		l = new Labirinto();
		l.creaStanze();
		biblioteca = new Stanza("Biblioteca");
		DS1 = new Stanza("DS1");
		p = new Partita(l);
	}


	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", l.getStanzaVincente().getNome());
	}

	@Test 
	public void testsetStanzaVincente() {
		l.setStanzaVincente(DS1);
		assertEquals("DS1", l.getStanzaVincente().getNome());
	}


	@Test
	public void testSetStanzaCorrente() {
		p.setStanzaCorrente(DS1);
		assertEquals(DS1, p.getStanzaCorrente());
	}
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Atrio", p.getStanzaCorrente().getNome());
	}

}
