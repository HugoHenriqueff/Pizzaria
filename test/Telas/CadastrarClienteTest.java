package Telas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class CadastrarClienteTest {
    private CadastrarCliente cadastrarCliente;
    public CadastrarClienteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        cadastrarCliente = new CadastrarCliente();
        cadastrarCliente.getTxtEma().setText("Emma@email.com");    
        cadastrarCliente.getTxtNom().setText("Emma");
    }
    
    @After
    public void tearDown() {
    }   
    @Test
    public void testCadastrarClienteEmaVazio(){
        cadastrarCliente.getTxtEma().setText("");
        cadastrarCliente.CadastrarClienteBD();
    }
    @Test
    public void testCadastrarClienteNomVazio(){
       cadastrarCliente.getTxtNom().setText(""); 
       cadastrarCliente.CadastrarClienteBD();
    }
    
}
