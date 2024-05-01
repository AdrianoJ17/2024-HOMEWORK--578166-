package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {	

	Stanza s1 = new Stanza("s1");
	Stanza s2= new Stanza("s2");
	Attrezzo alabarda = new Attrezzo("alabarda", 50);
	
	@Test
	public void testGetStanzaAdiacente() {
		assertNull(s1.getStanzaAdiacente("sud"));
	}
	

	@Test
	public void testSetStanzaAdiacente() {
		s1.impostaStanzaAdiacente("sud", s2);
		assertEquals(s2, s1.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testAddAttrezzo() {
		assertTrue(s1.addAttrezzo(alabarda));
	}
	
	@Test
	public void testLimiteAttrezzi() {
		Attrezzo a = new Attrezzo("a", 5);
		Attrezzo b = new Attrezzo("b", 5);
		Attrezzo c = new Attrezzo("c", 5);
		Attrezzo d = new Attrezzo("d", 5);
		Attrezzo e = new Attrezzo("e", 5);
		Attrezzo f = new Attrezzo("f", 5);
		Attrezzo g = new Attrezzo("g", 5);
		Attrezzo h = new Attrezzo("h", 5);
		Attrezzo i = new Attrezzo("i", 5);
		Attrezzo l = new Attrezzo("l", 5);

		s1.addAttrezzo(a);
		s1.addAttrezzo(b);
		s1.addAttrezzo(c);
		s1.addAttrezzo(d);
		s1.addAttrezzo(e);
		s1.addAttrezzo(f);
		s1.addAttrezzo(g);
		s1.addAttrezzo(h);
		s1.addAttrezzo(i);
		
		assertTrue(s1.addAttrezzo(l));
	}
	
	@Test
	public void testTroppiAttrezzi() {
		Attrezzo a = new Attrezzo("a", 5);
		Attrezzo b = new Attrezzo("b", 5);
		Attrezzo c = new Attrezzo("c", 5);
		Attrezzo d = new Attrezzo("d", 5);
		Attrezzo e = new Attrezzo("e", 5);
		Attrezzo f = new Attrezzo("f", 5);
		Attrezzo g = new Attrezzo("g", 5);
		Attrezzo h = new Attrezzo("h", 5);
		Attrezzo i = new Attrezzo("i", 5);
		Attrezzo l = new Attrezzo("l", 5);
		Attrezzo m = new Attrezzo("m", 5);

		s1.addAttrezzo(a);
		s1.addAttrezzo(b);
		s1.addAttrezzo(c);
		s1.addAttrezzo(d);
		s1.addAttrezzo(e);
		s1.addAttrezzo(f);
		s1.addAttrezzo(g);
		s1.addAttrezzo(h);
		s1.addAttrezzo(i);
		s1.addAttrezzo(l);
		
		assertFalse(s1.addAttrezzo(m));
	}
	
	@Test
	public void testGetAttrezzo() {
		s1.addAttrezzo(alabarda);
		assertEquals(alabarda, s1.getAttrezzo(alabarda.getNome()));
	}

	@Test
	public void testRemoveAttrezzoNull() {
		assertFalse(s1.removeAttrezzo(null));
	}
	
	@Test
	public void testRemoveAttrezzo() {
		Attrezzo a = new Attrezzo("a", 5);
		s2.addAttrezzo(a);
		assertTrue(s2.removeAttrezzo(a));
	}
	
	@Test
	public void testRemoveAttrezzoStanzaSbagliata() {
		Attrezzo a = new Attrezzo("a", 5);
		s2.addAttrezzo(a);
		assertFalse(s1.removeAttrezzo(a));
	}
}
