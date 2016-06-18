package javastock.pessoa;

import javastock.misc.DAO;
import javastock.misc.DatabaseFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.*;
import java.util.List;

/**
 * Classe Responsavel por fazer operacoes da entidade Funcionario no banco de dados.
 */
public class PessoaDAO implements DAO<Pessoa> {

    private static final PessoaDAO instancia = new PessoaDAO();

    private PessoaDAO() {
    }

    /**
     * Singleton
     *
     * @return Instancia de PessoaDAO.
     */
    public static PessoaDAO getInstancia() {
        return instancia;
    }

    private Connection getConnection() throws SQLException {
        return new DatabaseFactory().getConnection();
    }

    public int salvar(Pessoa pessoa) {
        try (Connection connection = this.getConnection()) {
            if (pessoa.getIdPessoa() == -1)
                return this.criar(connection, pessoa);
            else
                return this.atualizar(connection, pessoa);
        } catch (SQLException e) {
            System.out.print(e);
        }

        return -1;
    }

    public List<Pessoa> listar() {
        // @TODO Terceira entrega.
        throw new NotImplementedException();
    }

    private int criar(Connection connection, Pessoa pessoa) throws SQLException {
        String sql = "INSERT INTO Pessoa (nome, email, rg, cpf, rua, numero, bairro, " +
                "cidade, uf, cep, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, pessoa.getNome());
        stmt.setString(2, pessoa.getEmail());
        stmt.setString(3, pessoa.getRg());
        stmt.setString(4, pessoa.getCpf());
        stmt.setString(5, pessoa.getEndereco().getRua());
        stmt.setInt(6, pessoa.getEndereco().getNumero());
        stmt.setString(7, pessoa.getEndereco().getBairro());
        stmt.setString(8, pessoa.getEndereco().getCidade());
        stmt.setString(9, pessoa.getEndereco().getUf());
        stmt.setString(10, pessoa.getEndereco().getCep());
        stmt.setInt(11, 1);

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

    private int atualizar(Connection connection, Pessoa pessoa) {
        // @TODO Terceira entrega.
        throw new NotImplementedException();
    }

}
