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
     * @param nome Nome do produto.
     * @param descricao Descricao do produto.
     * @param categoria Nome da categoria do produto.
     * @param fornecedor Nome do fornecedor do produto.
     * @param precoEntrada Preco de custo do produto.
     * @param quantidadeEstoque Quantidade de produtos no estoque.
     * @param margemLucro Porcentagem de lucro na venda do produto (1 = 100%).
     * @param quantidadeMinima Quantidade mínima de produtos no estoque para alertar o gerente.
     * @throws RuntimeException Caso algum argumento nao passe pela validacao.
     */
    public Produto(String nome, String descricao, String categoria, String fornecedor, float precoEntrada,
                   int quantidadeEstoque, double margemLucro, int quantidadeMinima) {
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
     * @param idProduto Id do produto.
     * @param nome Nome do produto
     * @param descricao Descricao do produto
     * @param categoria Nome da categoria do produto
     * @param fornecedor Nome do fornecedor do produto
     * @param precoEntrada Preco de custo do produto
     * @param quantidadeEstoque Quantidade de produtos no estoque
     * @param margemLucro Porcentagem de lucro na venda do produto (1 = 100%)
     * @param quantidadeMinima Quantidade mínima de produtos no estoque para alertar o gerente
     * @throws RuntimeException Caso algum argumento nao passe pela validacao.
     */
    Produto(int idProduto, String nome, String descricao, String categoria, String fornecedor,
            float precoEntrada, int quantidadeEstoque, double margemLucro, int quantidadeMinima) {
        this(nome, descricao, categoria, fornecedor, precoEntrada, quantidadeEstoque, margemLucro, quantidadeMinima);
        this.setId(idProduto);
    }

    /**
     * Obtem o Identificador Unico do produto.
     * @return Identificador Unico do produto.
     */
    public int getIdProduto() {
        return this.idProduto;
    }

    /**
     * Obtem o nome do produto.
     * @return Nome do produto.
     * @throws RuntimeException Caso o valor informado for menor que zero.
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
     * Altera o nome do produto.
     * @param nome Novo nome.
     * @throws RuntimeException Caso o valor informado for vazio ou nulo.
     */
    public void setNome(String nome) {
        if (nome == null || nome.equals(""))
            throw new RuntimeException("Este campo é obrigatorio");

        this.nome = nome;
    }

    /**
     * Obtem a descricao do produto.
     * @return Descricao do produto.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Altera a descricao do produto.
     * @param descricao Nova descricao.
     * @throws RuntimeException Caso o valor informado for vazio ou nulo.
     */
    public void setDescricao(String descricao) {
        if (nome == null || nome.equals(""))
            throw new RuntimeException("Este campo é obrigatorio");


        this.descricao = descricao;
    }

    /**
     * Obtem a categoria do produto.
     * @return Categoria do produto.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Altera o nome da categoria do produto.
     * @param categoria Nova categoria.
     * @throws RuntimeException Caso o valor informado for vazio ou nulo.
     */
    public void setCategoria(String categoria) {
        if (nome == null || nome.equals(""))
            throw new RuntimeException("Este campo é obrigatorio");

        this.categoria = categoria;
    }

    /**
     * Obtem o fornecedor do produto.
     * @return Nome do fornecedor do produto.
     */
    public String getFornecedor() {
        return fornecedor;
    }

    /**
     * Altera o nome do fornecedor produto.
     * @param fornecedor Novo nome do fornecedor.
     * @throws RuntimeException Caso o valor informado for vazio ou nulo.
     */
    public void setFornecedor(String fornecedor) {
        if (nome == null || nome.equals(""))
            throw new RuntimeException("Este campo é obrigatorio");

        this.fornecedor = fornecedor;
    }

    /**
     * Obtem o preco de custo do produto.
     * @return Preco de custo do produto.
     */
    public float getPrecoEntrada() {
        return precoEntrada;
    }

    /**
     * Altera o preco de custo produto.
     * @param precoEntrada Novo preco.
     * @throws RuntimeException Caso o valor informado for menor que zero.
     */
    public void setPrecoEntrada(float precoEntrada) {
        if (precoEntrada < 0)
            throw new RuntimeException("O valor deve ser maior que zero");

        this.precoEntrada = precoEntrada;
    }

    /**
     * Obtem o numero de produtos no estoque.
     * @return Quantidade de produtos no estoque.
     */
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    /**
     * Altera a quantidade de produtos no estoque.
     * @param quantidadeEstoque Nova quantidade.
     * @throws RuntimeException Caso o valor informado for menor que zero.
     */
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        if (quantidadeEstoque < 0)
            throw new RuntimeException("O valor deve ser maior que zero");

        this.quantidadeEstoque = quantidadeEstoque;
    }

    /**
     * Obtem a margem de lucro de venda por produto.
     * @return Porcentagem de lucro na venda do produto (1 = 100%).
     */
    public double getMargemLucro() {
        return margemLucro;
    }

    /**
     * Altera a margem de lucro do produto.
     * @param margemLucro Nova margem (1 = 100%).
     * @throws RuntimeException Caso o valor informado for menor que zero.
     */
    public void setMargemLucro(double margemLucro) {
        if (margemLucro < 0)
            throw new RuntimeException("O valor deve ser maior que zero");


        this.margemLucro = margemLucro;
    }

    /**
     * Obtem a quantidade minima de produtos no estoque para alertar o gerente.
     * @return Quantidade minima de produtos no estoque para alertar o gerente.
     */
    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    /**
     * Altera a quantidade minima de produtos no estoque para alertar o gerente.
     * @param quantidadeMinima Nova quantidade.
     * @throws RuntimeException Caso o valor informado for menor que zero.
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
