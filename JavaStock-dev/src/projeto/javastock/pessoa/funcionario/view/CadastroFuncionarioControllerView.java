package javastock.pessoa.funcionario.view;

import javastock.pessoa.funcionario.FuncionarioController;

/**
 * ControllerView do cadastro de Funcionário, mapeando os inputs.
 */
public class CadastroFuncionarioControllerView {
    public void salvarFuncionario(){
        String nome = "Fulano de tal";
        String cpf = "11111111111";
        String rg = "324423423";
        String email = "fulano@javali.com";
        String rua = "Rua...";
        int numero = 100;
        String bairro = "Bairro...";
        String cidade = "Dois Vizinhos";
        String uf = "PR";
        String cep = "856600000";
        float salario = 3000;
        float cargaHoraria = 8;
        String funcao = "funcionario";
        String regimeDeTrababalho = "diurno";

        FuncionarioController.getInstancia().criar(nome, cpf, rg, email, rua, numero, bairro,
                cidade, uf, cep, salario, cargaHoraria, funcao, regimeDeTrababalho);

    }
    public void limparFuncionario(){

    }
}
