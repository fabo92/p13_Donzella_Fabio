package test_strutturali;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import gestione_spesa.Acquirente;
import gestione_spesa.Negozio;
import gestione_spesa.Prodotto;
import gestione_spesa.Proprietario_Negozio;
import gestione_spesa.Recensione;
import gestione_spesa.Sistema;

public class RecensioneTest {
	private static Sistema s = null;
	private static Acquirente a1 = null;
	private static Proprietario_Negozio p1 = null;
	private static Negozio n = null;
	private static Recensione r = null;
	private static Prodotto p = null;

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
		r = new Recensione("titrec", "Negozio scadente", "fabiod@email.it", null, null);
		p = new Prodotto("Mela", "Melinda", "alimentari", 5, 1000,
				n);
	}
	
	@Test
	public void testNegozio() {
		r.setNegozio(n);
		assertEquals("Il negozio della recensione deve essere ", n, 
				r.getNegozio());
	}
	
	@Test
	public void testProdotto() {
		r.setProdotto(p);
		assertEquals("Il prodotto della recensione deve essere ", p, 
				r.getProdotto());
	}
	
	@Test
	public void testAutore() {
		String scritrec= "scrittoredirecensioni";
		r.setAutore(scritrec);
		assertEquals("L'autore della recensione deve essere ", scritrec, 
				r.getAutore());
	}
	
	@Test
	public void testTitolo() {
		String titolo= "titolo";
		r.settitolo(titolo);
		assertEquals("Il titolo della recensione deve essere ", titolo, 
				r.getTitolo());
	}
	
	@Test
	public void testTesto() {
		String testo= "testo";
		r.setTesto(testo);
		assertEquals("Il titolo della recensione deve essere ", testo, 
				r.getTesto());
	}
}
