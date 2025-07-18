/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Telas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hugo
 */
public class CadastrarFuncionarioTest {
    private CadastrarFuncionario cadastrarFuncionario;
    public CadastrarFuncionarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        cadastrarFuncionario = new CadastrarFuncionario();
        cadastrarFuncionario.getTxtNom().setText("Emma");
        cadastrarFuncionario.getTxtSen().setText("258");
        cadastrarFuncionario.getTxtEma().setText("Emma@email.com");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCadastroFuncionarioNomeVazio() {
        cadastrarFuncionario.getTxtNom().setText("");
        cadastrarFuncionario.CadastrarFuncionarioBD();
        
    }
    @Test
    public void testCadastroFuncionarioSenhaVazio() {
        cadastrarFuncionario.getTxtSen().setText("");
        cadastrarFuncionario.CadastrarFuncionarioBD();
        
    }
    @Test
    public void testCadastroFuncionarioEmailVazio() {
        cadastrarFuncionario.getTxtEma().setText("");
        cadastrarFuncionario.CadastrarFuncionarioBD();
        
    }
    
}
