package gestione_spesa;

import java.util.Date;

public class Utente {
	/** Nome della persona */
    private String nome;
    
    /** Cognome della persona */
    private String cognome;
    
    /** Indirizzo della persona */
    private String indirizzo;
    
    /** Data di nascita della persona */
    private Date dataNascita;
    
    /** Codice Fiscale della persona */
    private String codiceFiscale;
    
    /** Numero di telefono della persona */
    private String telefono;
    
    /** Email della persona, usata per il login */
    private String email;
    
    /** Password della persona, usata per il login */
    private String password;
    
    /** Associazione fra utente e sistema */
    private Sistema sistema;
    
    /**
	 * Costruttore di Persona.
	 *
	 * @param nome il nome della persona
	 * @param cognome il cognome della persona
	 * @param indirizzo l'indirizzo della persona
	 * @param dataNascita la data di nascita della persona
	 * @param codiceFiscale il codice fiscale della persona
	 * @param telefono il numero di telefono della persona
	 * @param email l'indirizzo email della persona
	 * @param password la password della persona
	 * @param sistema sistema associato alla persona
	 */
	public Utente(String nome, String cognome, String indirizzo, 
			Date dataNascita, String codiceFiscale, String telefono, 
			String email, String password, Sistema sistema) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.dataNascita = dataNascita;
		this.codiceFiscale = codiceFiscale;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
		this.sistema = sistema;
	} 
    
	
	/**
	 * Sets nome utente
	 * @param nome
	 */
	public void setNomeUtente(String nome){
		this.nome = nome;
	}
	
	/**
	 * Gets nome Utente
	 * @return nome
	 */
	public String getNomeUtente() {
		return nome;
	}
	
	/**
	 * Sets cognome utente
	 * @param nome
	 */
	public void setcognomeUtente(String cognome){
		this.cognome = cognome;
	}
	
	/**
	 * Gets cognome Utente
	 * @return cognome
	 */
	public String getCognomeUtente() {
		return cognome;
	}
    
	/**
	 * Sets email/username utente
	 * @param email
	 */
	public void setEmailUtente(String email){
		this.email = email;
	}
	
	/**
	 * Gets email/username Utente
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets password utente
	 * @param password
	 */
	public void setPasswordUtente(String password){
		this.password = password;
	}
	
	/**
	 * Gets password Utente
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	
	
}

