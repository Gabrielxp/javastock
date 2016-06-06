package javastock.pessoa;

import javastock.misc.Endereco;
import javastock.misc.Entidade;

/**
 * Entidade pessoa
 */
public abstract class Pessoa implements Entidade {

    private int idPessoa = -1;
    private String nome;
    private String cpf;
    private String rg;
    private String email;
    private Endereco endereco;

    /**
     * Cria uma nova pessoa.
     * @param nome Nome da pessoa.
     * @param cpf CPF da pessoa.
     * @param rg Numero da carteira de identidade da pessoa.
     * @param email Email da pessoa.
     * @param endereco Endereco da pessoa.
     * @throws RuntimeException Caso algum argumento nao passe pela validacao.
     */
    public Pessoa(String nome, String cpf, String rg, String email, Endereco endereco) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setRg(rg);
        this.setEmail(email);
        this.setEndereco(endereco);
    }

    /**
     * Instancia pessoa com id. Utilizado apenas para instanciar entidade ja inseridas no banco.
     * @param idPessoa Id da pessoa.
     * @param nome Nome da pessoa.
     * @param cpf CPF da pessoa.
     * @param rg Numero da carteira de identidade da pessoa.
     * @param email Email da pessoa.
     * @param endereco Endereco da pessoa.
     * @throws RuntimeException Caso algum argumento nao passe pela validacao.
     */
    Pessoa(int idPessoa, String nome, String cpf, String rg, String email, Endereco endereco) {
        this(nome, cpf, rg, email, endereco);
        this.setIdPessoa(idPessoa);
    }

    /**
     * Obtem o id da pessoa.
     * @return Id da pessoa
     */
    public int getIdPessoa() {
        return idPessoa;
    }

    /**
     * Altera o id da pessoa.
     * @param idPessoa Novo Id da pessoa.
     * @throws RuntimeException Caso o valor informado for menor que zero.
     */
    protected void setIdPessoa(int idPessoa) {
        if (idPessoa < 0)
            throw new RuntimeException("Id nao pode ser negativo");

        this.idPessoa = idPessoa;
    }

    /**
     * Obtem o nome da pessoa.
     * @return Nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Altera o nome da pessoa.
     * @param nome Novo nome..
     * @throws RuntimeException Caso o valor informado for vazio ou nulo.
     */
    public void setNome(String nome) {
        if (nome == null || nome.equals(""))
            throw new RuntimeException("Este campo é obrigatorio");

        this.nome = nome;
    }

    /**
     * Obtem o numero da carteira de identidade da pessoa.
     * @return RG da pessoa.
     */
    public String getRg() {
        return rg;
    }

    /**
     * Altera o RG da pessoa.
     * @param rg Novo RG.
     * @throws RuntimeException Caso o valor informado for vazio ou nulo.
     */
    public void setRg(String rg) {
        if (rg == null || rg.equals(""))
            throw new RuntimeException("Este campo é obrigatorio");

        this.rg = rg;
    }

    /**
     * Obtem o CPF da pessoa.
     * @return CPF da pessoa
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Altera o CPF da pessoa.
     * @param cpf Novo CPF.
     * @throws RuntimeException Caso o valor informado for vazio ou nulo.
     */
    public void setCpf(String cpf) {
        if (cpf == null || cpf.equals(""))
            throw new RuntimeException("Este campo é obrigatorio");

        this.cpf = cpf;
    }

    /**
     * Obtem o email da pessoa.
     * @return Email da pessoa
     */
    public String getEmail() {
        return email;
    }

    /**
     * Altera o email da pessoa.
     * @param email Novo email.
     * @throws RuntimeException Caso o valor informado for vazio ou nulo.
     */
    public void setEmail(String email) {
        if (email == null || email.equals(""))
            throw new RuntimeException("Este campo é obrigatorio");

        this.email = email;
    }

    /**
     * Obtem o endereco da pessoa.
     * @return Endereco da pessoa
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * Altera o endereco da pessoa.
     * @param endereco Novo endereco.
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
