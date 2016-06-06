package javastock.venda.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javastock.produto.Produto;
import javastock.produto.view.ProdutoProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabri on 05/06/2016.
 */
public class VendaControllerView {

    @FXML
    private TextField total;
    @FXML
    private TextField codigoProd;
    @FXML
    private TableView tabelaProdutos;

    @FXML
    TableColumn<ProdutoProperty, String> nomeProduto;
    @FXML
    TableColumn<ProdutoProperty, String> quantidade;
    @FXML
    private TextField quantidadeProd;
    @FXML
    TableColumn<ProdutoProperty, String> codProduto;
    @FXML
    TableColumn<ProdutoProperty, String> valor;

    private ObservableList<ProdutoProperty> produtosData = FXCollections.observableArrayList();


    public void selecionaProduto() {
        //passar a busca aqui
        Produto produto = buscaProduto(codigoProd.getText());
        produto = new Produto("Geladeira", null, null, null, 10, 0, 0.2, 0);//apagar  isso

        if (produto != null) {
            if (!quantidadeProd.getText().isEmpty()) {

                String valorProduto = "" + produto.getMargemLucro() * produto.getPrecoEntrada() * Integer.parseInt(quantidadeProd.getText());

                ProdutoProperty produtoProp = new ProdutoProperty("" + produto.getIdProduto(), produto.getNome(), quantidadeProd.getText(), null, valorProduto, null);
                produtosData.add(produtoProp);
                nomeProduto.setCellValueFactory(produtosData -> produtosData.getValue().nomeProdutoProperty());
                quantidade.setCellValueFactory(produtosData -> produtosData.getValue().quantidadeProperty());
                valor.setCellValueFactory(produtosData -> produtosData.getValue().margemLucroProperty());
                codProduto.setCellValueFactory(produtosData -> produtosData.getValue().codProdProperty());
                Float totalValor = null;

                tabelaProdutos.setItems(produtosData);

                if (total.getText().isEmpty() || total == null || total.equals(null)) {
                    totalValor = Float.parseFloat(valorProduto);
                } else {
                    Float a = null;
                    a = Float.parseFloat(total.getText());

                    totalValor = a + Float.parseFloat(valorProduto);
                }


                total.setText("" + totalValor);
                quantidadeProd.clear();
                codigoProd.clear();
            }
        }
    }

    public void fecharVenda() {
        //Converter Os property em produtos e salvar no banco.
        List<Produto> produtoList = new ArrayList<>();
        for (ProdutoProperty property : produtosData) {


        }

    }

    /**
     * Buscar produto no banco.
     *
     * @return
     */

    public Produto buscaProduto(String codProduto) {

        return null;
    }
}
