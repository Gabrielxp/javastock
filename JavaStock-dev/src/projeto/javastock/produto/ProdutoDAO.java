package javastock.produto;

import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import javastock.misc.DAO;
import javastock.misc.DatabaseFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Classe Responsavel por fazer operacoes da entidade Produto no banco de dados.
 */
public class ProdutoDAO implements DAO<Produto> {

    private static final ProdutoDAO instancia = new ProdutoDAO();

    private ProdutoDAO() {}

    /**
     * Singleton
     * @return Instancia de ProdutoDAO.
     */
    public static ProdutoDAO getInstancia() {
        return instancia;
    }

    private Connection getConnection() throws SQLException {
        return new DatabaseFactory().getConnection();
    }

    public void salvar(Produto produto) {
        try (Connection connection = this.getConnection()) {
            if (produto.getIdProduto() == -1)
                this.criar(connection, produto);
            else
                this.atualizar(connection, produto);
        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    public List<Produto> listar() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM Produto";

        try (Connection connection = this.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet registros = stmt.executeQuery();

            while (registros.next()) {
                int id = registros.getInt("id_produto");
                String nome = registros.getString("nome");
                String descricao = registros.getString("descricao");
                String categoria = registros.getString("categoria");
                String fornecedor = registros.getString("fornecedor");
                float precoDeEntrada = registros.getFloat("preco_entrada");
                int quantidadeEstoque = registros.getInt("quantidade_estoque");
                double margemLucro = registros.getDouble("margem_lucro");
                int quantidadeMinima = registros.getInt("quantidade_minima");

                Produto produto = new Produto(id, nome, descricao, categoria, fornecedor,
                        precoDeEntrada, quantidadeEstoque, margemLucro, quantidadeMinima);

                produtos.add(produto);
            }

            stmt.close();

        } catch (SQLException e) {
            System.out.print(e);
        }

        return produtos;
    }

    private void criar(Connection connection, Produto produto) throws SQLException {
        String sql = "INSERT INTO Produto (nome, descricao, categoria, fornecedor, " +
                "preco_entrada, quantidade_estoque, margem_lucro, quantidade_minima)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, produto.getNome());
        stmt.setString(2, produto.getDescricao());
        stmt.setString(3, produto.getCategoria());
        stmt.setString(4, produto.getFornecedor());
        stmt.setFloat(5, produto.getPrecoEntrada());
        stmt.setInt(6, produto.getQuantidadeEstoque());
        stmt.setDouble(7, produto.getMargemLucro());
        stmt.setInt(8, produto.getQuantidadeMinima());

        stmt.execute();
        stmt.close();
    }

    private void atualizar(Connection connection, Produto produto) {
        // @TODO Terceira entrega.
        throw new NotImplementedException();
    }

}
