package test_strutturali;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import gestione_spesa.Acquirente;
import gestione_spesa.Negozio;
import gestione_spesa.Proprietario_Negozio;
import gestione_spesa.Sistema;
import gestione_spesa.Utente;
import gestione_spesa.Messaggio;

public class MessaggioTest {
	private static Sistema s = null;
	private static Utente u1 = null;
	private static Utente u2 = null;
	private static Messaggio m = null;
	
	@BeforeClass
	public static void init() {
		s = new Sistema("Sistema gestione spesa");
		u1 = new Acquirente("Nome", "Cognome", 
				"Indirizzo", new Date(), "codiceFiscale", "0123456", 
				"fabiod@email.it", "pass", s, "banca");
		u2 = new Proprietario_Negozio("Mario", "Rossi", 
				"Strada di Rossi", new Date(), "RSSMRSCAW", "17238132", 
				"marior@email.it", "Rossi_Rule", s, "1723861cas", "182639163");
		s.getUtenti().add(u1);
		s.getUtenti().add(u2);
	}
	
	@Test
	public void testDestinatarioMessaggio() {
		m = new Messaggio("Importante", "Ciao Mario, come stai?", u1, u2);
		assertEquals("Il destinatario deve essere ", u2, 
				m.getDestinatario());
		
	}
}
