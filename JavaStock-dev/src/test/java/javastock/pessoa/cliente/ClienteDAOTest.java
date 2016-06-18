package javastock.pessoa.cliente;

import javastock.misc.Endereco;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Created by fernando on 6/18/16.
 */
public class ClienteDAOTest extends TestCase{

    @Test
    public void testeSalvar() {
        Endereco e1 = new Endereco("Rua Centro", 666, "Arraial", "Dois vizinhos", "PR", "85660-000");
        Cliente c1 = new Cliente("Rui barbosa", "213.434.324-34", "23.434.343", "rui@gmail.com", e1, 1);
        int salvar =  ClienteDAO.getInstancia().salvar(c1);
        boolean sucesso = salvar > 0;
        assertEquals(true, sucesso);
    }

    @Test
    public void testeListar() {
        List<Cliente> lista = ClienteDAO.getInstancia().listar();
        assertNotNull(lista);
    }

/*    public void testeAtualizar() {
        Cliente p = ClienteDAO.getInstancia().getById(1);
        p.setNome("Djalma");
        ClienteDAO.getInstancia().salvar(p);

        p = ClienteDAO.getInstancia().getById(1);
        assertEquals(p.getNome(), "Djalma");
    }*/
}
