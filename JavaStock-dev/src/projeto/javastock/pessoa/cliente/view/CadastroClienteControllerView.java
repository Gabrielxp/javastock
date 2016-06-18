package javastock.pessoa.cliente.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javastock.misc.Endereco;
import javastock.pessoa.cliente.Cliente;
import javastock.pessoa.cliente.ClienteController;

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

    public void salvarCliente() {
        ClienteController.getInstancia().criar(nome.getText(),cpf.getText(),rg.getText(),email.getText(),rua.getText(),Integer.parseInt(numero.getText()),bairro.getText(),cidade.getText(),uf.getText(),cep.getText(),1);
    }

    public void limparCliente() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToolBar toolBar = new ToolBar();
        Tooltip tooltip = new Tooltip("Apenas Numeros!");
        toolBar.setTooltip(tooltip);
        numero.setTooltip(toolBar.getTooltip());
    }
}
