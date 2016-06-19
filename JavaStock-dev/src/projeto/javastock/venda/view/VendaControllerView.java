package javastock.venda.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javastock.botaoMensagens.BotaoView;
import javastock.principal.PrincipalView;
import javastock.produto.Produto;
import javastock.produto.ProdutoDAO;
import javastock.produto.view.ProdutoProperty;
import javastock.venda.VendaController;

import java.net.URL;
import java.util.*;

/**
 * ControllerView de vendas, mapeando os inputs.
 */
public class VendaControllerView implements Initializable {

    @FXML
    private TextField total;
    @FXML
    private TextField codigoProd;
    @FXML
    private TextField valorDesconto;
    @FXML
    private TableView<ProdutoProperty> tabelaProdutos;
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

    private List<Produto> carrinho;

    private List<Produto> produtos = ProdutoDAO.getInstancia().listar();

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

    /**
     * Este metodo apenas busca os carrinho e retorna para view.
     */
    public void selecionaProduto() {
        Produto produto = null;
        float id = Float.parseFloat(codigoProd.getText());
        for (Produto prod : this.produtos) {
            if (prod.getIdProduto() == id)
                produto = prod;
        }
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

    /**
     * Neste metodo realmente é criado o venda, e salvo os carrinho no venda_produtos.
     */
    public void fecharVenda() throws Exception {
        Map<Integer, Integer> compras = new HashMap<>();
        for (ProdutoProperty produto : tabelaProdutos.getItems())
            compras.put(Integer.parseInt(produto.getCodProd()), Integer.parseInt(produto.getQuantidade()));

        VendaController.getInstancia().criar(compras, Integer.parseInt(valorDesconto.getText()), PrincipalView.funcionarioLogado.getIdPessoa());
        new BotaoView("", "Vendido!").start(new Stage());
        //limpaTela
        produtosData.clear();
        total.clear();
        valorDesconto.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carrinho = new ArrayList<>();
    }

    public void aplicarDesconto() {
        double valor = Float.parseFloat(total.getText());
        double desconto = Float.parseFloat(valorDesconto.getText());
        desconto = desconto / 100;
        valor -= valor * desconto;
        total.setText(valor + "");
    }

    public void buscarCliente() {

    }

    public void sair() throws Exception {
        PrincipalView.stage.setFullScreen(true);
        VendaView.close();

    }
}
