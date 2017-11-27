package test_strutturali;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import gestione_spesa.Proprietario_Negozio;
import gestione_spesa.Recensione;
import gestione_spesa.Sistema;
import gestione_spesa.Utente;
import gestione_spesa.Acquirente;
import gestione_spesa.Messaggio;
import gestione_spesa.Negozio;
import gestione_spesa.Prodotto;

public class SistemaTest {
	private static Sistema s = null;
	private static Proprietario_Negozio p1 = null;
	private static Proprietario_Negozio p2 = null;
	private static Acquirente a1 = null;
	private static Acquirente a2 = null;
	private static Prodotto prodotto = null;
	private static Negozio negozio = null;
	private static Utente u1 = null;
	private static Utente u2 = null;
	private static Messaggio mex = null;
	private static Recensione rec = null;
	private static List<Negozio> neg = null;
	private static List<Proprietario_Negozio> prop = null;
	private static List<Acquirente> acq = null;
	
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
	public void testRicercaProdottoOK(){
		String prodotto = "Pera";
		List<Prodotto> prodotti = (s.ricercaProdotto(prodotto));
		assertEquals("La List utenti deve corrispondere ", 
				prodotti, s.ricercaProdotto(prodotto));
	}
	
	@Test
	public void testRicercaProdottoWrong(){
		String prodotto = "Mela";
		List<Prodotto> prodotti = (s.ricercaProdotto(prodotto));
		assertEquals("La List utenti deve corrispondere ", 
				prodotti, s.ricercaProdotto(prodotto));
	}
	
	@Test
	public void testRicercaProdottoWrong2(){
		String prod = "Mela";
		p2 = new Proprietario_Negozio("nomeprovaa", "cognomeprovaa", 
				"prova roada", new Date(), "aihscauw", "asuhccaw", 
				"provaa", "provaa", s, "12873cu", "81623612");
		s.aggiungiProdotto(prodotto, p2, negozio);
		s.aggiungiProdotto(prodotto, p2, negozio);
		List<Prodotto> prodotti = (s.ricercaProdotto(prod));
		assertEquals("La List utenti deve corrispondere ", 
				prodotti, s.ricercaProdotto(prod));
	}

	@Test
	public void testRicercaOK1() {
		String username = "Fabio";
		List<Utente> utenti = s.ricercaUtente(username);
		assertEquals("La List utenti deve corrispondere ", 
				utenti, s.ricercaUtente(username));
	}

	@Test
	public void testRicercaOK2() {
		String username = "Donzella";
		List<Utente> utenti = s.ricercaUtente(username);
		assertEquals("La List utenti deve corrispondere ", 
				utenti, s.ricercaUtente(username));
	}
	
	@Test
	public void testRicercaOK3() {
		String username = "fabiod@email.it";
		List<Utente> utenti = s.ricercaUtente(username);
		assertEquals("La List utenti deve corrispondere ", 
				utenti, s.ricercaUtente(username));
	}
	
	@Test
	public void testRicercaWrong() {
		String username = "Mario";
		List<Utente> utenti = s.ricercaUtente(username);
		assertEquals("La List utenti deve corrispondere ", 
				utenti, s.ricercaUtente(username));
	}
	
	@Test
	public void testMessaggi(){
		u1 = new Utente("Fabio", "Donzella", 
				"indirizzo", new Date(), "codfisc", "0123456", 
				"fabiod@email.it", "pass", s);
		s.getUtenti().add(u1);
		u2 = new Utente("Mario", "Rossi", 
				"indirizzo", new Date(), "codfisc", "0123456", 
				"marior@email.it", "pass", s);
		s.getUtenti().add(u2);
		s.inviaMessaggio(u1, u2, "Ciao mario", "Questa e una prova");
		List<Messaggio> tempmex = s.leggiMessaggi(u2);
		assertEquals("La List messaggi deve corrispondere ", 
				tempmex, s.leggiMessaggi(u2));
	}
	
