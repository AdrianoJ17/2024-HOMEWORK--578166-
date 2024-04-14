package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "prendi", "posa", "fine"};
	
	private IOConsole console = new IOConsole();

	private Partita partita;

	public DiaDia() {
		Labirinto labirinto = new Labirinto();

		this.partita = new Partita(labirinto);
	}

	public void gioca() {
		String istruzione; 
		
		console.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do		
			istruzione = console.leggiRiga();
			//istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (istruzione.isEmpty())
			console.mostraMessaggio("Comando vuoto");
		else if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if(comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			console.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			console.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null) {
			console.mostraMessaggio("Dove vuoi andare?");
			return;
		}
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null) {
			console.mostraMessaggio("Direzione inesistente");
			return;
		}
		else {
			partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);

		}
		System.out.println(partita.getStanzaCorrente().getDescrizione());

	}

	/*
	 * Comando "prendi"
	 */

	private boolean prendi(String oggetto) {
		if (oggetto == null)
			console.mostraMessaggio("Devi prendere un oggetto");
		else {
			Attrezzo a = this.partita.getStanzaCorrente().getAttrezzo(oggetto);
			this.partita.getStanzaCorrente().removeAttrezzo(a);
			this.partita.getGiocatore().getBorsa().addAttrezzo(a);
		}
		return false;
	}
	/*
	 * Comando "posa"
	 */
	private boolean posa(String oggetto) {
		if (oggetto == null)
			console.mostraMessaggio("Devi posare un oggetto");
		else {
			Attrezzo a = this.partita.getGiocatore().getBorsa().getAttrezzo(oggetto);
			this.partita.getStanzaCorrente().addAttrezzo(a);
			this.partita.getGiocatore().getBorsa().removeAttrezzo(a.getNome());
		}
		return false;
	}
	/**
	 * Comando "Fine".
	 */
	private void fine() {
		console.mostraMessaggio("Grazie per aver giocato"); // Smetti di giocare
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}