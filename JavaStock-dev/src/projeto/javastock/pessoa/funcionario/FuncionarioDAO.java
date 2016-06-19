package javastock.pessoa.funcionario;

import javastock.misc.DAO;
import javastock.misc.DatabaseFactory;
import javastock.misc.Endereco;
import javastock.pessoa.Pessoa;
import javastock.pessoa.PessoaDAO;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Classe Responsavel por fazer operacoes da entidade Funcionario no banco de dados.
 */
public class FuncionarioDAO extends PessoaDAO implements DAO<Funcionario> {

    private static final FuncionarioDAO instancia = new FuncionarioDAO();

    private FuncionarioDAO() {}

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
        int idPessoa = super.criar(connection, funcionario);

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

    private int atualizar(Connection connection, Funcionario funcionario) throws SQLException {
        super.atualizar(connection, funcionario);

        String sql = "UPDATE Funcionario SET funcao = ?, salario = ?, carga_horario = ?, "
                + "regime_trabalho = ?, senha = ? WHERE f_id_pessoa = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, funcionario.getFuncao().toUpperCase().equals("GERENTE") ? 2 : 1);
        stmt.setFloat(2, funcionario.getSalario());
        stmt.setFloat(3, funcionario.getCargaHoraria());
        stmt.setString(4, funcionario.getRegimeDeTrabalho());
        stmt.setString(5, funcionario.getSenha());
        stmt.setInt(6, funcionario.getIdPessoa());

        stmt.execute();
        stmt.close();

        return funcionario.getIdPessoa();
    }

    public Funcionario getById(int id) {
        String sql = "SELECT * FROM Funcionario WHERE f_id_pessoa = ? LIMIT 1";
        Funcionario funcionario = null;

        try (Connection connection = this.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet registros = stmt.executeQuery();
            registros.next();

            String funcao = registros.getInt("funcao") == 2 ? "GERENTE" : "VENDEDOR";
            int cargaHoraria = registros.getInt("carga_horario");
            float salario = registros.getFloat("salario");
            String regimeDeTrabalho = registros.getString("regime_trabalho");
            String senha = registros.getString("senha");

            stmt.close();

            Pessoa pessoa = super.getById(connection, id);
            String nome = pessoa.getNome();
            String cpf = pessoa.getCpf();
            String rg = pessoa.getRg();
            String email = pessoa.getEmail();
            Endereco endereco = pessoa.getEndereco();
            int status = pessoa.getStatus();

            funcionario = new Funcionario(id, nome, cpf, rg, email, endereco, status, salario,
                    cargaHoraria, funcao, regimeDeTrabalho, senha);

        } catch (SQLException e) {
            System.out.print(e);
        }

        return funcionario;
    }

}
