package javastock.principal;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by gabri on 16/05/2016.
 */
public class PrincipalControllerView implements Initializable {

    @FXML
    AnchorPane centerPane;

    @FXML
    StackPane stackpane;

    @FXML
    AnchorPane cadastroP;

    @FXML
    AnchorPane listagemP;

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
    public void sair(){
        System.exit(0);
    }
}
