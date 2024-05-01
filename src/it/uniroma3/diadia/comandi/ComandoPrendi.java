package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	private IO io;
	private String oggetto;
	private final static String NOME = "prendi";
	
	int contatorePrendiVuoto = 0;
	boolean maledizioneStanchezza = false;

	public ComandoPrendi(String oggetto) {
		this.oggetto = oggetto;
	}

	@Override
	public void esegui(Partita partita) {
		if (oggetto == null) {
			this.contatorePrendiVuoto++;

			if (this.contatorePrendiVuoto >= 10 && !maledizioneStanchezza) {
				io.mostraMessaggio("le tue braccia stanno chiedendo pietà");
				io.mostraMessaggio("Sei stato colpito dalla maledizione della stanchezza");
				this.maledizioneStanchezza = true; 
			}
			io.mostraMessaggio("Afferri l'aria gelida che c'è nella stanza");
		}
		else if (!this.maledizioneStanchezza) {
			Attrezzo a = partita.getStanzaCorrente().getAttrezzo(oggetto);
			if (a != null) {
				partita.getStanzaCorrente().removeAttrezzo(a);
				partita.getGiocatore().getBorsa().addAttrezzo(a);
				io.mostraMessaggio("Hai preso " + a.getNome());
			}
			else io.mostraMessaggio("L'oggetto non è in questa stanza");
		}
		else {
			io.mostraMessaggio("Non puoi afferrare oggetti a causa della maledizione della stanchezza");

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
