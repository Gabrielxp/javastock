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
import javastock.principal.PrincipalView;
import javastock.produto.Produto;
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
    @FXML
    private TextField idProd;

    private int idProduto = -1;

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

        if (idProduto == -1) {
            ProdutoController.getInstancia().criar(nome, descricao, categoria, fornecedorP,
                    precoEntradaP, quantidadeEstoque, margemLucroP, quantidadeMinima);
        } else {


            if (ProdutoController.getInstancia().atualizar(Integer.parseInt(idProd.getText()), nome, descricao, categoria, fornecedorP,
                    precoEntradaP, quantidadeEstoque, margemLucroP, quantidadeMinima) != -1) {
                CadastroProdutoView.close();
                PrincipalView.stage.setFullScreen(true);
            }

        }

        limparProduto();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        categoriaProduto.getItems().setAll(options);
        if (CadastroProdutoView.produtoParaEditar != null) {
            carregaTelaEdicao(CadastroProdutoView.produtoParaEditar);

        }
    }

    private void carregaTelaEdicao(Produto produto) {
        idProduto = produto.getIdProduto();
        nomeProduto.setText(produto.getNome());
        quantidadeProduto.setText(produto.getQuantidadeEstoque() + "");
        quantidadeMinimaProduto.setText(produto.getQuantidadeMinima() + "");
        margemLucro.setText(produto.getMargemLucro() + "");
        precoEntrada.setText(produto.getPrecoEntrada() + "");
        fornecedor.setText(produto.getFornecedor());
        categoriaProduto.setValue(produto.getCategoria());
        descricaoProduto.setText(produto.getDescricao());
        idProd.setText(produto.getIdProduto() + "");
    }
}