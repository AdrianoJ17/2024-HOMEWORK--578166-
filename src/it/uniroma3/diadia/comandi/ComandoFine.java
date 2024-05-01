package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {

	private IO io;
	private final static String NOME = "fine";
		
	/**
	 * Comando "Fine".
	 */
	public ComandoFine() {
		
	}
	
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Grazie per aver giocato"); // Smetti di giocare
		partita.setFinita();
	}

	@Override
	public void setParametro(String parametro) {

	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
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
