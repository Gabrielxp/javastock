package javastock.pessoa.cliente.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javastock.botaoMensagens.BotaoView;
import javastock.pessoa.cliente.ClienteController;
import javastock.principal.PrincipalView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by gabri on 18/06/2016.
 */
public class CadastroClienteControllerView implements Initializable {
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
    private TextField email;
    @FXML
    private TextField cidade;
    @FXML
    private TextField cpf;
    @FXML
    private TextField rg;
    @FXML
    private TextField telefone;

    @FXML
    private Label labelSucesso;

    public void salvarCliente() throws Exception {

        if (ClienteController.getInstancia().criar(nome.getText(), cpf.getText(), rg.getText(), email.getText(), rua.getText(), Integer.parseInt(numero.getText()), bairro.getText(), cidade.getText(), uf.getText(), cep.getText(), 1) != -1) {

            new BotaoView("Atenção!", "Cadastro Feito com Sucesso").start(new Stage());

            limparCliente();
        }

    }

    public void limparCliente() {
        nome.clear();
        rua.clear();
        numero.clear();
        bairro.clear();
        cep.clear();
        uf.clear();
        cidade.clear();
        cpf.clear();
        rg.clear();
        email.clear();
        telefone.clear();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
