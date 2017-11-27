package gestione_spesa;

/**
 * Classe Prodotto
 * @author Fabio Donzella
 *
 */
public class Prodotto {
	
    /** Nome del prodotto */
    private String nome;
    
    /** Marca del prodotto */
    private String marca;
    
    /** Genere del prodotto */
    private String genere;
    
    /** Quantita del prodotto */
    private int quantita;
    
    /** Costo del prodotto */
    private int costo;

    /** Negozio associato al prodotto */
    private Negozio negozio;

    /**
     * Costruttore di Prodotto
     * @param nome nome del prodotto
     * @param marca marca del prodotto
     * @param genere genere del prodotto
     * @param costo prezzo del prodotto
     * @param quantita quantita del prodotto
     * @param negozio negozio associato al prodotto
     */
    public Prodotto(String nome, String marca, String genere, 
    				int costo, int quantita, Negozio negozio) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.genere = genere;
		this.costo = costo;
		this.quantita = quantita;
		this.negozio = negozio;
	}
	
    /**
     * Gets nome Prodotto
     * @return nome
     */
    public String getNome(){
    	return nome;
    }
    
    /**
     * Sets nome Prodotto
     * @param arg
     */
    public void setNome(String arg){
    	this.nome = arg;
    }
    
    /** Gets negozio associato al prodotto
     * @return negozio
     */
    public Negozio getNegozio(){
    	return negozio;
    }
    
    /**
     * Sets nome Prodotto
     * @param arg
     */
    public void setNegozio(Negozio n){
    	this.negozio = n;
    }
}
