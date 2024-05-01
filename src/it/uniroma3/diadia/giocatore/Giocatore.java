package it.uniroma3.diadia.giocatore;


/*	La classe giocatore ha la responsabilità di  gestire
 *  i CFU del giocatore e di memorizzare gli attrezzi in
 *  un oggetto istanza della classe Borsa
 * */

public class Giocatore {
	static final private int CFU_INIZIALI = 20;
	public int cfu = CFU_INIZIALI;
	public Borsa borsa = new Borsa();
	
	
	public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}

	public Borsa getBorsa() {
		return borsa;
	}

	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}	
	
	
}