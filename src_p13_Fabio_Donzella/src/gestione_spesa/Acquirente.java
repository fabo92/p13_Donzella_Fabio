package gestione_spesa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Classe Acquirente sottoclasse di Utente
 * @author Fabio Donzella
 *
 */
public class Acquirente extends Utente{

	/** Metodo di pagamento */
	private String metododipagamento;
	
	/** Lista della spesa con una List di Prodotti */
	private List<Prodotto> listaSpesa;
	
	/**
	 * Costruttore di Acquirente, richiama il costruttore di Utente
	 * @param nome nome dell'Acquirente
	 * @param cognome cognome dell'Acquirente
	 * @param indirizzo indirizzo dell'Acquirente
	 * @param dataNascita data di nascita dell'acquirente
	 * @param codiceFiscale codice fiscale dell'acquirente
	 * @param telefono numero di telefono dell'acquirente
	 * @param email indirizzo email dell'acquirente
	 * @param password password dell'acquirente
	 * @param sistema sistema associato all'acquirente
	 * @param metododipagamento metodo di pagamento dell'accquirente
	 */
	public Acquirente(String nome, String cognome, String indirizzo, 
    		Date dataNascita, String codiceFiscale, String telefono, 
    		String email, String password, Sistema sistema, String metododipagamento) {
		super(nome, cognome, indirizzo, dataNascita, codiceFiscale, 
				telefono, email, password, sistema);
		this.metododipagamento = metododipagamento;
		this.listaSpesa = new ArrayList<Prodotto>();
	}
	
	/**
	 * Gets Lista della spesa
	 * @return listaSpesa 
	 */
	public List<Prodotto> getLista(){
		return listaSpesa;
	}
	
	/**
	 * Aggiunge oggetto Prodotto alla Lista della spesa
	 * @param prod 
	 */
	public void addProduct(Prodotto prod){
		listaSpesa.add(prod); 
	}
	
	/**
	 * Gets metodo di pagamento
	 * @return metododipagamento
	 */
	public String getMetododipagamento() {
		return metododipagamento;
	}
	

	/** Sets metodo di pagamento
	 * @param metodopagamento
	 */
	public void setMetododipagamento(String metodopagamento) {
		this.metododipagamento = metodopagamento;
	}
}

