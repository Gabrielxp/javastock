package javastock.pessoa.funcionario.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * ControllerView do cadastro de Funcionário, mapeando os inputs.
 */
public class CadastroFuncionarioControllerView implements Initializable {
    @FXML
    private TextField nome;
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


    public void salvarFuncionario() {
        //pegar combo selecionado
        funcao.getValue().toString();
    }

    public void limparFuncionario() {
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
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        funcao.getItems().setAll("Vendedor", "Gerente");
    }
}
