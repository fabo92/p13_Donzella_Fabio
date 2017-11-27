package test_funzionali;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import gestione_spesa.Sistema;
import gestione_spesa.Utente;

public class UC2 {
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
	public void testLoginCorretto() {
		String username = "fabiod@email.it";
		String pass = "pass";
		boolean login;
		login = s.login(username, pass);
		assertTrue("L'username e la password devono essere "
				+ "corretti", login);
	}

	@Test
	public void testLoginUserErrato() {
		String username = "bcajbcas@csaj.it";
		String pass = "pass";
		assertEquals("L'username deve essere errato ", s.login(username,pass), false);
	}
	
	@Test
	public void testLoginPassErrata() {
		String username = "fabiod@email.it";
		String pass = "password";
		assertEquals("La password deve essere errata ", s.login(username,pass), false);
	}
}
