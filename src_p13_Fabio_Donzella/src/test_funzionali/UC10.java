package test_funzionali;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import gestione_spesa.Acquirente;
import gestione_spesa.Negozio;
import gestione_spesa.Prodotto;
import gestione_spesa.Proprietario_Negozio;
import gestione_spesa.Sistema;

public class UC10 {

	private static Sistema s = null;
	private static Acquirente a2 = null;
	private static Proprietario_Negozio p1 = null;
	private static Negozio negozio = null;
	private static Prodotto prodotto = null;
	
	@BeforeClass
	public static void init() {
		s = new Sistema("Sistema gestionespesa");
		negozio = new Negozio("n3", "conad", 
				"alimentari", p1);
		p1 = new Proprietario_Negozio("nomeprova", "cognomeprova", 
				"prova road", new Date(), "aihscau", "asuhcaw", 
				"prova", "prova", s, "12873cu", "81623612");
		s.aggiungiNegozio(negozio, p1);
		s.aggiungiNegozio(negozio, p1);
		prodotto = new Prodotto("Pera", "Peranda", "alimentari",
				7, 1200, negozio);
		
		s.aggiungiProdotto(prodotto, p1, negozio);
		s.aggiungiProdotto(prodotto, p1, negozio);
	}
	
	@Test
	public void testAggiungiProdottoToLista(){
		a2 = new Acquirente("Nome3", "Cognome3", 
				"Indirizzo3", new Date(), "codiceFiscale3", "01234562", 
				"email@a2.it", "pass3", s, 
				"metododipagamento");
		s.addProdottotoLista(a2, prodotto);
		assertEquals("Lista spesa a2 deve essere vuota ", 
				a2.getLista().size(), 0);
	}
}
