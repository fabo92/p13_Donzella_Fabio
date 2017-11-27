package test_strutturali;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({AcquirenteTest.class, MessaggioTest.class, 
	NegozioTest.class, OrdineTest.class, ProdottoTest.class, 
	Proprietario_NegozioTest.class, RecensioneTest.class, SistemaTest.class,
	SistemaTestLogin.class, UtenteTest.class })

@RunWith(Suite.class)
public class TestSuite {

}
