package javastock.pessoa.cliente;

import javastock.misc.Endereco;

/**
 * Controller de Cliente.
 */
public class ClienteController {
    private ClienteDAO clienteDAO = ClienteDAO.getInstancia();
    private static final ClienteController instancia = new ClienteController();

    private ClienteController() {

    }

    public static ClienteController getInstancia() {
        return instancia;
    }

    public void criar(String nome, String cpf, String rg, String email, String rua,
                      int numero, String bairro, String cidade, String uf, String cep, int status) {

        Endereco endereco = new Endereco(rua, numero, bairro, cidade, uf, cep);

        Cliente cliente = new Cliente(nome, cpf, rg, email, endereco);

        this.clienteDAO.salvar(cliente);
    }
}
