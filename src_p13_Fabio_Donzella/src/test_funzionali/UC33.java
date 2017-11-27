package test_funzionali;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import gestione_spesa.Acquirente;
import gestione_spesa.Messaggio;
import gestione_spesa.Negozio;
import gestione_spesa.Prodotto;
import gestione_spesa.Proprietario_Negozio;
import gestione_spesa.Sistema;
import gestione_spesa.Utente;

public class UC33 {

	private static Sistema s = null;
	private static Proprietario_Negozio p1 = null;
	private static Acquirente a1 = null;
	private static Prodotto prodotto = null;
	private static Negozio negozio = null;
	private static Utente u1 = null;
	private static Utente u2 = null;
	
	@BeforeClass
	public static void init() {
		s = new Sistema("Sistema gestionespesa");
		
		p1 = new Proprietario_Negozio("nomeprova", "cognomeprova", 
				"prova road", new Date(), "aihscau", "asuhcaw", 
				"prova", "prova", s, "12873cu", "81623612");
		s.inserisciProprietario(p1);
		s.getUtenti().add(p1);
		
		a1 = new Acquirente("Nome2", "Cognome2", 
				"Indirizzo2", new Date(), "codiceFiscale2", "01234562", 
				"email@a1.it", "pass2", s, 
				"metododipagamento");
		s.inserisciAcquirente(a1);
		
		negozio = new Negozio("n3", "conad", 
				"alimentari", p1);
		s.aggiungiNegozio(negozio, p1);
		s.aggiungiNegozio(negozio, p1);
		prodotto = new Prodotto("Pera", "Peranda", "alimentari",
				7, 1200, negozio);
		
		s.aggiungiProdotto(prodotto, p1, negozio);
		s.aggiungiProdotto(prodotto, p1, negozio);
	}
	
	@Test
	public void testMessaggi(){
		u1 = new Utente("Fabio", "Donzella", 
				"indirizzo", new Date(), "codfisc", "0123456", 
				"fabiod@email.it", "pass", s);
		s.getUtenti().add(u1);
		u2 = new Utente("Mario", "Rossi", 
				"indirizzo", new Date(), "codfisc", "0123456", 
				"marior@email.it", "pass", s);
		s.getUtenti().add(u2);
		s.inviaMessaggio(u1, u2, "Ciao mario", "Questa e una prova");
		List<Messaggio> tempmex = s.leggiMessaggi(u2);
		assertEquals("La List messaggi deve corrispondere ", 
				tempmex, s.leggiMessaggi(u2));
	}
	
	@Test
	public void testMessaggi2(){
		u1 = new Utente("Fabio", "Donzella", 
				"indirizzo", new Date(), "codfisc", "0123456", 
				"fabiod@email.it", "pass", s);
		s.getUtenti().add(u1);
		u2 = new Utente("Mario", "Rossi", 
				"indirizzo", new Date(), "codfisc", "0123456", 
				"marior@email.it", "pass", s);
		s.inviaMessaggio(u1, u2, "Ciao mario", "Questa e una prova");
		List<Messaggio> tempmex = s.leggiMessaggi(u2);
		assertEquals("La List messaggi size deve corrispondere ", 
				tempmex.size(), 0);
	}
	
	@Test
	public void testMessaggi3(){
		u1 = new Utente("Fabio", "Donzella", 
				"indirizzo", new Date(), "codfisc", "0123456", 
				"fabiod@email.it", "pass", s);
		u2 = new Utente("Mario", "Rossi", 
				"indirizzo", new Date(), "codfisc", "0123456", 
				"marior@email.it", "pass", s);
		s.inviaMessaggio(u1, u2, "Ciao mario", "Questa e una prova");
		List<Messaggio> tempmex = s.leggiMessaggi(p1);
		assertEquals("La List messaggi size deve corrispondere ", 
				tempmex.size(), 0);
	}
	
	@Test
	public void testMessaggi4(){
		u1 = new Utente("Fabio", "Donzella", 
				"indirizzo", new Date(), "codfisc", "0123456", 
				"fabiod@email.it", "pass", s);
		s.inviaMessaggio(u2, u1, "Ciao mario", "Questa e una prova");
		List<Messaggio> tempmex = s.leggiMessaggi(u1);
		assertEquals("La List messaggi size deve corrispondere ", 
				tempmex.size(), 1);
	}
}
