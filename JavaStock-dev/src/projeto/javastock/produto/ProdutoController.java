package javastock.produto;

import javastock.misc.DAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller de produtos
 */
public class ProdutoController {

    private final static ProdutoController instancia = new ProdutoController();

    private ProdutoController() {
    }

    /**
     * Singleton
     *
     * @return Instancia de ProdutoController.
     */
    public static ProdutoController getInstancia() {
        return instancia;
    }

    private DAO<Produto> produtoDAO = ProdutoDAO.getInstancia();

    /**
     * Cria novo produto e o salvano banco de dados.
     *
     * @param nome              Nome do produto.
     * @param descricao         Descricao do produto.
     * @param categoria         Nome da categoria do produto.
     * @param fornecedor        Nome do fornecedor do produto.
     * @param precoEntrada      Preco de custo do produto.
     * @param quantidadeEstoque Quantidade de produtos no estoque.
     * @param margemLucro       Porcentagem de lucro na venda do produto (1 = 100%).
     * @param quantidadeMinima  Quantidade mínima de produtos no estoque para alertar o gerente.
     */
    public void criar(String nome, String descricao, String categoria, String fornecedor,
                      float precoEntrada, int quantidadeEstoque, double margemLucro, int quantidadeMinima) {
        Produto produto = new Produto(nome, descricao, categoria, fornecedor, precoEntrada,
                quantidadeEstoque, margemLucro, quantidadeMinima);

        this.produtoDAO.salvar(produto);
    }

    /**
     * Lista todos os produtos contidoa no banco de dados.
     *
     * @return Lista de produtos.
     */
    public List<Produto> listar() {
        return this.produtoDAO.listar();
    }

    public Produto buscar(int idProduto) {
        List<Produto> produtos = this.produtoDAO.listar();
        Produto produto;
        for (Produto p : produtos) {
            if (p.getIdProduto() == idProduto) {
                produto = p;
                return produto;
            }

        }
        return null;
    }

    public int atualizar(int id, String nome, String descricao, String categoria, String fornecedor,
                         float precoEntrada, int quantidadeEstoque, double margemLucro, int quantidadeMinima) {
        Produto produto = new Produto(id, nome, descricao, categoria, fornecedor, precoEntrada,
                quantidadeEstoque, margemLucro, quantidadeMinima);

        return this.produtoDAO.salvar(produto);
    }

    public List<Produto> abaixoEstoque() {
        List<Produto> produtos = produtoDAO.listar();
        List<Produto> produtosComEstoqueBaixo = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getQuantidadeEstoque() < produto.getQuantidadeMinima()) {
                produtosComEstoqueBaixo.add(produto);
            }
        }

        return produtosComEstoqueBaixo;
    }

}
