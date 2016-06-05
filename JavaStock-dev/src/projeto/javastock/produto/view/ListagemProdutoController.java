package javastock.produto.view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

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
        //trocar o object pelo model Produto!
        List<Object> produtos = new ArrayList<>();//funcao buscaTodos do produto Controller.

       // for (Produto produto1 : produtos) {
            //converter os parametos do model produto pra string e passar nesse Produto property e rodar essas coisas...

            ProdutoProperty produto = new ProdutoProperty("Geladeira", "12", "10", "10.2", "12.2");
            produtosData.add(produto);
            nomeProduto.setCellValueFactory(produtosData -> produtosData.getValue().nomeProdutoProperty());
            quantidade.setCellValueFactory(produtosData -> produtosData.getValue().quantidadeProperty());
            quantidadeMinima.setCellValueFactory(produtosData -> produtosData.getValue().quantidadeMinimaProperty());
            margemLucro.setCellValueFactory(produtosData -> produtosData.getValue().margemLucroProperty());
            precoEntrada.setCellValueFactory(produtosData -> produtosData.getValue().precoEntradaProperty());

           tabelaProdutos.setItems(produtosData);
        

     //   }

    }
}
