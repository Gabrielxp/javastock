package javastock.produto;


import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * Created by fernando on 6/17/16.
 */
public class ProdutoDAOTest extends TestCase {

    @Test
    @Ignore
    public void testeSalvar() {
        Produto p1 = new Produto("Skol", "Cerveja", "Bebidas", "Matheus", (float) 3.00, 100, 2, 20);
        int salvar = ProdutoDAO.getInstancia().salvar(p1);
        boolean sucesso = salvar > 0;
        assertEquals(true, sucesso);
    }

    @Test
    @Ignore
    public void testeListar() {
        List<Produto> lista = ProdutoDAO.getInstancia().listar();
        assertNotNull(lista);
    }

}