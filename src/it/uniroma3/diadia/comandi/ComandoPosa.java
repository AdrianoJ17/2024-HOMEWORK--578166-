package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	
	private IO io;
	String oggetto;
	private final static String NOME = "posa";
	
	/*
	 * Comando "posa"
	 */
	public ComandoPosa(String oggetto) {
		this.oggetto = oggetto;
	}

	@Override
	public void esegui(Partita partita) {
		if (oggetto == null)
			io.mostraMessaggio("Devi specificare un oggetto da posare");
		else {
			Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(oggetto);
			if (a != null) {
			partita.getStanzaCorrente().addAttrezzo(a);
			partita.getGiocatore().getBorsa().removeAttrezzo(a.getNome());
			io.mostraMessaggio("Hai posato " + a.getNome() + " nella stanza");
			}
			else io.mostraMessaggio("Non hai questo oggetto nella borsa");
		}
		return;
	}

	@Override
	public void setParametro(String parametro) {
		this.oggetto = parametro;
	}

	@Override
	public String getParametro() {
		return this.oggetto;
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
