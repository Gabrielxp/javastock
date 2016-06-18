package javastock.pessoa.cliente;

import javastock.misc.Endereco;
import javastock.misc.Entidade;
import javastock.pessoa.Pessoa;

/**
 * Created by gabri on 17/06/2016.
 */
public class Cliente extends Pessoa implements Entidade {


    /**
     * Cria uma nova pessoa.
     *
     * @param nome     Nome da pessoa.
     * @param cpf      CPF da pessoa.
     * @param rg       Numero da carteira de identidade da pessoa.
     * @param email    Email da pessoa.
     * @param endereco Endereco da pessoa.
     * @param status   Status da pessoa.
     * @throws RuntimeException Caso algum argumento nao passe pela validacao.
     */
    public Cliente(String nome, String cpf, String rg, String email, Endereco endereco, int status) {
        super(nome, cpf, rg, email, endereco, status);
    }

    


    /**
     * Cria uma nova pessoa.
     *
     * @param nome     Nome da pessoa.
     * @param cpf      CPF da pessoa.
     * @param rg       Numero da carteira de identidade da pessoa.
     * @param email    Email da pessoa.
     * @param endereco Endereco da pessoa.
     * @param status   Status da pessoa.
     * @throws RuntimeException Caso algum argumento nao passe pela validacao.
     */
    public Cliente(int idCliente, String nome, String cpf, String rg, String email, Endereco endereco, int status) {
        super(nome, cpf, rg, email, endereco, status);
        this.setIdPessoa(idCliente);
    }

}
