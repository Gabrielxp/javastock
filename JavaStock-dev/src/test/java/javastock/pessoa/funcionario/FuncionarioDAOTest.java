package javastock.pessoa.funcionario;

import javastock.misc.Endereco;
import org.junit.Test;

/**
 * Created by fernando on 6/17/16.
 */
public class FuncionarioDAOTest {
    @Test
    public void testeSalvar() {
        Endereco e1 = new Endereco("Rua Guilherme Guzzo", 200, "Centro Norte", "Dois vizinhos", "PR", "85660-000");
        Funcionario f1 = new Funcionario("José Lucas", "102.323.323-23", "23.434.343","jaodv@gmail.com", e1, 1,(float) 4.000, (float) 20, "GERENTE", "Noturno", "1q2w3e");

        Endereco e2 = new Endereco("Rua Palmital", 777, "Centro Sul", "Dois vizinhos", "PR", "85660-000");
        Funcionario f2 = new Funcionario("Gabriel", "232.233.231-23", "76.676.454", "gabriel@gmail.com", e2, 1, (float) 2.000, (float) 40, "GERENTE", "Diurno", "qweasd");

        FuncionarioDAO dao = new FuncionarioDAO();
        dao.salvar(f1);
        dao.salvar(f2);
    }
}