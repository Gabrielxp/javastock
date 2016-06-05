package javastock.produto;

import javastock.misc.Entidade;

/**
 * Entidade Produto
 */
public class Produto implements Entidade {

    private int idProduto = -1;
    private String nome;
    private String descricao;
    private String categoria;
    private String fornecedor;
    private float precoEntrada;
    private int quantidadeEstoque;
    private double margemLucro;
    private int quantidadeMinima;

    /**
     * Cria um produto.
     */
    public Produto() { }

    /**
     * Cria um produto.
     * @param nome Nome do produto.
     * @param descricao Descricao do produto.
     * @param categoria Nome da categoria do produto.
     * @param fornecedor Nome do fornecedor do produto.
     * @param precoEntrada Preco de custo do produto.
     * @param quantidadeEstoque Quantidade de produtos no estoque.
     * @param margemLucro Porcentagem de lucro na venda do produto (1 = 100%).
     * @param quantidadeMinima Quantidade mínima de produtos no estoque para alertar o gerente.
     */
    public Produto(String nome, String descricao, String categoria, String fornecedor, float precoEntrada, int quantidadeEstoque, double margemLucro, int quantidadeMinima) {
        this();
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setCategoria(categoria);
        this.setFornecedor(fornecedor);
        this.setPrecoEntrada(precoEntrada);
        this.setQuantidadeEstoque(quantidadeEstoque);
        this.setMargemLucro(margemLucro);
        this.setQuantidadeMinima(quantidadeMinima);
    }

    /**
     * Instancia produto com id. Utilizado apenas para instanciar entidade ja inseridas no banco.
     * @param nome Nome do produto
     * @param descricao Descricao do produto
     * @param categoria Nome da categoria do produto
     * @param fornecedor Nome do fornecedor do produto
     * @param precoEntrada Preco de custo do produto
     * @param quantidadeEstoque Quantidade de produtos no estoque
     * @param margemLucro Porcentagem de lucro na venda do produto (1 = 100%)
     * @param quantidadeMinima Quantidade mínima de produtos no estoque para alertar o gerente
     */
    Produto(int idProduto, String nome, String descricao, String categoria, String fornecedor, float precoEntrada, int quantidadeEstoque, double margemLucro, int quantidadeMinima) {
        this(nome, descricao, categoria, fornecedor, precoEntrada, quantidadeEstoque, margemLucro, quantidadeMinima);
        this.setId(idProduto);
    }

    /**
     * @return Identificador Unico do produto.
     */
    public int getIdProduto() {
        return this.idProduto;
    }

    /**
     * @return Nome do produto.
     */
    public String getNome() {
        return nome;
    }

    private void setId(int idProduto) {
        if (idProduto < 0)
            throw new RuntimeException("Id nao pode ser negativo");

        this.idProduto = idProduto;
    }

    /**
     * @param nome Nome do produto.
     */
    public void setNome(String nome) {
        if (nome == null || nome.equals(""))
            throw new RuntimeException("Este campo é obrigatorio");

        this.nome = nome;
    }

    /**
     * @return Descricao do produto.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao Descricao do produto.
     */
    public void setDescricao(String descricao) {
        if (nome == null || nome.equals(""))
            throw new RuntimeException("Este campo é obrigatorio");


        this.descricao = descricao;
    }

    /**
     * @return Categoria do produto.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria Categoria do produto.
     */
    public void setCategoria(String categoria) {
        if (nome == null || nome.equals(""))
            throw new RuntimeException("Este campo é obrigatorio");

        this.categoria = categoria;
    }

    /**
     * @return Nome do fornecedor do produto.
     */
    public String getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor Nome do fornecedor do produto.
     */
    public void setFornecedor(String fornecedor) {
        if (nome == null || nome.equals(""))
            throw new RuntimeException("Este campo é obrigatorio");

        this.fornecedor = fornecedor;
    }

    /**
     * @return Preco de custo do produto.
     */
    public float getPrecoEntrada() {
        return precoEntrada;
    }

    /**
     * @param precoEntrada Preco de custo do produto.
     */
    public void setPrecoEntrada(float precoEntrada) {
        if (precoEntrada < 0)
            throw new RuntimeException("O valor deve ser maior que zero");

        this.precoEntrada = precoEntrada;
    }

    /**
     * @return Quantidade de produtos no estoque.
     */
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    /**
     * @param quantidadeEstoque Quantidade de produtos no estoque.
     */
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        if (quantidadeEstoque < 0)
            throw new RuntimeException("O valor deve ser maior que zero");

        this.quantidadeEstoque = quantidadeEstoque;
    }

    /**
     * @return Porcentagem de lucro na venda do produto (1 = 100%)
     */
    public double getMargemLucro() {
        return margemLucro;
    }

    /**
     * @param margemLucro Porcentagem de lucro na venda do produto (1 = 100%)
     */
    public void setMargemLucro(double margemLucro) {
        if (margemLucro < 0)
            throw new RuntimeException("O valor deve ser maior que zero");


        this.margemLucro = margemLucro;
    }

    /**
     * @return Quantidade mínima de produtos no estoque para alertar o gerente.
     */
    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    /**
     * @param quantidadeMinima Quantidade mínima de produtos no estoque para alertar o gerente.
     */
    public void setQuantidadeMinima(int quantidadeMinima) {
        if (quantidadeMinima < 0)
            throw new RuntimeException("O valor deve ser maior que zero");


        this.quantidadeMinima = quantidadeMinima;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "idProduto=" + idProduto +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", categoria='" + categoria + '\'' +
                ", fornecedor='" + fornecedor + '\'' +
                ", precoEntrada=" + precoEntrada +
                ", quantidadeEstoque=" + quantidadeEstoque +
                ", margemLucro=" + margemLucro +
                ", quantidadeMinima=" + quantidadeMinima +
                '}';
    }
}
