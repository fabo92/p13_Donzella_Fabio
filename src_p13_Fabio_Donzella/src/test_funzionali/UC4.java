package test_funzionali;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import gestione_spesa.Proprietario_Negozio;
import gestione_spesa.Sistema;
import gestione_spesa.Negozio;
import gestione_spesa.Prodotto;

public class UC2 {
	private static Sistema s = null;
	private static Proprietario_Negozio p1 = null;
	private static Prodotto prodotto = null;
	private static Negozio negozio = null;
	
	@BeforeClass
	public static void init() {
		s = new Sistema("Sistema gestionespesa");
		p1 = new Proprietario_Negozio("nomeprova", "cognomeprova", 
				"prova road", new Date(), "aihscau", "asuhcaw", 
				"prova", "prova", s, "12873cu", "81623612");
		s.getProprietari().add(p1);
		
		negozio = new Negozio("n3", "conad", 
				"alimentari", p1);
		s.getNegozi().add(negozio);
		
		prodotto = new Prodotto("Pera", "Peranda", "alimentari",
				7, 1200, negozio);
		negozio.addProduct(prodotto);
	}
	
	@Test
	public void testRicercaProdottoOK(){
		String prodotto = "Pera";
		List<Prodotto> prodotti = (s.ricercaProdotto(prodotto));
		assertTrue("La dimensione di prodotti deve "
				+ "essere !=0", prodotti.size()!=0);
	}
	
	@Test
	public void testRicercaProdottoWrong(){
		String prodotto = "Mela";
		List<Prodotto> prodotti = (s.ricercaProdotto(prodotto));
		assertTrue("La dimensione di prodotti deve "
				+ "essere ==0", prodotti.size()==0);
	}
}
