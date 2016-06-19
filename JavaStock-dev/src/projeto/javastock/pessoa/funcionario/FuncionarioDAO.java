package javastock.pessoa.funcionario;

import javastock.misc.DAO;
import javastock.misc.DatabaseFactory;
import javastock.pessoa.PessoaDAO;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    private int atualizar(Connection connection, Funcionario funcionario) {
        // @TODO Terceira entrega.
        throw new NotImplementedException();
    }

    public Funcionario getById(int id) {
        String sql = "SELECT * FROM Funcionario WHERE f_id_pessoa = ? LIMIT 1";

        try (Connection connection = this.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(0, id);
            ResultSet registros = stmt.executeQuery();
/*
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

            stmt.close();**/

        } catch (SQLException e) {
            System.out.print(e);
        }

        return null;
    }

}
