package javastock.produto.view;

import javafx.beans.property.*;

/**
 * Classe para apresentar a list de Produtos no formato tableView.
 */
public class ProdutoProperty {
    private final StringProperty codProd;

    private final StringProperty nomeProduto;
    private final StringProperty quantidade;
    private final StringProperty quantidadeMinima;
    private final StringProperty margemLucro;
    private final StringProperty precoEntrada;


    public void setCodProd(String codProd) {
        this.codProd.set(codProd);
    }

    public ProdutoProperty(String codProd, String nomeProduto, String quantidade, String quantidadeMinima, String margemLucro, String precoEntrada) {
        this.nomeProduto = new SimpleStringProperty(nomeProduto);
        this.quantidade = new SimpleStringProperty(quantidade);
        this.quantidadeMinima = new SimpleStringProperty(quantidadeMinima);
        this.margemLucro = new SimpleStringProperty(margemLucro);
        this.precoEntrada = new SimpleStringProperty(precoEntrada);
        this.codProd = new SimpleStringProperty(codProd);
    }

    public String getNomeProduto() {
        return nomeProduto.get();
    }

    public StringProperty nomeProdutoProperty() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto.set(nomeProduto);
    }

    public String getQuantidade() {
        return quantidade.get();
    }

    public StringProperty quantidadeProperty() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade.set(quantidade);
    }

    public String getQuantidadeMinima() {
        return quantidadeMinima.get();
    }

    public StringProperty quantidadeMinimaProperty() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(String quantidadeMinima) {
        this.quantidadeMinima.set(quantidadeMinima);
    }

    public String getMargemLucro() {
        return margemLucro.get();
    }

    public StringProperty margemLucroProperty() {
        return margemLucro;
    }

    public void setMargemLucro(String margemLucro) {
        this.margemLucro.set(margemLucro);
    }

    public String getPrecoEntrada() {
        return precoEntrada.get();
    }

    public StringProperty precoEntradaProperty() {
        return precoEntrada;
    }

    public void setPrecoEntrada(String precoEntrada) {
        this.precoEntrada.set(precoEntrada);
    }

    public String getCodProd() {
        return codProd.get();
    }

    public StringProperty codProdProperty() {
        return codProd;
    }
}
