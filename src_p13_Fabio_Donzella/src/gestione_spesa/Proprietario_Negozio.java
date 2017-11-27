package gestione_spesa;

import java.util.Date;

/**
 * Classe Proprietario_Negozio sottoclasse di Utente
 * @author Fabio Donzella
 *
 */
public class Proprietario_Negozio extends Utente{
	
	/** Partita iva del proprietario*/
	private String partitaiva;
	
	/** iban del proprietario*/
	private String iban;
	
	
	/**
	 * Costruttore di Proprietario_Negozio, richiama il costruttore di Utente
	 * @param nome nome Proprietario
	 * @param cognome cognome Proprietario
	 * @param indirizzo indirizzo Proprietario
	 * @param dataNascita data di nascita del Proprietario
	 * @param codiceFiscale codice fiscale del Proprietario
	 * @param telefono numero di telefono del proprietario
	 * @param email email del proprietario
	 * @param password password del proprietario
	 * @param sistema sistema associato al proprietario
	 * @param partitaiva partita iva del proprietario
	 * @param iban iban del proprietario
	 */
	public Proprietario_Negozio(String nome, String cognome, String indirizzo, 
    		Date dataNascita, String codiceFiscale, String telefono, 
    		String email, String password, Sistema sistema, String partitaiva, String iban) {
		super(nome, cognome, indirizzo, dataNascita, codiceFiscale, 
				telefono, email, password, sistema);
		
	}
	
	/**
	 * Gets partita iva del Proprietario
	 * @return partitaiva
	 */
	public String getpartitaiva() {
		return partitaiva;
	}
	
	/** Sets partita iva
	 * @param partiva
	 */
	public void setpartitaiva(String partiva) {
		this.partitaiva = partiva;
	}
	
	/**
	 * Gets iban del Proprietario
	 * @return iban
	 */
	public String getiban() {
		return iban;
	}
	
	/** Sets iban
	 * @param iban
	 */
	public void setiban(String iban) {
		this.iban = iban;
	}
}