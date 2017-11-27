package test_funzionali;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import gestione_spesa.Sistema;
import gestione_spesa.Utente;

public class UC8 {
	private static Sistema s = null;
	private static Utente u1 = null;
	
	@BeforeClass
	public static void init() {
		s = new Sistema("Sistema gestionespesa");
		u1 = new Utente("Fabio", "Donzella", 
				"indirizzo", new Date(), "codfisc", "0123456", 
				"fabiod@email.it", "pass", s);
		s.getUtenti().add(u1);
	}
	
	@Test
	public void testRicercaOK1() {
		String username = "Fabio";
		List<Utente> utenti = s.ricercaUtente(username);
		assertEquals("La dimensione di utenti deve corrispondere", utenti.size(), 1);
	}

	@Test
	public void testRicercaOK2() {
		String username = "Donzella";
		List<Utente> utenti = s.ricercaUtente(username);
		assertEquals("La dimensione di utenti deve corrispondere", utenti.size(), 1);
	}
	
	@Test
	public void testRicercaOK3() {
		String username = "fabiod@email.it";
		List<Utente> utenti = s.ricercaUtente(username);
		assertEquals("La dimensione di utenti deve corrispondere", utenti.size(), 1);
	}
	
	@Test
	public void testRicercaWrong() {
		String username = "Mario";
		List<Utente> utenti = s.ricercaUtente(username);
		assertEquals("La dimensione di utenti deve corrispondere", utenti.size(), 0);
	}
	
}
