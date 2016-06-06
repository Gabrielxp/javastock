package javastock.produto.view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javastock.produto.Produto;
import javastock.produto.ProdutoController;

import java.util.ArrayList;
import java.util.List;

/**
 * ControllerView da {@link ListagemProdutoView}.
 */
public class ListagemProdutoControllerView extends Application {


    //Listagem produto.
    @FXML
    TableView<ProdutoProperty> tabelaProdutos;
    @FXML
    TableColumn<ProdutoProperty, String> nomeProduto;
    @FXML
    TableColumn<ProdutoProperty, String> quantidade;
    @FXML
    TableColumn<ProdutoProperty, String> quantidadeMinima;
    @FXML
    TableColumn<ProdutoProperty, String> margemLucro;
    @FXML
    TableColumn<ProdutoProperty, String> precoEntrada;

    private ObservableList<ProdutoProperty> produtosData = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception {


    }

    /**
     * Método para listar produtos.
     */
    public void listarProdutos() {
        List<Produto> produtos = ProdutoController.getInstancia().listar();

        for (Produto produto : produtos) {
            String nome = produto.getNome();
            String qtd = Integer.toString(produto.getQuantidadeEstoque());
            String qtdMin = Integer.toString(produto.getQuantidadeMinima());
            String mrgLucro = Double.toString(produto.getMargemLucro());
            String precoEntda = Double.toString(produto.getPrecoEntrada());

            ProdutoProperty produtoProp = new ProdutoProperty(null,nome, qtd, qtdMin, mrgLucro, precoEntda);
            produtosData.add(produtoProp);
            nomeProduto.setCellValueFactory(produtosData -> produtosData.getValue().nomeProdutoProperty());
            quantidade.setCellValueFactory(produtosData -> produtosData.getValue().quantidadeProperty());
            quantidadeMinima.setCellValueFactory(produtosData -> produtosData.getValue().quantidadeMinimaProperty());
            margemLucro.setCellValueFactory(produtosData -> produtosData.getValue().margemLucroProperty());
            precoEntrada.setCellValueFactory(produtosData -> produtosData.getValue().precoEntradaProperty());

            tabelaProdutos.setItems(produtosData);
        }

    }
}
