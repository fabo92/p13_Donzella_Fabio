package test_strutturali;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import gestione_spesa.Acquirente;
import gestione_spesa.Negozio;
import gestione_spesa.Ordine;
import gestione_spesa.Prodotto;
import gestione_spesa.Proprietario_Negozio;
import gestione_spesa.Sistema;

public class OrdineTest {

	private static Sistema s = null;
	private static Proprietario_Negozio p1 = null;
	private static Acquirente a1 = null;
	private static Negozio n = null;
	private static Date data = null;
	private static List<Prodotto> prodotti = new ArrayList<>();
	
	@BeforeClass
	public static void init() {
		s = new Sistema("Sistema gestione spesa");
		data = new Date();
		a1 = new Acquirente("Nome", "Cognome", 
				"Indirizzo", new Date(), "codiceFiscale", "0123456", 
				"fabiod@email.it", "pass", s, "banca");
		p1 = new Proprietario_Negozio("Mario", "Rossi", 
				"Strada di Rossi", new Date(), "RSSMRSCAW", "17238132", 
				"marior@email.it", "Rossi_Rule", s, "1723861cas", "182639163");
		n = new Negozio("n3", "conad", "alimentari", 
				p1);
		s.aggiungiNegozio(n, p1);
		Prodotto mela = new Prodotto("Mela", "Melinda", "alimentari", 5, 1000,
				n);
		n.addProduct(mela);
		
	}
	
	@Test
	public void testOrdine() {
		Prodotto pera = new Prodotto("Pera", "Peranda", "alimentari", 7, 1200,
				n);
		prodotti.add(pera);
		Ordine o = new Ordine(prodotti, a1, data);
		o.setOrdine(prodotti);
		assertEquals("La grandezza deve essere uguale ", prodotti.size(), 
				o.getProdotti().size());
	}
	
	@Test
	public void testGetData() {
		Prodotto pera = new Prodotto("Pera", "Peranda", "alimentari", 7, 1200,
				n);
		prodotti.add(pera);
		Ordine o = new Ordine(prodotti, a1, data);
		assertEquals("La data deve corrispondere ", data, 
				o.getDate());
	}
	
	@Test
	public void testGetAcquirente() {
		Prodotto pera = new Prodotto("Pera", "Peranda", "alimentari", 7, 1200,
				n);
		prodotti.add(pera);
		Ordine o = new Ordine(prodotti, a1, data);
		assertEquals("L'acquirente deve corrispondere ", a1, 
				o.getAcquirente());
	}
}
