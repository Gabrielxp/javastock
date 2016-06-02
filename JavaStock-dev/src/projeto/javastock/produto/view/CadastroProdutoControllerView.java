package javastock.produto.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * Classe que mapeia os elementos e funções da tela.
 */
public class CadastroProdutoControllerView {
    @FXML
    private TextField nomeProduto;
    @FXML
    private TextField quantidadeProduto;
    @FXML
    private TextField quantidadeMinimaProduto;
    @FXML
    private TextField margemLucro;
    @FXML
    private TextField precoEntrada;
    @FXML
    private TextArea descricaoProduto;

    /**
     * Metodo para limpar campos de produtos.
     */
    public void limparProduto() {
        nomeProduto.clear();
        quantidadeMinimaProduto.clear();
        quantidadeProduto.clear();
        margemLucro.clear();
        precoEntrada.clear();
        descricaoProduto.clear();
    }

    /**
     * Método para salvar o produto cadastrado no banco.
     */
    public void salvarProduto() {
        System.out.println(nomeProduto.getText());
    }

}