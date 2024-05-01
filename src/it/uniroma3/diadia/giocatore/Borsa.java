package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMAX;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMAX) {
		this.pesoMAX = pesoMAX;
		this.attrezzi = new Attrezzo[10];
		this.numeroAttrezzi = 0;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMAX())
			return false;
		if (this.numeroAttrezzi > DEFAULT_PESO_MAX_BORSA)
			return false;

		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;

		if(nomeAttrezzo!=null){
			int i = 0;
			for(Attrezzo att : this.attrezzi) {
				if(att != null) {
					if(att.getNome().equals(nomeAttrezzo)) {
						for (int j=i; j<this.numeroAttrezzi; j++) {
							this.attrezzi[j] = this.attrezzi[j+1];
						}
						//a = att;
						this.attrezzi[this.numeroAttrezzi] = null;
						this.numeroAttrezzi--;
					}
				}
				i++;
			}
		}
		return a;
	}

	public int getPesoMAX() {
		return this.pesoMAX;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a  = null;
		for (int i=0; i<this.numeroAttrezzi; i++) {
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = this.attrezzi[i];
		}
		return a;
	}

	public int getPeso() {
		int peso = 0;
		for (int i=0; i<numeroAttrezzi; i++) {
			peso += this.attrezzi[i].getPeso();
		}
		return peso;
	}

	public boolean isEmpty() {
		return (this.numeroAttrezzi == 0);
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return getAttrezzo(nomeAttrezzo) != null; 
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Borsa (" + this.getPeso() + "kg/" + this.getPesoMAX() + "Kg): ");
			for (int i=0; i<this.numeroAttrezzi; i++) 
				s.append(attrezzi[i].getNome() + ", ");
			s.setCharAt(s.length()-2, '.');
	
		}
		else 
			s.append("Borsa vuota");
		return s.toString();
	}

}