package javastock.pessoa.funcionario.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javastock.pessoa.funcionario.Funcionario;
import javastock.pessoa.funcionario.FuncionarioController;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * ControllerView do cadastro de Funcionário, mapeando os inputs.
 */
public class CadastroFuncionarioControllerView implements Initializable {
    @FXML
    private TextField nome;
    @FXML
    private TextField senha;
    @FXML
    private TextField rua;
    @FXML
    private TextField numero;
    @FXML
    private TextField bairro;
    @FXML
    private TextField cep;
    @FXML
    private TextField uf;
    @FXML
    private TextField email;
    @FXML
    private TextField cidade;
    @FXML
    private TextField cpf;
    @FXML
    private TextField rg;
    @FXML
    private ComboBox funcao;
    @FXML
    private TextField salario;
    @FXML
    private TextField cargaHoraria;
    @FXML
    private TextField regimeTrabalho;
    @FXML
    private TextField telefone;
    @FXML
    private CheckBox status;

    private int idFuncionario = -1;

    public void salvarFuncionario() {

        if (idFuncionario == -1) {
            FuncionarioController.getInstancia().criar(nome.getText(), cpf.getText(), rg.getText(), email.getText(), rua.getText(), Integer.parseInt(numero.getText()), bairro.getText(),
                    cidade.getText(), uf.getText(), cep.getText(), 1 , Float.parseFloat(salario.getText()), Float.parseFloat(cargaHoraria.getText()), funcao.getValue().toString(), regimeTrabalho.getText(),senha.getText());
            limparFuncionario();
        } else {
            //fazer update
            limparFuncionario();
        }

    }

    public void limparFuncionario() {
        senha.clear();
        telefone.clear();
        nome.clear();
        rua.clear();
        numero.clear();
        bairro.clear();
        cep.clear();
        uf.clear();
        cidade.clear();
        cpf.clear();
        rg.clear();
        salario.clear();
        cargaHoraria.clear();
        regimeTrabalho.clear();
        email.clear();
        idFuncionario = -1;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        funcao.getItems().setAll("Vendedor", "Gerente");

    }

    public void buscarFunc() throws Exception {
        Funcionario funcionario = null;

        nome.setText(funcionario.getNome());
        rua.setText(funcionario.getEndereco().getRua());
        numero.setText(funcionario.getEndereco().getNumero() + "");
        bairro.setText(funcionario.getEndereco().getBairro());
        cep.setText(funcionario.getEndereco().getCep());
        uf.setText(funcionario.getEndereco().getUf());
        cidade.setText(funcionario.getEndereco().getCidade());
        cpf.setText(funcionario.getCpf());
        rg.setText(funcionario.getRg());
        salario.setText(funcionario.getSalario() + "");
        cargaHoraria.setText(funcionario.getCargaHoraria() + "");
        regimeTrabalho.setText(funcionario.getRegimeDeTrabalho());
        email.setText(funcionario.getEmail());

        status.setSelected(true);
    }
}
