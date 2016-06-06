package javastock.produto;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import javastock.misc.DAO;
import javastock.misc.DatabaseFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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

    public int salvar(Produto produto) {
        try (Connection connection = this.getConnection()) {
            if (produto.getIdProduto() == -1)
                return this.criar(connection, produto);
            else
                return this.atualizar(connection, produto);
        } catch (SQLException e) {
            System.out.print(e);
        }

        return -1;
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

    private int criar(Connection connection, Produto produto) throws SQLException {
        String sql = "INSERT INTO Produto (nome, descricao, categoria, fornecedor, " +
                "preco_entrada, quantidade_estoque, margem_lucro, quantidade_minima)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, produto.getNome());
        stmt.setString(2, produto.getDescricao());
        stmt.setString(3, produto.getCategoria());
        stmt.setString(4, produto.getFornecedor());
        stmt.setFloat(5, produto.getPrecoEntrada());
        stmt.setInt(6, produto.getQuantidadeEstoque());
        stmt.setDouble(7, produto.getMargemLucro());
        stmt.setInt(8, produto.getQuantidadeMinima());

        stmt.execute();
        int id;

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next())
            id = rs.getInt(1);
        else
            throw new RuntimeException("Erro ao obter id");

        stmt.close();

        return id;
    }

    private int atualizar(Connection connection, Produto produto) {
        // @TODO Terceira entrega.
        throw new NotImplementedException();
    }

}