	@Test
	public void testMessaggi2(){
		u1 = new Utente("Fabio", "Donzella", 
				"indirizzo", new Date(), "codfisc", "0123456", 
				"fabiod@email.it", "pass", s);
		s.getUtenti().add(u1);
		u2 = new Utente("Mario", "Rossi", 
				"indirizzo", new Date(), "codfisc", "0123456", 
				"marior@email.it", "pass", s);
		s.inviaMessaggio(u1, u2, "Ciao mario", "Questa e una prova");
		List<Messaggio> tempmex = s.leggiMessaggi(u2);
		assertEquals("La List messaggi size deve corrispondere ", 
				tempmex.size(), 0);
	}
	
	@Test
	public void testMessaggi3(){
		u1 = new Utente("Fabio", "Donzella", 
				"indirizzo", new Date(), "codfisc", "0123456", 
				"fabiod@email.it", "pass", s);
		u2 = new Utente("Mario", "Rossi", 
				"indirizzo", new Date(), "codfisc", "0123456", 
				"marior@email.it", "pass", s);
		s.inviaMessaggio(u1, u2, "Ciao mario", "Questa e una prova");
		List<Messaggio> tempmex = s.leggiMessaggi(p1);
		assertEquals("La List messaggi size deve corrispondere ", 
				tempmex.size(), 0);
	}
	
	@Test
	public void testMessaggi4(){
		u1 = new Utente("Fabio", "Donzella", 
				"indirizzo", new Date(), "codfisc", "0123456", 
				"fabiod@email.it", "pass", s);
		s.inviaMessaggio(u2, u1, "Ciao mario", "Questa e una prova");
		List<Messaggio> tempmex = s.leggiMessaggi(u1);
		assertEquals("La List messaggi size deve corrispondere ", 
				tempmex.size(), 1);
	}
	
	@Test
	public void testOrdineOK(){
		s.addProdottotoLista(a1, prodotto);
		assertTrue("Deve tornare true ", 
				s.effettuaOrdine(a1.getEmail()));
	}
	
	@Test
	public void testOrdineWrong1(){
		assertEquals("Lista spesa vuota", s.effettuaOrdine(a1.getEmail()), false);
	}
	
	@Test
	public void testOrdineEmailWrong2(){
		String temp = "bubu";
		assertEquals("Lista spesa vuota", s.effettuaOrdine(temp), false);
	}
	

	@Test
	public void testModificaRecensione(){
		String newtitolo = "Nuovotitolo";
		rec = new Recensione("titrec", "Negozio scadente", "fabiod@email.it", null, null);
		s.modificaRecensione(rec, newtitolo, "Nuovo testo della rec");
		assertEquals("Email non corretta ", 
				rec.getTitolo(), newtitolo);
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
	
	@Test
	public void testNegozi() {
		neg = new ArrayList<>();
		neg.add(negozio);
		assertEquals("I negozi devono corrispondere", neg, 
				s.getNegozi());
	}
	
	@Test
	public void testAcquirenti() {
		acq = new ArrayList<>();
		acq.add(a1);
		assertEquals("Gli acquirenti devono corrispondere", acq, 
				s.getAcquirenti());
	}
	
	@Test
	public void testProprietari() {
		prop = new ArrayList<>();
		prop.add(p1);
		assertEquals("I Proprietari Negozi devono corrispondere", prop, 
				s.getProprietari());
	}
	
	@Test
	public void testProprietarioOK() {
		String prova = "prova"; //email di p1
		assertEquals("I Proprietari Negozi devono corrispondere", p1, 
				s.getProprietario(prova));
	}
	
	@Test
	public void testProprietarioWrong() {
		String prova = "pasichiashc"; //email di p1
		assertNotEquals("I Proprietari Negozi non devono corrispondere", p1, 
				s.getProprietario(prova));
	}
	
	@Test
	public void testAcquirenteOK() {
		String prova = "email@a1.it"; //email di p1
		assertEquals("Gli acquirenti devono corrispondere", a1, 
				s.getAcquirente(prova));
	}
	
	@Test
	public void testAcquirenteWrong() {
		String prova = "alshciaohca"; //email di a1
		assertNotEquals("Gli acquirenti non devono corrispondere", a1, 
				s.getAcquirente(prova));
	}
}
