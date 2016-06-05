package javastock.produto.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javastock.produto.ProdutoController;

import java.util.List;

/**
 * Classe que mapeia os elementos e funções da tela.
 */
public class CadastroProdutoControllerView {
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
;

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
        String nome = nomeProduto.getText();
        String descricao = descricaoProduto.getText();
        String categoria = categoriaProduto.getText();
        String fornecedor = fornecedorProduto.getText();
        float precoEntrada = Float.parseFloat(precoEntrada.getText());
        int quantidadeEstoque = Integer.parseInt(quantidadeProduto.getText());
        double margemLucro = Double.parseDouble(margemLucro.getText());
        int quantidadeMinima = Integer.parseInt(quantidadeMinimaProduto.getText());

        ProdutoController.getInstancia().criar(nome, descricao, categoria, fornecedor,
                precoEntrada, quantidadeEstoque, margemLucro, quantidadeMinima);
    }
}