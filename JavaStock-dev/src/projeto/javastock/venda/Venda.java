package javastock.venda;

import javastock.misc.Entidade;
import javastock.produto.Produto;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Entidade venda
 */
public class Venda implements Entidade {

    private int idVenda = -1;
    private Date data;
    private Map<Produto, Integer> carrinho = new HashMap<>();
    private double desconto;
    private int idVendedor;

    /**
     * Cria uma venda.
     * @param carrinho   Carrinho com todos os produtos inclusos na venda e a quantidade de cada um.
     * @param desconto   Desconto da venda;
     * @param idVendedor  ID do funcionario que realizou a venda.
     */
    public Venda(double desconto, int idVendedor, Map carrinho) {
        this.setData(new Date());
        this.setIdVendedor(idVendedor);
        this.setCarrinho(carrinho);
        this.setDesconto(desconto);
    }

    /**
     * Instancia venda com o id, Utilizado apenas para instanciar entidade inseridas no banco.
     *
     * @param idVenda    Id da venda.
     * @param data       Data da venda.
     * @param carrinho   Carrinho com todos os produtos inclusos na venda e a quantidade de cada um
     * @param desconto   Desconto da venda.
     * @param idVendedor ID do funcionario que realizou a venda.
     */
    Venda(int idVenda, Date data, double desconto, int idVendedor, Map carrinho) {
        this(desconto, idVendedor, carrinho);
        this.setData(data);
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
        this.data = data;
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
     * Obtem o ID do funcionario que realizou a venda.
     * @return ID do funcionario que realizou a venda.
     */
    public int getIdVendedor() {
        return idVendedor;
    }

    /**
     * Atribui o ID do funcionario que realizou a venda.
     * @param idVendedor ID Funcionario que realizou a venda.
     */
    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

}
