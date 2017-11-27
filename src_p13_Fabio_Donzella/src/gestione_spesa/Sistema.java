package gestione_spesa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe Sistema
 * @author Fabio Donzella
 *
 */
public class Sistema{
	
    /** Nome del sistema */
    private String nome;
    
    /** Lista ordini del sistema */
    private List<Ordine> elencoOrdini;
    
    /** Lista recensioni del sistema */
    private List<Recensione> recensioninegozio;
    
    /** Lista recensioni del sistema */
    private List<Recensione> recensioniprodotto;
    
    /** Lista negozi del sistema */
    private List<Negozio> negozi;
    
    /** Lista utenti registrati del sistema */
    private List<Utente> utenti;
    
    /** Lista proprietari del sistema */
    private List<Proprietario_Negozio> proprietari;
    
    /** Lista acquirenti del sistema */
    private List<Acquirente> acquirenti;
    
    private List<Messaggio> messaggi;
    
    /** Data attuale*/
    Date date = new Date();
    
    /**
     * Costruttore di Sbu
     *
     * @param nome nome dell'SBU
     */
	public Sistema(String nome) {
		super();
		this.nome = nome;
		utenti = new ArrayList<Utente>();
		negozi = new ArrayList<Negozio>();
		proprietari = new ArrayList<Proprietario_Negozio>();
		acquirenti = new ArrayList<Acquirente>();
		elencoOrdini = new ArrayList<Ordine>();
		messaggi = new ArrayList<Messaggio>();
	}
    
