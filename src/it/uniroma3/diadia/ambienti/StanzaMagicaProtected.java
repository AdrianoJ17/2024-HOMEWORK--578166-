package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected {
	final static private int SOGLIA_MAGICA_DEFAULT = 3;

	private int contatoreAttrezziPosati;
	private int sogliaMagica;

	public StanzaMagicaProtected(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}

	public StanzaMagicaProtected(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}

	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo != null) {
			if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
				this.attrezzi[numeroAttrezzi] = attrezzo;
				this.numeroAttrezzi++;
				this.contatoreAttrezziPosati++;
				if (this.contatoreAttrezziPosati > this.sogliaMagica) 
					this.attrezzi[numeroAttrezzi-1] = modificaAttrezzo(attrezzo);
				return true;
			}
		}
		return false;


	}

	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		int pesoX2 = attrezzo.getPeso() * 2;

		attrezzo = new Attrezzo(nomeInvertito.toString(), pesoX2);
		return attrezzo;
	}

}
