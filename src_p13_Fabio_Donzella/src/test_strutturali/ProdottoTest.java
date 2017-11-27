package test_strutturali;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import gestione_spesa.Negozio;
import gestione_spesa.Prodotto;
import gestione_spesa.Proprietario_Negozio;
import gestione_spesa.Sistema;

public class ProdottoTest {

	private static Sistema s = null;
	private static Proprietario_Negozio p1 = null;
	private static Negozio n = null;
	private static Negozio n2 = null;
	private static Prodotto mela = null;
	
	@BeforeClass
	public static void init() {
		s = new Sistema("Sistema gestione spesa");
		p1 = new Proprietario_Negozio("Mario", "Rossi", 
				"Strada di Rossi", new Date(), "RSSMRSCAW", "17238132", 
				"marior@email.it", "Rossi_Rule", s, "1723861cas", "182639163");
		n = new Negozio("n3", "conad", "alimentari", 
				p1);
		s.aggiungiNegozio(n, p1);
		mela = new Prodotto("Mela", "Melinda", "alimentari", 5, 1000,
				n);
		n.addProduct(mela);
		
	}
	
	@Test
	public void testGetNomeProdotto() {
		mela.setNome("mela");
		assertEquals("Il nome del prodotto deve essere ", "mela", 
				mela.getNome());
	}
	
	@Test
	public void testGetNegozio() {
		n2 = new Negozio("n4", "coop", "alimentari", 
				p1);
		mela.setNegozio(n2);
		assertEquals("Il negozio deve essere ", n2, 
				mela.getNegozio());
	}
}
