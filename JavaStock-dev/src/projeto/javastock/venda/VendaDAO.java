package javastock.venda;

import java.sql.*;
import java.util.List;
import java.util.Map;

import javastock.misc.DAO;
import javastock.misc.DatabaseFactory;
import javastock.produto.Produto;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Classe Responsavel por fazer operacoes da entidade Venda no banco de dados.
 */
public class VendaDAO implements DAO<Venda> {

    private static final VendaDAO instancia = new VendaDAO();

    private VendaDAO() {}

    /**
     * Singleton
     * @return Instancia de VendaDAO.
     */
    public static VendaDAO getInstancia() {
        return instancia;
    }

    private Connection getConnection() throws SQLException {
        return new DatabaseFactory().getConnection();
    }

    public int salvar(Venda venda) {
        try (Connection connection = this.getConnection()) {
            if (venda.getIdVenda() == -1)
                return this.criar(connection, venda);
            else
                return this.atualizar(connection, venda);
        } catch (SQLException e) {
            System.out.println(e);
        }

        return -1;
    }

    private int criar(Connection connection, Venda venda) throws SQLException {
        String sql = "INSERT INTO Venda (data, desconto, v_f_id_pessoa) VALUES (?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setTimestamp(1, new java.sql.Timestamp(venda.getData().getTime()));
        stmt.setDouble(2, venda.getDesconto());
        stmt.setInt(3, venda.getIdVendedor());

        stmt.execute();
        int id;

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next())
            id = rs.getInt(1);
        else
            throw new RuntimeException("Erro ao obter id");

        stmt.close();

        for (Map.Entry<Produto, Integer> item : venda.getCarrinho().entrySet())
            this.salvarItem(connection, item.getKey(), item.getValue(), id);

        return id;
    }

    private void salvarItem(Connection connection, Produto produto, int quantidade, int idVenda)
            throws SQLException {
        String sql = "INSERT INTO venda_produto (vp_id_venda, vp_id_produto, quantidade," +
                "valor_unitario) VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idVenda);
        stmt.setInt(2, produto.getIdProduto());
        stmt.setInt(3, quantidade);
        stmt.setFloat(4, produto.getPrecoEntrada());
        stmt.execute();
        stmt.close();
    }

    private int atualizar(Connection connection, Venda venda) {
        // @TODO Terceira entrega.
        throw new NotImplementedException();
    }

    public List<Venda> listar() {
        // @TODO Terceira entrega.
        throw new NotImplementedException();
    }

}
