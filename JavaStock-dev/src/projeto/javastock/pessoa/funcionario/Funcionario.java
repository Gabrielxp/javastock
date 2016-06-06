package javastock.pessoa.funcionario;

import javastock.misc.Endereco;
import javastock.misc.Entidade;
import javastock.pessoa.Pessoa;

/**
 * Entidade Funcionario
 */
public class Funcionario extends Pessoa implements Entidade {

    private float salario;
    private float cargaHoraria;
    private String funcao;
    private String regimeDeTrabalho;

    /**
     * Cria um novo funcionario.
     * @param nome Nome do funcionario.
     * @param cpf CPF do funcionario.
     * @param rg Numero da carteira de identidade da pessoa.
     * @param email Email do funcionario.
     * @param endereco Endereco da funcionario.
     * @param salario Salario do funcionario.
     * @param cargaHoraria Carga horaria do funcionario.
     * @param funcao Funcao do funcionario.
     * @param regimeDeTrabalho Regime de trabalho do funcionario.
     * @throws RuntimeException Caso algum argumento nao passe pela validacao.
     */
    public Funcionario(String nome, String cpf, String rg, String email, Endereco endereco,
                       float salario, float cargaHoraria, String funcao, String regimeDeTrabalho) {
        super(nome, cpf, rg, email, endereco);
        this.setSalario(salario);
        this.setCargaHoraria(cargaHoraria);
        this.setFuncao(funcao);
        this.setRegimeDeTrabalho(regimeDeTrabalho);
    }

    /**
     * Instancia funcionario com id. Utilizado apenas para instanciar entidade ja inseridas no banco.
     * @param idFuncionario Id do funcionario.
     * @param nome Nome do funcionario.
     * @param cpf CPF do funcionario.
     * @param rg Numero da carteira de identidade da pessoa.
     * @param email Email do funcionario.
     * @param endereco Endereco da funcionario.
     * @param salario Salario do funcionario.
     * @param cargaHoraria Carga horaria do funcionario.
     * @param funcao Funcao do funcionario.
     * @param regimeDeTrabalho Regime de trabalho do funcionario.
     * @throws RuntimeException Caso algum argumento nao passe pela validacao.
     */
    public Funcionario(int idFuncionario, String nome, String cpf, String rg, String email, Endereco endereco,
                       float salario, float cargaHoraria, String funcao, String regimeDeTrabalho) {
        this(nome, cpf, rg, email, endereco, salario, cargaHoraria, funcao, regimeDeTrabalho);
        this.setIdPessoa(idFuncionario);
    }

    /**
     * Obtem valor do salario do funcionario.
     * @return Salario do funcionario.
     */
    public float getSalario() {
        return salario;
    }

    /**
     * Altera o salario do funcionario.
     * @param salario Novo salario.
     * @throws RuntimeException Caso o valor informado for menor que zero.
     */
    public void setSalario(float salario) {
        if (salario < 0)
            throw new RuntimeException("O valor deve ser maior que zero");

        this.salario = salario;
    }

    /**
     * Obtem a carga horaria do funcionario.
     * @return Carga horaria do funcionario.
     */
    public float getCargaHoraria() {
        return cargaHoraria;
    }

    /**
     * Altera a carga horaria do funcionario.
     * @param cargaHoraria Novo carga horaria.
     * @throws RuntimeException Caso o valor informado for menor que zero.
     */
    public void setCargaHoraria(float cargaHoraria) {
        if (cargaHoraria < 0)
            throw new RuntimeException("O valor deve ser maior que zero");

        this.cargaHoraria = cargaHoraria;
    }

    /**
     * Obtem a funcao do funcionario.
     * @return Funcao do funcionario.
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     * Altera a funcao do funcionario.
     * @param funcao Nova funcao.
     * @throws RuntimeException Caso o valor informado for vazio ou nulo.
     */
    public void setFuncao(String funcao) {
        if (funcao == null || funcao.equals(""))
            throw new RuntimeException("Este campo é obrigatorio");

        this.funcao = funcao;
    }

    /**
     * Obtem o regime de trabalho do funcionario.
     * @return Regime de trabalho do funcionario.
     */
    public String getRegimeDeTrabalho() {
        return regimeDeTrabalho;
    }

    /**
     * Altera o regime de trabalho do funcionario.
     * @param regimeDeTrabalho Novo regime.
     * @throws RuntimeException Caso o valor informado for vazio ou nulo.
     */
    public void setRegimeDeTrabalho(String regimeDeTrabalho) {
        if (regimeDeTrabalho == null || regimeDeTrabalho.equals(""))
            throw new RuntimeException("Este campo é obrigatorio");

        this.regimeDeTrabalho = regimeDeTrabalho;
    }
}
