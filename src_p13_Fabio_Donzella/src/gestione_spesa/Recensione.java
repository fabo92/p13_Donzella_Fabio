package gestione_spesa;


/**
 * Classe Recensione
 * @author Fabio Donzella
 *
 */
public class Recensione {
	
	/**	Titolo recensione*/
	private String titolo;
	
	/** Testo della recensione */
	private String testo;
	
	/** Nome autore della recensione */
	private String nomeAutore;
	
	/** Oggetto Negozio associato alla recensione*/
	private Negozio negozio;
	
	/** Oggetto Prodotto associato alla recensione*/
	private Prodotto prodotto;
	/**
	 * Costruttore di Recensione
	 * @param titolo titolo della recensione
	 * @param testo testo della recensione
	 * @param autore autore della recensione
	 * @param negozio oggetto Negozio della recensione
	 */
	public Recensione(String titolo, String testo, String autore, Negozio negozio, Prodotto prodotto) {
		super();
		this.titolo = titolo;
		this.testo = testo;
		this.nomeAutore = autore;
		this.negozio = negozio;
		this.prodotto = prodotto;
	}
	
	/**
	 * Sets Negozio
	 * @param n
	 */
	public void setNegozio(Negozio n){
		this.negozio = n;
	}
	
	/** 
	 * Gets Negozio
	 * @return negozio
	 */
	public Negozio getNegozio(){
		return negozio;
	}
	
	/**
	 * Sets Prodotto
	 * @param n
	 */
	public void setProdotto(Prodotto p){
		this.prodotto = p;
	}
	
	/** 
	 * Gets oggetto prodotto
	 * @return prodotto
	 */
	public Prodotto getProdotto(){
		return prodotto;
	}
	
	/**
	 * Sets Prodotto
	 * @param n
	 */
	public void setAutore(String na){
		this.nomeAutore = na;
	}
	
	/**
	 * Gets nome dell'autore
	 * @return nomeAutore
	 */
	public String getAutore() {
		return nomeAutore;
	}
	
	/**
	 * Sets Titolo recensione
	 * @param tit
	 */
	public void settitolo(String tit){
		this.titolo = tit;
	}
	
	/**
	 * Gets titolo recensione
	 * @return titolo
	 */
	public String getTitolo() {
		return titolo;
	}
	
	/**
	 * Sets Testo
	 * @param text
	 */
	public void setTesto(String text){
		this.testo = text;
	}
	
	/**
	 * Gets Testo
	 * @return testo
	 */
	public String getTesto() {
		return testo;
	}
}
