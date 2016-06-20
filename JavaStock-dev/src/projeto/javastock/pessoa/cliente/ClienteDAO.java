package javastock.pessoa.cliente;

import javastock.misc.DAO;
import javastock.misc.DatabaseFactory;
import javastock.misc.Endereco;
import javastock.pessoa.Pessoa;
import javastock.pessoa.PessoaDAO;
import javastock.pessoa.funcionario.Funcionario;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO de {@link Cliente}.
 * Created by gabri on 17/06/2016.
 */
public class ClienteDAO extends PessoaDAO implements DAO<Cliente> {
    public static final ClienteDAO instancia = new ClienteDAO();

    /**
     * Construtor privado para não instanciar ClienteDAO.
     */
    private ClienteDAO() {

    }

    /**
     * Retorna instancia de clienteDAO.
     *
     * @return
     */
    public static ClienteDAO getInstancia() {
        return instancia;
    }

    /**
     * Método para salvar Cliente.
     *
     * @param cliente
     * @return
     */
    @Override
    public int salvar(Cliente cliente) {
        try (Connection connection = this.getConnection()) {
            if (cliente.getIdPessoa() == -1) {
                return this.criar(connection, cliente);
            } else {
                return this.atualizar(connection, cliente);
            }
        } catch (SQLException e) {
            System.out.print(e);
        }

        return -1;
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente c, Pessoa p WHERE c.c_id_pessoa = p.id_pessoa";

        try (Connection connection = this.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet registros = stmt.executeQuery();

            while (registros.next())
                clientes.add(this.getClienteFromResult(registros));

            stmt.close();

        } catch (SQLException e) {
            System.out.print(e);
        }

        return clientes;
    }

    /**
     * Metodo para conectar na base de dados.
     *
     * @return
     * @throws SQLException
     */
    private Connection getConnection() throws SQLException {
        return new DatabaseFactory().getConnection();
    }

    /**
     * Criar cliente no banco.
     *
     * @param connection
     * @param cliente
     * @return
     * @throws SQLException
     */
    public int criar(Connection connection, Cliente cliente) throws SQLException {
        int idPessoa = super.criar(connection, cliente);

        String sql = "INSERT INTO Cliente (c_id_pessoa) VALUES (?)";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idPessoa);

        stmt.execute();
        stmt.close();

        return idPessoa;

    }

    /**
     * Método para atualizar cliente.
     *
     * @param connection
     * @param cliente
     * @return
     */
    public int atualizar(Connection connection, Cliente cliente) {
        throw new NotImplementedException();
        /*
        int idPessoa = PessoaDAO.getInstancia().salvar(cliente);


        return idPessoa;*/
    }

    public Cliente getById(int id) {
        throw new NotImplementedException();
    }

    private Cliente getClienteFromResult(ResultSet result) throws SQLException {
        Pessoa pessoa = super.getDataFromResult(result);
        return new Cliente(pessoa.getIdPessoa(), pessoa.getNome(), pessoa.getCpf(),
                pessoa.getRg(), pessoa.getEmail(), pessoa.getEndereco(), pessoa.getStatus());
    }
}
