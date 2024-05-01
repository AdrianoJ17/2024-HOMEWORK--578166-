package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	
	private IO io;
	private String direzione;
	private final static String NOME = "vai";
	
	public ComandoVai(String direzione) {
		this.direzione = direzione;
	}
	
	
	@Override
	public void esegui(Partita partita) {
		
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		
		if (this.direzione == null) {
			io.mostraMessaggio("Dove vuoi andare?\nSpecifica una direzione");
			return;
		}
		
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if (prossimaStanza == null) {
			io.mostraMessaggio("*BONK*");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		//io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());	--> Viene fatto in "guarda"
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
		return;
		
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
		return;
	}


	@Override
	public String getParametro() {
		return this.direzione;
	}


	@Override
	public String getNome() {
		return NOME;
	}
	
	@Override
	public void setIO(IO io) {
		this.io = io;
	}
}
