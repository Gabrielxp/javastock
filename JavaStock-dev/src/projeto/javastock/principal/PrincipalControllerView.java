package javastock.principal;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javastock.venda.view.VendaView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller mapeando os inputs da Classe {@link PrincipalView}.
 */
public class PrincipalControllerView implements Initializable {
    /**
     * Tela central.
     */
    @FXML
    AnchorPane centerPane;

    @FXML
    StackPane stackpane;
    /**
     * Tela Cadastro de Produtos.
     */
    @FXML
    AnchorPane cadastroP;
    /**
     * Tela Listagem de Produtos.
     */
    @FXML
    AnchorPane listagemP;
    /**
     * Tela cadastro de Funcionários.
     */
    @FXML
    AnchorPane cadastroFunc;


    @FXML
    public void abreTelaProdutos() throws Exception {
        listagemP.setVisible(false);
        listagemP.disableProperty().setValue(true);
        cadastroFunc.setVisible(false);
        cadastroFunc.disableProperty().setValue(true);
        cadastroP.disableProperty().setValue(false);
        cadastroP.setVisible(true);

    }

    public void listagemP() {
        cadastroFunc.setVisible(false);
        cadastroFunc.disableProperty().setValue(true);
        cadastroP.setVisible(false);
        cadastroP.disableProperty().setValue(true);
        listagemP.disableProperty().setValue(false);
        listagemP.setVisible(true);
    }

    public void cadastroFuncionarios() {
        cadastroP.setVisible(false);
        cadastroP.disableProperty().setValue(true);
        listagemP.disableProperty().setValue(true);
        listagemP.setVisible(false);
        cadastroFunc.setVisible(true);
        cadastroFunc.disableProperty().setValue(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cadastroP.setVisible(false);
        cadastroP.disableProperty().setValue(true);
        listagemP.setVisible(false);
        listagemP.disableProperty().setValue(true);
        cadastroFunc.setVisible(false);
        cadastroFunc.disableProperty().setValue(true);
    }

    public void abrirTelaVenda() throws Exception {
        new VendaView().start(new Stage());
    }

    public void sair() {
        System.exit(0);
    }
}
