package javastock.venda;

import javastock.misc.Entidade;
import javastock.produto.Produto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Entidade venda
 */
public class Venda implements Entidade {

    private int idVenda = -1;
    private Date data;
    private int quantidade;
    private Map<Produto, Integer> carrinho = new HashMap<Produto, Integer>();
    private double desconto;
    private double valorVenda;
    private double orcamento;
    ;

    /**
     * Cria uma venda.
     * @param data       Data da venda.
     * @param quantidade Quantidade de produtos.
     * @param carrinho   Carrinho com todos os produtos inclusos na venda e a quantidade de cada um.
     * @param desconto   Desconto da venda;
     * @param valorVenda Valor da venda.
     * @param orcamento  Valor orçamento.
     */

    public Venda(Date data, int quantidade, Map carrinho, double desconto, double valorVenda, double orcamento) {
        this.setData(data);
        this.setQuantidade(quantidade);
        this.setCarrinho(carrinho);
        this.setDesconto(desconto);
        this.setValorVenda(valorVenda);
        this.setOrcamento(orcamento);
    }

    /**
     * Instancia venda com o id, Utilizado apenas para instanciar entidade inseridas no banco.
     *
     * @param idVenda    Id da venda.
     * @param data       Data da venda.
     * @param quantidade Quantidade de produtos.
     * @param carrinho   Carrinho com todos os produtos inclusos na venda e a quantidade de cada um
     * @param desconto   Desconto da venda.
     * @param valorVenda Valor da venda.
     * @param orcamento  Valor orçamento.
     */

    Venda(int idVenda, Date data, int quantidade, Map carrinho, double desconto, double valorVenda, double orcamento) {
        this(data, quantidade, carrinho, desconto, valorVenda, orcamento);
        this.setId(idVenda);
    }

    /**
     * Obtem o Identificar Unico da venda.
     *
     * @return Identificador Unico da venda.
     */
    public int getIdVenda() {
        return this.idVenda;
    }

    private void setId(int idVenda) {
        if (idVenda < 0)
            throw new RuntimeException("Id nao pode ser negativo");

        this.idVenda = idVenda;
    }

    /**
     * Obtem a data da venda.
     * @return Data da venda.
     */
    public Date getData() {
        return data;
    }

    /**
     * Atribui data a venda,
     * @param data Data da venda.
     */
    public void setData(Date data) {
        this.data = new Date();
    }

    /**
     * Obtem a quantidade de produtos na venda.
     * @return Quantidade de produtos na venda.
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Atribui a quantidade de produtos na venda.
     * @param quantidade Quantidade de produtos na venda.
     * @throws RuntimeException Caso o valor informado for vazio ou nulo.
     */
    public void setQuantidade(int quantidade) {
        if (quantidade < 0)
            throw new RuntimeException("A quantidade deve ser maior que zero");

        this.quantidade = quantidade;
    }

    /**
     * Obtem o produto e a quantidade na venda.
     * @return Produto e a quantidade na venda.
     */
    public Map<Produto, Integer> getCarrinho() {
        return carrinho;
    }

    /**
     * Atribui o produto e a quantidade na venda.
     * @param carrinho Produto e a quantidade na venda.
     */
    public void setCarrinho(Map<Produto, Integer> carrinho) {
        this.carrinho = carrinho;
    }

    /**
     * Obtem o desconto da venda.
     * @return Desconto da venda.
     */
    public double getDesconto() {
        return desconto;
    }

    /**
     * Atribui o desconto da venda.
     * @param desconto Desconto da venda.
     * @throws RuntimeException Caso o valor informado for vazio ou nulo.
     */
    public void setDesconto(double desconto) {
        if (desconto < 0)
            throw new RuntimeException("O desconto deve ser maior que zero");

        this.desconto = desconto;
    }

    /**
     * Obtem o valor da venda.
     * @return Valor da venda.
     */
    public double getValorVenda() {
        return valorVenda;
    }

    /**
     * Atribui o valor da venda.
     * @param valorVenda Valor da venda.
     */
    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    /**
     * Obtem o valor do oramento.
     * @return Valor do orçamento.
     */
    public double getOrcamento() {
        return orcamento;
    }

    /**
     * Atribui o valor do orçamento.
     * @param orcamento Valor do orçamento.
     */
    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "idVenda=" + idVenda +
                ", data=" + data +
                ", quantidade=" + quantidade +
                ", carrinho=" + carrinho +
                ", desconto=" + desconto +
                ", valorVenda=" + valorVenda +
                ", orcamento=" + orcamento +
                '}';
    }
}
