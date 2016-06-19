package javastock.pessoa;

import javastock.misc.Endereco;

import java.sql.*;

/**
 * Classe Responsavel por fazer operacoes da entidade Funcionario no banco de dados.
 */
public abstract class PessoaDAO {

    protected int criar(Connection connection, Pessoa pessoa) throws SQLException {
        String sql = "INSERT INTO Pessoa (nome, email, rg, cpf, rua, numero, bairro, " +
                "cidade, uf, cep, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        this.setDataToStatement(pessoa, stmt);

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

    protected int atualizar(Connection connection, Pessoa pessoa) throws SQLException {
        String sql = "UPDATE Pessoa SET nome = ?, email = ?, rg = ?, cpf = ?, rua = ?, " +
                "numero = ?, bairro = ?, cidade = ?, uf = ?, cep = ?, status = ? WHERE id_pessoa = ?";

        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        this.setDataToStatement(pessoa, stmt);

        stmt.execute();
        stmt.close();

        return pessoa.getIdPessoa();
    }
/*
    protected Pessoa getById(Connection connection, int id) throws SQLException {
        String sql = "SELECT * FROM pessoa WHERE id_pessoa = ? LIMIT 1";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet registros = stmt.executeQuery();
        registros.next();

        return this.getDataFromResult(registros);
    }
*/
    private void setDataToStatement(Pessoa pessoa, PreparedStatement stmt) throws SQLException {
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
        stmt.setInt(11, pessoa.getStatus());

        if (pessoa.getIdPessoa() > 0)
            stmt.setInt(12, pessoa.getIdPessoa());
    }

    protected Pessoa getDataFromResult(ResultSet result) throws SQLException {
        int id = result.getInt("id_pessoa");
        String nome = result.getString("nome");
        String cpf = result.getString("cpf");
        String rg = result.getString("rg");
        String email = result.getString("email");
        int status = result.getInt("status");

        String rua = result.getString("rua");
        int numero = result.getInt("numero");
        String bairro = result.getString("bairro");
        String cidade = result.getString("cidade");
        String uf = result.getString("uf");
        String cep = result.getString("cep");
        Endereco endereco = new Endereco(rua, numero, bairro, cidade, uf, cep);

        return new Pessoa(id, nome, cpf, rg, email, endereco, status) {};
    }

}
