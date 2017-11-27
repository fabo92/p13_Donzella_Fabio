package gestione_spesa;

/**
 * Classe Messaggio
 * @author fabio
 */
public class Messaggio {

	/**	Titolo Messaggio*/
	private String titolo;
	
	/** Testo del messaggio */
	private String testo;
	
	/** Nome autore del Messaggio*/
	private Utente mittente;
	
	/** Oggetto Negozio associato alla recensione*/
	private Utente destinatario;
	
	public Messaggio(String titolo, String testo, Utente mittente, Utente destinatario) {
		super();
		this.titolo = titolo;
		this.testo = testo;
		this.mittente = mittente;
		this.destinatario = destinatario;
	}
	/**
	 * Gets nome dell'autore
	 * @return nomeAutore
	 */
	public Utente getDestinatario() {
		return destinatario;
	}
	
}
