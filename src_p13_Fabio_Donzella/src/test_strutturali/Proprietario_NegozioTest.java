package test_strutturali;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import gestione_spesa.Acquirente;
import gestione_spesa.Negozio;
import gestione_spesa.Proprietario_Negozio;
import gestione_spesa.Sistema;

public class Proprietario_NegozioTest {
	private static Sistema s = null;
	private static Acquirente a1 = null;
	private static Proprietario_Negozio p1 = null;
	private static Negozio n = null;

	@BeforeClass
	public static void init() {
		s = new Sistema("Sistema gestione spesa");
		a1 = new Acquirente("Nome", "Cognome", 
				"Indirizzo", new Date(), "codiceFiscale", "0123456", 
				"fabiod@email.it", "pass", s, "banca");
		p1 = new Proprietario_Negozio("Mario", "Rossi", 
				"Strada di Rossi", new Date(), "RSSMRSCAW", "17238132", 
				"marior@email.it", "Rossi_Rule", s, "1723861cas", "182639163");
		s.getAcquirenti().add(a1);
		n = new Negozio("n3", "conad", "alimentari", 
				p1);
	}
	

	@Test
	public void testpartitaiva() {
		String partitaiva="partitaiva";
		p1.setpartitaiva(partitaiva);
		assertEquals("La partita iva deve corrispondere ", partitaiva, 
				p1.getpartitaiva());
	}
	

	@Test
	public void testiban() {
		String iban="iban";
		p1.setiban(iban);
		assertEquals("L'iban deve corrispondere ", iban, 
				p1.getiban());
	}
}
