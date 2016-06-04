package javastock.produto.view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Created by gabri on 04/06/2016.
 */
public class ListagemProdutoController extends Application {


    //Listagem produto.
    @FXML
    TableView<ProdutoProperty> tabelaProdutos;
    @FXML
    TableColumn<ProdutoProperty, String> nomeProduto;
    @FXML
    TableColumn<ProdutoProperty, Integer> quantidade;
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
        ProdutoProperty produto = new ProdutoProperty("Geladeira",10,10,10.2,12.2);
        produto.setNomeProduto("Geladeira");
        produtosData.add(produto);
        nomeProduto.setCellValueFactory(produtosData -> produtosData.getValue().nomeProdutoProperty());
        tabelaProdutos.setItems(produtosData);
    }
}
