package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	
	private IO io;
	
	private static final  String[] elencoComandi = {"vai", "aiuto", "prendi", "posa", "fine", "guarda"};
	private final static String NOME = "aiuto";
	
	/**
	 * Stampa informazioni di aiuto.
	 */
	
	public ComandoAiuto() {
	
	}
		

	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
		return;
	}

	
	@Override
	public void setParametro(String parametro) {
		return;
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
