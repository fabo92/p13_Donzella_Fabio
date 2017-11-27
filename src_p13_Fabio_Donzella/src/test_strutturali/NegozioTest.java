package test_strutturali;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import gestione_spesa.Negozio;
import gestione_spesa.Prodotto;
import gestione_spesa.Proprietario_Negozio;
import gestione_spesa.Sistema;

public class NegozioTest {
	private static Sistema s = null;
	private static Proprietario_Negozio p1 = null;
	private static Negozio n = null;
	
	@BeforeClass
	public static void init() {
		s = new Sistema("Sistema gestione spesa");
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
	public void testAddProdottotoNegozio() {
		Prodotto pera = new Prodotto("Pera", "Peranda", "alimentari", 7, 1200,
				n);
		n.addProduct(pera);
		assertEquals("Il nome del negozio deve essere ", pera, 
				n.getProdotti().get(n.getProdotti().size()-1));
	}
	
	@Test
	public void testAddProdottotoNegozio2() {
		boolean ok;
		Prodotto mela2 = new Prodotto("Mela", "Melinda", "alimentari", 5, 1000,
				n);
		ok = n.addProduct(mela2);
		assertTrue("Il prodotto e' gia presente nel negozio", ok);
	}
	
	@Test
	public void testNomeNegozio() {
		String nomenegozio="frutta";
		n.setNome(nomenegozio);
		assertEquals("Il nome del negozio deve essere ", nomenegozio, 
				n.getNome());
		
	}
	
	@Test
	public void testProprietarioNegozio() {
		Proprietario_Negozio p3 = new Proprietario_Negozio("nomeprova", "cognomeprova", 
				"prova road", new Date(), "aihscau", "asuhcaw", 
				"prova", "prova", s, "12873cu", "81623612");
		n.setProprietario(p3);
		assertEquals("Il proprietario deve essere ", p3, 
				n.getProprietario());
		
	}
	
}
