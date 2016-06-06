package javastock.venda;

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

    public void salvar(Venda venda) {
        try (Connection connection = this.getConnection()) {
            if (venda.getIdVenda() == -1)
                this.criar(connection, venda);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    private int idVenda = -1;
    private Date data;
    private int quantidade;
    private Map<Produto, Integer> carrinho = new HashMap<Produto, Integer>();
    private double desconto;
    private double valorVenda;
    private double orcamento;


    public void criar(Connection connection, Venda venda) throws SQLException {
        String sql = "INSERT INTO Venda (data, quantidade, carrinho, desconto, valorVenda, orcamento)" +
                "VALUES (?, ? , ? , ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setDate(1, venda.getData());
        stmt.setInt(2, venda.setQuantidade());
        stmt.set(3, venda);
        stmt.setDouble(4, venda.setDesconto());
        stmt.setDouble(5, venda.setValorVenda());
        stmt.setDouble(6, venda.setOrcamento());

        stmt.execute();
        stmt.close();
    }

}
