package javastock.pessoa.funcionario;

import javastock.misc.DAO;
import javastock.misc.DatabaseFactory;
import javastock.pessoa.PessoaDAO;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Classe Responsavel por fazer operacoes da entidade Funcionario no banco de dados.
 */
public class FuncionarioDAO implements DAO<Funcionario> {

    private static final FuncionarioDAO instancia = new FuncionarioDAO();

    public FuncionarioDAO() {}

    /**
     * Singleton
     * @return Instancia de FuncionarioDAO.
     */
    public static FuncionarioDAO getInstancia() {
        return instancia;
    }

    private Connection getConnection() throws SQLException {
        return new DatabaseFactory().getConnection();
    }

    /**
     * Salva o funcionario no banco
     * @param funcionario Produto a ser salvo.
     */
    public int salvar(Funcionario funcionario) {
        try (Connection connection = this.getConnection()) {
            if (funcionario.getIdPessoa() == -1)
                return this.criar(connection, funcionario);
            else
                return this.atualizar(connection, funcionario);
        } catch (SQLException e) {
            System.out.print(e);
        }

        return -1;
    }

    public List<Funcionario> listar() {
        // @TODO Terceira entrega.
        throw new NotImplementedException();
    }

    private int criar(Connection connection, Funcionario funcionario) throws SQLException {
        int idPessoa = PessoaDAO.getInstancia().salvar(funcionario);

        String sql = "INSERT INTO Funcionario (f_id_pessoa, funcao, salario, carga_horario,"
                + "regime_trabalho, senha) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idPessoa);
        stmt.setInt(2, funcionario.getFuncao().toUpperCase().equals("GERENTE") ? 2 : 1);
        stmt.setFloat(3, funcionario.getSalario());
        stmt.setFloat(4, funcionario.getCargaHoraria());
        stmt.setString(5, funcionario.getRegimeDeTrabalho());
        stmt.setString(6, funcionario.getSenha());

        stmt.execute();
        stmt.close();

        return idPessoa;
    }

    private int atualizar(Connection connection, Funcionario funcionario) {
        // @TODO Terceira entrega.
        throw new NotImplementedException();
    }

}
