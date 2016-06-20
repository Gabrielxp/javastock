package javastock.login;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javastock.pessoa.funcionario.Funcionario;
import javastock.principal.PrincipalView;
import javastock.produto.Produto;
import javastock.produto.ProdutoController;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by gabri on 19/06/2016.
 */
public class InicialControllerView implements Initializable {
    @FXML
    TextArea estoqueBaixo;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        estoqueBaixo.setStyle("-fx-background-color: white;-fx-border-color: white");
        Funcionario funcionarioLogado = PrincipalView.funcionarioLogado;

        if (funcionarioLogado.getFuncao().equals("gerente")) {
            List<Produto> produtos = new ArrayList<>();
            produtos = ProdutoController.getInstancia().abaixoEstoque();
            if (!produtos.isEmpty()) {
                String produto = "PRODUTOS COM ESTOQUE BAIXO!\n\n";
                for (Produto p : produtos) {
                    produto = produto.concat(
                            "ID:" + p.getIdProduto() + "\nNOME:" + p.getNome()
                            + "\nQUANTIDADE EM ESTOQUE: " + p.getQuantidadeEstoque()
                            + "\nQUANTIDADE MÍNIMA:" + p.getQuantidadeMinima() + "" +
                                    "\n----------------------\n");
                }
                estoqueBaixo.setText(produto);
            }
        }
    }
}
