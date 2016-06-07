package javastock.produto.view;

import javafx.application.Application;
import javafx.beans.property.ListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javastock.produto.ProdutoController;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Classe que mapeia os elementos e funções da tela.
 */
public class CadastroProdutoControllerView implements Initializable {
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
    private TextField fornecedor;
    @FXML
    private ComboBox categoriaProduto;
    @FXML
    private TextArea descricaoProduto;

    ObservableList<String> options =
            FXCollections.observableArrayList(
                    "Alimentício",
                    "Higiene",
                    "Limpeza",
                    "Saúde",
                    "Construção",
                    "Frutas e Verduras",
                    "Massas",
                    "Pães",
                    "Carnes",
                    "Estética",
                    "Bebidas"
            );

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
        fornecedor.clear();
    }

    /**
     * Método para salvar o produto cadastrado no banco da tela de cadastro.
     */
    public void salvarProduto() {
        String nome = nomeProduto.getText();
        String descricao = descricaoProduto.getText();
        String categoria = categoriaProduto.getValue().toString();
        String fornecedorP = fornecedor.getText();
        float precoEntradaP = Float.parseFloat(precoEntrada.getText());
        int quantidadeEstoque = Integer.parseInt(quantidadeProduto.getText());
        double margemLucroP = Double.parseDouble(margemLucro.getText());
        int quantidadeMinima = Integer.parseInt(quantidadeMinimaProduto.getText());

        ProdutoController.getInstancia().criar(nome, descricao, categoria, fornecedorP,
                precoEntradaP, quantidadeEstoque, margemLucroP, quantidadeMinima);
        limparProduto();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        categoriaProduto.getItems().setAll(options);
    }
}