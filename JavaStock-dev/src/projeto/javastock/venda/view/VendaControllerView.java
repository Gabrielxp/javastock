package javastock.venda.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javastock.produto.Produto;
import javastock.produto.view.ProdutoProperty;
import javastock.venda.VendaController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ControllerView de vendas, mapeando os inputs.
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
//    public void salvarVenda(){
//
//        // Map<IdProduto, quantidade>
//        Map<Integer, Integer> carrinho = new HashMap<>();
//        carrinho.put(1, 3);
//        carrinho.put(2, 4);
//
//        double desconto = .2;
//        int idVendedor = 1;
//
//        // Ter certeza que todos os IDs existam no banco.
//        VendaController.getInstancia().criar(carrinho, desconto, idVendedor);
//
//    }
    public void selecionaProduto() {
        //passar a busca aqui
        Produto produto = null;
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
}
