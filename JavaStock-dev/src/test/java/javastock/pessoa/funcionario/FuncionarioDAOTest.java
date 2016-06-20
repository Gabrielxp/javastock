package javastock.pessoa.funcionario;

import javastock.misc.Endereco;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;


/**
 * Created by fernando on 6/17/16.
 */
public class FuncionarioDAOTest extends TestCase {

    @Test
    public void testeSalvar() {
        Endereco e1 = new Endereco("Rua Guilherme Guzzo", 200, "Centro Norte", "Dois vizinhos", "PR", "85660-000");
        Funcionario f1 = new Funcionario("José Lucas", "102.323.323-23", "23.434.343","jaodv@gmail.com", e1, 1,(float) 4000, (float) 20, "GERENTE", "Noturno", "1q2w3e");
        int salvar = FuncionarioDAO.getInstancia().salvar(f1);
        boolean sucesso = salvar > 0;
        assertEquals(true, sucesso);
    }

    @Test
    public void testeListar() {
        List<Funcionario> lista = FuncionarioDAO.getInstancia().listar();
        assertNotNull(lista);
    }

    @Test
    public void testeAtualizar() {
        Funcionario f = FuncionarioDAO.getInstancia().getById(1);
        f.setSalario(5000f);
        FuncionarioDAO.getInstancia().salvar(f);

        f = FuncionarioDAO.getInstancia().getById(1);
        assertEquals(f.getSalario(), 5000f);
    }
}