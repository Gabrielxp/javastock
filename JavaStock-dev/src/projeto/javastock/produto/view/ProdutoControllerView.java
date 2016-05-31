package javastock.produto.view;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

/**
 * Classe que mapeia os elementos e funções da tela.
 */
public class ProdutoControllerView {
    @FXML
    AnchorPane cadastroProdutoTela;

    public ProdutoControllerView() {

    }

    public AnchorPane getCadastroProdutoTela() {
        return cadastroProdutoTela;
    }

    public void setCadastroProdutoTela(AnchorPane cadastroProdutoTela) {
        this.cadastroProdutoTela = cadastroProdutoTela;
    }
}