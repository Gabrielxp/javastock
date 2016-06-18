package javastock.produto;


import org.junit.Test;

/**
 * Created by fernando on 6/17/16.
 */
public class ProdutoDAOTest {

       @Test
       public void testeSalvar() {
            Produto p1 = new Produto("Skol", "Cerveja", "Bebidas", "Matheus", (float) 3.00, 100, 2, 20);
            Produto p2 = new Produto("Antartica", "Cerveja", "Bebidas", "Matheus", (float) 4.50, 200, (float) 2.5, 20);
            ProdutoDAO dao = new ProdutoDAO();
            dao.salvar(p1);
            dao.salvar(p2);
       }



}