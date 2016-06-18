package javastock.pessoa.cliente;

import javastock.misc.Endereco;
import org.junit.Test;

/**
 * Created by fernando on 6/18/16.
 */
public class ClienteDAOTest {
    @Test
    public void testeSalvar() {
        Endereco e1 = new Endereco("Rua Centro", 666, "Arraial", "Dois vizinhos", "PR", "85660-000");
        Cliente c1 = new Cliente("Rui barbosa", "213.434.324-34", "23.434.343", "rui@gmail.com", e1, 1);
        ClienteDAO.getInstancia().salvar(c1);
    }

}