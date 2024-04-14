//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	private Stanza s1 = new Stanza("s1");
	private Stanza s2 = new Stanza("s2");
	private Stanza s3 = new Stanza("s3");
	
	@Test
	public void testSetGetStanzaAdiacente1() {
		s1.impostaStanzaAdiacente("nord", s2);
		assertEquals(s1.getStanzaAdiacente("nord"),s2);
	}
	
	@Test
	public void testSetGetStanzaAdiacente2() {
		s1.impostaStanzaAdiacente("nord", s2);
		assertFalse(s1.getStanzaAdiacente("nord") == s3);
	}
	
	@Test
	public void testSetGetStanzaAdiacente3() {
		s1.impostaStanzaAdiacente("nord", s2);
		assertFalse(s1.getStanzaAdiacente("sud") == s2);
	}
	
	@Test
	public void testAddAttrezzo() {
		Attrezzo a = new Attrezzo("alabarda", 5);
		assertTrue(s1.addAttrezzo(a));
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
	public void testGetAttrezzo1() {
		Attrezzo a = new Attrezzo("a", 5);
		
		assertFalse(a==s1.getAttrezzo(a.getNome()));
	}
	
	@Test
	public void testGetAttrezzo2() {
		Attrezzo a = new Attrezzo("a", 5);
		s1.addAttrezzo(a);
		
		assertEquals(a, s1.getAttrezzo(a.getNome()));
	}
	
	@Test
	public void testRemoveAttrezzo1() {
		assertFalse(s1.removeAttrezzo(null));
	}
	
	@Test
	public void testRemoveAttrezzo2() {
		Attrezzo a = new Attrezzo("a", 5);
		s1.addAttrezzo(a);
		assertTrue(s1.removeAttrezzo(a));
	}
	
	
	@Test
	public void testRemoveAttrezzo3() {
		Attrezzo a = new Attrezzo("a", 5);
		s2.addAttrezzo(a);
		assertFalse(s1.removeAttrezzo(a));
	}	
	
	
}
