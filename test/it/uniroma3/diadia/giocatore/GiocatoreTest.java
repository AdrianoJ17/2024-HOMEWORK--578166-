package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GiocatoreTest {
	
	Giocatore g = new Giocatore();
	
	@Test
	public void testGetCfuDefault() {
		assertEquals(20, g.getCfu());
	}
	
	@Test
	public void testSetCfu() {
		g.setCfu(3);
		assertEquals(3, g.getCfu());
	}

	@Test
	public void testGetBorsaDefault() {
		assertNotNull(g.getBorsa());
	}
	
	@Test
	public void testSetGetBorsa() {
		Borsa v = new Borsa();
		g.setBorsa(v);
		assertEquals(g.getBorsa(), v);
	}
}
