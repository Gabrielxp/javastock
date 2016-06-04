package javastock.produto.view;

import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

/**
 * Classe para apresentar a list de Produtos.
 * Created by gabri on 04/06/2016.
 */
public class ProdutoProperty {
    private final StringProperty nomeProduto;
    private final IntegerProperty quantidade;
    private final IntegerProperty quantidadeMinima;
    private final DoubleProperty margemLucro;
    private final DoubleProperty precoEntrada;

    public ProdutoProperty(String nomeProduto, Integer quantidade, Integer quantidadeMinima, double margemLucro, double precoEntrada) {
        this.nomeProduto = new SimpleStringProperty(nomeProduto);
        this.quantidade = new SimpleIntegerProperty(quantidade);
        this.quantidadeMinima = new SimpleIntegerProperty(quantidadeMinima);
        this.margemLucro = new SimpleDoubleProperty(margemLucro);
        this.precoEntrada = new SimpleDoubleProperty(precoEntrada);
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

    public int getQuantidade() {
        return quantidade.get();
    }

    public IntegerProperty quantidadeProperty() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade.set(quantidade);
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima.get();
    }

    public IntegerProperty quantidadeMinimaProperty() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima.set(quantidadeMinima);
    }

    public double getMargemLucro() {
        return margemLucro.get();
    }

    public DoubleProperty margemLucroProperty() {
        return margemLucro;
    }

    public void setMargemLucro(double margemLucro) {
        this.margemLucro.set(margemLucro);
    }

    public double getPrecoEntrada() {
        return precoEntrada.get();
    }

    public DoubleProperty precoEntradaProperty() {
        return precoEntrada;
    }

    public void setPrecoEntrada(double precoEntrada) {
        this.precoEntrada.set(precoEntrada);
    }
}