    /**
     * Login (controllo username e password). Ritorna true se email e
     * password corrispondono a quelle di una Persona contenuta nella
     * lista utenti
     *
     * @param email email da controllare
     * @param password password da controllare
     * @return boolean
     */
    public boolean login ( String email, String password ) {
    	for (Utente u: utenti) {
    		if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * Ricerca di un prodotto a partire da una stringa
     * @param product Stringa di ricerca del nome del prodotto
     * @return prodotti
     */
    public List<Prodotto> ricercaProdotto ( String product ) {
    	List<Prodotto> prodotti = new ArrayList<Prodotto>();
    	List<Prodotto> prodottinegozio = new ArrayList<Prodotto>();
		for (Negozio n:negozi) {
			prodottinegozio = n.getProdotti();
			for (int i=0; i<prodottinegozio.size(); i++){
				if(prodottinegozio.get(i).getNome().contains(product)){
					prodotti.add(prodottinegozio.get(i));
				}	
			}
		}
		return prodotti;
    }
    
    /**
     * Conferma ordine di una lista spesa di un Acquirente,
     * riconosciuto tramite una Stringa
     * @param username Stringa che identifica l'acquirente
     * @return boolean che conferma o meno l'ordine
     */
    public boolean effettuaOrdine(String username){
    	boolean ok = false;
    	for (Acquirente a: acquirenti) {
    		if(a.getEmail().equals(username)) {
    			if(a.getLista().size() == 0){
    				return ok;
    			}
    			List<Prodotto> tempprod = new ArrayList<>(a.getLista());
    			Ordine ordine = new Ordine(tempprod, a, date);
    			elencoOrdini.add(ordine);
    			a.getLista().clear();
    			ok = true;
    		}
    	}
    	return ok;
    }
    
    
	/**
	 * Inserimento acquirente nel sistema
	 * @param user oggetto Acquirente che verrà inserito nell'apposita struttura dati
	 * @return boolean che conferma l'avvenuta operazione
	 */
    
	public boolean inserisciAcquirente(Acquirente user){
    if (utenti.contains(user)) {
    		return false;
    	}
    	acquirenti.add(user);
    	return utenti.add(user);
    }
	
	/**
	 * Inserimento proprietario nel sistema
	 * @param user oggetto Proprietario che verrà inserito nell'apposita struttura dati
	 * @return boolean che conferma l'avvenuta operazione
	 */
	public boolean inserisciProprietario ( Proprietario_Negozio user ) {
	    if (utenti.contains(user)) {
	    		return false;
	    	}
	    	proprietari.add(user);
	    	return utenti.add(user);
	}
	
	
	/**
	 * Inserimento negozio nel sistema
	 * @param negozio oggetto Negozio che verrà inserito nell'apposita struttura dati
	 * @param proprietario oggetto Proprietario che verrà associato al negozio
	 * @return boolean che conferma l'avvenuta operazione
	 */
	public boolean aggiungiNegozio ( Negozio negozio, Utente proprietario ) {
    	if (login (proprietario.getEmail(), proprietario.getPassword())){
    		if(!negozi.contains(negozio)){
    			return negozi.add(negozio);
    		}
    	}
    	return false;
    }

	/**
	 * Aggiunta prodotto nel sistema
	 * @param prodotto oggetto Prodotto che verrà inserito nell'apposita struttura dati
	 * @param proprietario oggetto Proprietario associato al negozio
	 * @param negozio oggetto Negozio associato al Prodotto
	 * @return
	 */
	public boolean aggiungiProdotto ( Prodotto prodotto, Utente proprietario, Negozio negozio ) {
    	if (login (proprietario.getEmail(), proprietario.getPassword()) && !negozio.getProdotti().contains(prodotto)){
    		return negozio.addProduct(prodotto);
    	}
    	return false;
    }
	
	/**
	 * Ricerca di un utente generico nel sistema
	 * @param arg Stringa dell'utente da cercare nel sistema
	 * @return List di utenti che contengono la Stringa arg nel proprio nome, cognome o username
	 */
	public List<Utente> ricercaUtente ( String arg ) {
		List<Utente> utentiTrovati = new ArrayList<>();
		for (Utente u: utenti) {
    		if (u.getNomeUtente().contains(arg) || u.getCognomeUtente().contains(arg) || u.getEmail().contains(arg)) {
    			utentiTrovati.add(u);
    		}
    	}
		return utentiTrovati;
    }
	
	/**
	 * Ricerca proprietario nel sistema
	 * @param arg Stringa del proprietario da cercare nel sistema
	 * @return oggetto Proprietario corrispondente
	 */
	public Proprietario_Negozio getProprietario ( String arg ) {
		for (Proprietario_Negozio p: proprietari) {
    		if (p.getEmail().equals(arg)) {
    			return p;
    		}
    	}
		return null;
    }
	
	/**
	 * Ricerca Acquirente nel sistema
	 * @param arg Stringa dell'acquirente da cercare nel sistema
	 * @return oggetto acquirente corrispondente
	 */
	public Acquirente getAcquirente ( String arg ) {
		for (Acquirente a: acquirenti) {
    		if (a.getEmail().equals(arg)) {
    			return a;
    		}
    	}
		return null;
    }
	
	/**
	 * Gets List Utenti
	 * @return utenti
	 */
	
	public List<Utente> getUtenti() {
		return utenti;
	}
	
	/**
	 * Gets List Proprietari
	 * @return proprietari
	 */
	
	public List<Proprietario_Negozio> getProprietari() {
		return proprietari;
	}
	
	/**
	 * Gets List Acquirenti
	 * @return acquirenti
	 */
	
	public List<Acquirente> getAcquirenti() {
		return acquirenti;
	}
	
	/**
	 * Gets negozi
	 * @return negozi
	 */
	public List<Negozio> getNegozi() {
		return negozi;
	}
	
	/**
	 * Aggiunta di un prodotto alla lista della spesa
	 * @param acquirente oggetto Acquirente associato alla lista della spesa
	 * @param prod oggetto Prodotto che verrà aggiunto alla lista della spesa
	 */
	public void addProdottotoLista(Acquirente acquirente, Prodotto prod){
		for(int i=0; i<acquirenti.size(); i++){
			if(acquirenti.get(i).getEmail().equals(acquirente.getEmail())){
				acquirenti.get(i).addProduct(prod);
			}
		}
	}
	
	
	/**
	 * Modifica il titolo ed il testo di una recensione
	 * @param r Recensione corrispondente
	 * @param titolo titolo della recensione
	 * @param testo testo della recensione
	 */
	public void modificaRecensione(Recensione r, String titolo, String testo){
		r.settitolo(titolo);
		r.setTesto(testo);
	}
	
	/**
	 * Invia un messaggio nel'apposita struttura dati
	 * @param mittente mittente del messaggio
	 * @param destinatario destinatario del messaggio
	 * @param titolo titolo del messaggio
	 * @param testo testo del messaggio
	 * @return boolean per conferma dell'avvenuto invio
	 */
	public boolean inviaMessaggio(Utente mittente, Utente destinatario, String titolo, String testo){
		Messaggio mex = new Messaggio(titolo, testo, mittente, destinatario);
		for(Utente u: utenti){
			if(u.getEmail().equals(destinatario.getEmail())){
				messaggi.add(mex);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Ritorna i messaggi associati all'utente loggato al sistema
	 * @param utente utente loggato al sistema
	 * @return messaggitrovati messaggi associati all'utente loggato
	 */
	public List<Messaggio> leggiMessaggi(Utente utente){
		List<Messaggio> messaggitrovati = new ArrayList<>();
		for(Messaggio m: messaggi){
			if(m.getDestinatario().getEmail().equals(utente.getEmail())){
				messaggitrovati.add(m);
			}
		}
		return messaggitrovati;
	}
	
}