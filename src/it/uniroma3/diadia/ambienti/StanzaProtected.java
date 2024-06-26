package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaProtected {

	static final private int NUMERO_MASSIMO_DIREZIONI= 4;
	protected static final int NUMERO_MASSIMO_ATTREZZI = 10;

	private String nome;
	protected Attrezzo[] attrezzi;
	protected int numeroAttrezzi;

	public int getNumeroAttrezziPossibili() {
		return NUMERO_MASSIMO_ATTREZZI - numeroAttrezzi;
	}

	protected StanzaProtected[] stanzeAdiacenti;
	protected int numeroStanzeAdiacenti;
	protected String[] direzioni;

	public StanzaProtected(String nome) {
		this.nome = nome;
		this.numeroAttrezzi = 0;
		this.numeroStanzeAdiacenti = 0;
		this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
		this.stanzeAdiacenti = new StanzaProtected[NUMERO_MASSIMO_DIREZIONI];
		this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
	}

	public void impostaStanzaAdiacente(String direzione, StanzaProtected stanza) {
		boolean aggiornato = false;
		for (int i=0; i<this.direzioni.length; i++) 
			if (direzione.equals(this.direzioni[i])) {
				this.stanzeAdiacenti[i] = stanza;
				aggiornato = true;
			}
		if (!aggiornato) 
			if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
				this.direzioni[numeroStanzeAdiacenti] = direzione;
				this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
				this.numeroStanzeAdiacenti++;
			}
	}

	public StanzaProtected getStanzaAdiacente(String direzione) {
		StanzaProtected stanza = null;
		for (int i=0; i < this.numeroStanzeAdiacenti; i++)
			if (this.direzioni[i].equals(direzione))
				stanza = this.stanzeAdiacenti[i];
		return stanza;
	}

	public String getNome() {
		return this.nome;
	}

	public String getDescrizione() {
		return this.toString();
	}

	public Attrezzo[] getAttrezzi() {
		return this.attrezzi;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
			this.attrezzi[numeroAttrezzi] = attrezzo;
			this.numeroAttrezzi++;
			return true;
		}
		else return false;
	}

	public String toString() {
		StringBuilder out= new StringBuilder();

		out.append(this.nome);

		out.append("\nUscite: ");
		for (int i=0; i<this.direzioni.length; i++) {
			String direzione = direzioni[i];
			if (direzioni != null)
				out.append(direzione + " ");
		}

		out.append("\nAttrezzi nella stanza: ");
		for (int i=0; i<this.attrezzi.length; i++) {
			Attrezzo attrezzo = attrezzi[i];
			if (attrezzo != null)
				out.append(attrezzo.toString() + " ");
		}
		return out.toString();
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato = false;

		for (Attrezzo attrezzo : this.attrezzi) 
			if (attrezzo != null)
				if (attrezzo.getNome().equals(nomeAttrezzo))
					trovato = true;

		return trovato;
	}
	
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if (attrezzo != null) {
			int i = 0;
			for (Attrezzo a : this.attrezzi) {
				if (a != null) {
					if (a.getNome().equals(attrezzo.getNome())) {
						this.attrezzi[i] = null;
						this.numeroAttrezzi--;
					}
				}
				i++;
			}
			return true;
		}
		else return false;
	}
	
	public String[] getDirezioni() {
		String[] direzioni = new String[this.numeroStanzeAdiacenti];
		for (int i=0; i<this.numeroStanzeAdiacenti; i++) 
			direzioni[i] = this.direzioni[i];
		return direzioni;
	}

}
