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

    /**
     * Cria um cliente no banco.
     *
     * @param nome             Nome do cliente.
     * @param cpf              CPF do cliente.
     * @param rg               Numero da carteira de identidade da pessoa.
     * @param email            Email do cliente.
     * @param rua              Rua do endereco.
     * @param numero           Numero do endereco.
     * @param bairro           Bairro do endereco.
     * @param cidade           Cidade do endereco.
     * @param uf               Sigla do estado do endereco.
     * @param cep              CEP do endereco.
     */
    public int criar(String nome, String cpf, String rg, String email, String rua,
                      int numero, String bairro, String cidade, String uf, String cep, int status) {

        Endereco endereco = new Endereco(rua, numero, bairro, cidade, uf, cep);

        Cliente cliente = new Cliente(nome, cpf, rg, email, endereco, status);

        return this.clienteDAO.salvar(cliente);
    }

    /**
     * Atualiza cliente no banco.
     *
     * @param id               Id do cliente.
     * @param nome             Nome do cliente.
     * @param cpf              CPF do cliente.
     * @param rg               Numero da carteira de identidade da pessoa.
     * @param email            Email do cliente.
     * @param rua              Rua do endereco.
     * @param numero           Numero do endereco.
     * @param bairro           Bairro do endereco.
     * @param cidade           Cidade do endereco.
     * @param uf               Sigla do estado do endereco.
     * @param cep              CEP do endereco.
     */
    public int criar(int id, String nome, String cpf, String rg, String email, String rua,
                     int numero, String bairro, String cidade, String uf, String cep, int status) {

        Endereco endereco = new Endereco(rua, numero, bairro, cidade, uf, cep);

        Cliente cliente = new Cliente(id, nome, cpf, rg, email, endereco, status);

        return this.clienteDAO.salvar(cliente);
    }
}
