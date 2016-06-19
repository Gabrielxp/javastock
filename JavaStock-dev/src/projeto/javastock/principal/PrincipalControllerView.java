package javastock.principal;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javastock.botaoMensagens.BotaoView;
import javastock.login.InicialControllerView;
import javastock.login.LoginView;
import javastock.pessoa.funcionario.Funcionario;
import javastock.produto.Produto;
import javastock.produto.ProdutoController;
import javastock.venda.view.VendaView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
    AnchorPane edicaoFunc;

    @FXML
    MenuButton administrativo;

    @FXML
    AnchorPane cadastroCli;

    @FXML
    AnchorPane inicial;

    @FXML
    Label nome;

    public static Funcionario funcionarioLogado;

    @FXML
    public void abreTelaProdutos() throws Exception {
        listagemP.setVisible(false);
        listagemP.disableProperty().setValue(true);
        cadastroFunc.setVisible(false);
        cadastroFunc.disableProperty().setValue(true);
        cadastroP.disableProperty().setValue(false);
        cadastroP.setVisible(true);
        edicaoFunc.setVisible(false);
        edicaoFunc.disableProperty().setValue(true);
        cadastroCli.setVisible(false);
        cadastroCli.disableProperty().setValue(true);
        inicial.setVisible(false);

    }

    public void listagemP() {
        inicial.setVisible(false);
        cadastroFunc.setVisible(false);
        cadastroFunc.disableProperty().setValue(true);
        cadastroP.setVisible(false);
        cadastroP.disableProperty().setValue(true);
        listagemP.disableProperty().setValue(false);
        listagemP.setVisible(true);
        edicaoFunc.setVisible(false);
        edicaoFunc.disableProperty().setValue(true);
        cadastroCli.setVisible(false);
        cadastroCli.disableProperty().setValue(true);
    }

    public void cadastroFuncionarios() {
        cadastroP.setVisible(false);
        cadastroP.disableProperty().setValue(true);
        listagemP.disableProperty().setValue(true);
        listagemP.setVisible(false);
        cadastroFunc.setVisible(true);
        cadastroFunc.disableProperty().setValue(false);
        edicaoFunc.setVisible(false);
        edicaoFunc.disableProperty().setValue(true);
        cadastroCli.setVisible(false);
        cadastroCli.disableProperty().setValue(true);
    }

    public void edicaoFuncionarios() {
        inicial.setVisible(false);
        cadastroP.setVisible(false);
        cadastroP.disableProperty().setValue(true);
        listagemP.disableProperty().setValue(true);
        listagemP.setVisible(false);
        cadastroFunc.setVisible(false);
        cadastroFunc.disableProperty().setValue(true);
        edicaoFunc.setVisible(true);
        edicaoFunc.disableProperty().setValue(false);
        cadastroCli.setVisible(false);
        cadastroCli.disableProperty().setValue(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        funcionarioLogado = PrincipalView.funcionarioLogado;
        if (funcionarioLogado.getFuncao().equals("gerente")) {
            administrativo.disableProperty().setValue(false);


        } else {
            administrativo.disableProperty().setValue(true);
        }

        nome.setStyle("-fx-text-fill: white; fx-font-weight:bold");

        nome.setText(funcionarioLogado.getNome());
        cadastroP.setVisible(false);
        cadastroP.disableProperty().setValue(true);
        listagemP.setVisible(false);
        listagemP.disableProperty().setValue(true);
        cadastroFunc.setVisible(false);
        cadastroFunc.disableProperty().setValue(true);
        edicaoFunc.setVisible(false);
        edicaoFunc.disableProperty().setValue(true);
        cadastroCli.setVisible(false);
        cadastroCli.disableProperty().setValue(true);
    }

    public void cadastroClientes() {
        inicial.setVisible(false);
        cadastroP.setVisible(false);
        cadastroP.disableProperty().setValue(true);
        listagemP.setVisible(false);
        listagemP.disableProperty().setValue(true);
        cadastroFunc.setVisible(false);
        cadastroFunc.disableProperty().setValue(true);
        edicaoFunc.setVisible(false);
        edicaoFunc.disableProperty().setValue(true);
        cadastroCli.setVisible(true);
        cadastroCli.disableProperty().setValue(false);
    }

    public void abrirTelaVenda() throws Exception {
        new VendaView().start(new Stage());
    }

    public void sair() throws Exception {
        PrincipalView.stage.close();
        new LoginView().start(new Stage());
    }

    public void telaInicial() {
        inicial.setVisible(true);
        cadastroP.setVisible(false);
        cadastroP.disableProperty().setValue(true);
        listagemP.setVisible(false);
        listagemP.disableProperty().setValue(true);
        cadastroFunc.setVisible(false);
        cadastroFunc.disableProperty().setValue(true);
        edicaoFunc.setVisible(false);
        edicaoFunc.disableProperty().setValue(true);
        cadastroCli.setVisible(false);
        cadastroCli.disableProperty().setValue(true);

    }
}
