package javastock.pessoa;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.*;

/**
 * Classe Responsavel por fazer operacoes da entidade Funcionario no banco de dados.
 */
public abstract class PessoaDAO {

    protected int criar(Connection connection, Pessoa pessoa) throws SQLException {
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

    protected int atualizar(Connection connection, Pessoa pessoa) {
        // @TODO Terceira entrega.
        throw new NotImplementedException();
    }

}
