package javastock.produto.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;

import java.util.List;

/**
 * Classe que mapeia os elementos e funções da tela.
 */
public class ProdutoControllerView {
    //Cadastro Produto.
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

    //Listagem produto.
    @FXML
    TreeView<String> listagemProdutos;

    /**
     * Metodo para limpar campos de produtos que estão sendo cadastrados.
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
     * Método para salvar o produto cadastrado no banco da tela de cadastro.
     */
    public void salvarProduto() {
        System.out.println(nomeProduto.getText());
    }

    /**
     * Método para listar produtos.
     */
    public void listarProdutos() {
        listagemProdutos = new TreeView<>();
    }

}