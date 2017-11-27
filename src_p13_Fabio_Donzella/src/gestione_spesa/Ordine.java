package gestione_spesa;

import java.util.Date;
import java.util.List;

/**
 * Classe Ordine
 * @author fabio
 */
public class Ordine {
	
	/**Lista dei prodotti da acquistare dell'ordine */
	private List<Prodotto> prodotti;
	
	/**Acquirente associato all'ordine */
	private Acquirente acquirente;
	
	/**Data dell'ordine */
	private Date data;
	
	/**
	 * Costruttore di Ordine
	 * @param products lista dei prodotti
	 * @param utente acquirente associato all'ordine
	 * @param date data dell'ordine
	 */
	public Ordine(List<Prodotto> products, Acquirente utente, Date date) {
		super();
		this.prodotti = products;
		this.acquirente = utente;
		this.data = date;
	}
	
	/**
	 * Sets products, List di Prodotti
	 * @param products
	 */
	public void setOrdine(List<Prodotto> products){
		prodotti = products;
	}
	
	/**
	 * Gets Data dell'ordine
	 * @return data
	 */
	public Date getDate(){
		return data;
	}
	
	/**
	 * Gets prodotti dell'ordine
	 * @return prodotti
	 */
	public List<Prodotto> getProdotti(){
		return prodotti;
	}
	
	/**
	 * Gets acquirente associato all'ordine
	 * @return acquirente
	 */
	public Acquirente getAcquirente(){
		return acquirente;
	}
	
}
