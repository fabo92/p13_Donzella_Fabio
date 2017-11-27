package gestione_spesa;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Negozio
 * @author Fabio Donzella
 *
 */
public class Negozio {
	
	/** Nome Negozio */
	private String nome;
    
	/** Catena del Negozio */
    private String catena;
    
    /** Genere del Negozio */
    private String genere;
    
    /** Proprietario del Negozio */
    private Proprietario_Negozio proprietario;
    
    /** Elenco dei prodotti disponibili nel Negozio */
    private List<Prodotto> prodotti;
    
    
    /**
     * Costruttore di Negozio
     * @param nome nome del Negozio
     * @param catena catena del Negozio
     * @param genere genere del Negozio
     * @param proprietario Proprietario associato al negozio
     */
    public Negozio(String nome, String catena, String genere, 
			Proprietario_Negozio proprietario) {
    	super();
		this.nome = nome;
		this.catena = catena;
		this.genere = genere;
		this.proprietario = proprietario;
		prodotti = new ArrayList<Prodotto>();
    }
    
    /**
     * Aggiunta di un prodotto al negozio associato
     * @param prodotto prodotto associato al negozio
     * @return boolean che conferma l'avvenuta operazione
     */
    public boolean addProduct ( Prodotto prodotto ) {
    	Boolean ok = false;
    	for(Prodotto p: prodotti){
    		if(p.getNome().equals(prodotto.getNome())){
    			ok = true;
    		}
    	}
    	if (!ok){
    		return prodotti.add(prodotto);
    	}
    	return ok;
    }
    
    /** Sets nome negozio
     * @param arg
     */
    public void setNome(String arg) {
		this.nome = arg;
	}
    
    /** Gets nome negozio
     * @return nome
     */
    public String getNome() {
		return nome;
	}
    
    /** Sets Proprietario negozio
     * @param p
     */
    public void setProprietario(Proprietario_Negozio p) {
		this.proprietario = p;
	}
    
    /** Gets oggetto proprietario del negozio
     * @return proprietario
     */
    public Proprietario_Negozio getProprietario() {
		return proprietario;
	}
    
    /** Gets lista di prodotti disponibili del negozio
     * @return prodotti
     */
    public List<Prodotto> getProdotti() {
		return prodotti;
	}
    
}
