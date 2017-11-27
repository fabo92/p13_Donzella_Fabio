package test_funzionali;

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

public class UC21 {
	
	private static Sistema s = null;
	private static Proprietario_Negozio p1 = null;
	private static Acquirente a1 = null;
	private static Prodotto prodotto = null;
	private static Negozio negozio = null;
	private static Recensione rec = null;
	
	@BeforeClass
	public static void init() {
		s = new Sistema("Sistema gestionespesa");
		
		p1 = new Proprietario_Negozio("nomeprova", "cognomeprova", 
				"prova road", new Date(), "aihscau", "asuhcaw", 
				"prova", "prova", s, "12873cu", "81623612");
		s.inserisciProprietario(p1);
		s.getUtenti().add(p1);
		
		negozio = new Negozio("n3", "conad", 
				"alimentari", p1);
		s.aggiungiNegozio(negozio, p1);
	}
	
	@Test
	public void testModificaRecensione(){
		String newtitolo = "Nuovotitolo";
		rec = new Recensione("titrec", "Negozio scadente", "fabiod@email.it", null, null);
		s.modificaRecensione(rec, newtitolo, "Nuovo testo della rec");
		assertEquals("Email non corretta ", 
				rec.getTitolo(), newtitolo);
	}
}
