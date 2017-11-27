package test_strutturali;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import gestione_spesa.Acquirente;
import gestione_spesa.Proprietario_Negozio;
import gestione_spesa.Sistema;
import gestione_spesa.Utente;

@RunWith(Parameterized.class)

public class SistemaTestLogin {
	private static Sistema sistema = null;
	private static Utente u1 = null;
	private static Acquirente a1 = null;
	private static Proprietario_Negozio p1 = null;
	
	@Parameters
	public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"email@p1.it","pass1",true},
            {"email@a1.it","pass2",true},
            {"email@p1.it","pass",false},
            {"NO@U1.it","pass2",false},
            {"email@a1.it","pass3",false},
        });
	}
	
	@Parameter(0)
	public String user;
	
	@Parameter(1)
	public String pass;
	
	@Parameter(2)
	public boolean check;
	
	@BeforeClass
	public static void init() {
		sistema = new Sistema("Sistema gestione spesa");
		p1 = new Proprietario_Negozio("Nome1", "Cognome1", 
				"Indirizzo1", new Date(), "codiceFiscale1", "01234561", 
				"email@p1.it", "pass1", sistema, "partitaiva", "iban");
		a1 = new Acquirente("Nome2", "Cognome2", 
				"Indirizzo2", new Date(), "codiceFiscale2", "01234562", 
				"email@a1.it", "pass2", sistema, 
				"metododipagamento");
		sistema.inserisciAcquirente(a1);
		sistema.inserisciProprietario(p1);
		sistema.inserisciAcquirente(a1);
		sistema.inserisciProprietario(p1);
	}

	@Test
	public void testLogin() {
		boolean result;
		if (!sistema.login(user, pass)) {
			result = false;
		} else {
			result = true;
		}
		assertEquals("Il login deve avvenire correttamente", 
				result,check);
	}

	@After
	public void after() {
		sistema = new Sistema("Sistema gestione spesa");
		sistema.inserisciAcquirente(a1);
		sistema.inserisciProprietario(p1);
	}

}