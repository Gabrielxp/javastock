package javastock.pessoa.funcionario;

import javastock.misc.DAO;
import javastock.misc.Endereco;

/**
 * Controller de funcionarios.
 */
public class FuncionarioController {

    private final static FuncionarioController instancia = new FuncionarioController();

    private FuncionarioController() {
    }

    /**
     * Singleton
     *
     * @return Instancia de ProdutoController.
     */
    public static FuncionarioController getInstancia() {
        return instancia;
    }

    private DAO<Funcionario> funcionarioDAO = FuncionarioDAO.getInstancia();

    /**
     * Cria novo funcionario e o salva no banco de dados.
     *
     * @param nome             Nome do funcionario.
     * @param cpf              CPF do funcionario.
     * @param rg               Numero da carteira de identidade da pessoa.
     * @param email            Email do funcionario.
     * @param rua              Rua do endereco.
     * @param numero           Numero do endereco.
     * @param bairro           Bairro do endereco.
     * @param cidade           Cidade do endereco.
     * @param uf               Sigla do estado do endereco.
     * @param cep              CEP do endereco.
     * @param salario          Salario do funcionario.
     * @param cargaHoraria     Carga horaria do funcionario.
     * @param funcao           Funcao do funcionario.
     * @param regimeDeTrabalho Regime de trabalho do funcionario.
     */
    public void criar(String nome, String cpf, String rg, String email, String rua,
                      int numero, String bairro, String cidade, String uf, String cep, int status, float salario,
                      float cargaHoraria, String funcao, String regimeDeTrabalho, String senha) {

        Endereco endereco = new Endereco(rua, numero, bairro, cidade, uf, cep);

        Funcionario funcionario = new Funcionario(nome, cpf, rg, email, endereco, status,
                salario, cargaHoraria, funcao, regimeDeTrabalho, senha);

        this.funcionarioDAO.salvar(funcionario);
    }

    public void salvar(int id, String nome, String cpf, String rg, String email, String rua,
                       int numero, String bairro, String cidade, String uf, String cep, int status, float salario,
                       float cargaHoraria, String funcao, String regimeDeTrabalho, String senha) {
        Endereco endereco = new Endereco(rua, numero, bairro, cidade, uf, cep);

        Funcionario funcionario = new Funcionario(id, nome, cpf, rg, email, endereco, status,
                salario, cargaHoraria, funcao, regimeDeTrabalho, senha);

        this.funcionarioDAO.salvar(funcionario);

    }

}

