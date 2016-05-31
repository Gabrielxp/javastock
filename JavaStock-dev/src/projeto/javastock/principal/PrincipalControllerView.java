package javastock.principal;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javastock.produto.view.ProdutoControllerView;

/**
 * Created by gabri on 16/05/2016.
 */
public class PrincipalControllerView {

    @FXML
    AnchorPane anchorPane;

    public void abreTelaProdutos() throws Exception {
        ProdutoControllerView produtoControllerView = new ProdutoControllerView();

        setAnchorPane(produtoControllerView.getCadastroProdutoTela());

    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }
}
