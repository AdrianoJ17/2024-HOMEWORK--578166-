package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {

	Borsa b = new Borsa();
	Attrezzo falce;
	Attrezzo martello;
	
	@BeforeEach
	public void setUp() {
		falce = new Attrezzo("falce", 2);
		martello = new Attrezzo("martello", 21);
	}

	@Test
	public void testVuota() {
		assertTrue(b.isEmpty());
	}
	@Test
	public void testNonVuota() {
		b.addAttrezzo(falce);
		assertFalse(b.isEmpty());
	}	
	
	
	@Test
	public void testAddAttrezzoPesoMinoreDiDieci() {
		assertTrue(b.addAttrezzo(falce));

	}
	
	@Test
	public void testAddAttrezzoPesoMaggioreDiDieci() {
		assertFalse(b.addAttrezzo(martello));

	}
	
	@Test
	public void testGetPeso() {
		b.addAttrezzo(falce);
		assertEquals(falce, b.getAttrezzo("falce"));
	}
	
	@Test
	public void testRemove() {
		b.addAttrezzo(falce);
		b.removeAttrezzo(falce.getNome());
		assertTrue(b.isEmpty());
	}
	
}
