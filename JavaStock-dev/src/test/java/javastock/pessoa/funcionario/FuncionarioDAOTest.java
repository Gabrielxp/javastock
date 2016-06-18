package javastock.pessoa.funcionario;

import javastock.misc.Endereco;
import org.junit.Test;

/**
 * Created by fernando on 6/17/16.
 */
public class FuncionarioDAOTest {
    @Test
    public void testeSalvar() {
        Endereco e1 = new Endereco("Rua Guilherme Guzzo", 200, "Centro Norte", "Dois vizinhos", "MG", "85660-000");
        Funcionario f1 = new Funcionario("José Lucas", "102.323.323-23", "23.434.343","jaodv@gmail.com", e1, (float) 2.000, (float) 40, "GERENTE", "Noturno");
        FuncionarioDAO dao = new FuncionarioDAO();
        dao.salvar(f1);

    }
}