package test_strutturali;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import gestione_spesa.Sistema;
import gestione_spesa.Utente;

public class UtenteTest {
	private static Sistema s = null;
	private static Utente u = null;
	
	@BeforeClass
	public static void init() {
		s = new Sistema("Sistema gestione spesa");
		u = new Utente("Mario", "Rossi", 
				"Strada di Rossi", new Date(), "RSSMRSCAW", "17238132", 
				"marior@email.it", "Rossi_Rule", s);
	}
	
	@Test
	public void testNome() {
		String nome = "Luigi";
		u.setNomeUtente(nome);
		assertEquals("Il nome dell'utente dev'essere ", nome, 
				u.getNomeUtente());
	}
	
	@Test
	public void testCognome() {
		String cognome = "Verdi";
		u.setcognomeUtente(cognome);
		assertEquals("Il cognome dell'utente dev'essere ", cognome, 
				u.getCognomeUtente());
	}
	
	@Test
	public void testemail() {
		String email = "luigimail";
		u.setEmailUtente(email);
		assertEquals("L'email dell'utente dev'essere ", email, 
				u.getEmail());
	}
	
	@Test
	public void testpassword() {
		String password = "luigipassword";
		u.setPasswordUtente(password);
		assertEquals("La password dell'utente dev'essere ", password, 
				u.getPassword());
	}
}
