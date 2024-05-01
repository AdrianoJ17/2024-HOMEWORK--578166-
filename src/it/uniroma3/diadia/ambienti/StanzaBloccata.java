package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	
	private String direzioneBloccata;
	private String attrezzoChiave;
	
	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoChiave) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoChiave = attrezzoChiave;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if (this.direzioneBloccata.equals(direzione) && !this.hasAttrezzo(this.attrezzoChiave))
			return this;
		return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		String bloccata = new String();
		bloccata = "La direzione " + direzioneBloccata + " è bloccata.\n Devi ottenere il " + attrezzoChiave + " e posarlo nella stanza";
		
		if (!this.hasAttrezzo(attrezzoChiave))
			return bloccata;
		return super.getDescrizione();
	}
	
}
