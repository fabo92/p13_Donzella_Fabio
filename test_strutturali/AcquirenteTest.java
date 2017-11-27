package test_strutturali;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import gestione_spesa.Sistema;
import gestione_spesa.Acquirente;
import gestione_spesa.Negozio;
import gestione_spesa.Prodotto;
import gestione_spesa.Proprietario_Negozio;

public class AcquirenteTest {
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
	public void testMetododiPagamento() {
		String metododipagamento="banca";
		a1.setMetododipagamento(metododipagamento);
		assertEquals("Il metodo di pagamento deve deve essere ", "banca", 
				a1.getMetododipagamento());
		
	}

	@Test
	public void testAddProdottotoListaspesa() {
		Prodotto pera = new Prodotto("Pera", "Peranda", "alimentari", 7, 1200,
				n);
		a1.addProduct(pera);
		assertEquals("L'oggetto preso dalla lista deve essere una ", pera, 
				a1.getLista().get((a1.getLista().size())-1));
		
	}
}