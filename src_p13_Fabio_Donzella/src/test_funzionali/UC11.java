package test_funzionali;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import gestione_spesa.Acquirente;
import gestione_spesa.Negozio;
import gestione_spesa.Prodotto;
import gestione_spesa.Proprietario_Negozio;
import gestione_spesa.Sistema;

public class UC11 {

	private static Sistema s = null;
	private static Proprietario_Negozio p1 = null;
	private static Acquirente a1 = null;
	private static Prodotto prodotto = null;
	private static Negozio negozio = null;
	
	@BeforeClass
	public static void init() {
		s = new Sistema("Sistema gestionespesa");
		
		p1 = new Proprietario_Negozio("nomeprova", "cognomeprova", 
				"prova road", new Date(), "aihscau", "asuhcaw", 
				"prova", "prova", s, "12873cu", "81623612");
		s.inserisciProprietario(p1);
		s.getUtenti().add(p1);
		
		a1 = new Acquirente("Nome2", "Cognome2", 
				"Indirizzo2", new Date(), "codiceFiscale2", "01234562", 
				"email@a1.it", "pass2", s, 
				"metododipagamento");
		s.inserisciAcquirente(a1);
		
		negozio = new Negozio("n3", "conad", 
				"alimentari", p1);
		s.aggiungiNegozio(negozio, p1);
		s.aggiungiNegozio(negozio, p1);
		prodotto = new Prodotto("Pera", "Peranda", "alimentari",
				7, 1200, negozio);
		
		s.aggiungiProdotto(prodotto, p1, negozio);
		s.aggiungiProdotto(prodotto, p1, negozio);
	}
	
	@Test
	public void testOrdineOK(){
		s.addProdottotoLista(a1, prodotto);
		assertTrue("Deve tornare true ", 
				s.effettuaOrdine(a1.getEmail()));
	}
	
	@Test
	public void testOrdineWrong1(){
		assertEquals("Lista spesa vuota ", 
				s.effettuaOrdine(a1.getEmail()), false);
	}
	
	@Test
	public void testOrdineEmailWrong2(){
		String temp = "bubu";
		assertEquals("Email non corretta ", 
				s.effettuaOrdine(temp), false);
	}
}
