import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.giocatore.Borsa;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GiocatoreTest {
	
	Giocatore g = new Giocatore();
	Borsa b = new Borsa();
	
	
	/*@BeforeEach
	public void setUp() {
		g.setCfu(0);
	}*/
	
	@Test
	public void testGetSetCfu1() {
		assertTrue(g.getCfu() == 20);
	}
	
	@Test
	public void testGetSetCfu2() {
		g.setCfu(10);
		assertFalse(g.getCfu() == 20);
	}
	
	@Test
	public void testGetSetCfu3() {
		g.setCfu(10);
		assertTrue(g.getCfu() == 10);
	}
	
	@Test
	public void testGetSetBorsa() {
		g.setBorsa(b);
		assertEquals(g.getBorsa(), b);
	}
}